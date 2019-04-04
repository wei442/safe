package com.cloud.consumer.safe.controller;

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
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.user.UserAdminPasswordIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserAdminPasswordRequest;
import com.cloud.consumer.safe.service.IUserAdminPasswordService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.user.UserAdminPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理密码管理 UserAdminPasswordController
 * @author wei.yong
 * @ClassName: UserAdminPasswordController
 */
@Api(tags = "用户管理密码")
@RestController
@RequestMapping("/user/admin/password")
public class UserAdminPasswordController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理密码 Service
	@Autowired
	private IUserAdminPasswordService userAdminPasswordService;


	/**
	 * 获取用户管理密码详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户管理密码详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserAdminPasswordIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户管理密码】(UserAdminPasswordController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminPasswordId = req.getUserAdminPasswordId();
		JSONObject jsonUserAdminPassword = userAdminPasswordService.getById(userAdminPasswordId);
		logger.info("===step2:【获取用户管理密码】(UserAdminPasswordController-getDetail)-根据userAdminPasswordId获取用户管理密码, jsonUserAdminPassword:{}", jsonUserAdminPassword);
		UserAdminPasswordVo userAdminPasswordVo = JSONObject.toJavaObject(jsonUserAdminPassword, UserAdminPasswordVo.class);

		//返回信息
		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		userAdminPasswordResponse.put(CommConstants.RESULT, userAdminPasswordVo);
	    logger.info("===step3:【获取用户管理密码】(UserAdminPasswordController-getDetail)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
	    return userAdminPasswordResponse;
	}

//	/**
//	 * 根据用户id获取用户管理密码详情
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "根据用户id获取用户管理密码详情")
//	@RequestMapping(value="/getByUserId",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse getByUserId(
//		@Validated @RequestBody UserInfoIdRequest req,
//		BindingResult bindingResult) {
//		logger.info("===step1:【根据用户id获取用户管理密码详情】(UserAdminPasswordController-getByUserId)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		Integer userId = req.getUserId();
//		JSONObject jsonUserAdminPassword = userAdminPasswordService.getByUserId(userId);
//		logger.info("===step2:【根据用户id获取用户管理密码详情】(UserAdminPasswordController-getByUserId)-根据userId获取用户管理密码详情, jsonUserAdminPassword:{}", jsonUserAdminPassword);
//		UserAdminPasswordVo userAdminPasswordVo = JSONObject.toJavaObject(jsonUserAdminPassword, UserAdminPasswordVo.class);
//
//		//返回信息
//		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
//		userAdminPasswordResponse.put(CommConstants.RESULT, userAdminPasswordVo);
//		logger.info("===step3:【根据用户id获取用户管理密码详情】(UserAdminPasswordController-getByUserId)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
//		return userAdminPasswordResponse;
//	}

	/**
	 * 根据userId和password获取用户管理密码详情
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据用户id和密码获取用户管理密码详情")
	@RequestMapping(value="/getByUserIdPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getByUserIdPassword(
		@Validated @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据userId和password获取用户管理密码详情】(UserAdminPasswordController-getByUserIdPassword)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAdminPassword = userAdminPasswordService.getByUserIdPassword(req);
		logger.info("===step2:【根据userId和password获取用户管理密码详情】(UserAdminPasswordController-getByUserIdPassword)-根据userId和password获取用户管理密码详情, jsonUserAdminPassword:{}", jsonUserAdminPassword);
		UserAdminPasswordVo userAdminPasswordVo = JSONObject.toJavaObject(jsonUserAdminPassword, UserAdminPasswordVo.class);

		//返回信息
		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		userAdminPasswordResponse.put(CommConstants.RESULT, userAdminPasswordVo);
		logger.info("===step3:【根据userId和password获取用户管理密码详情】(UserAdminPasswordController-getByUserIdPassword)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 新增用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户管理密码")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户管理密码】(UserAdminPasswordController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String password = req.getPassword();
		req.setPassword(DigestUtils.sha256Hex(password));
		JSONObject jsonUserAdminPassword = userAdminPasswordService.add(req);
		logger.info("===step2:【新增用户管理密码】(UserAdminPasswordController-add)-新增用户管理密码, jsonUserAdminPassword:{}", jsonUserAdminPassword);

		//返回信息
		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增用户管理密码】(UserAdminPasswordController-add)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
	    return userAdminPasswordResponse;
	}

	/**
	 * 删除用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新删除用户管理密码")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserAdminPasswordIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户管理密码】(UserAdminPasswordController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminPasswordId = req.getUserAdminPasswordId();
		JSONObject jsonUserAdminPassword = userAdminPasswordService.deleteById(userAdminPasswordId);
		logger.info("===step2:【删除用户管理密码】(UserAdminPasswordController-delete)-根据userAdminPasswordId删除用户管理密码, jsonUserAdminPassword:{}", jsonUserAdminPassword);

		//返回信息
		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除用户管理密码】(UserAdminPasswordController-delete)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 修改用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理密码")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理密码】(UserAdminPasswordController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String password = req.getPassword();
		req.setPassword(DigestUtils.sha256Hex(password));
		JSONObject jsonUserAdminPassword = userAdminPasswordService.update(req);
		logger.info("===step2:【修改用户管理密码】(UserAdminPasswordController-update)-修改用户管理密码, jsonUserAdminPassword:{}", jsonUserAdminPassword);

		//返回信息
		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理密码】(UserAdminPasswordController-update)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

}