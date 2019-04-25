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
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.page.risk.RiskDutyPageRequest;
import com.cloud.consumer.safe.rest.request.risk.RiskDutyIdRequest;
import com.cloud.consumer.safe.rest.request.risk.RiskDutyRequest;
import com.cloud.consumer.safe.service.IRiskDutyService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.risk.RiskDutyVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险责任管理 RiskDutyController
 * @author wei.yong
 * @ClassName: RiskDutyController
 */
@Api(tags = "风险责任")
@RestController
@RequestMapping("/risk/duty")
public class RiskDutyController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险责任 Service
	@Autowired
	private IRiskDutyService riskDutyService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险责任列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody RiskDutyPageRequest req) {
		logger.info("===step1:【分页查询】(RiskDutyController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskDuty = riskDutyService.getListByPage(req);
		logger.info("===step2:【分页查询】(RiskDutyController-getListByPage)-分页查询风险责任列表, jsonRiskDuty:{}", jsonRiskDuty);
		String dataListStr = JSONObject.toJSONString(jsonRiskDuty.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonRiskDuty.getJSONObject(PageConstants.PAGE));
		List<RiskDutyVo> riskDutyVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskDutyVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, riskDutyVoList);
		//返回信息
		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		riskDutyResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(RiskDutyController-getListByPage)-返回信息, riskDutyResponse:{}", riskDutyResponse);
	    return riskDutyResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险责任列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody RiskDutyPageRequest req) {
		logger.info("===step1:【不分页查询】(RiskDutyController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskDuty = riskDutyService.getList(req);
		logger.info("===step2:【不分页查询】(RiskDutyController-getList)-不分页查询风险责任列表, jsonRiskDuty:{}", jsonRiskDuty);
		String dataListStr = JSONObject.toJSONString(jsonRiskDuty.getJSONArray(PageConstants.DATA_LIST));
		List<RiskDutyVo> riskDutyVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskDutyVo>>(){});

		BaseResultVo result = new BaseResultVo(riskDutyVoList);
		//返回信息
		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		riskDutyResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(RiskDutyController-getList)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 获取风险责任详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取风险责任详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody RiskDutyIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取风险责任】(RiskDutyController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskDutyId = req.getRiskDutyId();
		JSONObject jsonRiskDuty = riskDutyService.getById(riskDutyId);
		logger.info("===step2:【获取风险责任】(RiskDutyController-getDetail)-根据riskDutyId获取风险责任, jsonRiskDuty:{}", jsonRiskDuty);
		RiskDutyVo riskDutyVo = JSONObject.toJavaObject(jsonRiskDuty, RiskDutyVo.class);

		//返回信息
		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		riskDutyResponse.put(CommConstants.RESULT, riskDutyVo);
	    logger.info("===step3:【获取风险责任】(RiskDutyController-getDetail)-返回信息, riskDutyResponse:{}", riskDutyResponse);
	    return riskDutyResponse;
	}

	/**
	 * 新增风险责任
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增风险责任")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody RiskDutyRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增风险责任】(RiskDutyController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskDuty = riskDutyService.add(req);
		logger.info("===step2:【新增风险责任】(RiskDutyController-add)-分页查询风险责任列表, jsonRiskDuty:{}", jsonRiskDuty);

		//返回信息
		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增风险责任】(RiskDutyController-add)-返回信息, riskDutyResponse:{}", riskDutyResponse);
	    return riskDutyResponse;
	}

	/**
	 * 删除风险责任
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除风险责任")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody RiskDutyIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除风险责任】(RiskDutyController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskDutyId = req.getRiskDutyId();
		JSONObject jsonRiskDuty = riskDutyService.deleteById(riskDutyId);
		logger.info("===step2:【删除风险责任】(RiskDutyController-delete)-根据riskDutyId删除风险责任, jsonRiskDuty:{}", jsonRiskDuty);

		//返回信息
		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除风险责任】(RiskDutyController-delete)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 修改风险责任
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险责任")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody RiskDutyRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险责任】(RiskDutyController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskDuty = riskDutyService.update(req);
		logger.info("===step2:【修改风险责任】(RiskDutyController-update)-修改风险责任, jsonRiskDuty:{}", jsonRiskDuty);

		//返回信息
		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险责任】(RiskDutyController-update)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

}