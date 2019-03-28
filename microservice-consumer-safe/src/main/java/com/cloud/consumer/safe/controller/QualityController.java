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
import com.cloud.consumer.safe.rest.request.QualityIdRequest;
import com.cloud.consumer.safe.rest.request.QualityRequest;
import com.cloud.consumer.safe.rest.request.page.QualityPageRequest;
import com.cloud.consumer.safe.service.IQualityService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.QualityVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

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
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【分页查询】(QualityController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonQuality = qualityService.getListByPage(req);
		logger.info("===step2:【分页查询】(QualityController-getListByPage)-分页查询资质列表, jsonQuality:{}", jsonQuality);
		String dataListStr = JSONObject.toJSONString(jsonQuality.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonQuality.getJSONObject(PageConstants.PAGE));
		List<QualityVo> qualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<QualityVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, qualityVoList);
		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(QualityController-getListByPage)-返回信息, qualityResponse:{}", qualityResponse);
	    return qualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询资质列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【不分页查询】(QualityController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonQuality = qualityService.getListByPage(req);
		logger.info("===step2:【不分页查询】(QualityController-getList)-不分页查询资质列表, jsonQuality:{}", jsonQuality);
		String dataListStr = JSONObject.toJSONString(jsonQuality.getJSONArray(PageConstants.DATA_LIST));
		List<QualityVo> qualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<QualityVo>>(){});

		BaseResultVo result = new BaseResultVo(qualityVoList);
		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(QualityController-getList)-返回信息, qualityResponse:{}", qualityResponse);
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
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody QualityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取资质】(QualityController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer qualityId = req.getQualityId();
		JSONObject jsonQuality = qualityService.getById(qualityId);
		logger.info("===step2:【获取资质】(QualityController-get)-根据qualityId获取资质, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
	    logger.info("===step3:【获取资质】(QualityController-get)-返回信息, qualityResponse:{}", qualityResponse);
	    return qualityResponse;
	}

	/**
	 * 新增资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增资质")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增资质】(QualityController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonQuality = qualityService.add(req);
		logger.info("===step2:【新增资质】(QualityController-add)-分页查询资质列表, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
	    logger.info("===step3:【新增资质】(QualityController-add)-返回信息, qualityResponse:{}", qualityResponse);
	    return qualityResponse;
	}

	/**
	 * 删除资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除资质")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody QualityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除资质】(QualityController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer qualityId = req.getQualityId();
		JSONObject jsonQuality = qualityService.deleteById(qualityId);
		logger.info("===step2:【删除资质】(QualityController-delete)-根据qualityId删除资质, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
		logger.info("===step3:【删除资质】(QualityController-delete)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 修改资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改资质")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改资质】(QualityController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonQuality = qualityService.update(req);
		logger.info("===step2:【修改资质】(QualityController-update)-修改资质, jsonQuality:{}", jsonQuality);
		QualityVo qualityVo = JSONObject.toJavaObject(jsonQuality, QualityVo.class);

		//返回信息
		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(RetSafeConstants.RESULT, qualityVo);
		logger.info("===step3:【修改资质】(QualityController-update)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

}