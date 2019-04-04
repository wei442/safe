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
import com.cloud.consumer.safe.rest.request.base.user.BaseUserLoginIdRequest;
import com.cloud.consumer.safe.rest.request.base.user.BaseUserLoginRequest;
import com.cloud.consumer.safe.rest.request.page.base.user.BaseUserLoginPageRequest;
import com.cloud.consumer.safe.service.IBaseUserLoginService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.base.user.BaseUserLoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户登录管理 BaseUserLoginController
 * @author wei.yong
 * @ClassName: BaseUserLoginController
 */
@Api(tags = "基础用户登录")
@RestController
@RequestMapping("/base/userLogin")
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
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【分页查询】(BaseUserLoginController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserLogin = baseUserLoginService.getListByPage(req);
		logger.info("===step2:【分页查询】(BaseUserLoginController-getListByPage)-分页查询基础用户登录列表, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserLogin.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonBaseUserLogin.getJSONObject(PageConstants.PAGE));
		List<BaseUserLoginVo> baseUserLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserLoginVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, baseUserLoginVoList);
		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(BaseUserLoginController-getListByPage)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
	    return baseUserLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户登录列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【不分页查询】(BaseUserLoginController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserLogin = baseUserLoginService.getListByPage(req);
		logger.info("===step2:【不分页查询】(BaseUserLoginController-getList)-不分页查询基础用户登录列表, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserLogin.getJSONArray(PageConstants.DATA_LIST));
		List<BaseUserLoginVo> baseUserLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserLoginVo>>(){});

		BaseResultVo result = new BaseResultVo(baseUserLoginVoList);
		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(BaseUserLoginController-getList)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
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
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody BaseUserLoginIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取基础用户登录】(BaseUserLoginController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer baseUserLoginId = req.getBaseUserLoginId();
		JSONObject jsonBaseUserLogin = baseUserLoginService.getById(baseUserLoginId);
		logger.info("===step2:【获取基础用户登录】(BaseUserLoginController-get)-根据baseUserLoginId获取基础用户登录, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
	    logger.info("===step3:【获取基础用户登录】(BaseUserLoginController-get)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
	    return baseUserLoginResponse;
	}

	/**
	 * 新增基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增基础用户登录")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增基础用户登录】(BaseUserLoginController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserLogin = baseUserLoginService.add(req);
		logger.info("===step2:【新增基础用户登录】(BaseUserLoginController-add)-分页查询基础用户登录列表, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
	    logger.info("===step3:【新增基础用户登录】(BaseUserLoginController-add)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
	    return baseUserLoginResponse;
	}

	/**
	 * 删除基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除基础用户登录")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody BaseUserLoginIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除基础用户登录】(BaseUserLoginController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer baseUserLoginId = req.getBaseUserLoginId();
		JSONObject jsonBaseUserLogin = baseUserLoginService.deleteById(baseUserLoginId);
		logger.info("===step2:【删除基础用户登录】(BaseUserLoginController-delete)-根据baseUserLoginId删除基础用户登录, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
		logger.info("===step3:【删除基础用户登录】(BaseUserLoginController-delete)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 修改基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户登录")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户登录】(BaseUserLoginController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserLogin = baseUserLoginService.update(req);
		logger.info("===step2:【修改基础用户登录】(BaseUserLoginController-update)-修改基础用户登录, jsonBaseUserLogin:{}", jsonBaseUserLogin);
		BaseUserLoginVo baseUserLoginVo = JSONObject.toJavaObject(jsonBaseUserLogin, BaseUserLoginVo.class);

		//返回信息
		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(RetSafeConstants.RESULT, baseUserLoginVo);
		logger.info("===step3:【修改基础用户登录】(BaseUserLoginController-update)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

}