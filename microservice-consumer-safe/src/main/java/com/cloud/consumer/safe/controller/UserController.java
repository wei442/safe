package com.cloud.consumer.safe.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.wheel.RetWheelConstants;
import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.login.UserEnterpriseRegisterRequest;
import com.cloud.consumer.safe.rest.request.login.UserLoginRequest;
import com.cloud.consumer.safe.service.IUserAdminLoginService;
import com.cloud.consumer.safe.service.IUserAdminPasswordService;
import com.cloud.consumer.safe.service.IUserAdminService;
import com.cloud.consumer.safe.service.IUserInfoService;
import com.cloud.consumer.safe.service.IUserService;
import com.cloud.consumer.safe.vo.EnterpriseVo;
import com.cloud.consumer.safe.vo.UserInfoVo;
import com.cloud.consumer.safe.vo.user.UserLoginVo;

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

	//用户信息 Service
	@Autowired
	private IUserInfoService userInfoService;

	//用户管理 Service
	@Autowired
	private IUserAdminService userAdminService;

	//用户管理密码 Service
	@Autowired
	private IUserAdminPasswordService userAdminPasswordService;

	//用户管理登录 Service
	@Autowired
	private IUserAdminLoginService userAdminLoginService;

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
		@RequestBody UserLoginRequest req) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		if(StringUtils.isBlank(userAccount)) {
        	throw new SafeException(RetSafeAdminResultEnum.PARAMETER_NULL.getCode(), "用户账户为空");
		}

		JSONObject jsonUser = userService.loginFirst(req);
        logger.info("===step3:【用户登录】(UserController-login)-用户登录第一步, jsonUser:{}", jsonUser);

		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUser, UserInfoVo.class);
		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonUser, EnterpriseVo.class);
		Integer userId = userInfoVo.getUserId();
		String userName = userInfoVo.getUserName();
		Integer enterpriseId = enterpriseVo.getEnterpriseId();

		String userPassword = req.getUserPassword();
		if(StringUtils.isBlank(userPassword)) {
        	throw new SafeException(RetSafeAdminResultEnum.PARAMETER_NULL.getCode(), "用户密码为空");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
   		params.put("userPassword", userPassword);
		jsonUser = userService.loginSecond(params);
        logger.info("===step3:【用户登录】(UserController-login)-用户登录第二步, jsonUser:{}", jsonUser);

		//设置token
		String token = this.setToken(enterpriseId, userId, userAccount);

		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setToken(token);
		userLoginVo.setEnterpriseId(enterpriseId);
		userLoginVo.setUserId(userId);
		userLoginVo.setUserAccount(userAccount);
		userLoginVo.setUserName(userName);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(RetWheelConstants.RESULT, userLoginVo);
        logger.info("===step3:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
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
	 * 用户企业注册
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户企业注册")
	@RequestMapping(value="/enterprise/register",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse userEnterpriseRegister(
		@RequestBody UserEnterpriseRegisterRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户企业注册】(UserController-userEnterpriseRegister)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));
		this.bindingResult(bindingResult);

		JSONObject jsonUser = userService.addUserEnterprise(req);
		logger.info("===step2:【用户企业注册】(UserController-userEnterpriseRegister)-用户企业注册, jsonUser:{}", jsonUser);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUser, UserInfoVo.class);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.put(RetWheelConstants.RESULT, userInfoVo);
        logger.info("===step3:【用户企业注册】(UserController-userEnterpriseRegister)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

//	/**
//	 * 用户登录
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "用户登录")
//	@RequestMapping(value="/login1",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse login1(
//		@Validated @RequestBody UserLoginRequest req,
//		BindingResult bindingResult) {
//		String requestIp = this.getRequestIp();
//		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));
//		this.bindingResult(bindingResult);
//
//		String userAccount = req.getUserAccount();
//		String userPassword = req.getUserPassword();
//
//		JSONObject jsonUser = userService.loginFirst(req);
//		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUser, UserInfoVo.class);
//		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonUser, EnterpriseVo.class);
//		Integer userId = userInfoVo.getUserId();
//		String userName = userInfoVo.getUserName();
//		Integer enterpriseId = enterpriseVo.getEnterpriseId();
//
//
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("userId", userId);
//   		params.put("userPassword", userPassword);
//		jsonUser = userService.loginSecond(params);
////		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonUser, EnterpriseVo.class);
////		Integer enterpriseId = enterpriseVo.getEnterpriseId();
//
//		//设置token
//		String token = this.setToken(enterpriseId, userId, userAccount);
//
//		UserLoginVo userLoginVo = new UserLoginVo();
//		userLoginVo.setToken(token);
//		userLoginVo.setEnterpriseId(enterpriseId);
//		userLoginVo.setUserId(userId);
//		userLoginVo.setUserAccount(userAccount);
//		userLoginVo.setUserName(userName);
//
//        //返回信息
//		BaseRestMapResponse userResponse = new BaseRestMapResponse();
//		userResponse.put(RetWheelConstants.RESULT, userLoginVo);
//        logger.info("===step3:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
//		return userResponse;
//	}


}