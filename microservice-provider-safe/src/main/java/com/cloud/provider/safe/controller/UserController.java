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
import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.rest.request.user.login.UserAdminResetPasswordRequest;
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
	 * 添加用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理")
	@RequestMapping(value="/admin/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertAdminUser(
		@Validated @RequestBody UserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理】(UserController-insertAdminUser)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【添加用户管理】(UserController-insertAdminUser)-根据userAccount查询用户信息, userInfo:{}", userInfo);

		Integer userId = null;
		if(userInfo != null) {
			userId = userInfo.getId();
			if(userId != null) {
				return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_EXIST);
			}

			UserAdmin userAdmin = userAdminService.selectByUserId(userId);
			logger.info("===step3:【添加用户管理】(UserController-insertAdminUser)-根据userId查询用户管理, userAdmin:{}", userAdmin);
			if(userAdmin != null) {
				Integer adminType = userAdmin.getAdminType();
				Integer enterpriseId = userAdmin.getEnterpriseId();
				Enterprise enterprise = enterpriseService.selectById(enterpriseId);
				logger.info("===step3.1:【添加用户管理】(UserController-insertAdminUser)-根据enterpriseId查询企业, enterprise:{}", enterprise);
				String enterpriseName = enterprise.getEnterpriseName();
				if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER.equals(adminType)) {
					return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_ENTERPRISE_MASTER_EXIST.getCode(), "此用户已经是"+enterpriseName+"的主管理员");
				} else if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE.equals(adminType)) {
					return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_ENTERPRISE_SLAVE_EXIST.getCode(), "此用户已经是"+enterpriseName+"的子管理员");
				}
				return new BaseRestMapResponse(SafeResultEnum.ENTERPRISE_EXIST);
			}
		}

		String enterpriseName = req.getEnterpriseName();
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseName(enterpriseName);

		userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		int i = userService.insertAdminUser(userInfo, enterprise);
		logger.info("===step4:【添加用户管理】(UserController-insertAdminUser)-添加用户管理, i:{}", i);

		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(enterprise));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		logger.info("===step5:【添加用户管理】(UserController-insertAdminUser)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户登录第一步
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户登录第一步")
	@RequestMapping(value="/admin/login/first",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse loginAdminFirst(
		@Validated @RequestBody UserLoginFirstRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【用户登录第一步】(UserController-loginAdminFirst)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount =  req.getUserAccount();
		String userPassword = req.getUserPassword();

		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【用户登录第一步】(UserController-loginAdminFirst)-根据userAccount查询用户信息, userInfo:{}", userInfo);
		if(userInfo == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_NOTEXIST);
		}
		Integer userId = userInfo.getId();

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		logger.info("===step3:【用户登录第一步】(UserController-loginAdminFirst)-根据userId查询用户管理, userAdmin:{}", userAdmin);
		if(userAdmin == null) {
			return new BaseRestMapResponse(SafeResultEnum.ENTERPRISE_NOTEXIST);
		}

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectByUserIdPassword(userId, userPassword);
		logger.info("===step4:【用户登录第一步】(UserController-loginAdminFirst)-根据userId和userPassword查询用户管理登录, userAdminPassword:{}", userAdminPassword);
		if(userAdminPassword == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_ERROR);
		}

		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
		logger.info("===step5:【用户登录第一步】(UserController-loginAdminFirst)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);

		UserAdminLoginVo userAdminLoginVo = new UserAdminLoginVo().convertToUserAdminLoginVo(userAdminLogin);
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);
		UserInfoVo userInfoVo = new UserInfoVo().convertToUserInfoVo(userInfo);
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userAdminLoginVo));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfoVo));
		logger.info("===step6:【用户登录第一步】(UserController-loginAdminFirst)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户登录第二步
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户登录第二步")
	@RequestMapping(value="/admin/login/second",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse loginAdminSecond(
		@Validated @RequestBody UserLoginSecondRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【用户登录第二步】(UserController-loginAdminSecond)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = req.getEnterpriseId();
		Integer userId = req.getUserId();

		Enterprise enterprise = enterpriseService.selectById(enterpriseId);
		logger.info("===step2:【用户登录第二步】(UserController-loginAdminSecond)-根据enterpriseId查询企业, enterprise:{}", enterprise);

		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
		logger.info("===step3:【用户登录第二步】(UserController-loginAdminSecond)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);

		UserOrg userOrg = userOrgService.selectByEnterpriseIdUserId(enterpriseId, userId);
		logger.info("===step4:【用户登录第二步】(UserController-loginAdminSecond)-根据enterpriseId和userId查询用户机构, userOrg:{}", userOrg);
		Integer orgId = userOrg.getOrgId();

		Org org = orgService.selectById(orgId);
		logger.info("===step5:【用户登录第二步】(UserController-loginAdminSecond)-根据orgId查询机构, org:{}", org);
		OrgVo orgVo = new OrgVo().convertToOrgVo(org);

		Long loginCount = userAdminLogin.getLoginCount();
		userAdminLogin.setLoginCount(loginCount+1);
		int i = userAdminLoginService.modify(userAdminLogin);
		logger.info("===step6:【用户登录第二步】(UserController-loginAdminSecond)-修改用户管理登录登录次数, i:{}", i);

		EnterpriseVo enterpriseVo = new EnterpriseVo().convertToEnterpriseVo(enterprise);
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(enterpriseVo));
		if(userOrg != null) {
			UserOrgVo userOrgVo = new UserOrgVo().convertToUserOrgVo(userOrg);
			userResponse.putAll((JSONObject) JSONObject.toJSON(userOrgVo));
		}
		userResponse.putAll((JSONObject) JSONObject.toJSON(orgVo));
		logger.info("===step7:【用户登录第二步】(UserController-loginAdminSecond)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 用户管理重置密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "用户管理重置密码")
	@RequestMapping(value="/admin/reset/password",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse resetAdminPassword(
		@Validated @RequestBody UserAdminResetPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【用户管理重置密码】(UserController-resetAdminPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
		logger.info("===step2:【用户管理重置密码】(UserController-resetAdminPassword)-根据userId查询用户管理登录, userAdminLogin:{}", userAdminLogin);
		if(userAdminLogin == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_ERROR);
		}

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectByUserId(userId);
		logger.info("===step3:【用户管理重置密码】(UserController-resetAdminPassword)-根据userId查询用户管理密码, userAdminPassword:{}", userAdminPassword);
		if(userAdminPassword == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_PASSWORD_ERROR);
		}

		int i = userService.resetAdminUserPassword(userAdminLogin, userAdminPassword);
		logger.info("===step4:【用户管理重置密码】(UserController-loginAdminFirst)-重置密码录, i:{}", i);

		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		logger.info("===step5:【用户管理重置密码】(UserController-resetAdminPassword)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}



}