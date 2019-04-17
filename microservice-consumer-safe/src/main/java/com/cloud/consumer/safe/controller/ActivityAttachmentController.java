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
import com.cloud.consumer.safe.rest.request.activity.ActivityAttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.activity.ActivityAttachmentRequest;
import com.cloud.consumer.safe.rest.request.page.activity.ActivityAttachmentPageRequest;
import com.cloud.consumer.safe.service.IActivityAttachmentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.activity.ActivityAttachmentVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 安全活动附件管理 ActivityAttachmentController
 * @author wei.yong
 * @ClassName: ActivityAttachmentController
 */
@Api(tags = "安全活动附件")
@RestController
@RequestMapping("/activity/attachment")
public class ActivityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//安全活动附件 Service
	@Autowired
	private IActivityAttachmentService activityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询安全活动附件列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody ActivityAttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(ActivityAttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonActivityAttachment = activityAttachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(ActivityAttachmentController-getListByPage)-分页查询安全活动附件列表, jsonActivityAttachment:{}", jsonActivityAttachment);
		String dataListStr = JSONObject.toJSONString(jsonActivityAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonActivityAttachment.getJSONObject(PageConstants.PAGE));
		List<ActivityAttachmentVo> activityAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<ActivityAttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, activityAttachmentVoList);
		//返回信息
		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		activityAttachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(ActivityAttachmentController-getListByPage)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
	    return activityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询安全活动附件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody ActivityAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(ActivityAttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonActivityAttachment = activityAttachmentService.getList(req);
		logger.info("===step2:【不分页查询】(ActivityAttachmentController-getList)-不分页查询安全活动附件列表, jsonActivityAttachment:{}", jsonActivityAttachment);
		String dataListStr = JSONObject.toJSONString(jsonActivityAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<ActivityAttachmentVo> activityAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<ActivityAttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(activityAttachmentVoList);
		//返回信息
		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		activityAttachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(ActivityAttachmentController-getList)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 获取安全活动附件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取安全活动附件详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody ActivityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取安全活动附件】(ActivityAttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityAttachmentId = req.getActivityAttachmentId();
		JSONObject jsonActivityAttachment = activityAttachmentService.getById(activityAttachmentId);
		logger.info("===step2:【获取安全活动附件】(ActivityAttachmentController-getDetail)-根据activityAttachmentId获取安全活动附件, jsonActivityAttachment:{}", jsonActivityAttachment);
		ActivityAttachmentVo activityAttachmentVo = JSONObject.toJavaObject(jsonActivityAttachment, ActivityAttachmentVo.class);

		//返回信息
		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		activityAttachmentResponse.put(CommConstants.RESULT, activityAttachmentVo);
	    logger.info("===step3:【获取安全活动附件】(ActivityAttachmentController-getDetail)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
	    return activityAttachmentResponse;
	}

	/**
	 * 新增安全活动附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增安全活动附件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody ActivityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增安全活动附件】(ActivityAttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonActivityAttachment = activityAttachmentService.add(req);
		logger.info("===step2:【新增安全活动附件】(ActivityAttachmentController-add)-分页查询安全活动附件列表, jsonActivityAttachment:{}", jsonActivityAttachment);

		//返回信息
		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增安全活动附件】(ActivityAttachmentController-add)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
	    return activityAttachmentResponse;
	}

	/**
	 * 删除安全活动附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除安全活动附件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody ActivityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除安全活动附件】(ActivityAttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityAttachmentId = req.getActivityAttachmentId();
		JSONObject jsonActivityAttachment = activityAttachmentService.deleteById(activityAttachmentId);
		logger.info("===step2:【删除安全活动附件】(ActivityAttachmentController-delete)-根据activityAttachmentId删除安全活动附件, jsonActivityAttachment:{}", jsonActivityAttachment);

		//返回信息
		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除安全活动附件】(ActivityAttachmentController-delete)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 修改安全活动附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改安全活动附件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody ActivityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改安全活动附件】(ActivityAttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonActivityAttachment = activityAttachmentService.update(req);
		logger.info("===step2:【修改安全活动附件】(ActivityAttachmentController-update)-修改安全活动附件, jsonActivityAttachment:{}", jsonActivityAttachment);

		//返回信息
		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改安全活动附件】(ActivityAttachmentController-update)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

}