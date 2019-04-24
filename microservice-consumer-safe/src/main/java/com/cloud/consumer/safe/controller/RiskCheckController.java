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
import com.cloud.consumer.safe.rest.request.dict.RiskCheckIdRequest;
import com.cloud.consumer.safe.rest.request.dict.RiskCheckRequest;
import com.cloud.consumer.safe.rest.request.page.dict.RiskCheckPageRequest;
import com.cloud.consumer.safe.service.IRiskCheckService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.dict.RiskCheckVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项管理 RiskCheckController
 * @author wei.yong
 * @ClassName: RiskCheckController
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping("/risk/check")
public class RiskCheckController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典子项 Service
	@Autowired
	private IRiskCheckService riskCheckService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典子项列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody RiskCheckPageRequest req) {
		logger.info("===step1:【分页查询】(RiskCheckController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskCheck = riskCheckService.getListByPage(req);
		logger.info("===step2:【分页查询】(RiskCheckController-getListByPage)-分页查询字典子项列表, jsonRiskCheck:{}", jsonRiskCheck);
		String dataListStr = JSONObject.toJSONString(jsonRiskCheck.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonRiskCheck.getJSONObject(PageConstants.PAGE));
		List<RiskCheckVo> riskCheckVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskCheckVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, riskCheckVoList);
		//返回信息
		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		riskCheckResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(RiskCheckController-getListByPage)-返回信息, riskCheckResponse:{}", riskCheckResponse);
	    return riskCheckResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典子项列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody RiskCheckPageRequest req) {
		logger.info("===step1:【不分页查询】(RiskCheckController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskCheck = riskCheckService.getList(req);
		logger.info("===step2:【不分页查询】(RiskCheckController-getList)-不分页查询字典子项列表, jsonRiskCheck:{}", jsonRiskCheck);
		String dataListStr = JSONObject.toJSONString(jsonRiskCheck.getJSONArray(PageConstants.DATA_LIST));
		List<RiskCheckVo> riskCheckVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskCheckVo>>(){});

		BaseResultVo result = new BaseResultVo(riskCheckVoList);
		//返回信息
		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		riskCheckResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(RiskCheckController-getList)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 获取字典子项详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取字典子项详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody RiskCheckIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典子项】(RiskCheckController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskCheckId = req.getRiskCheckId();
		JSONObject jsonRiskCheck = riskCheckService.getById(riskCheckId);
		logger.info("===step2:【获取字典子项】(RiskCheckController-getDetail)-根据riskCheckId获取字典子项, jsonRiskCheck:{}", jsonRiskCheck);
		RiskCheckVo riskCheckVo = JSONObject.toJavaObject(jsonRiskCheck, RiskCheckVo.class);

		//返回信息
		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		riskCheckResponse.put(CommConstants.RESULT, riskCheckVo);
	    logger.info("===step3:【获取字典子项】(RiskCheckController-getDetail)-返回信息, riskCheckResponse:{}", riskCheckResponse);
	    return riskCheckResponse;
	}

	/**
	 * 新增字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增字典子项")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody RiskCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典子项】(RiskCheckController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskCheck = riskCheckService.add(req);
		logger.info("===step2:【新增字典子项】(RiskCheckController-add)-分页查询字典子项列表, jsonRiskCheck:{}", jsonRiskCheck);

		//返回信息
		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增字典子项】(RiskCheckController-add)-返回信息, riskCheckResponse:{}", riskCheckResponse);
	    return riskCheckResponse;
	}

	/**
	 * 删除字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除字典子项")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody RiskCheckIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典子项】(RiskCheckController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskCheckId = req.getRiskCheckId();
		JSONObject jsonRiskCheck = riskCheckService.deleteById(riskCheckId);
		logger.info("===step2:【删除字典子项】(RiskCheckController-delete)-根据riskCheckId删除字典子项, jsonRiskCheck:{}", jsonRiskCheck);

		//返回信息
		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除字典子项】(RiskCheckController-delete)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 修改字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典子项")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody RiskCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(RiskCheckController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskCheck = riskCheckService.update(req);
		logger.info("===step2:【修改字典子项】(RiskCheckController-update)-修改字典子项, jsonRiskCheck:{}", jsonRiskCheck);

		//返回信息
		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(RiskCheckController-update)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

}