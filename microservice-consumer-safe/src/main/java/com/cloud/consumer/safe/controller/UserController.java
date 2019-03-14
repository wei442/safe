package com.cloud.consumer.safe.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.Period;
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
import com.cloud.common.constants.wheel.WheelConstants;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.user.UserLoginRequest;
import com.cloud.consumer.safe.service.IUserInfoService;
import com.cloud.consumer.safe.vo.gofun.ValidateUserVo;
import com.cloud.consumer.safe.vo.user.NewUserLoginVo;
import com.cloud.consumer.safe.vo.user.UserLoginLogVo;
import com.cloud.consumer.safe.vo.user.UserLoginVo;
import com.cloud.consumer.safe.vo.user.UserSignVo;
import com.cloud.consumer.safe.vo.user.UserVo;

import io.swagger.annotations.Api;

/**
 * 用户信息管理 UserController
 * @author wei.yong
 * @ClassName: UserController
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 4.1.2.1	用户登录接口
	 * 不做token验证
	 * @param req
	 * @param request
	 */
	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse login(
		@RequestBody UserLoginRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String gToken = req.getgToken();
		if (StringUtils.isBlank(gToken)) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_NULL_ERROR_MSG, this.getRequestParameterEmpty(), "gToken为空");
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

       	this.insertDiamondRealRank(userId, userAccount, diamond, loginCount);
       	this.insertCalculateRealRank(userId, userAccount, calculate, loginCount);

       	//新用户登录送能量方块
       	if(loginCount != null && loginCount.equals(1)) {
    		NewUserLoginVo newUserLoginVo = new NewUserLoginVo();
    		newUserLoginVo.setDiamondCode(WheelConstants.DIAMONDCODE_0009);
    		newUserLoginVo.setUserId(userId);
    		newUserLoginVo.setUserAccount(userAccount);
    		newUserLoginVo.setType(WheelConstants.NEW_USER_LOGIN_TYPE_LOGIN);
    		/** push数据推送(能量记录)队列-左进右出  **/
    		String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_NEW_USER_LOGIN;
    		String value = JSONObject.toJSONString(newUserLoginVo);
    		logger.info("===step3.1:【用户登录】(UserController-login)-push数据推送(新用户登录送能量方块)-传入参数, queueKey:{}, value", queueKey, value);
    		long l = redisService.lpush(queueKey, value);
    		logger.info("===step3.2:【用户登录】(UserController-login)-push数据推送(新用户登录送能量方块)-返回信息, l:{}", l);

    		//新增新用户赠送固定能量记录
    		this.addNewUserGiftDiamondRecord(userId, WheelConstants.DIAMONDCODE_0009);
       	}

//       	String usertaskkey = RedisKeysUtil.CN_OCHAIN_WHEEL_APP_H5_LOGIN_USERTASK_USERID_TIME + userId + ":" + new LocalDate().toString(DateFormatConstants.DF_YYYYMMDD);
//       	String usertaskResult = redisService.get(usertaskkey);
//       	logger.info("===step4:【用户登录】(UserController-login)-获取用户算力任务redis结果, usertaskResult:{}", usertaskResult);
//       	//为空表示今天第一次登录，然后才获取并添加用户算力任务
//       	if(StringUtils.isBlank(usertaskResult)) {
//       		//新用户查询所有算力任务完成情况-暂时注释
//			params = new HashMap<String, Object>();
//			params.put("userId", gId);
//			//新用户查询所有算力任务完成情况
//			JSONObject jsonGoFunUserTask = goFunService.getUserTask(params);
//			logger.info("===step4.1:【用户登录】(UserController-login)-查询所有算力任务完成情况, jsonGoFunUserTask:{}", jsonGoFunUserTask);
//			goFunCode = Objects.toString(jsonGoFunUserTask.get(GoFunConstants.CODE), "");
//			if (StringUtils.equals(goFunCode, GoFunConstants.OK)) {
//				JSONObject jsonDataGoFunUserTask = jsonGoFunUserTask.getJSONObject(GoFunConstants.DATA);
//				if(jsonDataGoFunUserTask != null && !jsonDataGoFunUserTask.isEmpty()) {
//					UserTaskVo userTaskVo = JSONObject.toJavaObject(jsonDataGoFunUserTask, UserTaskVo.class);
//					this.addUserTask(userTaskVo, userId, userAccount, gId);
//				}
//			}
//       	}

		LocalDate localDate = new LocalDate();
       	//今天签到字符串
       	String todaySignTimeStr = localDate.toString();
		JSONObject jsonUserSign = userSignService.getUserSignByUserId(userId, todaySignTimeStr);
		logger.info("===step5:【用户登录】(UserController-login)-根据userId和todaySignTimeStr获取用户签到-返回信息, jsonUserSign:{}", jsonUserSign);
		bootCode = Objects.toString(jsonUserSign.get(BootWheelConstants.BOOT_CODE), "");
		UserSignVo userSignVo = null;
		Integer isSign = WheelConstants.USER_SIGN_NO;
		Integer signDays = 0;
		if (StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			userSignVo = JSONObject.toJavaObject(jsonUserSign, UserSignVo.class);
			isSign = userSignVo.getIsSign();
			signDays = userSignVo.getSignDays();
		}

		String queueUserSignTimeKey = RedisKeysUtil.CN_OCHAIN_WHEEL_USER_SIGN_TIME_USERID + userId +":"+ localDate.toString(DateFormatConstants.DF_YYYYMMDD);
		String value = redisService.get(queueUserSignTimeKey);
		logger.info("===step6:【用户登录】(UserController-login)-获取指定用户签到是否已增减签到天数key值-返回信息, queueUserSignTimeKey:{}, value:{}", queueUserSignTimeKey, value);
		//已签到没有减去以前添加的7日累计算力
		if(StringUtils.isBlank(value)) {
			//昨天签到字符串
			String yesterdaySignTimeStr = localDate.minus(Period.days(1)).toString();
			NewUserLoginVo newUserLoginVo = new NewUserLoginVo();
			newUserLoginVo.setSignTimeStr(yesterdaySignTimeStr);
			newUserLoginVo.setUserId(userId);
			newUserLoginVo.setUserAccount(userAccount);
			newUserLoginVo.setSignDays(signDays);
			newUserLoginVo.setType(WheelConstants.NEW_USER_LOGIN_TYPE_LOGIN_SIGN);
			newUserLoginVo.setQueueUserSignTimeKey(queueUserSignTimeKey);
			/** push数据推送(新用户登录送能量方块)队列-左进右出  **/
			String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_NEW_USER_LOGIN;
			value = JSONObject.toJSONString(newUserLoginVo);
			logger.info("===step6.1:【用户登录】(UserController-login)-push数据推送(用户昨日未签到)-传入参数, queueKey:{}, value", queueKey, value);
			long l = redisService.lpush(queueKey, value);
			logger.info("===step6.2:【用户登录】(UserController-login)-push数据推送(用户昨日未签到)-返回信息, l:{}", l);
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
     * 4.1.2.2	用户签到接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/sign",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse sign(
		@RequestBody UserLoginRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【用户签到接口】(UserController-sign)-用户签到接口, 请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		JSONObject payloadJSON = this.getTokenPayload();
   		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
   		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		JSONObject jsonUserSign = userSignService.addUserSign(params);
		logger.info("===step2:【用户签到接口】(UserController-sign)-根据userId获取用户签到-返回信息, jsonUserSign:{}", jsonUserSign);
       	String bootCode = Objects.toString(jsonUserSign.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		UserSignVo userSignVo = JSONObject.toJavaObject(jsonUserSign, UserSignVo.class);
		Integer isSign = userSignVo.getIsSign();
		Integer signDays = userSignVo.getSignDays();
		Integer isFirst = userSignVo.getIsFirst();

       	//今天签到字符串
       	String signTimeStr = new LocalDate().toString();
		String todayUserSignKey = RedisKeysUtil.CN_OCHAIN_WHEEL_USER_SIGN_USERID + userId + ":" + signTimeStr;
		String todayUserSignResult = redisService.get(todayUserSignKey);
		logger.info("===step3:【用户签到接口】(UserController-sign)-获取今天用户签到, todayUserSignKey:{}, todayUserSignResult:{}", todayUserSignKey, todayUserSignResult);
		if(StringUtils.isBlank(todayUserSignResult)) {
			//今日首次签到，添加签到算力
			if(WheelConstants.USER_SIGN_FIRST_YES.equals(isFirst)) {
				//小于7天时候才增加每日签到临时算力，大于7天固定增加7天固定算力
				if(signDays != null && signDays <= 7) {
					NewUserLoginVo newUserLoginVo = new NewUserLoginVo();
					newUserLoginVo.setUserId(userId);
					newUserLoginVo.setUserAccount(userAccount);
					newUserLoginVo.setSignDays(signDays);
					newUserLoginVo.setType(WheelConstants.NEW_USER_LOGIN_TYPE_SIGN);
					newUserLoginVo.setSignTimeStr(signTimeStr);
					/** push数据推送(新用户登录送能量方块)队列-左进右出  **/
					String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_NEW_USER_LOGIN;
					String value = JSONObject.toJSONString(newUserLoginVo);
					logger.info("===step4:【用户签到接口】(UserController-sign)-push数据推送(新用户签到)-传入参数, queueKey:{}, value", queueKey, value);
					long l = redisService.lpush(queueKey, value);
					logger.info("===step4.1:【用户签到接口】(UserController-sign)-push数据推送(新用户签到)-返回信息, l:{}", l);
				} else if(signDays != null && signDays > 7) {
					NewUserLoginVo newUserLoginVo = new NewUserLoginVo();
					newUserLoginVo.setUserId(userId);
					newUserLoginVo.setUserAccount(userAccount);
					newUserLoginVo.setSignDays(signDays);
					newUserLoginVo.setType(WheelConstants.NEW_USER_LOGIN_TYPE_SIGN_SEVEN_DAYS);
					newUserLoginVo.setSignTimeStr(signTimeStr);
					/** push数据推送(新用户登录送能量方块)队列-左进右出  **/
					String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_NEW_USER_LOGIN;
					String value = JSONObject.toJSONString(newUserLoginVo);
					logger.info("===step4.2:【用户签到接口】(UserController-sign)-push数据推送(新用户签到)-传入参数, queueKey:{}, value", queueKey, value);
					long l = redisService.lpush(queueKey, value);
					logger.info("===step4.3:【用户签到接口】(UserController-sign)-push数据推送(新用户签到)-返回信息, l:{}", l);
				}
			}
		}

		long l = redisService.incr(todayUserSignKey);
		long ll = redisService.expire(todayUserSignKey, RetWheelConstants.TWENTY_FOUR_HOUR_SECONDS_TIME);
		logger.info("===step5:【用户签到接口】(UserController-sign)-今天签到值加1, todayUserSignKey:{}, l:{}, ll:{}", todayUserSignKey, l, ll);

		String desc = "每日签到获取萃取力是临时的，签到获取的萃取力有效期为七天，有效期内签到获取萃取力是累计，用户连续签到即可获取萃取力奖励";
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("isSign", isSign);
		result.put("desc", desc);
        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(RetWheelConstants.RESULT, result);
    	logger.info("===step6:【用户签到接口】(UserController-sign)-返回信息, userResponse:{}", userResponse);
    	return userResponse;
	}

}