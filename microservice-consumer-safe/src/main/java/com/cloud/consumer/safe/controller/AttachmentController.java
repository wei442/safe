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
import com.cloud.consumer.safe.rest.request.AttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.AttachmentRequest;
import com.cloud.consumer.safe.rest.request.page.AttachmentPageRequest;
import com.cloud.consumer.safe.service.IAttachmentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.AttachmentVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 附件管理 AttachmentController
 * @author wei.yong
 * @ClassName: AttachmentController
 */
@Api(tags = "附件")
@RestController
@RequestMapping("/attachment")
public class AttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//附件 Service
	@Autowired
	private IAttachmentService attachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询附件列表")
	@RequestMapping(value="/getAttachmentListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getAttachmentListByPage(
		@RequestBody AttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(AttachmentController-getAttachmentListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonAttachment = attachmentService.getAttachmentListByPage(req);
		logger.info("===step2:【分页查询】(AttachmentController-getAttachmentListByPage)-分页查询附件列表, jsonAttachment:{}", jsonAttachment);
		String dataListStr = JSONObject.toJSONString(jsonAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonAttachment.getJSONObject(PageConstants.PAGE));
		List<AttachmentVo> attachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<AttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, attachmentVoList);
		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(AttachmentController-getAttachmentListByPage)-返回信息, attachmentResponse:{}", attachmentResponse);
	    return attachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询附件列表")
	@RequestMapping(value="/getAttachmentList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getAttachmentList(
		@RequestBody AttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(AttachmentController-getAttachmentList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonAttachment = attachmentService.getAttachmentListByPage(req);
		logger.info("===step2:【不分页查询】(AttachmentController-getAttachmentList)-不分页查询附件列表, jsonAttachment:{}", jsonAttachment);
		String dataListStr = JSONObject.toJSONString(jsonAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<AttachmentVo> attachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<AttachmentVo>>(){});

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(RetSafeConstants.RESULT, attachmentVoList);
		logger.info("===step3:【不分页查询】(AttachmentController-getAttachmentList)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 获取附件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取附件详情")
	@RequestMapping(value="/getAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getAttachment(
		@Validated @RequestBody AttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取附件】(AttachmentController-getAttachment)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer attachmentId = req.getAttachmentId();
		JSONObject jsonAttachment = attachmentService.getAttachmentById(attachmentId);
		logger.info("===step2:【获取附件】(AttachmentController-getAttachment)-根据attachmentId获取附件, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(RetSafeConstants.RESULT, attachmentVo);
	    logger.info("===step3:【获取附件】(AttachmentController-getAttachment)-返回信息, attachmentResponse:{}", attachmentResponse);
	    return attachmentResponse;
	}

	/**
	 * 新增附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增附件")
	@RequestMapping(value="/addAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addAttachment(
		@Validated @RequestBody AttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增附件】(AttachmentController-addAttachment)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonAttachment = attachmentService.addAttachment(req);
		logger.info("===step2:【新增附件】(AttachmentController-addAttachment)-分页查询附件列表, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(RetSafeConstants.RESULT, attachmentVo);
	    logger.info("===step3:【新增附件】(AttachmentController-addAttachment)-返回信息, attachmentResponse:{}", attachmentResponse);
	    return attachmentResponse;
	}

	/**
	 * 删除附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除附件")
	@RequestMapping(value="/deleteAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteAttachment(
		@Validated @RequestBody AttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除附件】(AttachmentController-deleteAttachment)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer attachmentId = req.getAttachmentId();
		JSONObject jsonAttachment = attachmentService.deleteAttachmentById(attachmentId);
		logger.info("===step2:【删除附件】(AttachmentController-deleteAttachment)-根据attachmentId删除附件, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(RetSafeConstants.RESULT, attachmentVo);
		logger.info("===step3:【删除附件】(AttachmentController-deleteAttachment)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 修改附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改附件")
	@RequestMapping(value="/updateAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateAttachment(
		@Validated({ UpdateGroup.class }) @RequestBody AttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改附件】(AttachmentController-updateAttachment)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonAttachment = attachmentService.addAttachment(req);
		logger.info("===step2:【修改附件】(AttachmentController-updateAttachment)-修改附件, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(RetSafeConstants.RESULT, attachmentVo);
		logger.info("===step3:【修改附件】(AttachmentController-updateAttachment)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

}