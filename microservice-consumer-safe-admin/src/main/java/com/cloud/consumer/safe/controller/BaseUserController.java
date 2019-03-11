package com.cloud.consumer.safe.controller;

import java.util.List;

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
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.PageConstants;
import com.cloud.common.constants.safe.RetSafeConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.BaseUserRequest;
import com.cloud.consumer.safe.rest.request.page.BaseUserPageRequest;
import com.cloud.consumer.safe.service.IBaseUserService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.BaseUserVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户管理 BaseUserController
 * @author wei.yong
 * @ClassName: BaseUserController
 */
@Api(tags = "基础用户")
@RestController
@RequestMapping("/baseUser")
public class BaseUserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户 Service
	@Autowired
	private IBaseUserService baseUserService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户列表")
	@RequestMapping(value="/getBaseUserListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserListByPage(
		@RequestBody BaseUserPageRequest req) {
		logger.info("===step1:【分页查询】(BaseUserController-getBaseUserListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUser = baseUserService.getBaseUserListByPage(req);
		logger.info("===step2:【分页查询】(BaseUserController-getBaseUserListByPage)-分页查询基础用户列表, jsonBaseUser:{}", jsonBaseUser);
		String dataListStr = JSONObject.toJSONString(jsonBaseUser.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonBaseUser.getJSONObject(PageConstants.PAGE));
		List<BaseUserVo> baseUserVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, baseUserVoList);
		//返回信息
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(BaseUserController-getBaseUserListByPage)-返回信息, baseUserResponse:{}", baseUserResponse);
	    return baseUserResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户列表")
	@RequestMapping(value="/getBaseUserList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserList(
		@RequestBody BaseUserPageRequest req) {
		logger.info("===step1:【不分页查询】(BaseUserController-getBaseUserList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUser = baseUserService.getBaseUserListByPage(req);
		logger.info("===step2:【不分页查询】(BaseUserController-getBaseUserList)-不分页查询基础用户列表, jsonBaseUser:{}", jsonBaseUser);
		String dataListStr = JSONObject.toJSONString(jsonBaseUser.getJSONArray(PageConstants.DATA_LIST));
		List<BaseUserVo> baseUserVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserVo>>(){});

		//返回信息
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(RetSafeConstants.RESULT, baseUserVoList);
		logger.info("===step3:【不分页查询】(BaseUserController-getBaseUserList)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 获取基础用户详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取基础用户详情")
	@RequestMapping(value="/getBaseUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUser(
		@RequestBody BaseUserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取基础用户】(BaseUserController-getBaseUser)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserId = req.getBaseUserId();
		JSONObject jsonBaseUser = baseUserService.getBaseUserById(baseUserId);
		logger.info("===step2:【获取基础用户】(BaseUserController-getBaseUser)-根据baseUserId获取基础用户, jsonBaseUser:{}", jsonBaseUser);
		BaseUserVo baseUserVo = JSONObject.toJavaObject(jsonBaseUser, BaseUserVo.class);

		//返回信息
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(RetSafeConstants.RESULT, baseUserVo);
	    logger.info("===step3:【获取基础用户】(BaseUserController-getBaseUser)-返回信息, baseUserResponse:{}", baseUserResponse);
	    return baseUserResponse;
	}

	/**
	 * 新增基础用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增基础用户")
	@RequestMapping(value="/addBaseUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addBaseUser(
		@Validated @RequestBody BaseUserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增基础用户】(BaseUserController-addBaseUser)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonBaseUser = baseUserService.addBaseUser(req);
		logger.info("===step2:【新增基础用户】(BaseUserController-addBaseUser)-分页查询基础用户列表, jsonBaseUser:{}", jsonBaseUser);
		BaseUserVo baseUserVo = JSONObject.toJavaObject(jsonBaseUser, BaseUserVo.class);

		//返回信息
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(RetSafeConstants.RESULT, baseUserVo);
	    logger.info("===step3:【新增基础用户】(BaseUserController-addBaseUser)-返回信息, baseUserResponse:{}", baseUserResponse);
	    return baseUserResponse;
	}

	/**
	 * 删除基础用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除基础用户")
	@RequestMapping(value="/deleteBaseUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteBaseUser(
		@RequestBody BaseUserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除基础用户】(BaseUserController-deleteBaseUser)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserId = req.getBaseUserId();
		JSONObject jsonBaseUser = baseUserService.deleteBaseUserById(baseUserId);
		logger.info("===step2:【删除基础用户】(BaseUserController-deleteBaseUser)-根据baseUserId删除基础用户, jsonBaseUser:{}", jsonBaseUser);
		BaseUserVo baseUserVo = JSONObject.toJavaObject(jsonBaseUser, BaseUserVo.class);

		//返回信息
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(RetSafeConstants.RESULT, baseUserVo);
		logger.info("===step3:【删除基础用户】(BaseUserController-deleteBaseUser)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 修改基础用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户")
	@RequestMapping(value="/updateBaseUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateBaseUser(
		@Validated({ UpdateGroup.class }) @RequestBody BaseUserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户】(BaseUserController-updateBaseUser)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonBaseUser = baseUserService.addBaseUser(req);
		logger.info("===step2:【修改基础用户】(BaseUserController-updateBaseUser)-修改基础用户, jsonBaseUser:{}", jsonBaseUser);
		BaseUserVo baseUserVo = JSONObject.toJavaObject(jsonBaseUser, BaseUserVo.class);

		//返回信息
		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(RetSafeConstants.RESULT, baseUserVo);
		logger.info("===step3:【修改基础用户】(BaseUserController-updateBaseUser)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

}