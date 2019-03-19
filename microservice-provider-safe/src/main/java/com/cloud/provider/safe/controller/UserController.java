package com.cloud.provider.safe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.rest.request.UserRequest;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.service.IUserService;

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

	//用户管理Service
	@Autowired
	private IUserAdminService userAdminService;

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
		this.bindingResult(bindingResult);

		String userAccount = req.getUserAccount();
		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		Integer userId = null;
		if(userInfo != null) {
			userId = userInfo.getId();
			return new BaseRestMapResponse(SafeResultEnum.USER_ACCOUNT_EXIST);
		}

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		if(userAdmin != null) {
			return new BaseRestMapResponse(SafeResultEnum.ENTERPRISE_EXIST);
		}

		Enterprise enterprise = new Enterprise();
		userInfo = new UserInfo();
		userAdmin = new UserAdmin();
		UserAdminPassword userAdminPassword = new UserAdminPassword();
		UserAdminLogin userAdminLogin = new UserAdminLogin();
		BeanUtils.copyProperties(req, enterprise);
		BeanUtils.copyProperties(req, userInfo);
		BeanUtils.copyProperties(req, userAdmin);
		BeanUtils.copyProperties(req, userAdminPassword);
		BeanUtils.copyProperties(req, userAdminLogin);

		int i = userService.insertUser(enterprise, userInfo, userAdmin, userAdminPassword, userAdminLogin);
		logger.info("===step2:【添加用户】(UserController-insertUser)-插入用户, i:{}", i);

		BaseRestMapResponse userResponse = new BaseRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(enterprise));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userAdmin));
		userResponse.putAll((JSONObject) JSONObject.toJSON(userAdminPassword));
		logger.info("===step3:【添加用户】(UserController-insertUser)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}


}