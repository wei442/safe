package com.cloud.consumer.safe.controller;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
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
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.base.user.login.BaseUserLoginRequest;
import com.cloud.consumer.safe.service.IBaseUserService;
import com.cloud.consumer.safe.vo.base.user.BaseUserInfoVo;
import com.cloud.consumer.safe.vo.base.user.BaseUserLoginLogVo;
import com.cloud.consumer.safe.vo.base.user.login.UserLoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户管理 BaseUserController
 * @author wei.yong
 * @ClassName: BaseUserController
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@Api(tags = "基础用户")
@RestController
@RequestMapping("/base/user")
public class BaseUserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理员登录 Service
	@Autowired
	private IBaseUserService baseUserService;

	/**
	 * 用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "基础用户登录")
	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse login(
		@Validated @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【基础用户登录】(BaseUserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String userPassword = req.getUserPassword();
		req.setUserPassword(DigestUtils.sha256Hex(userPassword));

		JSONObject jsonBaseUser = baseUserService.login(req);
		logger.info("===step2:【基础用户登录】(BaseUserController-login)-用户登录, jsonBaseUser:{}", jsonBaseUser);
		BaseUserInfoVo baseUserInfoVo = JSONObject.toJavaObject(jsonBaseUser, BaseUserInfoVo.class);
		Integer baseUserId = baseUserInfoVo.getBaseUserId();
		String userName = baseUserInfoVo.getUserName();

		//设置token
		String token = this.setToken(baseUserId, userAccount, userName);

		BaseUserLoginLogVo baseUserLoginLogVo = new BaseUserLoginLogVo();
		baseUserLoginLogVo.setBaseUserId(baseUserId);
		baseUserLoginLogVo.setUserAccount(userAccount);
		baseUserLoginLogVo.setUserName(userName);
		baseUserLoginLogVo.setLoginType(SqlSafeConstants.SQL_BASE_USER_LOGIN_LOG_LOGIN);
		baseUserLoginLogVo.setLoginTime(new Date());
		baseUserLoginLogVo.setLoginMode("PC");
		baseUserLoginLogVo.setLoginIp(requestIp);
		/** push数据推送(基础用户登录日志)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_CLOUD_SAFE_BASE_USER_LOGIN_LOG;
		String value = JSONObject.toJSONString(baseUserLoginLogVo);
		logger.info("===step3:【基础用户登录】(BaseUserController-login)-push数据推送(基础用户登录日志)-传入参数, queueKey:{}, value", queueKey, value);
		long l = redisService.lpush(queueKey, value);
		logger.info("===step3.1:【基础用户登录】(BaseUserController-login)-push数据推送(基础用户登录日志)-返回信息, l:{}", l);

		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setToken(token);
		userLoginVo.setBaseUserId(baseUserId);
		userLoginVo.setUserAccount(userAccount);
		userLoginVo.setUserName(userName);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(CommConstants.RESULT, userLoginVo);
        logger.info("===step4:【基础用户登录】(BaseUserController-login)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户退出
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "基础用户退出")
	@RequestMapping(value="/logout",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse logout(
		@RequestBody BaseUserLoginRequest req) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【基础用户退出】(BaseUserController-logout)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		JSONObject payloadJSON = this.getTokenPayload();
		Integer baseUserId = new Integer(Objects.toString(payloadJSON.get(CommConstants.BASE_USER_ID)));
		String userAccount = Objects.toString(payloadJSON.get(CommConstants.USER_ACCOUNT));
		String userName = Objects.toString(payloadJSON.get(CommConstants.USER_NAME));
		this.clearToken(baseUserId);

		BaseUserLoginLogVo baseUserLoginLogVo = new BaseUserLoginLogVo();
		baseUserLoginLogVo.setBaseUserId(baseUserId);
		baseUserLoginLogVo.setUserAccount(userAccount);
		baseUserLoginLogVo.setUserName(userName);
		baseUserLoginLogVo.setLoginType(SqlSafeConstants.SQL_BASE_USER_LOGIN_LOG_LOGOUT);
		baseUserLoginLogVo.setLoginTime(new Date());
		baseUserLoginLogVo.setLoginMode("PC");
		baseUserLoginLogVo.setLoginIp(requestIp);
		/** push数据推送(基础用户登录日志)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_CLOUD_SAFE_BASE_USER_LOGIN_LOG;
		String value = JSONObject.toJSONString(baseUserLoginLogVo);
		logger.info("===step3:【基础用户登录】(BaseUserController-login)-push数据推送(基础用户登录日志)-传入参数, queueKey:{}, value", queueKey, value);
		long l = redisService.lpush(queueKey, value);
		logger.info("===step3.1:【基础用户登录】(BaseUserController-login)-push数据推送(基础用户登录日志)-返回信息, l:{}", l);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step2:【基础用户退出】(BaseUserController-logout)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

}