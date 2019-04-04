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
import com.cloud.provider.safe.po.BaseUserPassword;
import com.cloud.provider.safe.rest.request.base.user.BaseUserPasswordRequest;
import com.cloud.provider.safe.service.IBaseUserPasswordService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.base.user.BaseUserPasswordVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户密码 BaseUserPasswordController
 * @author wei.yong
 */
@Api(tags = "基础用户密码")
@RestController
@RequestMapping(value="/base/user/password")
public class BaseUserPasswordController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户密码Service
	@Autowired
	private IBaseUserPasswordService baseUserPasswordService;

	/**
	 * 据id查询基础用户密码
	 * @param baseUserPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询基础用户密码")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer baseUserPasswordId) {
		logger.info("===step1:【据id查询基础用户密码】(selectById-selectById)-传入参数, baseUserPasswordId:{}", baseUserPasswordId);

		if(baseUserPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserPasswordId不能为空");
		}

		BaseUserPassword baseUserPassword = baseUserPasswordService.selectById(baseUserPasswordId);
		logger.info("===step2:【据id查询基础用户密码】(BaseUserPasswordController-selectById)-根据id查询基础用户密码, baseUserPassword:{}", baseUserPassword);
		BaseUserPasswordVo baseUserPasswordVo = new BaseUserPasswordVo().convertToBaseUserPasswordVo(baseUserPassword);

		BaseRestMapResponse baseUserPasswordResponse = new BaseRestMapResponse();
		baseUserPasswordResponse.putAll((JSONObject) JSONObject.toJSON(baseUserPasswordVo));
		logger.info("===step3:【据id查询基础用户密码】(BaseUserPasswordController-selectById)-返回信息, baseUserPasswordResponse:{}", baseUserPasswordResponse);
		return baseUserPasswordResponse;
	}

	/**
	 * 据baseUserId查询基础用户密码
	 * @param baseUserId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据baseUserId查询基础用户密码")
	@RequestMapping(value="/selectByBaseUserId/{baseUserId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByBaseUserId(
		@PathVariable(value="baseUserId",required=false) Integer baseUserId) {
		logger.info("===step1:【据baseUserId查询基础用户密码】(selectById-selectById)-传入参数, baseUserPasswordId:{}", baseUserId);

		if(baseUserId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserId不能为空");
		}

		BaseUserPassword baseUserPassword = baseUserPasswordService.selectByBaseUserId(baseUserId);
		logger.info("===step2:【据baseUserId查询基础用户密码】(BaseUserPasswordController-selectById)-根据baseUserId查询基础用户密码, baseUserPassword:{}", baseUserPassword);
		BaseUserPasswordVo baseUserPasswordVo = new BaseUserPasswordVo().convertToBaseUserPasswordVo(baseUserPassword);

		BaseRestMapResponse baseUserPasswordResponse = new BaseRestMapResponse();
		baseUserPasswordResponse.putAll((JSONObject) JSONObject.toJSON(baseUserPasswordVo));
		logger.info("===step3:【据baseUserId查询基础用户密码】(BaseUserPasswordController-selectById)-返回信息, baseUserPasswordResponse:{}", baseUserPasswordResponse);
		return baseUserPasswordResponse;
	}

	/**
	 * 添加基础用户密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户密码")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody BaseUserPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户密码】(BaseUserPasswordController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		BaseUserPassword baseUserPassword = req.convertToBaseUserPassword();
		int i = baseUserPasswordService.insert(baseUserPassword);
		logger.info("===step2:【添加基础用户密码】(BaseUserPasswordController-insert)-插入基础用户密码, i:{}", i);

		BaseRestMapResponse baseUserPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户密码】(BaseUserPasswordController-insert)-返回信息, baseUserPasswordResponse:{}", baseUserPasswordResponse);
		return baseUserPasswordResponse;
	}

	/**
	 * 根据id删除基础用户密码
	 * @param baseUserPasswordId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除基础用户密码")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer baseUserPasswordId) {
		logger.info("===step1:【根据id删除基础用户密码】(selectById-deleteById)-传入参数, baseUserPasswordId:{}", baseUserPasswordId);

		if(baseUserPasswordId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserPasswordId不能为空");
		}

		int i = baseUserPasswordService.deleteById(baseUserPasswordId);
		logger.info("===step2:【根据id删除基础用户密码】(BaseUserPasswordController-deleteById)-根据id查询基础用户密码, i:{}", i);

		BaseRestMapResponse baseUserPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除基础用户密码】(BaseUserPasswordController-deleteById)-返回信息, baseUserPasswordResponse:{}", baseUserPasswordResponse);
		return baseUserPasswordResponse;
	}

	/**
	 * 修改基础用户密码
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户密码")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody BaseUserPasswordRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户密码】(BaseUserPasswordController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer baseUserPasswordId = req.getBaseUserPasswordId();
		BaseUserPassword baseUserPassword = req.convertToBaseUserPassword();
		baseUserPassword.setId(baseUserPasswordId);
		int i = baseUserPasswordService.modify(baseUserPassword);
		logger.info("===step2:【修改基础用户密码】(BaseUserPasswordController-modify)-修改基础用户密码, i:{}", i);

		BaseRestMapResponse baseUserPasswordResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改基础用户密码】(BaseUserPasswordController-modify)-返回信息, baseUserPasswordResponse:{}", baseUserPasswordResponse);
		return baseUserPasswordResponse;
	}


}