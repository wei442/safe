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
import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.po.BaseUserPassword;
import com.cloud.provider.safe.rest.request.user.login.UserLoginFirstRequest;
import com.cloud.provider.safe.service.IBaseUserInfoService;
import com.cloud.provider.safe.service.IBaseUserLoginService;
import com.cloud.provider.safe.service.IBaseUserPasswordService;
import com.cloud.provider.safe.vo.base.user.BaseUserInfoVo;
import com.cloud.provider.safe.vo.base.user.BaseUserLoginVo;
import com.cloud.provider.safe.vo.base.user.BaseUserPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户 BaseUserController
 * @author wei.yong
 */
@Api(tags = "基础用户")
@RestController
@RequestMapping(value="/base/user")
public class BaseUserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户信息Service
	@Autowired
	private IBaseUserInfoService baseUserInfoService;

	//基础用户密码Service
	@Autowired
	private IBaseUserPasswordService baseUserPasswordService;

	//基础用户登录Service
	@Autowired
	private IBaseUserLoginService baseUserLoginService;

	/**
	 * 基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "基础用户登录")
	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse login(
		@Validated @RequestBody UserLoginFirstRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【基础用户登录】(BaseUserController-loginFirst)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount =  req.getUserAccount();
		String userPassword = req.getUserPassword();

		BaseUserInfo baseUserInfo = baseUserInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【基础用户登录】(BaseUserController-login)-根据userAccount查询用户信息, baseUserInfo:{}", baseUserInfo);
		if(baseUserInfo == null) {
			return new BaseRestMapResponse(SafeResultEnum.BASE_USER_ACCOUNT_NOTEXIST);
		}
		Integer baseUserId = baseUserInfo.getId();

		BaseUserPassword baseUserPassword = baseUserPasswordService.selectByBaseUserIdPassword(baseUserId, userPassword);
		logger.info("===step3:【基础用户登录】(BaseUserController-login)-根据baseUserId和userPassword查询基础用户登录,  baseUserPassword:{}", baseUserPassword);
		if(baseUserPassword == null) {
			return new BaseRestMapResponse(SafeResultEnum.BASE_USER_PASSWORD_ERROR);
		}

		BaseUserLogin baseUserLogin = baseUserLoginService.selectByBaseUserId(baseUserId);
		logger.info("===step4:【基础用户登录】(BaseUserController-login)-根据userId查询用户管理登录, baseUserLogin:{}", baseUserLogin);

		BaseUserInfoVo baseUserInfoVo = new BaseUserInfoVo().convertToBaseUserInfoVo(baseUserInfo);
		BaseUserPasswordVo baseUserPasswordVo = new BaseUserPasswordVo().convertToBaseUserPasswordVo(baseUserPassword);
		BaseUserLoginVo baseUserLoginVo = new BaseUserLoginVo().convertToBaseUserLoginVo(baseUserLogin);
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.putAll((JSONObject) JSONObject.toJSON(baseUserInfoVo));
		baseUserResponse.putAll((JSONObject) JSONObject.toJSON(baseUserPasswordVo));
		baseUserResponse.putAll((JSONObject) JSONObject.toJSON(baseUserLoginVo));
		logger.info("===step5:【基础用户登录】(BaseUserController-login)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

}