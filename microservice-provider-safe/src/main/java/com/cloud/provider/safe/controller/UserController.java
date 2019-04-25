package com.cloud.provider.safe.controller;

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
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.rest.request.user.login.UserLoginFirstRequest;
import com.cloud.provider.safe.rest.request.user.login.UserLoginSecondRequest;
import com.cloud.provider.safe.rest.request.user.login.UserRequest;
import com.cloud.provider.safe.service.IEnterpriseService;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.service.IUserAdminLoginService;
import com.cloud.provider.safe.service.IUserAdminPasswordService;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.service.IUserOrgService;
import com.cloud.provider.safe.service.IUserService;
import com.cloud.provider.safe.vo.enterprise.EnterpriseVo;
import com.cloud.provider.safe.vo.enterprise.OrgVo;
import com.cloud.provider.safe.vo.user.UserAdminLoginVo;
import com.cloud.provider.safe.vo.user.UserAdminVo;
import com.cloud.provider.safe.vo.user.UserInfoVo;
import com.cloud.provider.safe.vo.user.UserOrgVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户 UserController
 * @author wei.yong
 */
@Api(tags = "用户")
@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserService userService;

	//用户信息Service
	@Autowired
	private IUserInfoService userInfoService;

	//企业Service
	@Autowired
	private IEnterpriseService enterpriseService;

	//用户管理Service
	@Autowired
	private IUserAdminService userAdminService;

	//用户管理登录Service
	@Autowired
	private IUserAdminLoginService userAdminLoginService;

	//用户管理密码Service
	@Autowired
	private IUserAdminPasswordService userAdminPasswordService;

	//用户机构Service
	@Autowired
	private IUserOrgService userOrgService;

	//组织机构Service
	@Autowired
	private IOrgService orgService;

	/**
	 * 添加用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户")
	@RequestMapping(value="/insertUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUser(
		@Validated @RequestBody UserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户】(UserController-insertUser)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【添加用户】(UserController-insertUser)-根据userAccount查询用户信息, userInfo:{}", userInfo);

		Integer userId = null;
		if(userInfo != null) {
			userId = userInfo.getId();
			if(userId != null) {
				return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_EXIST);
			}

			UserAdmin userAdmin = userAdminService.selectByUserId(userId);
			logger.info("===step3:【添加用户】(UserController-insertUser)-根据userId查询用户管理, userAdmin:{}", userAdmin);
			if(userAdmin != null) {
				return new BaseRestMapResponse(SafeResultEnum.ENTERPRISE_EXIST);
			}
		}

		String enterpriseName = req.getEnterpriseName();
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseName(enterpriseName);

		userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		int i = userService.insertUser(userInfo, enterprise);
		logger.info("===step4:【添加用户】(UserController-insertUser)-添加用户, i:{}", i);

		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(enterprise));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		logger.info("===step5:【添加用户】(UserController-insertUser)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户登录第一步
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户登录第一步")
	@RequestMapping(value="/login/first",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse loginFirst(
		@Validated @RequestBody UserLoginFirstRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【用户登录第一步】(UserController-loginFirst)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount =  req.getUserAccount();
		String userPassword = req.getUserPassword();

		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【用户登录第一步】(UserController-loginFirst)-根据userAccount查询用户信息, userInfo:{}", userInfo);
		if(userInfo == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_NOTEXIST);
		}
		Integer userId = userInfo.getId();

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		logger.info("===step3:【用户登录第一步】(UserController-loginFirst)-根据userId查询用户管理, userAdmin:{}", userAdmin);
		if(userAdmin == null) {
			return new BaseRestMapResponse(SafeResultEnum.ENTERPRISE_NOTEXIST);
		}

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectByUserIdPassword(userId, userPassword);
		logger.info("===step4:【用户登录第一步】(UserController-loginFirst)-根据userId和userPassword查询用户管理登录, userAdminPassword:{}", userAdminPassword);
		if(userAdminPassword == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_ERROR);
		}

		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
		logger.info("===step5:【用户登录第一步】(UserController-loginFirst)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);

		UserAdminLoginVo userAdminLoginVo = new UserAdminLoginVo().convertToUserAdminLoginVo(userAdminLogin);
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);
		UserInfoVo userInfoVo = new UserInfoVo().convertToUserInfoVo(userInfo);
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userAdminLoginVo));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfoVo));
		logger.info("===step6:【用户登录第一步】(UserController-loginFirst)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户登录第二步
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户登录第二步")
	@RequestMapping(value="/login/second",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse loginSecond(
		@Validated @RequestBody UserLoginSecondRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【用户登录】(UserController-loginSecond)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = req.getEnterpriseId();
		Integer userId = req.getUserId();

		Enterprise enterprise = enterpriseService.selectById(enterpriseId);
		logger.info("===step2:【用户登录第二步】(UserController-loginSecond)-根据enterpriseId查询企业, enterprise:{}", enterprise);

		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
		logger.info("===step3:【用户登录第二步】(UserController-loginSecond)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);

		UserOrg userOrg = userOrgService.selectByEnterpriseIdUserId(enterpriseId, userId);
		logger.info("===step4:【用户登录第二步】(UserController-loginSecond)-根据enterpriseId和userId查询用户机构, userOrg:{}", userOrg);
		Integer orgId = userOrg.getOrgId();

		Org org = orgService.selectById(orgId);
		logger.info("===step5:【用户登录第二步】(UserController-loginSecond)-根据orgId查询机构, org:{}", org);
		OrgVo orgVo = new OrgVo().convertToOrgVo(org);

		Long loginCount = userAdminLogin.getLoginCount();
		userAdminLogin.setLoginCount(loginCount+1);
		int i = userAdminLoginService.modify(userAdminLogin);
		logger.info("===step6:【用户登录第二步】(UserController-loginSecond)-修改用户管理登录登录次数, i:{}", i);

		EnterpriseVo enterpriseVo = new EnterpriseVo().convertToEnterpriseVo(enterprise);
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(enterpriseVo));
		if(userOrg != null) {
			UserOrgVo userOrgVo = new UserOrgVo().convertToUserOrgVo(userOrg);
			userResponse.putAll((JSONObject) JSONObject.toJSON(userOrgVo));
		}
		userResponse.putAll((JSONObject) JSONObject.toJSON(orgVo));
		logger.info("===step7:【用户登录第二步】(UserController-loginSecond)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}






















	/**
	 * 用户登录第一步
	 * @param req
	 * @return BaseRestMapResponse
	 */
//	@ApiOperation(value = "用户登录第一步")
//	@RequestMapping(value="/login/first",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse loginFirst(
//		@RequestBody UserLoginRequest req) {
//		logger.info("===step1:【用户登录第一步】(UserController-loginFirst)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		String userAccount =  req.getUserAccount();
//		if(StringUtils.isBlank(userAccount)) {
//			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "用户账户不能为空");
//		}
//
//		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
//		logger.info("===step2:【用户登录第一步】(UserController-loginFirst)-根据userAccount查询用户信息, userInfo:{}", userInfo);
//		if(userInfo == null) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_NOTEXIST);
//		}
//		Integer userId = userInfo.getId();
//
//		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
//		logger.info("===step3:【用户登录第一步】(UserController-loginFirst)-根据userId查询用户管理, userAdmin:{}", userAdmin);
//		Integer enterpriseId = null;
//		if(userAdmin != null) {
//			enterpriseId = userAdmin.getEnterpriseId();
//			return new BaseRestMapResponse(SafeResultEnum.ENTERPRISE_EXIST);
//		}
//
//		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
//		logger.info("===step4:【用户登录第一步】(UserController-loginFirst)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);
//		Integer firstLogin = userAdminLogin.getFirstLogin();
//		if(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_NO.equals(firstLogin)) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_FIRST_LOGIN_CHANGE_PASSWORD);
//		}
//
//		Enterprise enterprise = enterpriseService.selectById(enterpriseId);
//		logger.info("===step5:【用户登录第一步】(UserController-loginFirst)-根据enterpriseId查询企业, enterprise:{}", enterprise);
//
//		BaseRestMapResponse userResponse = new BaseRestMapResponse();
//		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
//		userResponse.putAll((JSONObject) JSONObject.toJSON(enterprise));
//		logger.info("===step6:【用户登录第一步】(UserController-loginFirst)-返回信息, userResponse:{}", userResponse);
//		return userResponse;
//	}

	/**
	 * 用户登录第二步
	 * @param req
	 * @return BaseRestMapResponse
	 */
//	@ApiOperation(value = "用户登录第二步")
//	@RequestMapping(value="/login/second",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse loginSecond(
//		@RequestBody UserLoginRequest req) {
//		logger.info("===step1:【用户登录第二步】(UserController-loginSecond)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		String userPassword = req.getUserPassword();
//		Integer userId = req.getUserId();
//		if(StringUtils.isBlank(userPassword)) {
//			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "用户密码不能为空");
//		} else if(userId == null) {
//			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "用户id不能为空");
//		}
//		UserInfo userInfo = userInfoService.selectById(userId);
//		logger.info("===step2:【用户登录第二步】(UserController-loginSecond)-根据userId查询用户信息, userInfo:{}", userInfo);
//		if(userInfo == null) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_NOTEXIST);
//		}
//		UserAdminPassword userAdminPassword = userAdminPasswordService.selectByUserIdPassword(userId, userPassword);
//		logger.info("===step3:【用户登录第二步】(UserController-loginSecond)-根据userId和userPassword查询用户管理登录, userAdminPassword:{}", userAdminPassword);
//		if(userAdminPassword == null) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_ERROR);
//		}
//
//		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
//		logger.info("===step4:【用户登录第一步】(UserController-loginFirst)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);
//		Long loginCount = userAdminLogin.getLoginCount();
//		userAdminLogin.setLoginCount(loginCount+1);
//		int i = userAdminLoginService.modify(userAdminLogin);
//		logger.info("===step5:【用户登录第一步】(UserController-loginFirst)-修改用户管理登录登录次数, i:{}", i);
//
//		BaseRestMapResponse userResponse = new BaseRestMapResponse();
//		logger.info("===step7:【用户登录第二步】(UserController-loginSecond)-返回信息, userResponse:{}", userResponse);
//		return userResponse;
//	}


}