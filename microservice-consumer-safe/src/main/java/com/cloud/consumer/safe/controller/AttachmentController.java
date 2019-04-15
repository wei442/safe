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
import com.cloud.consumer.safe.rest.request.AttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.AttachmentRequest;
import com.cloud.consumer.safe.rest.request.page.AttachmentPageRequest;
import com.cloud.consumer.safe.service.IAttachmentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.AttachmentVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

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
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody AttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(AttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonAttachment = attachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(AttachmentController-getListByPage)-分页查询附件列表, jsonAttachment:{}", jsonAttachment);
		String dataListStr = JSONObject.toJSONString(jsonAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonAttachment.getJSONObject(PageConstants.PAGE));
		List<AttachmentVo> attachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<AttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, attachmentVoList);
		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(AttachmentController-getListByPage)-返回信息, attachmentResponse:{}", attachmentResponse);
	    return attachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询附件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody AttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(AttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonAttachment = attachmentService.getListByPage(req);
		logger.info("===step2:【不分页查询】(AttachmentController-getList)-不分页查询附件列表, jsonAttachment:{}", jsonAttachment);
		String dataListStr = JSONObject.toJSONString(jsonAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<AttachmentVo> attachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<AttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(attachmentVoList);
		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(AttachmentController-getList)-返回信息, attachmentResponse:{}", attachmentResponse);
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
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody AttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取附件】(AttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer attachmentId = req.getAttachmentId();
		JSONObject jsonAttachment = attachmentService.getById(attachmentId);
		logger.info("===step2:【获取附件】(AttachmentController-getDetail)-根据attachmentId获取附件, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(CommConstants.RESULT, attachmentVo);
	    logger.info("===step3:【获取附件】(AttachmentController-getDetail)-返回信息, attachmentResponse:{}", attachmentResponse);
	    return attachmentResponse;
	}

	/**
	 * 新增附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增附件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody AttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增附件】(AttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonAttachment = attachmentService.add(req);
		logger.info("===step2:【新增附件】(AttachmentController-add)-分页查询附件列表, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(CommConstants.RESULT, attachmentVo);
	    logger.info("===step3:【新增附件】(AttachmentController-add)-返回信息, attachmentResponse:{}", attachmentResponse);
	    return attachmentResponse;
	}

	/**
	 * 删除附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除附件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody AttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除附件】(AttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer attachmentId = req.getAttachmentId();
		JSONObject jsonAttachment = attachmentService.deleteById(attachmentId);
		logger.info("===step2:【删除附件】(AttachmentController-delete)-根据attachmentId删除附件, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(CommConstants.RESULT, attachmentVo);
		logger.info("===step3:【删除附件】(AttachmentController-delete)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 修改附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改附件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody AttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改附件】(AttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonAttachment = attachmentService.update(req);
		logger.info("===step2:【修改附件】(AttachmentController-update)-修改附件, jsonAttachment:{}", jsonAttachment);
		AttachmentVo attachmentVo = JSONObject.toJavaObject(jsonAttachment, AttachmentVo.class);

		//返回信息
		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(CommConstants.RESULT, attachmentVo);
		logger.info("===step3:【修改附件】(AttachmentController-update)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

}