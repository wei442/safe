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
import com.cloud.consumer.safe.rest.request.BaseUserLoginRequest;
import com.cloud.consumer.safe.rest.request.page.BaseUserLoginPageRequest;
import com.cloud.consumer.safe.service.IBaseUserLoginService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.BaseUserLoginVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户登录管理 BaseUserLoginController
 * @author wei.yong
 * @ClassName: BaseUserLoginController
 */
@Api(tags = "基础用户登录")
@RestController
@RequestMapping("/baseUserLogin")
public class BaseUserLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录 Service
	@Autowired
	private IBaseUserLoginService baseUserLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户登录列表")
	@RequestMapping(value="/getBaseUserLoginListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserLoginListByPage(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【分页查询】(BaseUserLoginController-getBaseUserLoginListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserLogin = baseUserLoginService.getBaseUserLoginListByPage(req);
		logger.info("===step2:【分页查询】(BaseUserLoginController-getBaseUserLoginListByPage)-分页查询基础用户登录列表, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserLogin.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonBaseUserLogin.getJSONObject(PageConstants.PAGE));
		List<BaseUserLoginVo> baseUserLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserLoginVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, baseUserLoginVoList);
		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(BaseUserLoginController-getBaseUserLoginListByPage)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
	    return baseUserLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户登录列表")
	@RequestMapping(value="/getBaseUserLoginList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserLoginList(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【不分页查询】(BaseUserLoginController-getBaseUserLoginList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserLogin = baseUserLoginService.getBaseUserLoginListByPage(req);
		logger.info("===step2:【不分页查询】(BaseUserLoginController-getBaseUserLoginList)-不分页查询基础用户登录列表, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserLogin.getJSONArray(PageConstants.DATA_LIST));
		List<BaseUserLoginVo> baseUserLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserLoginVo>>(){});

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVoList);
		logger.info("===step3:【不分页查询】(BaseUserLoginController-getBaseUserLoginList)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 获取基础用户登录详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取基础用户登录详情")
	@RequestMapping(value="/getBaseUserLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserLogin(
		@RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取基础用户登录】(BaseUserLoginController-getBaseUserLogin)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserLoginId = req.getBaseUserLoginId();
		JSONObject jsonBaseUserLogin = baseUserLoginService.getBaseUserLoginById(baseUserLoginId);
		logger.info("===step2:【获取基础用户登录】(BaseUserLoginController-getBaseUserLogin)-根据baseUserLoginId获取基础用户登录, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
	    logger.info("===step3:【获取基础用户登录】(BaseUserLoginController-getBaseUserLogin)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
	    return baseUserLoginResponse;
	}

	/**
	 * 新增基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增基础用户登录")
	@RequestMapping(value="/addBaseUserLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addBaseUserLogin(
		@Validated @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增基础用户登录】(BaseUserLoginController-addBaseUserLogin)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonBaseUserLogin = baseUserLoginService.addBaseUserLogin(req);
		logger.info("===step2:【新增基础用户登录】(BaseUserLoginController-addBaseUserLogin)-分页查询基础用户登录列表, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
	    logger.info("===step3:【新增基础用户登录】(BaseUserLoginController-addBaseUserLogin)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
	    return baseUserLoginResponse;
	}

	/**
	 * 删除基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除基础用户登录")
	@RequestMapping(value="/deleteBaseUserLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteBaseUserLogin(
		@RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除基础用户登录】(BaseUserLoginController-deleteBaseUserLogin)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserLoginId = req.getBaseUserLoginId();
		JSONObject jsonBaseUserLogin = baseUserLoginService.deleteBaseUserLoginById(baseUserLoginId);
		logger.info("===step2:【删除基础用户登录】(BaseUserLoginController-deleteBaseUserLogin)-根据baseUserLoginId删除基础用户登录, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
		logger.info("===step3:【删除基础用户登录】(BaseUserLoginController-deleteBaseUserLogin)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 修改基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户登录")
	@RequestMapping(value="/updateBaseUserLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateBaseUserLogin(
		@Validated({ UpdateGroup.class }) @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户登录】(BaseUserLoginController-updateBaseUserLogin)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonBaseUserLogin = baseUserLoginService.addBaseUserLogin(req);
		logger.info("===step2:【修改基础用户登录】(BaseUserLoginController-updateBaseUserLogin)-修改基础用户登录, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
		logger.info("===step3:【修改基础用户登录】(BaseUserLoginController-updateBaseUserLogin)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

}