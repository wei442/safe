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
import com.cloud.consumer.safe.rest.request.page.risk.RiskAcceptPageRequest;
import com.cloud.consumer.safe.rest.request.risk.RiskAcceptIdRequest;
import com.cloud.consumer.safe.rest.request.risk.RiskAcceptRequest;
import com.cloud.consumer.safe.service.IRiskAcceptService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.risk.RiskAcceptVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险验收管理 RiskAcceptController
 * @author wei.yong
 * @ClassName: RiskAcceptController
 */
@Api(tags = "风险验收")
@RestController
@RequestMapping("/risk/accept")
public class RiskAcceptController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险验收 Service
	@Autowired
	private IRiskAcceptService riskAcceptService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险验收列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody RiskAcceptPageRequest req) {
		logger.info("===step1:【分页查询】(RiskAcceptController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskAccept = riskAcceptService.getListByPage(req);
		logger.info("===step2:【分页查询】(RiskAcceptController-getListByPage)-分页查询风险验收列表, jsonRiskAccept:{}", jsonRiskAccept);
		String dataListStr = JSONObject.toJSONString(jsonRiskAccept.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonRiskAccept.getJSONObject(PageConstants.PAGE));
		List<RiskAcceptVo> riskAcceptVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskAcceptVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, riskAcceptVoList);
		//返回信息
		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		riskAcceptResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(RiskAcceptController-getListByPage)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
	    return riskAcceptResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险验收列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody RiskAcceptPageRequest req) {
		logger.info("===step1:【不分页查询】(RiskAcceptController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskAccept = riskAcceptService.getList(req);
		logger.info("===step2:【不分页查询】(RiskAcceptController-getList)-不分页查询风险验收列表, jsonRiskAccept:{}", jsonRiskAccept);
		String dataListStr = JSONObject.toJSONString(jsonRiskAccept.getJSONArray(PageConstants.DATA_LIST));
		List<RiskAcceptVo> riskAcceptVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RiskAcceptVo>>(){});

		BaseResultVo result = new BaseResultVo(riskAcceptVoList);
		//返回信息
		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		riskAcceptResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(RiskAcceptController-getList)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 获取风险验收详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取风险验收详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody RiskAcceptIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取风险验收】(RiskAcceptController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskAcceptId = req.getRiskAcceptId();
		JSONObject jsonRiskAccept = riskAcceptService.getById(riskAcceptId);
		logger.info("===step2:【获取风险验收】(RiskAcceptController-getDetail)-根据riskAcceptId获取风险验收, jsonRiskAccept:{}", jsonRiskAccept);
		RiskAcceptVo riskAcceptVo = JSONObject.toJavaObject(jsonRiskAccept, RiskAcceptVo.class);

		//返回信息
		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		riskAcceptResponse.put(CommConstants.RESULT, riskAcceptVo);
	    logger.info("===step3:【获取风险验收】(RiskAcceptController-getDetail)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
	    return riskAcceptResponse;
	}

	/**
	 * 新增风险验收
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增风险验收")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody RiskAcceptRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增风险验收】(RiskAcceptController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskAccept = riskAcceptService.add(req);
		logger.info("===step2:【新增风险验收】(RiskAcceptController-add)-分页查询风险验收列表, jsonRiskAccept:{}", jsonRiskAccept);

		//返回信息
		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增风险验收】(RiskAcceptController-add)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
	    return riskAcceptResponse;
	}

	/**
	 * 删除风险验收
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除风险验收")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody RiskAcceptIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除风险验收】(RiskAcceptController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskAcceptId = req.getRiskAcceptId();
		JSONObject jsonRiskAccept = riskAcceptService.deleteById(riskAcceptId);
		logger.info("===step2:【删除风险验收】(RiskAcceptController-delete)-根据riskAcceptId删除风险验收, jsonRiskAccept:{}", jsonRiskAccept);

		//返回信息
		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除风险验收】(RiskAcceptController-delete)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 修改风险验收
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险验收")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody RiskAcceptRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险验收】(RiskAcceptController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRiskAccept = riskAcceptService.update(req);
		logger.info("===step2:【修改风险验收】(RiskAcceptController-update)-修改风险验收, jsonRiskAccept:{}", jsonRiskAccept);

		//返回信息
		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险验收】(RiskAcceptController-update)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

}