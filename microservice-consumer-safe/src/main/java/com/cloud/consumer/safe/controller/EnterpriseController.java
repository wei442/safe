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
import com.cloud.consumer.safe.rest.request.EnterpriseIdRequest;
import com.cloud.consumer.safe.rest.request.EnterpriseRequest;
import com.cloud.consumer.safe.rest.request.page.EnterprisePageRequest;
import com.cloud.consumer.safe.service.IEnterpriseService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.EnterpriseVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 企业管理 EnterpriseController
 * @author wei.yong
 * @ClassName: EnterpriseController
 */
@Api(tags = "企业")
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//企业 Service
	@Autowired
	private IEnterpriseService enterpriseService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询企业列表")
	@RequestMapping(value="/getEnterpriseListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getEnterpriseListByPage(
		@RequestBody EnterprisePageRequest req) {
		logger.info("===step1:【分页查询】(EnterpriseController-getEnterpriseListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonEnterprise = enterpriseService.getEnterpriseListByPage(req);
		logger.info("===step2:【分页查询】(EnterpriseController-getEnterpriseListByPage)-分页查询企业列表, jsonEnterprise:{}", jsonEnterprise);
		String dataListStr = JSONObject.toJSONString(jsonEnterprise.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonEnterprise.getJSONObject(PageConstants.PAGE));
		List<EnterpriseVo> enterpriseVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<EnterpriseVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, enterpriseVoList);
		//返回信息
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(EnterpriseController-getEnterpriseListByPage)-返回信息, enterpriseResponse:{}", enterpriseResponse);
	    return enterpriseResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询企业列表")
	@RequestMapping(value="/getEnterpriseList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getEnterpriseList(
		@RequestBody EnterprisePageRequest req) {
		logger.info("===step1:【不分页查询】(EnterpriseController-getEnterpriseList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonEnterprise = enterpriseService.getEnterpriseListByPage(req);
		logger.info("===step2:【不分页查询】(EnterpriseController-getEnterpriseList)-不分页查询企业列表, jsonEnterprise:{}", jsonEnterprise);
		String dataListStr = JSONObject.toJSONString(jsonEnterprise.getJSONArray(PageConstants.DATA_LIST));
		List<EnterpriseVo> enterpriseVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<EnterpriseVo>>(){});

		//返回信息
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, enterpriseVoList);
		logger.info("===step3:【不分页查询】(EnterpriseController-getEnterpriseList)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 获取企业详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取企业详情")
	@RequestMapping(value="/getEnterprise",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getEnterprise(
		@RequestBody EnterpriseIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取企业】(EnterpriseController-getEnterprise)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer enterpriseId = req.getEnterpriseId();
		JSONObject jsonEnterprise = enterpriseService.getEnterpriseById(enterpriseId);
		logger.info("===step2:【获取企业】(EnterpriseController-getEnterprise)-根据enterpriseId获取企业, jsonEnterprise:{}", jsonEnterprise);
		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonEnterprise, EnterpriseVo.class);

		//返回信息
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, enterpriseVo);
	    logger.info("===step3:【获取企业】(EnterpriseController-getEnterprise)-返回信息, enterpriseResponse:{}", enterpriseResponse);
	    return enterpriseResponse;
	}

	/**
	 * 新增企业
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增企业")
	@RequestMapping(value="/addEnterprise",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addEnterprise(
		@Validated @RequestBody EnterpriseRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增企业】(EnterpriseController-addEnterprise)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonEnterprise = enterpriseService.addEnterprise(req);
		logger.info("===step2:【新增企业】(EnterpriseController-addEnterprise)-分页查询企业列表, jsonEnterprise:{}", jsonEnterprise);
		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonEnterprise, EnterpriseVo.class);

		//返回信息
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, enterpriseVo);
	    logger.info("===step3:【新增企业】(EnterpriseController-addEnterprise)-返回信息, enterpriseResponse:{}", enterpriseResponse);
	    return enterpriseResponse;
	}

	/**
	 * 删除企业
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除企业")
	@RequestMapping(value="/deleteEnterprise",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteEnterprise(
		@RequestBody EnterpriseIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除企业】(EnterpriseController-deleteEnterprise)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer enterpriseId = req.getEnterpriseId();
		JSONObject jsonEnterprise = enterpriseService.deleteEnterpriseById(enterpriseId);
		logger.info("===step2:【删除企业】(EnterpriseController-deleteEnterprise)-根据enterpriseId删除企业, jsonEnterprise:{}", jsonEnterprise);
		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonEnterprise, EnterpriseVo.class);

		//返回信息
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, enterpriseVo);
		logger.info("===step3:【删除企业】(EnterpriseController-deleteEnterprise)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 修改企业
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改企业")
	@RequestMapping(value="/updateEnterprise",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateEnterprise(
		@Validated({ UpdateGroup.class }) @RequestBody EnterpriseRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改企业】(EnterpriseController-updateEnterprise)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonEnterprise = enterpriseService.addEnterprise(req);
		logger.info("===step2:【修改企业】(EnterpriseController-updateEnterprise)-修改企业, jsonEnterprise:{}", jsonEnterprise);
		EnterpriseVo enterpriseVo = JSONObject.toJavaObject(jsonEnterprise, EnterpriseVo.class);

		//返回信息
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, enterpriseVo);
		logger.info("===step3:【修改企业】(EnterpriseController-updateEnterprise)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

}