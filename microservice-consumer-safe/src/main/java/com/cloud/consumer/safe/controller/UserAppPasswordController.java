package com.cloud.consumer.safe.controller;

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
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.user.UserAppPasswordIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserAppPasswordRequest;
import com.cloud.consumer.safe.service.IUserAppPasswordService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.user.UserAppPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户应用密码应用 UserAppPasswordController
 * @author wei.yong
 * @ClassName: UserAppPasswordController
 */
@Api(tags = "用户应用密码")
@RestController
@RequestMapping("/user/app/password")
public class UserAppPasswordController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用密码 Service
	@Autowired
	private IUserAppPasswordService userAppPasswordService;

	/**
	 * 获取用户应用密码详情
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户应用密码详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserAppPasswordIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户应用密码】(UserAppPasswordController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAppPasswordId = req.getUserAppPasswordId();
		JSONObject jsonUserAppPassword = userAppPasswordService.getById(userAppPasswordId);
		logger.info("===step2:【获取用户应用密码】(UserAppPasswordController-getDetail)-根据userAppPasswordId获取用户应用密码, jsonUserAppPassword:{}", jsonUserAppPassword);
		UserAppPasswordVo userAppPasswordVo = JSONObject.toJavaObject(jsonUserAppPassword, UserAppPasswordVo.class);

		//返回信息
		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		userAppPasswordResponse.put(CommConstants.RESULT, userAppPasswordVo);
	    logger.info("===step3:【获取用户应用密码】(UserAppPasswordController-getDetail)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
	    return userAppPasswordResponse;
	}

	/**
	 * 根据userId和password获取用户应用密码详情
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId和password获取用户应用密码详情")
	@RequestMapping(value="/getByUserIdPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getByUserIdPassword(
		@Validated @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据userId和password获取用户应用密码详情】(UserAppPasswordController-getByUserIdPassword)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppPassword = userAppPasswordService.getByUserIdPassword(req);
		logger.info("===step2:【根据userId和password获取用户应用密码详情】(UserAppPasswordController-getByUserIdPassword)-根据userId和password获取用户应用密码详情, jsonUserAppPassword:{}", jsonUserAppPassword);
		UserAppPasswordVo userAppPasswordVo = JSONObject.toJavaObject(jsonUserAppPassword, UserAppPasswordVo.class);

		//返回信息
		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		userAppPasswordResponse.put(CommConstants.RESULT, userAppPasswordVo);
		logger.info("===step3:【根据userId和password获取用户应用密码详情】(UserAppPasswordController-getByUserIdPassword)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 新增用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户应用密码")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户应用密码】(UserAppPasswordController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppPassword = userAppPasswordService.add(req);
		logger.info("===step2:【新增用户应用密码】(UserAppPasswordController-add)-分页查询用户应用密码列表, jsonUserAppPassword:{}", jsonUserAppPassword);

		//返回信息
		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增用户应用密码】(UserAppPasswordController-add)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
	    return userAppPasswordResponse;
	}

	/**
	 * 删除用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户应用密码")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserAppPasswordIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户应用密码】(UserAppPasswordController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAppPasswordId = req.getUserAppPasswordId();
		JSONObject jsonUserAppPassword = userAppPasswordService.deleteById(userAppPasswordId);
		logger.info("===step2:【删除用户应用密码】(UserAppPasswordController-delete)-根据userAppPasswordId删除用户应用密码, jsonUserAppPassword:{}", jsonUserAppPassword);

		//返回信息
		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除用户应用密码】(UserAppPasswordController-delete)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 修改用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户应用密码")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户应用密码】(UserAppPasswordController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppPassword = userAppPasswordService.update(req);
		logger.info("===step2:【修改用户应用密码】(UserAppPasswordController-update)-修改用户应用密码, jsonUserAppPassword:{}", jsonUserAppPassword);

		//返回信息
		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户应用密码】(UserAppPasswordController-update)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

}