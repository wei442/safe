package com.cloud.consumer.safe.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.gofun.GoFunConstants;
import com.cloud.common.constants.wheel.BootWheelConstants;
import com.cloud.common.constants.wheel.RetWheelConstants;
import com.cloud.common.constants.wheel.SqlWheelConstants;
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.login.UserLoginRequest;
import com.cloud.consumer.safe.service.IUserInfoService;
import com.cloud.consumer.safe.vo.gofun.ValidateUserVo;
import com.cloud.consumer.safe.vo.user.UserLoginLogVo;
import com.cloud.consumer.safe.vo.user.UserLoginVo;
import com.cloud.consumer.safe.vo.user.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息管理 UserController
 * @author wei.yong
 * @ClassName: UserController
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user/login")
public class UserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 用户登录接口
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户登录")
	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse login(
		@RequestBody UserLoginRequest req) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String gToken = req.getgToken();
		if (StringUtils.isBlank(gToken)) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_NULL_ERROR_MSG);
		}

		//验证gToken
		JSONObject jsonGoFunValidateUser = userInfoService.validateUser(gToken, this.gofunPortal);
		logger.info("===step2:【用户登录】(UserController-login))-验证gofunApp用户登陆状态, jsonGoFunValidateUser:{}", jsonGoFunValidateUser);
		String goFunCode = Objects.toString(jsonGoFunValidateUser.get(GoFunConstants.CODE), "");
		String goFunMsg = Objects.toString(jsonGoFunValidateUser.get(GoFunConstants.MSG), "");
		if (!StringUtils.equals(goFunCode, GoFunConstants.OK)) {
			//gtoken已过期
			if (StringUtils.equals(goFunCode, GoFunConstants.ERROR_1005)) {
				return new BaseRestMapResponse(RetWheelConstants.GTOKEN_ERROR, RetWheelConstants.GTOKEN_EXPIRE_MSG, RetWheelConstants.GTOKEN_EXPIRE, RetWheelConstants.GTOKEN_EXPIRE_MSG);
			} else {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, goFunMsg, RetWheelConstants.TDP_GOFUN_ERROR, goFunMsg);
			}
		}
		JSONObject jsonGoFunDataValidateUser = jsonGoFunValidateUser.getJSONObject(GoFunConstants.DATA);
		ValidateUserVo validateUserVo = JSONObject.toJavaObject(jsonGoFunDataValidateUser, ValidateUserVo.class);
		String gId = validateUserVo.getgId();
		String userAccount = validateUserVo.getUserAccount();
		String nickName = validateUserVo.getNickName();
		String cityCode = validateUserVo.getCityCode();
		String cityName = validateUserVo.getCityName();
		if(StringUtils.isBlank(gId)) {
			return new BaseRestMapResponse(RetWheelConstants.GOFUN_ERROR, "userId为空", RetWheelConstants.GOFUN_NULL_ERROR, "gofun.userId.isempty");
		} else if(StringUtils.isBlank(userAccount)) {
			return new BaseRestMapResponse(RetWheelConstants.GOFUN_ERROR, "手机号码为空", RetWheelConstants.GOFUN_NULL_ERROR, "gofun.sim.isempty");
		}
		Integer status = validateUserVo.getStatus();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gId", gId);
		params.put("userAccount", userAccount);
		params.put("nickName", nickName);
		params.put("cityCode", cityCode);
		params.put("cityName", cityName);
		params.put("status", status);
	 	JSONObject jsonUser = userService.addUser(params);
	 	logger.info("===step3:【用户登录】(UserController-login)-新增用户-返回信息, jsonUserLogin:{}", jsonUser);
       	String bootCode = Objects.toString(jsonUser.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
       	UserVo userVo = JSONObject.toJavaObject(jsonUser, UserVo.class);
       	Integer userId = userVo.getUserId();
       	Integer loginCount = userVo.getLoginCount();
       	//实时排名(能量和算力排名)
       	BigDecimal diamond = userVo.getDiamond();
       	Integer calculate = userVo.getCalculate();
       	Integer userStatus = userVo.getStatus();

       	if(SqlWheelConstants.SQL_USER_STATUS_FREEZE.equals(userStatus)) {
			return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.USER_FREEZE_ERROR_MSG, RetWheelConstants.USER_FREEZE_ERROR, RetWheelConstants.USER_FREEZE_ERROR_MSG);
       	} else if(SqlWheelConstants.SQL_USER_STATUS_CANCEL.equals(userStatus)) {
       		return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.USER_CANCEL_ERROR_MSG, RetWheelConstants.USER_CANCEL_ERROR, RetWheelConstants.USER_CANCEL_ERROR_MSG);
       	}


		UserLoginLogVo userLoginLogVo = new UserLoginLogVo();
		userLoginLogVo.setUserId(userId);
		userLoginLogVo.setLoginIp(requestIp);
		userLoginLogVo.setLoginTime(new Date());
		userLoginLogVo.setLoginType(SqlWheelConstants.SQL_USER_LOGIN_LOG_TYPE_LOGIN);
		userLoginLogVo.setLogType(SqlWheelConstants.SQL_USER_LOGIN_LOG_TYPE_H5);
		/** push数据推送(新用户登录送能量方块)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_USER_LOGIN_LOG;
		value = JSONObject.toJSONString(userLoginLogVo);
		logger.info("===step7:【用户登录】(UserController-login)-push数据推送(用户登录日志)-传入参数, queueKey:{}, value", queueKey, value);
		long l = redisService.lpush(queueKey, value);
		logger.info("===step7.1:【用户登录】(UserController-login)-push数据推送(用户登录日志)-返回信息, l:{}", l);

		//设置token
		String token = this.setToken(userId, userAccount, gToken);

		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setToken(token);
		userLoginVo.setgToken(gToken);
		userLoginVo.setUserAccount(userAccount);
		userLoginVo.setIsSign(isSign);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(RetWheelConstants.RESULT, userLoginVo);
        logger.info("===step8:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户退出接口
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户退出")
	@RequestMapping(value="/logOut",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse logOut(
		@RequestBody UserLoginRequest req) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String gToken = req.getgToken();
		if (StringUtils.isBlank(gToken)) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_NULL_ERROR_MSG);
		}

		//验证gToken
		JSONObject jsonGoFunValidateUser = goFunService.validateUser(gToken, this.gofunPortal);
		logger.info("===step2:【用户登录】(UserController-login))-验证gofunApp用户登陆状态, jsonGoFunValidateUser:{}", jsonGoFunValidateUser);
		String goFunCode = Objects.toString(jsonGoFunValidateUser.get(GoFunConstants.CODE), "");
		String goFunMsg = Objects.toString(jsonGoFunValidateUser.get(GoFunConstants.MSG), "");
		if (!StringUtils.equals(goFunCode, GoFunConstants.OK)) {
			//gtoken已过期
			if (StringUtils.equals(goFunCode, GoFunConstants.ERROR_1005)) {
				return new BaseRestMapResponse(RetWheelConstants.GTOKEN_ERROR, RetWheelConstants.GTOKEN_EXPIRE_MSG, RetWheelConstants.GTOKEN_EXPIRE, RetWheelConstants.GTOKEN_EXPIRE_MSG);
			} else {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, goFunMsg, RetWheelConstants.TDP_GOFUN_ERROR, goFunMsg);
			}
		}
		JSONObject jsonGoFunDataValidateUser = jsonGoFunValidateUser.getJSONObject(GoFunConstants.DATA);
		ValidateUserVo validateUserVo = JSONObject.toJavaObject(jsonGoFunDataValidateUser, ValidateUserVo.class);
		String gId = validateUserVo.getgId();
		String userAccount = validateUserVo.getUserAccount();
		String nickName = validateUserVo.getNickName();
		String cityCode = validateUserVo.getCityCode();
		String cityName = validateUserVo.getCityName();
		if(StringUtils.isBlank(gId)) {
			return new BaseRestMapResponse(RetWheelConstants.GOFUN_ERROR, "userId为空", RetWheelConstants.GOFUN_NULL_ERROR, "gofun.userId.isempty");
		} else if(StringUtils.isBlank(userAccount)) {
			return new BaseRestMapResponse(RetWheelConstants.GOFUN_ERROR, "手机号码为空", RetWheelConstants.GOFUN_NULL_ERROR, "gofun.sim.isempty");
		}
		Integer status = validateUserVo.getStatus();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gId", gId);
		params.put("userAccount", userAccount);
		params.put("nickName", nickName);
		params.put("cityCode", cityCode);
		params.put("cityName", cityName);
		params.put("status", status);
	 	JSONObject jsonUser = userService.addUser(params);
	 	logger.info("===step3:【用户登录】(UserController-login)-新增用户-返回信息, jsonUserLogin:{}", jsonUser);
       	String bootCode = Objects.toString(jsonUser.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
       	UserVo userVo = JSONObject.toJavaObject(jsonUser, UserVo.class);
       	Integer userId = userVo.getUserId();
       	Integer loginCount = userVo.getLoginCount();
       	//实时排名(能量和算力排名)
       	BigDecimal diamond = userVo.getDiamond();
       	Integer calculate = userVo.getCalculate();
       	Integer userStatus = userVo.getStatus();

       	if(SqlWheelConstants.SQL_USER_STATUS_FREEZE.equals(userStatus)) {
			return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.USER_FREEZE_ERROR_MSG, RetWheelConstants.USER_FREEZE_ERROR, RetWheelConstants.USER_FREEZE_ERROR_MSG);
       	} else if(SqlWheelConstants.SQL_USER_STATUS_CANCEL.equals(userStatus)) {
       		return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.USER_CANCEL_ERROR_MSG, RetWheelConstants.USER_CANCEL_ERROR, RetWheelConstants.USER_CANCEL_ERROR_MSG);
       	}


		UserLoginLogVo userLoginLogVo = new UserLoginLogVo();
		userLoginLogVo.setUserId(userId);
		userLoginLogVo.setLoginIp(requestIp);
		userLoginLogVo.setLoginTime(new Date());
		userLoginLogVo.setLoginType(SqlWheelConstants.SQL_USER_LOGIN_LOG_TYPE_LOGIN);
		userLoginLogVo.setLogType(SqlWheelConstants.SQL_USER_LOGIN_LOG_TYPE_H5);
		/** push数据推送(新用户登录送能量方块)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_USER_LOGIN_LOG;
		value = JSONObject.toJSONString(userLoginLogVo);
		logger.info("===step7:【用户登录】(UserController-login)-push数据推送(用户登录日志)-传入参数, queueKey:{}, value", queueKey, value);
		long l = redisService.lpush(queueKey, value);
		logger.info("===step7.1:【用户登录】(UserController-login)-push数据推送(用户登录日志)-返回信息, l:{}", l);

		//设置token
		String token = this.setToken(userId, userAccount, gToken);

		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setToken(token);
		userLoginVo.setgToken(gToken);
		userLoginVo.setUserAccount(userAccount);
		userLoginVo.setIsSign(isSign);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(RetWheelConstants.RESULT, userLoginVo);
        logger.info("===step8:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户注册
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户注册")
	@RequestMapping(value="/register",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse register(
		@RequestBody UserLoginRequest req) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String gToken = req.getgToken();
		if (StringUtils.isBlank(gToken)) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_NULL_ERROR_MSG);
		}

		//验证gToken
		JSONObject jsonGoFunValidateUser = goFunService.validateUser(gToken, this.gofunPortal);
		logger.info("===step2:【用户登录】(UserController-login))-验证gofunApp用户登陆状态, jsonGoFunValidateUser:{}", jsonGoFunValidateUser);
		String goFunCode = Objects.toString(jsonGoFunValidateUser.get(GoFunConstants.CODE), "");
		String goFunMsg = Objects.toString(jsonGoFunValidateUser.get(GoFunConstants.MSG), "");
		if (!StringUtils.equals(goFunCode, GoFunConstants.OK)) {
			//gtoken已过期
			if (StringUtils.equals(goFunCode, GoFunConstants.ERROR_1005)) {
				return new BaseRestMapResponse(RetWheelConstants.GTOKEN_ERROR, RetWheelConstants.GTOKEN_EXPIRE_MSG, RetWheelConstants.GTOKEN_EXPIRE, RetWheelConstants.GTOKEN_EXPIRE_MSG);
			} else {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, goFunMsg, RetWheelConstants.TDP_GOFUN_ERROR, goFunMsg);
			}
		}
		JSONObject jsonGoFunDataValidateUser = jsonGoFunValidateUser.getJSONObject(GoFunConstants.DATA);
		ValidateUserVo validateUserVo = JSONObject.toJavaObject(jsonGoFunDataValidateUser, ValidateUserVo.class);
		String gId = validateUserVo.getgId();
		String userAccount = validateUserVo.getUserAccount();
		String nickName = validateUserVo.getNickName();
		String cityCode = validateUserVo.getCityCode();
		String cityName = validateUserVo.getCityName();
		if(StringUtils.isBlank(gId)) {
			return new BaseRestMapResponse(RetWheelConstants.GOFUN_ERROR, "userId为空", RetWheelConstants.GOFUN_NULL_ERROR, "gofun.userId.isempty");
		} else if(StringUtils.isBlank(userAccount)) {
			return new BaseRestMapResponse(RetWheelConstants.GOFUN_ERROR, "手机号码为空", RetWheelConstants.GOFUN_NULL_ERROR, "gofun.sim.isempty");
		}
		Integer status = validateUserVo.getStatus();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gId", gId);
		params.put("userAccount", userAccount);
		params.put("nickName", nickName);
		params.put("cityCode", cityCode);
		params.put("cityName", cityName);
		params.put("status", status);
	 	JSONObject jsonUser = userService.addUser(params);
	 	logger.info("===step3:【用户登录】(UserController-login)-新增用户-返回信息, jsonUserLogin:{}", jsonUser);
       	String bootCode = Objects.toString(jsonUser.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
       	UserVo userVo = JSONObject.toJavaObject(jsonUser, UserVo.class);
       	Integer userId = userVo.getUserId();
       	Integer loginCount = userVo.getLoginCount();
       	//实时排名(能量和算力排名)
       	BigDecimal diamond = userVo.getDiamond();
       	Integer calculate = userVo.getCalculate();
       	Integer userStatus = userVo.getStatus();

       	if(SqlWheelConstants.SQL_USER_STATUS_FREEZE.equals(userStatus)) {
			return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.USER_FREEZE_ERROR_MSG, RetWheelConstants.USER_FREEZE_ERROR, RetWheelConstants.USER_FREEZE_ERROR_MSG);
       	} else if(SqlWheelConstants.SQL_USER_STATUS_CANCEL.equals(userStatus)) {
       		return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.USER_CANCEL_ERROR_MSG, RetWheelConstants.USER_CANCEL_ERROR, RetWheelConstants.USER_CANCEL_ERROR_MSG);
       	}


		UserLoginLogVo userLoginLogVo = new UserLoginLogVo();
		userLoginLogVo.setUserId(userId);
		userLoginLogVo.setLoginIp(requestIp);
		userLoginLogVo.setLoginTime(new Date());
		userLoginLogVo.setLoginType(SqlWheelConstants.SQL_USER_LOGIN_LOG_TYPE_LOGIN);
		userLoginLogVo.setLogType(SqlWheelConstants.SQL_USER_LOGIN_LOG_TYPE_H5);
		/** push数据推送(新用户登录送能量方块)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_USER_LOGIN_LOG;
		value = JSONObject.toJSONString(userLoginLogVo);
		logger.info("===step7:【用户登录】(UserController-login)-push数据推送(用户登录日志)-传入参数, queueKey:{}, value", queueKey, value);
		long l = redisService.lpush(queueKey, value);
		logger.info("===step7.1:【用户登录】(UserController-login)-push数据推送(用户登录日志)-返回信息, l:{}", l);

		//设置token
		String token = this.setToken(userId, userAccount, gToken);

		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setToken(token);
		userLoginVo.setgToken(gToken);
		userLoginVo.setUserAccount(userAccount);
		userLoginVo.setIsSign(isSign);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(RetWheelConstants.RESULT, userLoginVo);
        logger.info("===step8:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}


}