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
import com.cloud.consumer.safe.rest.request.page.risk.RiskPageRequest;
import com.cloud.consumer.safe.rest.request.risk.RiskIdRequest;
import com.cloud.consumer.safe.rest.request.risk.RiskRequest;
import com.cloud.consumer.safe.service.IRiskService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.risk.RiskVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险管理 RiskController
 * @author wei.yong
 * @ClassName: RiskController
 */
@Api(tags = "风险")
@RestController
@RequestMapping("/risk")
public class RiskController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险 Service
	@Autowired
	private IRiskService riskService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody RiskPageRequest req) {
		logger.info("===step1:【分页查询】(RiskController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRisk = riskService.getListByPage(req);
		logger.info("===step2:【分页查询】(RiskController-getListByPage)-分页查询风险列表, jsonRisk:{}", jsonRisk);
		String dataListStr = JSONObject.toJSONString(jsonRisk.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonRisk.getJSONObject(PageConstants.PAGE));
		List<RiskVo> riskVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, riskVoList);
		//返回信息
		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		riskResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(RiskController-getListByPage)-返回信息, riskResponse:{}", riskResponse);
	    return riskResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody RiskPageRequest req) {
		logger.info("===step1:【不分页查询】(RiskController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRisk = riskService.getList(req);
		logger.info("===step2:【不分页查询】(RiskController-getList)-不分页查询风险列表, jsonRisk:{}", jsonRisk);
		String dataListStr = JSONObject.toJSONString(jsonRisk.getJSONArray(PageConstants.DATA_LIST));
		List<RiskVo> riskVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskVo>>(){});

		BaseResultVo result = new BaseResultVo(riskVoList);
		//返回信息
		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		riskResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(RiskController-getList)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 获取风险详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取风险详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody RiskIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取风险】(RiskController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskId = req.getRiskId();
		JSONObject jsonRisk = riskService.getById(riskId);
		logger.info("===step2:【获取风险】(RiskController-getDetail)-根据riskId获取风险, jsonRisk:{}", jsonRisk);
		RiskVo riskVo = JSONObject.toJavaObject(jsonRisk, RiskVo.class);

		//返回信息
		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		riskResponse.put(CommConstants.RESULT, riskVo);
	    logger.info("===step3:【获取风险】(RiskController-getDetail)-返回信息, riskResponse:{}", riskResponse);
	    return riskResponse;
	}

	/**
	 * 新增风险
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增风险")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody RiskRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增风险】(RiskController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRisk = riskService.add(req);
		logger.info("===step2:【新增风险】(RiskController-add)-分页查询风险列表, jsonRisk:{}", jsonRisk);

		//返回信息
		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增风险】(RiskController-add)-返回信息, riskResponse:{}", riskResponse);
	    return riskResponse;
	}

	/**
	 * 删除风险
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除风险")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody RiskIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除风险】(RiskController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskId = req.getRiskId();
		JSONObject jsonRisk = riskService.deleteById(riskId);
		logger.info("===step2:【删除风险】(RiskController-delete)-根据riskId删除风险, jsonRisk:{}", jsonRisk);

		//返回信息
		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除风险】(RiskController-delete)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 修改风险
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody RiskRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险】(RiskController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRisk = riskService.update(req);
		logger.info("===step2:【修改风险】(RiskController-update)-修改风险, jsonRisk:{}", jsonRisk);

		//返回信息
		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险】(RiskController-update)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

}