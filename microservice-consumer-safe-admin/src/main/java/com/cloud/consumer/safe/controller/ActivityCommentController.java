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
import com.cloud.consumer.safe.rest.request.activity.ActivityCommentIdRequest;
import com.cloud.consumer.safe.rest.request.activity.ActivityCommentRequest;
import com.cloud.consumer.safe.rest.request.page.activity.ActivityCommentPageRequest;
import com.cloud.consumer.safe.service.IActivityCommentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.activity.ActivityCommentVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 安全活动评论管理 ActivityCommentController
 * @author wei.yong
 * @ClassName: ActivityCommentController
 */
@Api(tags = "安全活动评论")
@RestController
@RequestMapping("/activity/comment")
public class ActivityCommentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//安全活动评论 Service
	@Autowired
	private IActivityCommentService activityCommentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询安全活动评论列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody ActivityCommentPageRequest req) {
		logger.info("===step1:【分页查询】(ActivityCommentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonActivityComment = activityCommentService.getListByPage(req);
		logger.info("===step2:【分页查询】(ActivityCommentController-getListByPage)-分页查询安全活动评论列表, jsonActivityComment:{}", jsonActivityComment);
		String dataListStr = JSONObject.toJSONString(jsonActivityComment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonActivityComment.getJSONObject(PageConstants.PAGE));
		List<ActivityCommentVo> activityCommentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<ActivityCommentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, activityCommentVoList);
		//返回信息
		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		activityCommentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(ActivityCommentController-getListByPage)-返回信息, activityCommentResponse:{}", activityCommentResponse);
	    return activityCommentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询安全活动评论列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody ActivityCommentPageRequest req) {
		logger.info("===step1:【不分页查询】(ActivityCommentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonActivityComment = activityCommentService.getList(req);
		logger.info("===step2:【不分页查询】(ActivityCommentController-getList)-不分页查询安全活动评论列表, jsonActivityComment:{}", jsonActivityComment);
		String dataListStr = JSONObject.toJSONString(jsonActivityComment.getJSONArray(PageConstants.DATA_LIST));
		List<ActivityCommentVo> activityCommentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<ActivityCommentVo>>(){});

		BaseResultVo result = new BaseResultVo(activityCommentVoList);
		//返回信息
		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		activityCommentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(ActivityCommentController-getList)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 获取安全活动评论详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取安全活动评论详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody ActivityCommentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取安全活动评论】(ActivityCommentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityCommentId = req.getActivityCommentId();
		JSONObject jsonActivityComment = activityCommentService.getById(activityCommentId);
		logger.info("===step2:【获取安全活动评论】(ActivityCommentController-getDetail)-根据activityCommentId获取安全活动评论, jsonActivityComment:{}", jsonActivityComment);
		ActivityCommentVo activityCommentVo = JSONObject.toJavaObject(jsonActivityComment, ActivityCommentVo.class);

		//返回信息
		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		activityCommentResponse.put(CommConstants.RESULT, activityCommentVo);
	    logger.info("===step3:【获取安全活动评论】(ActivityCommentController-getDetail)-返回信息, activityCommentResponse:{}", activityCommentResponse);
	    return activityCommentResponse;
	}

	/**
	 * 新增安全活动评论
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增安全活动评论")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody ActivityCommentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增安全活动评论】(ActivityCommentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonActivityComment = activityCommentService.add(req);
		logger.info("===step2:【新增安全活动评论】(ActivityCommentController-add)-分页查询安全活动评论列表, jsonActivityComment:{}", jsonActivityComment);

		//返回信息
		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增安全活动评论】(ActivityCommentController-add)-返回信息, activityCommentResponse:{}", activityCommentResponse);
	    return activityCommentResponse;
	}

	/**
	 * 删除安全活动评论
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除安全活动评论")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody ActivityCommentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除安全活动评论】(ActivityCommentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityCommentId = req.getActivityCommentId();
		JSONObject jsonActivityComment = activityCommentService.deleteById(activityCommentId);
		logger.info("===step2:【删除安全活动评论】(ActivityCommentController-delete)-根据activityCommentId删除安全活动评论, jsonActivityComment:{}", jsonActivityComment);

		//返回信息
		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除安全活动评论】(ActivityCommentController-delete)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 修改安全活动评论
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改安全活动评论")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody ActivityCommentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改安全活动评论】(ActivityCommentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonActivityComment = activityCommentService.update(req);
		logger.info("===step2:【修改安全活动评论】(ActivityCommentController-update)-修改安全活动评论, jsonActivityComment:{}", jsonActivityComment);

		//返回信息
		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改安全活动评论】(ActivityCommentController-update)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

}