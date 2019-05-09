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
import com.cloud.provider.safe.rest.request.user.UserAdminPasswordRequest;
import com.cloud.provider.safe.service.IUserAdminPasswordService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserAdminPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理密码 UserAdminPasswordController
 * @author wei.yong
 */
@Api(tags = "用户管理密码")
@RestController
@RequestMapping(value="/user/admin/password")
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
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userAdminPasswordId) {
		logger.info("===step1:【据id查询用户管理密码】(UserAdminPasswordController-selectById)-传入参数, userAdminPasswordId:{}", userAdminPasswordId);

		if(userAdminPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userAdminPasswordId不能为空");
		}

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectById(userAdminPasswordId);
		logger.info("===step2:【据id查询用户管理密码】(UserAdminPasswordController-selectById)-根据id查询用户管理密码, userAdminPassword:{}", userAdminPassword);
		Assert.thanOrEqualZreo(userAdminPassword, SafeResultEnum.DATABASE_NOTEXIST);
		UserAdminPasswordVo userAdminPasswordVo = new UserAdminPasswordVo().convertToUserAdminPasswordVo(userAdminPassword);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		userAdminPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAdminPasswordVo));
		logger.info("===step3:【据id查询用户管理密码】(UserAdminPasswordController-selectById)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 根据userId和password查询用户管理密码
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId和password查询用户管理密码")
	@RequestMapping(value="/selectByUserIdPassword",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserIdPassword(
		@Validated @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据userId和password查询用户管理密码】(UserAdminPasswordController-selectByUserIdPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String password = req.getPassword();

		UserAdminPassword userAdminPassword = userAdminPasswordService.selectByUserIdPassword(userId, password);
		logger.info("===step2:【根据userId和password查询用户管理密码】(UserAdminPasswordController-selectByUserIdPassword)-根据userId和password查询用户管理密码, userAdminPassword:{}", userAdminPassword);
		UserAdminPasswordVo userAdminPasswordVo = new UserAdminPasswordVo().convertToUserAdminPasswordVo(userAdminPassword);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		userAdminPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userAdminPasswordVo));
		logger.info("===step3:【根据userId和password查询用户管理密码】(UserAdminPasswordController-selectByUserIdPassword)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 添加用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理密码")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理密码】(UserAdminPasswordController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserAdminPassword userAdminPassword = req.convertToUserAdminPassword();
		int i = userAdminPasswordService.insert(userAdminPassword);
		logger.info("===step2:【添加用户管理密码】(UserAdminPasswordController-insert)-插入用户管理密码, i:{}", i);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户管理密码】(UserAdminPasswordController-insert)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 根据id删除用户管理密码
	 * @param userAdminPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户管理密码")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userAdminPasswordId) {
		logger.info("===step1:【根据id删除用户管理密码】(selectById-deleteById)-传入参数, userAdminPasswordId:{}", userAdminPasswordId);

		if(userAdminPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userAdminPasswordId不能为空");
		}

		int i = userAdminPasswordService.deleteById(userAdminPasswordId);
		logger.info("===step2:【根据id删除用户管理密码】(UserAdminPasswordController-deleteById)-根据id查询用户管理密码, i:{}", i);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户管理密码】(UserAdminPasswordController-deleteById)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}

	/**
	 * 修改用户管理密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理密码")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理密码】(UserAdminPasswordController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminPasswordId = req.getUserAdminPasswordId();
		UserAdminPassword userAdminPassword = req.convertToUserAdminPassword();
		userAdminPassword.setId(userAdminPasswordId);
		int i = userAdminPasswordService.modify(userAdminPassword);
		logger.info("===step2:【修改用户管理密码】(UserAdminPasswordController-modify)-修改用户管理密码, i:{}", i);

		BaseRestMapResponse userAdminPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理密码】(UserAdminPasswordController-modify)-返回信息, userAdminPasswordResponse:{}", userAdminPasswordResponse);
		return userAdminPasswordResponse;
	}


}