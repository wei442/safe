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
import com.cloud.consumer.safe.rest.request.QualityRequest;
import com.cloud.consumer.safe.rest.request.page.QualityPageRequest;
import com.cloud.consumer.safe.service.IQualityService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.QualityVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 资质管理 QualityController
 * @author wei.yong
 * @ClassName: QualityController
 */
@Api(tags = "资质")
@RestController
@RequestMapping("/quality")
public class QualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//资质 Service
	@Autowired
	private IQualityService qualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询资质列表")
	@RequestMapping(value="/getQualityListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getQualityListByPage(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【分页查询】(QualityController-getQualityListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonQuality = qualityService.getQualityListByPage(req);
		logger.info("===step2:【分页查询】(QualityController-getQualityListByPage)-分页查询资质列表, jsonQuality:{}", jsonQuality);
		String dataListStr = JSONObject.toJSONString(jsonQuality.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonQuality.getJSONObject(PageConstants.PAGE));
		List<QualityVo> qualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<QualityVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, qualityVoList);
		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(QualityController-getQualityListByPage)-返回信息, qualityResponse:{}", qualityResponse);
	    return qualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询资质列表")
	@RequestMapping(value="/getQualityList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getQualityList(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【不分页查询】(QualityController-getQualityList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonQuality = qualityService.getQualityListByPage(req);
		logger.info("===step2:【不分页查询】(QualityController-getQualityList)-不分页查询资质列表, jsonQuality:{}", jsonQuality);
		String dataListStr = JSONObject.toJSONString(jsonQuality.getJSONArray(PageConstants.DATA_LIST));
		List<QualityVo> qualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<QualityVo>>(){});

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVoList);
		logger.info("===step3:【不分页查询】(QualityController-getQualityList)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 获取资质详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取资质详情")
	@RequestMapping(value="/getQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getQuality(
		@RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取资质】(QualityController-getQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer qualityId = req.getQualityId();
		JSONObject jsonQuality = qualityService.getQualityById(qualityId);
		logger.info("===step2:【获取资质】(QualityController-getQuality)-根据qualityId获取资质, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
	    logger.info("===step3:【获取资质】(QualityController-getQuality)-返回信息, qualityResponse:{}", qualityResponse);
	    return qualityResponse;
	}

	/**
	 * 新增资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增资质")
	@RequestMapping(value="/addQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addQuality(
		@Validated @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增资质】(QualityController-addQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonQuality = qualityService.addQuality(req);
		logger.info("===step2:【新增资质】(QualityController-addQuality)-分页查询资质列表, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
	    logger.info("===step3:【新增资质】(QualityController-addQuality)-返回信息, qualityResponse:{}", qualityResponse);
	    return qualityResponse;
	}

	/**
	 * 删除资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除资质")
	@RequestMapping(value="/deleteQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteQuality(
		@RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除资质】(QualityController-deleteQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer qualityId = req.getQualityId();
		JSONObject jsonQuality = qualityService.deleteQualityById(qualityId);
		logger.info("===step2:【删除资质】(QualityController-deleteQuality)-根据qualityId删除资质, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
		logger.info("===step3:【删除资质】(QualityController-deleteQuality)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 修改资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改资质")
	@RequestMapping(value="/updateQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateQuality(
		@Validated({ UpdateGroup.class }) @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改资质】(QualityController-updateQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonQuality = qualityService.addQuality(req);
		logger.info("===step2:【修改资质】(QualityController-updateQuality)-修改资质, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
		logger.info("===step3:【修改资质】(QualityController-updateQuality)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

}