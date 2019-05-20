package com.cloud.consumer.safe.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.user.login.UserLoginFirstPasswordRequest;
import com.cloud.consumer.safe.rest.request.user.login.UserLoginRequest;
import com.cloud.consumer.safe.rest.request.user.login.UserRegisterRequest;
import com.cloud.consumer.safe.service.IUserService;
import com.cloud.consumer.safe.util.PatternUtil;
import com.cloud.consumer.safe.vo.enterprise.EnterpriseVo;
import com.cloud.consumer.safe.vo.user.UserAdminLoginLogVo;
import com.cloud.consumer.safe.vo.user.UserAdminLoginVo;
import com.cloud.consumer.safe.vo.user.UserAdminVo;
import com.cloud.consumer.safe.vo.user.UserInfoVo;
import com.cloud.consumer.safe.vo.user.login.UserLoginErrorVo;
import com.cloud.consumer.safe.vo.user.login.UserLoginVo;

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
@RequestMapping("/user")
public class UserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserService userService;

	/**
	 * 用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户登录")
	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse login(
		@Validated @RequestBody UserLoginRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String userPassword = req.getUserPassword();
		req.setUserPassword(DigestUtils.sha256Hex(userPassword));

		JSONObject jsonUserFirst = userService.loginAdminFirst(req);
		logger.info("===step2:【用户登录】(UserController-login)-用户登录第一步, jsonUserFirst:{}", jsonUserFirst);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserFirst, UserInfoVo.class);
		UserAdminVo userAdminVo = JSONObject.toJavaObject(jsonUserFirst, UserAdminVo.class);
		UserAdminLoginVo userAdminLoginVo = JSONObject.toJavaObject(jsonUserFirst, UserAdminLoginVo.class);
		Integer firstLogin = userAdminLoginVo.getFirstLogin();
		Integer userId = userInfoVo.getUserId();
		String userName = userInfoVo.getUserName();
		Integer enterpriseId = userAdminVo.getEnterpriseId();

		if(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_NO.equals(firstLogin)) {
			BaseRestMapResponse userErrorResponse = new BaseRestMapResponse(RetSafeAdminResultEnum.USER_FIRST_LOGIN_CHANGE_PASSWORD);
			UserLoginErrorVo userLoginErrorVo = new UserLoginErrorVo();
			userLoginErrorVo.setEnterpriseId(enterpriseId);
			userLoginErrorVo.setUserId(userId);
			userErrorResponse.put(CommConstants.RESULT, userLoginErrorVo);
			this.setFirstLoginAccessToken(userId);
			return userErrorResponse;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("enterpriseId", enterpriseId);
		JSONObject jsonUserSecond = userService.loginAdminSecond(params);
		logger.info("===step3:【用户登录】(UserController-login)-用户登录第二步, jsonUserSecond:{}", jsonUserSecond);
		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonUserSecond, EnterpriseVo.class);
//		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserSecond, UserOrgVo.class);
//		OrgVo orgVo = JSONObject.toJavaObject(jsonUserSecond, OrgVo.class);
		String enterpriseName = enterpriseVo.getEnterpriseName();
//	    Integer orgId = userOrgVo.getOrgId();
//	    String orgName = orgVo.getOrgName();

		//设置token
		String token = this.setToken(enterpriseId, userId, userAccount, userName);

		UserAdminLoginLogVo userAdminLoginLogVo = new UserAdminLoginLogVo();
		userAdminLoginLogVo.setUserId(userId);
		userAdminLoginLogVo.setUserAccount(userAccount);
		userAdminLoginLogVo.setUserName(userName);
		userAdminLoginLogVo.setLoginType(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_LOG_LOGIN_TYPE_LOGIN);
		userAdminLoginLogVo.setLoginTime(new Date());
		userAdminLoginLogVo.setLoginMode("PC");
		userAdminLoginLogVo.setLogType(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_LOG_LOG_TYPE_PC);
		userAdminLoginLogVo.setLoginIp(requestIp);
		/** push数据推送(用户管理登录日志)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_CLOUD_SAFE_USER_ADMIN_LOGIN_LOG;
		String value = JSONObject.toJSONString(userAdminLoginLogVo);
		logger.info("===step4:【用户登录】(BaseUserController-login)-push数据推送(用户管理登录日志)-传入参数, queueKey:{}, value", queueKey, value);
		long l = redisService.lpush(queueKey, value);
		logger.info("===step4.1:【用户登录】(BaseUserController-login)-push数据推送(用户管理登录日志)-返回信息, l:{}", l);

		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setToken(token);
		userLoginVo.setEnterpriseId(enterpriseId);
		userLoginVo.setEnterpriseName(enterpriseName);
		userLoginVo.setUserId(userId);
		userLoginVo.setUserAccount(userAccount);
		userLoginVo.setUserName(userName);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(CommConstants.RESULT, userLoginVo);
        logger.info("===ste54:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户退出
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户退出")
	@RequestMapping(value="/logout",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse logOut(
		@RequestBody UserLoginRequest req) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户退出】(UserController-logout)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		Integer userId = this.getTokenUserId();
		this.clearToken(userId);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step2:【用户退出】(UserController-logout)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户注册
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户注册")
	@RequestMapping(value="/register",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse register(
		@RequestBody UserRegisterRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户注册】(UserController-register)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		JSONObject jsonUser = userService.addAdminUser(req);
		logger.info("===step2:【用户注册】(UserController-register)-用户注册, jsonUser:{}", jsonUser);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step3:【用户注册】(UserController-register)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户首次登录修改密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户首次登录修改密码")
	@RequestMapping(value="/firstLogin/updatePassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updatePassword(
		@Validated @RequestBody UserLoginFirstPasswordRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户首次登录修改密码】(UserController-updatePassword)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String password = req.getPassword();
		String confirmPassword = req.getConfirmPassword();
		if(!PatternUtil.PASSWORD.matcher(password).matches()) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_RULE);
		} else if(!PatternUtil.PASSWORD.matcher(confirmPassword).matches()) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_RULE);
		}
		if(!StringUtils.equals(password, confirmPassword)) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_NOT_EQUQAL);
		}

		String accesstokenkey = RedisKeysUtil.CN_CLOUD_SAFE_ADMIN_FIRSTLOGIN_ACCESSTOKEN_USERID + userId;
		String accesstoken = redisService.get(accesstokenkey);
		logger.info("===step2:【用户首次登录修改密码】(UserController-updatePassword)-获取accesstoken信息, accesstokenkey:{}, accesstoken:{}", accesstokenkey, accesstoken);
		if(StringUtils.isBlank(accesstoken)) {
			return new BaseRestMapResponse(RetSafeAdminResultEnum.USER_FIRST_LOGIN_CHANGE_PASSWORD_EXPIRE);
		}
		if(!userId.equals(new Integer(accesstoken))) {
			return new BaseRestMapResponse(RetSafeAdminResultEnum.USER_FIRST_LOGIN_CHANGE_PASSWORD_ILLEGAL);
		}

		req.setPassword(DigestUtils.sha256Hex(password));
		JSONObject jsonAdminPassword = userService.updateAdminPassword(req);
		logger.info("===step3:【用户首次登录修改密码】(UserController-updatePassword)-修改用户管理密码, jsonAdminPassword:{}", jsonAdminPassword);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step4:【用户首次登录修改密码】(UserController-updatePassword)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

//	/**
//	 * 重置用户管理密码
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "重置用户管理密码")
//	@RequestMapping(value="/reset/password",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse resetPassword(
//		@Validated @RequestBody UserLoginFirstPasswordRequest req,
//		BindingResult bindingResult) {
//		String requestIp = this.getRequestIp();
//		logger.info("===step1:【重置用户管理密码】(UserController-resetPassword)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));
//
//		Integer userId = req.getUserId();
//
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("userId", userId);
//		JSONObject jsonResetAdminPassword = userService.resetAdminPassword(params);
//		logger.info("===step2:【重置用户管理密码】(UserController-resetPassword)-重置密码, jsonResetAdminPassword:{}", jsonResetAdminPassword);
//
//        //返回信息
//		BaseRestMapResponse userResponse = new BaseRestMapResponse();
//        logger.info("===step3:【重置用户管理密码】(UserController-resetPassword)-返回信息, userResponse:{}", userResponse);
//		return userResponse;
//	}

}