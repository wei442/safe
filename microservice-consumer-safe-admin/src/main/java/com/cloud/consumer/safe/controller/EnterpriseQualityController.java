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
import com.cloud.consumer.safe.rest.request.EnterpriseQualityRequest;
import com.cloud.consumer.safe.rest.request.page.EnterpriseQualityPageRequest;
import com.cloud.consumer.safe.service.IEnterpriseQualityService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.EnterpriseQualityVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 企业资质管理 EnterpriseQualityController
 * @author wei.yong
 * @ClassName: EnterpriseQualityController
 */
@Api(tags = "企业资质")
@RestController
@RequestMapping("/enterprise/quality")
public class EnterpriseQualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//企业资质 Service
	@Autowired
	private IEnterpriseQualityService enterpriseQualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询企业资质列表")
	@RequestMapping(value="/getEnterpriseQualityListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getEnterpriseQualityListByPage(
		@RequestBody EnterpriseQualityPageRequest req) {
		logger.info("===step1:【分页查询】(EnterpriseQualityController-getEnterpriseQualityListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonEnterpriseQuality = enterpriseQualityService.getEnterpriseQualityListByPage(req);
		logger.info("===step2:【分页查询】(EnterpriseQualityController-getEnterpriseQualityListByPage)-分页查询企业资质列表, jsonEnterpriseQuality:{}", jsonEnterpriseQuality);
		String dataListStr = JSONObject.toJSONString(jsonEnterpriseQuality.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonEnterpriseQuality.getJSONObject(PageConstants.PAGE));
		List<EnterpriseQualityVo> enterpriseQualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<EnterpriseQualityVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, enterpriseQualityVoList);
		//返回信息
		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(EnterpriseQualityController-getEnterpriseQualityListByPage)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
	    return enterpriseQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询企业资质列表")
	@RequestMapping(value="/getEnterpriseQualityList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getEnterpriseQualityList(
		@RequestBody EnterpriseQualityPageRequest req) {
		logger.info("===step1:【不分页查询】(EnterpriseQualityController-getEnterpriseQualityList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonEnterpriseQuality = enterpriseQualityService.getEnterpriseQualityListByPage(req);
		logger.info("===step2:【不分页查询】(EnterpriseQualityController-getEnterpriseQualityList)-不分页查询企业资质列表, jsonEnterpriseQuality:{}", jsonEnterpriseQuality);
		String dataListStr = JSONObject.toJSONString(jsonEnterpriseQuality.getJSONArray(PageConstants.DATA_LIST));
		List<EnterpriseQualityVo> enterpriseQualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<EnterpriseQualityVo>>(){});

		//返回信息
		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(RetSafeConstants.RESULT, enterpriseQualityVoList);
		logger.info("===step3:【不分页查询】(EnterpriseQualityController-getEnterpriseQualityList)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 获取企业资质详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取企业资质详情")
	@RequestMapping(value="/getEnterpriseQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getEnterpriseQuality(
		@RequestBody EnterpriseQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取企业资质】(EnterpriseQualityController-getEnterpriseQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer enterpriseQualityId = req.getEnterpriseQualityId();
		JSONObject jsonEnterpriseQuality = enterpriseQualityService.getEnterpriseQualityById(enterpriseQualityId);
		logger.info("===step2:【获取企业资质】(EnterpriseQualityController-getEnterpriseQuality)-根据enterpriseQualityId获取企业资质, jsonEnterpriseQuality:{}", jsonEnterpriseQuality);
		EnterpriseQualityVo enterpriseQualityVo = JSONObject.toJavaObject(jsonEnterpriseQuality, EnterpriseQualityVo.class);

		//返回信息
		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(RetSafeConstants.RESULT, enterpriseQualityVo);
	    logger.info("===step3:【获取企业资质】(EnterpriseQualityController-getEnterpriseQuality)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
	    return enterpriseQualityResponse;
	}

	/**
	 * 新增企业资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增企业资质")
	@RequestMapping(value="/addEnterpriseQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addEnterpriseQuality(
		@Validated @RequestBody EnterpriseQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增企业资质】(EnterpriseQualityController-addEnterpriseQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonEnterpriseQuality = enterpriseQualityService.addEnterpriseQuality(req);
		logger.info("===step2:【新增企业资质】(EnterpriseQualityController-addEnterpriseQuality)-分页查询企业资质列表, jsonEnterpriseQuality:{}", jsonEnterpriseQuality);
		EnterpriseQualityVo enterpriseQualityVo = JSONObject.toJavaObject(jsonEnterpriseQuality, EnterpriseQualityVo.class);

		//返回信息
		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(RetSafeConstants.RESULT, enterpriseQualityVo);
	    logger.info("===step3:【新增企业资质】(EnterpriseQualityController-addEnterpriseQuality)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
	    return enterpriseQualityResponse;
	}

	/**
	 * 删除企业资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除企业资质")
	@RequestMapping(value="/deleteEnterpriseQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteEnterpriseQuality(
		@RequestBody EnterpriseQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除企业资质】(EnterpriseQualityController-deleteEnterpriseQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer enterpriseQualityId = req.getEnterpriseQualityId();
		JSONObject jsonEnterpriseQuality = enterpriseQualityService.deleteEnterpriseQualityById(enterpriseQualityId);
		logger.info("===step2:【删除企业资质】(EnterpriseQualityController-deleteEnterpriseQuality)-根据enterpriseQualityId删除企业资质, jsonEnterpriseQuality:{}", jsonEnterpriseQuality);
		EnterpriseQualityVo enterpriseQualityVo = JSONObject.toJavaObject(jsonEnterpriseQuality, EnterpriseQualityVo.class);

		//返回信息
		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(RetSafeConstants.RESULT, enterpriseQualityVo);
		logger.info("===step3:【删除企业资质】(EnterpriseQualityController-deleteEnterpriseQuality)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 修改企业资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改企业资质")
	@RequestMapping(value="/updateEnterpriseQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateEnterpriseQuality(
		@Validated({ UpdateGroup.class }) @RequestBody EnterpriseQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改企业资质】(EnterpriseQualityController-updateEnterpriseQuality)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonEnterpriseQuality = enterpriseQualityService.addEnterpriseQuality(req);
		logger.info("===step2:【修改企业资质】(EnterpriseQualityController-updateEnterpriseQuality)-修改企业资质, jsonEnterpriseQuality:{}", jsonEnterpriseQuality);
		EnterpriseQualityVo enterpriseQualityVo = JSONObject.toJavaObject(jsonEnterpriseQuality, EnterpriseQualityVo.class);

		//返回信息
		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(RetSafeConstants.RESULT, enterpriseQualityVo);
		logger.info("===step3:【修改企业资质】(EnterpriseQualityController-updateEnterpriseQuality)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

}