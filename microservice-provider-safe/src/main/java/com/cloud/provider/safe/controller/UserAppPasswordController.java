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
@RequestMapping(value="/user/app/password")
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
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userAppPasswordId) {
		logger.info("===step1:【据id查询用户应用密码】(selectById-selectById)-传入参数, userAppPasswordId:{}", userAppPasswordId);

		if(userAppPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppPasswordId不能为空");
		}

		UserAppPassword userAppPassword = userAppPasswordService.selectById(userAppPasswordId);
		logger.info("===step2:【据id查询用户应用密码】(UserAppPasswordController-selectById)-根据id查询用户应用密码, userAppPassword:{}", userAppPassword);
		UserAppPasswordVo userAppPasswordVo = new UserAppPasswordVo().convertToUserAppPasswordVo(userAppPassword);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		userAppPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAppPasswordVo));
		logger.info("===step3:【据id查询用户应用密码】(UserAppPasswordController-selectById)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 根据userId和password查询用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId和password查询用户应用密码")
	@RequestMapping(value="/selectByUserIdPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserIdPassword(
		@Validated @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据userId和password查询用户应用密码】(UserAppPasswordController-selectByUserIdPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String password = req.getPassword();

		UserAppPassword userAppPassword = userAppPasswordService.selectByUserIdPassword(userId, password);
		logger.info("===step2:【根据userId和password查询用户应用密码】(UserAppPasswordController-selectByUserIdPassword)-根据userId和password查询用户应用密码, userAppPassword:{}", userAppPassword);
		UserAppPasswordVo userAppPasswordVo = new UserAppPasswordVo().convertToUserAppPasswordVo(userAppPassword);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		userAppPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAppPasswordVo));
		logger.info("===step3:【根据userId和password查询用户应用密码】(UserAppPasswordController-selectByUserIdPassword)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 添加用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户应用密码")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户应用密码】(UserAppPasswordController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserAppPassword userAppPassword = req.convertToUserAppPassword();
		int i = userAppPasswordService.insert(userAppPassword);
		logger.info("===step2:【添加用户应用密码】(UserAppPasswordController-insert)-插入用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户应用密码】(UserAppPasswordController-insert)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 根据id删除用户应用密码
	 * @param userAppPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户应用密码")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userAppPasswordId) {
		logger.info("===step1:【根据id删除用户应用密码】(selectById-deleteById)-传入参数, userAppPasswordId:{}", userAppPasswordId);

		if(userAppPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppPasswordId不能为空");
		}

		int i = userAppPasswordService.deleteById(userAppPasswordId);
		logger.info("===step2:【根据id删除用户应用密码】(UserAppPasswordController-deleteById)-根据id查询用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户应用密码】(UserAppPasswordController-deleteById)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 修改用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户应用密码")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户应用密码】(UserAppPasswordController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAppPasswordId = req.getUserId();
		UserAppPassword userAppPassword = req.convertToUserAppPassword();
		userAppPassword.setId(userAppPasswordId);
		int i = userAppPasswordService.modify(userAppPassword);
		logger.info("===step2:【修改用户应用密码】(UserAppPasswordController-modify)-修改用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户应用密码】(UserAppPasswordController-modify)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

	/**
	 * 根据userId修改用户应用密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId修改用户应用密码")
	@RequestMapping(value="/modifyByUserId",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyByUserId(
		@Validated @RequestBody UserAppPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据userId修改用户应用密码】(UserAppPasswordController-modifyByUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String password = req.getPassword();
		UserAppPassword userAppPassword = userAppPasswordService.selectByUserId(userId);
		logger.info("===step2:【根据userId修改用户应用密码】(UserAppPasswordController-modifyByUserId)-根据userId查询用户应用密码, userAppPassword:{}", userAppPassword);

		userAppPassword.setPassword(password);
		int i = userAppPasswordService.modify(userAppPassword);
		logger.info("===step3:【根据userId修改用户应用密码】(UserAppPasswordController-modifyByUserId)-修改用户应用密码, i:{}", i);

		BaseRestMapResponse userAppPasswordResponse = new BaseRestMapResponse();
		logger.info("===step4:【根据userId修改用户应用密码】(UserAppPasswordController-modifyByUserId)-返回信息, userAppPasswordResponse:{}", userAppPasswordResponse);
		return userAppPasswordResponse;
	}

}