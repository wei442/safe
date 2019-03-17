package com.cloud.provider.safe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.rest.request.UserAdminPasswordRequest;
import com.cloud.provider.safe.service.IUserAdminPasswordService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserAdminPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理密码 UserAdminPasswordController
 * @author wei.yong
 */
@Api(tags = "用户管理密码")
@RestController
@RequestMapping(value="/user/adminPassword")
public class UserAdminPasswordController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理密码Service
	@Autowired
	private IUserAdminPasswordService userAdminPasswordService;

	/**
	 * 据id查询用户管理密码
	 * @param userAdminPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户管理密码")
	@RequestMapping(value="/selectUserAdminPasswordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminPasswordById(
		@PathVariable(value="id",required=false) Integer userAdminPasswordId) {
		logger.info("===step1:【据id查询用户管理密码】(selectUserAdminPasswordById-selectUserAdminPasswordById)-传入参数, userAdminPasswordId:{}", userAdminPasswordId);

		if(userAdminPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminPasswordId为空");
		}

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectUserAdminPasswordById(userAdminPasswordId);
		logger.info("===step2:【据id查询用户管理密码】(UserAdminPasswordController-selectUserAdminPasswordById)-根据id查询用户管理密码, userAdminPassword:{}", userAdminPassword);
		UserAdminPasswordVo userAdminPasswordVo = new UserAdminPasswordVo().convertToUserAdminPasswordVo(userAdminPassword);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		userAdminPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAdminPasswordVo));
		logger.info("===step3:【据id查询用户管理密码】(UserAdminPasswordController-selectUserAdminPasswordById)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 据userId查询用户管理密码
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId查询用户管理密码")
	@RequestMapping(value="/selectUserAdminPasswordByUserId",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminPasswordByUserId(
		@Validated @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据userId查询用户管理密码】(UserAdminPasswordController-selectUserAdminPasswordByUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		this.bindingResult(bindingResult);

		Integer userId = req.getUserId();
		String password = req.getPassword();

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectUserAdminPasswordByUserId(userId, password);
		logger.info("===step2:【根据userId查询用户管理密码】(UserAdminPasswordController-selectUserAdminPasswordByUserId)-根据userId和password查询用户管理密码, userAdminPassword:{}", userAdminPassword);
		UserAdminPasswordVo userAdminPasswordVo = new UserAdminPasswordVo().convertToUserAdminPasswordVo(userAdminPassword);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		userAdminPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAdminPasswordVo));
		logger.info("===step3:【根据userId查询用户管理密码】(UserAdminPasswordController-selectUserAdminPasswordByUserId)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 添加用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理密码")
	@RequestMapping(value="/insertUserAdminPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserAdminPassword(
		@Validated @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理密码】(UserAdminPasswordController-insertUserAdminPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserAdminPassword userAdminPassword = req.convertToUserAdminPassword();
		int i = userAdminPasswordService.insertUserAdminPassword(userAdminPassword);
		logger.info("===step2:【添加用户管理密码】(UserAdminPasswordController-insertUserAdminPassword)-插入用户管理密码, i:{}", i);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户管理密码】(UserAdminPasswordController-insertUserAdminPassword)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 根据id删除用户管理密码
	 * @param userAdminPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户管理密码")
	@RequestMapping(value="/deleteUserAdminPasswordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserAdminPasswordById(
		@PathVariable(value="id",required=false) Integer userAdminPasswordId) {
		logger.info("===step1:【根据id删除用户管理密码】(selectUserAdminPasswordById-deleteUserAdminPasswordById)-传入参数, userAdminPasswordId:{}", userAdminPasswordId);

		if(userAdminPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminPasswordId为空");
		}

		int i = userAdminPasswordService.deleteUserAdminPasswordById(userAdminPasswordId);
		logger.info("===step2:【根据id删除用户管理密码】(UserAdminPasswordController-deleteUserAdminPasswordById)-根据id查询用户管理密码, i:{}", i);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户管理密码】(UserAdminPasswordController-deleteUserAdminPasswordById)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 修改用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理密码")
	@RequestMapping(value="/modifyUserAdminPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserAdminPassword(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理密码】(UserAdminPasswordController-modifyUserAdminPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userAdminPasswordId = req.getUserId();
		UserAdminPassword userAdminPassword = req.convertToUserAdminPassword();
		userAdminPassword.setId(userAdminPasswordId);
		int i = userAdminPasswordService.modifyUserAdminPassword(userAdminPassword);
		logger.info("===step2:【修改用户管理密码】(UserAdminPasswordController-modifyUserAdminPassword)-修改用户管理密码, i:{}", i);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理密码】(UserAdminPasswordController-modifyUserAdminPassword)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

}