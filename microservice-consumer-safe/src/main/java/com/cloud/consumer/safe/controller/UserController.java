package com.cloud.consumer.safe.controller;

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
import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.constants.wheel.RetWheelConstants;
import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.user.login.UserLoginFirstPasswordRequest;
import com.cloud.consumer.safe.rest.request.user.login.UserLoginRequest;
import com.cloud.consumer.safe.rest.request.user.login.UserRegisterRequest;
import com.cloud.consumer.safe.service.IUserAdminLoginService;
import com.cloud.consumer.safe.service.IUserAdminPasswordService;
import com.cloud.consumer.safe.service.IUserAdminService;
import com.cloud.consumer.safe.service.IUserInfoService;
import com.cloud.consumer.safe.service.IUserService;
import com.cloud.consumer.safe.util.PatternUtil;
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
		@Validated @RequestBody UserLoginRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户登录】(UserController-login)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String userPassword = req.getUserPassword();
		req.setUserPassword(DigestUtils.sha256Hex(userPassword));

//		JSONObject jsonUser = userService.login(req);
//        logger.info("===step3:【用户登录】(UserController-login)-用户登录, jsonUser:{}", jsonUser);
//		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUser, UserInfoVo.class);
//		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonUser, EnterpriseVo.class);
//		Integer userId = userInfoVo.getUserId();
//		String userName = userInfoVo.getUserName();
//		Integer enterpriseId = enterpriseVo.getEnterpriseId();

		JSONObject jsonUserFirst = userService.loginFirst(req);
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
			userErrorResponse.put(RetWheelConstants.RESULT, userLoginErrorVo);
			return userErrorResponse;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("enterpriseId", enterpriseId);
		JSONObject jsonUserSecond = userService.loginSecond(params);
		logger.info("===step3:【用户登录】(UserController-login)-用户登录第二步, jsonUserSecond:{}", jsonUserSecond);

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
        logger.info("===step4:【用户登录】(UserController-login)-返回信息, userResponse:{}", userResponse);
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

		JSONObject jsonUser = userService.addUser(req);
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
	@RequestMapping(value="/firstlogin/updatePassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updatePassword(
		@Validated @RequestBody UserLoginFirstPasswordRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【用户首次登录修改密码】(UserController-updatePassword)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
//		String userAccount = req.getUserAccount();
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

//		JSONObject jsonUserInfo = userInfoService.getByUserAccount(userAccount);
//        logger.info("===step2:【用户首次登录修改密码】(UserController-updatePassword)-根据userAccount获取用户信息, jsonUserInfo:{}", jsonUserInfo);
//		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);
//		Integer userId = userInfoVo.getUserId();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("password", DigestUtils.sha256Hex(password));
		JSONObject jsonUserAdminPassword = userAdminPasswordService.updateByUserId(params);
		logger.info("===step2:【用户首次登录修改密码】(UserController-updatePassword)-根据userId修改用户管理密码, jsonUserAdminPassword:{}", jsonUserAdminPassword);

		params = new HashMap<String, Object>();
		params.put("userId", userId);
		JSONObject jsonUserAdminLogin = userAdminLoginService.updateByUserId(params);
		logger.info("===step3:【用户首次登录修改密码】(UserController-updatePassword)-根据userId修改获取用户登录, jsonUserAdminLogin:{}", jsonUserAdminLogin);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step4:【用户首次登录修改密码】(UserController-updatePassword)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}




//	/**
//	 * 添加用户管理密码
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "首次登录用户管理密码")
//	@RequestMapping(value="/insert",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse insert(
//		@Validated @RequestBody UserAdminPasswordRequest req,
//		BindingResult bindingResult) {
//		logger.info("===step1:【添加用户管理密码】(UserAdminPasswordController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		String userAccount = req.getUserAccount();
//		JSONObject jsonUserInfo = userInfoService.getByUserAccount(userAccount);
//
//
//		Integer userId = req.getUserId();
//		UserAdminPassword userAdminPassword = userAdminPasswordService.selectByUserId(userId);
//		userAdminPassword = req.convertToUserAdminPassword();
//		if(userAdminPassword != null) {
//			int i = userAdminPasswordService.modify(userAdminPassword);
//			logger.info("===step2:【修改用户管理密码】(UserAdminPasswordController-modify)-修改用户管理密码, i:{}", i);
//		} else {
//			int i = userAdminPasswordService.insert(userAdminPassword);
//			logger.info("===step2:【添加用户管理密码】(UserAdminPasswordController-insert)-插入用户管理密码, i:{}", i);
//		}
//
//		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
//		logger.info("===step3:【添加用户管理密码】(UserAdminPasswordController-insert)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
//		return userAdminPasswordResponse;
//	}


//	/**
//	 * 新增用户管理密码
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "新增用户管理密码")
//	@RequestMapping(value="/addUserAdminPassword",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse addUserAdminPassword(
//		@Validated @RequestBody UserAdminPasswordRequest req,
//		BindingResult bindingResult) {
//		logger.info("===step1:【新增用户管理密码】(UserAdminPasswordController-addUserAdminPassword)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		JSONObject jsonUserAdminPassword = userAdminPasswordService.add(req);
//		logger.info("===step2:【新增用户管理密码】(UserAdminPasswordController-addUserAdminPassword)-新增用户管理密码, jsonUserAdminPassword:{}", jsonUserAdminPassword);
//		UserAdminPasswordVo userAdminPasswordVo = JSONObject.toJavaObject(jsonUserAdminPassword, UserAdminPasswordVo.class);
//
//		//返回信息
//		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
//		userAdminPasswordResponse.put(RetSafeConstants.RESULT, userAdminPasswordVo);
//	    logger.info("===step3:【新增用户管理密码】(UserAdminPasswordController-addUserAdminPassword)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
//	    return userAdminPasswordResponse;
//	}


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
//
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