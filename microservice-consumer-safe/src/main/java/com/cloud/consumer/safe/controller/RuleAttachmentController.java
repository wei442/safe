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
import com.cloud.consumer.safe.rest.request.activity.RuleAttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.activity.RuleAttachmentRequest;
import com.cloud.consumer.safe.rest.request.page.activity.RuleAttachmentPageRequest;
import com.cloud.consumer.safe.service.IRuleAttachmentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.activity.RuleAttachmentVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 规范文件附件 RuleAttachmentController
 * @author wei.yong
 * @ClassName: RuleAttachmentController
 */
@Api(tags = "规范文件附件")
@RestController
@RequestMapping("/rule/attachment")
public class RuleAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//规范文件附件 Service
	@Autowired
	private IRuleAttachmentService ruleAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询规范文件附件列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody RuleAttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(RuleAttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonRuleAttachment = ruleAttachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(RuleAttachmentController-getListByPage)-分页查询规范文件附件列表, jsonRuleAttachment:{}", jsonRuleAttachment);
		String dataListStr = JSONObject.toJSONString(jsonRuleAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonRuleAttachment.getJSONObject(PageConstants.PAGE));
		List<RuleAttachmentVo> ruleAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RuleAttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, ruleAttachmentVoList);
		//返回信息
		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		ruleAttachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(RuleAttachmentController-getListByPage)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
	    return ruleAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询规范文件附件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody RuleAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(RuleAttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonRuleAttachment = ruleAttachmentService.getList(req);
		logger.info("===step2:【不分页查询】(RuleAttachmentController-getList)-不分页查询规范文件附件列表, jsonRuleAttachment:{}", jsonRuleAttachment);
		String dataListStr = JSONObject.toJSONString(jsonRuleAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<RuleAttachmentVo> ruleAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RuleAttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(ruleAttachmentVoList);
		//返回信息
		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		ruleAttachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(RuleAttachmentController-getList)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 获取规范文件附件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取规范文件附件详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody RuleAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取规范文件附件】(RuleAttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer ruleAttachmentId = req.getRuleAttachmentId();
		JSONObject jsonRuleAttachment = ruleAttachmentService.getById(ruleAttachmentId);
		logger.info("===step2:【获取规范文件附件】(RuleAttachmentController-getDetail)-根据ruleAttachmentId获取规范文件附件, jsonRuleAttachment:{}", jsonRuleAttachment);
		RuleAttachmentVo ruleAttachmentVo = JSONObject.toJavaObject(jsonRuleAttachment, RuleAttachmentVo.class);

		//返回信息
		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		ruleAttachmentResponse.put(CommConstants.RESULT, ruleAttachmentVo);
	    logger.info("===step3:【获取规范文件附件】(RuleAttachmentController-getDetail)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
	    return ruleAttachmentResponse;
	}

	/**
	 * 新增规范文件附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增规范文件附件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody RuleAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增规范文件附件】(RuleAttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRuleAttachment = ruleAttachmentService.add(req);
		logger.info("===step2:【新增规范文件附件】(RuleAttachmentController-add)-分页查询规范文件附件列表, jsonRuleAttachment:{}", jsonRuleAttachment);

		//返回信息
		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增规范文件附件】(RuleAttachmentController-add)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
	    return ruleAttachmentResponse;
	}

	/**
	 * 删除规范文件附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除规范文件附件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody RuleAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除规范文件附件】(RuleAttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer ruleAttachmentId = req.getRuleAttachmentId();
		JSONObject jsonRuleAttachment = ruleAttachmentService.deleteById(ruleAttachmentId);
		logger.info("===step2:【删除规范文件附件】(RuleAttachmentController-delete)-根据ruleAttachmentId删除规范文件附件, jsonRuleAttachment:{}", jsonRuleAttachment);

		//返回信息
		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除规范文件附件】(RuleAttachmentController-delete)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 修改规范文件附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改规范文件附件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody RuleAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改规范文件附件】(RuleAttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonRuleAttachment = ruleAttachmentService.update(req);
		logger.info("===step2:【修改规范文件附件】(RuleAttachmentController-update)-修改规范文件附件, jsonRuleAttachment:{}", jsonRuleAttachment);

		//返回信息
		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改规范文件附件】(RuleAttachmentController-update)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

}