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
import com.cloud.provider.safe.po.UserAppPassword;
import com.cloud.provider.safe.rest.request.UserAppPasswordRequest;
import com.cloud.provider.safe.service.IUserAppPasswordService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserAppPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户应用密码 UserAppPasswordController
 * @author wei.yong
 */
@Api(tags = "用户应用密码")
@RestController
@RequestMapping(value="/user/appPassword")
public class UserAppPasswordController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用密码Service
	@Autowired
	private IUserAppPasswordService userAppPasswordService;

	/**
	 * 据id查询用户应用密码
	 * @param userAppPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户应用密码")
	@RequestMapping(value="/selectUserAppPasswordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAppPasswordById(
		@PathVariable(value="id",required=false) Integer userAppPasswordId) {
		logger.info("===step1:【据id查询用户应用密码】(selectUserAppPasswordById-selectUserAppPasswordById)-传入参数, userAppPasswordId:{}", userAppPasswordId);

		if(userAppPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppPasswordId为空");
		}

		UserAppPassword userAppPassword = userAppPasswordService.selectUserAppPasswordById(userAppPasswordId);
		logger.info("===step2:【据id查询用户应用密码】(UserAppPasswordController-selectUserAppPasswordById)-根据id查询用户应用密码, userAppPassword:{}", userAppPassword);
		UserAppPasswordVo userAppPasswordVo = new UserAppPasswordVo().convertToUserAppPasswordVo(userAppPassword);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		userAppPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAppPasswordVo));
		logger.info("===step3:【据id查询用户应用密码】(UserAppPasswordController-selectUserAppPasswordById)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 据userId查询用户应用密码
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId查询用户应用密码")
	@RequestMapping(value="/selectUserAppPasswordByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAppPasswordByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户应用密码】(selectUserAppPasswordById-selectUserAppPasswordByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userId为空");
		}

		UserAppPassword userAppPassword = userAppPasswordService.selectUserAppPasswordByUserId(userId);
		logger.info("===step2:【据userId查询用户应用密码】(UserAppPasswordController-selectUserAppPasswordByUserId)-根据id查询用户应用密码, userAppPassword:{}", userAppPassword);
		UserAppPasswordVo userAppPasswordVo = new UserAppPasswordVo().convertToUserAppPasswordVo(userAppPassword);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		userAppPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAppPasswordVo));
		logger.info("===step3:【据userId查询用户应用密码】(UserAppPasswordController-selectUserAppPasswordByUserId)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 添加用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户应用密码")
	@RequestMapping(value="/insertUserAppPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserAppPassword(
		@Validated @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户应用密码】(UserAppPasswordController-insertUserAppPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserAppPassword userAppPassword = req.convertToUserAppPassword();
		int i = userAppPasswordService.insertUserAppPassword(userAppPassword);
		logger.info("===step2:【添加用户应用密码】(UserAppPasswordController-insertUserAppPassword)-插入用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户应用密码】(UserAppPasswordController-insertUserAppPassword)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 根据id删除用户应用密码
	 * @param userAppPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户应用密码")
	@RequestMapping(value="/deleteUserAppPasswordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserAppPasswordById(
		@PathVariable(value="id",required=false) Integer userAppPasswordId) {
		logger.info("===step1:【根据id删除用户应用密码】(selectUserAppPasswordById-deleteUserAppPasswordById)-传入参数, userAppPasswordId:{}", userAppPasswordId);

		if(userAppPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppPasswordId为空");
		}

		int i = userAppPasswordService.deleteUserAppPasswordById(userAppPasswordId);
		logger.info("===step2:【根据id删除用户应用密码】(UserAppPasswordController-deleteUserAppPasswordById)-根据id查询用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户应用密码】(UserAppPasswordController-deleteUserAppPasswordById)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 修改用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户应用密码")
	@RequestMapping(value="/modifyUserAppPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserAppPassword(
		@Validated({ ModifyGroup.class }) @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户应用密码】(UserAppPasswordController-modifyUserAppPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userAppPasswordId = req.getUserId();
		UserAppPassword userAppPassword = req.convertToUserAppPassword();
		userAppPassword.setId(userAppPasswordId);
		int i = userAppPasswordService.modifyUserAppPassword(userAppPassword);
		logger.info("===step2:【修改用户应用密码】(UserAppPasswordController-modifyUserAppPassword)-修改用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户应用密码】(UserAppPasswordController-modifyUserAppPassword)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

}