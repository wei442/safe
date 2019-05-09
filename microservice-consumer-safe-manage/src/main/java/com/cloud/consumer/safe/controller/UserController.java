package com.cloud.consumer.safe.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.user.login.AdminRequest;
import com.cloud.consumer.safe.rest.request.user.login.AdminResetPasswordRequest;
import com.cloud.consumer.safe.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理 UserController
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
	 * 新增主管理员
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增主管理员")
	@RequestMapping(value="/addAdminUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addAdminUser(
		@RequestBody AdminRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【新增主管理员】(UserController-addAdminUser)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		JSONObject jsonAdminUser = userService.addAdminUser(req);
		logger.info("===step2:【新增主管理员】(UserController-addAdminUser)-用户注册, jsonAdminUser:{}", jsonAdminUser);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step3:【新增主管理员】(UserController-addAdminUser)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 重置用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "重置用户管理密码")
	@RequestMapping(value="/resetAdminPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse resetAdminPassword(
		@Validated @RequestBody AdminResetPasswordRequest req,
		BindingResult bindingResult) {
		String requestIp = this.getRequestIp();
		logger.info("===step1:【重置用户管理密码】(UserController-resetAdminPassword)-请求参数, requestIp:{}, req:{}, json:{}", requestIp, req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		JSONObject jsonResetAdminPassword = userService.resetAdminPassword(params);
		logger.info("===step2:【重置用户管理密码】(UserController-resetAdminPassword)-重置密码, jsonResetAdminPassword:{}", jsonResetAdminPassword);

        //返回信息
		BaseRestMapResponse userResponse = new BaseRestMapResponse();
        logger.info("===step3:【重置用户管理密码】(UserController-resetAdminPassword)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

}