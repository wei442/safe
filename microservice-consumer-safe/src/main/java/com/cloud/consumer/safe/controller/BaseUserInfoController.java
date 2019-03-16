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
import com.cloud.consumer.safe.rest.request.BaseUserInfoIdRequest;
import com.cloud.consumer.safe.rest.request.BaseUserInfoRequest;
import com.cloud.consumer.safe.rest.request.page.BaseUserInfoPageRequest;
import com.cloud.consumer.safe.service.IBaseUserInfoService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.BaseUserInfoVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户信息管理 BaseUserInfoController
 * @author wei.yong
 * @ClassName: BaseUserInfoController
 */
@Api(tags = "基础用户信息")
@RestController
@RequestMapping("/base/user/info")
public class BaseUserInfoController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户信息 Service
	@Autowired
	private IBaseUserInfoService baseUserInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户信息列表")
	@RequestMapping(value="/getBaseUserInfoListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserInfoListByPage(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【分页查询】(BaseUserInfoController-getBaseUserInfoListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserInfo = baseUserInfoService.getBaseUserInfoListByPage(req);
		logger.info("===step2:【分页查询】(BaseUserInfoController-getBaseUserInfoListByPage)-分页查询基础用户信息列表, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserInfo.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonBaseUserInfo.getJSONObject(PageConstants.PAGE));
		List<BaseUserInfoVo> baseUserInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserInfoVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, baseUserInfoVoList);
		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(BaseUserInfoController-getBaseUserInfoListByPage)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
	    return baseUserInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户信息列表")
	@RequestMapping(value="/getBaseUserInfoList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserInfoList(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【不分页查询】(BaseUserInfoController-getBaseUserInfoList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserInfo = baseUserInfoService.getBaseUserInfoListByPage(req);
		logger.info("===step2:【不分页查询】(BaseUserInfoController-getBaseUserInfoList)-不分页查询基础用户信息列表, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserInfo.getJSONArray(PageConstants.DATA_LIST));
		List<BaseUserInfoVo> baseUserInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserInfoVo>>(){});

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(RetSafeConstants.RESULT, baseUserInfoVoList);
		logger.info("===step3:【不分页查询】(BaseUserInfoController-getBaseUserInfoList)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 获取基础用户信息详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取基础用户信息详情")
	@RequestMapping(value="/getBaseUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getBaseUserInfo(
		@Validated @RequestBody BaseUserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取基础用户信息】(BaseUserInfoController-getBaseUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserId = req.getBaseUserId();
		JSONObject jsonBaseUserInfo = baseUserInfoService.getBaseUserInfoById(baseUserId);
		logger.info("===step2:【获取基础用户信息】(BaseUserInfoController-getBaseUserInfo)-根据baseUserInfoId获取基础用户信息, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		BaseUserInfoVo baseUserInfoVo = JSONObject.toJavaObject(jsonBaseUserInfo, BaseUserInfoVo.class);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(RetSafeConstants.RESULT, baseUserInfoVo);
	    logger.info("===step3:【获取基础用户信息】(BaseUserInfoController-getBaseUserInfo)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
	    return baseUserInfoResponse;
	}

	/**
	 * 新增基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增基础用户信息")
	@RequestMapping(value="/addBaseUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addBaseUserInfo(
		@Validated @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增基础用户信息】(BaseUserInfoController-addBaseUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonBaseUserInfo = baseUserInfoService.addBaseUserInfo(req);
		logger.info("===step2:【新增基础用户信息】(BaseUserInfoController-addBaseUserInfo)-分页查询基础用户信息列表, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		BaseUserInfoVo baseUserInfoVo = JSONObject.toJavaObject(jsonBaseUserInfo, BaseUserInfoVo.class);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(RetSafeConstants.RESULT, baseUserInfoVo);
	    logger.info("===step3:【新增基础用户信息】(BaseUserInfoController-addBaseUserInfo)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
	    return baseUserInfoResponse;
	}

	/**
	 * 删除基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除基础用户信息")
	@RequestMapping(value="/deleteBaseUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteBaseUserInfo(
		@Validated @RequestBody BaseUserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除基础用户信息】(BaseUserInfoController-deleteBaseUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserId = req.getBaseUserId();
		JSONObject jsonBaseUserInfo = baseUserInfoService.deleteBaseUserInfoById(baseUserId);
		logger.info("===step2:【删除基础用户信息】(BaseUserInfoController-deleteBaseUserInfo)-根据baseUserInfoId删除基础用户信息, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		BaseUserInfoVo baseUserInfoVo = JSONObject.toJavaObject(jsonBaseUserInfo, BaseUserInfoVo.class);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(RetSafeConstants.RESULT, baseUserInfoVo);
		logger.info("===step3:【删除基础用户信息】(BaseUserInfoController-deleteBaseUserInfo)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 修改基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户信息")
	@RequestMapping(value="/updateBaseUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateBaseUserInfo(
		@Validated({ UpdateGroup.class }) @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户信息】(BaseUserInfoController-updateBaseUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonBaseUserInfo = baseUserInfoService.addBaseUserInfo(req);
		logger.info("===step2:【修改基础用户信息】(BaseUserInfoController-updateBaseUserInfo)-修改基础用户信息, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		BaseUserInfoVo baseUserInfoVo = JSONObject.toJavaObject(jsonBaseUserInfo, BaseUserInfoVo.class);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(RetSafeConstants.RESULT, baseUserInfoVo);
		logger.info("===step3:【修改基础用户信息】(BaseUserInfoController-updateBaseUserInfo)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

}