package com.cloud.provider.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.PageConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.ActivityComment;
import com.cloud.provider.safe.rest.request.activity.ActivityCommentRequest;
import com.cloud.provider.safe.rest.request.page.activity.ActivityCommentPageRequest;
import com.cloud.provider.safe.service.IActivityCommentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.activity.ActivityCommentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动评论 ActivityCommentController
 * @author wei.yong
 */
@Api(tags = "活动评论")
@RestController
@RequestMapping(value="/activity/comment")
public class ActivityCommentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//活动评论Service
	@Autowired
	private IActivityCommentService activityCommentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询活动评论列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody ActivityCommentPageRequest req) {
		logger.info("===step1:【分页查询活动评论列表】(ActivityCommentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<ActivityComment> list = activityCommentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询活动评论列表】(ActivityCommentController-selectListByPage)-分页查询活动评论列表, list.size:{}", list == null ? null : list.size());
		List<ActivityCommentVo> activityCommentVoList = new ActivityCommentVo().convertToActivityCommentVoList(list);

		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		activityCommentResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(activityCommentVoList));
		logger.info("===step3:【分页查询活动评论列表】(ActivityCommentController-selectListByPage)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询活动评论列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody ActivityCommentPageRequest req) {
		logger.info("===step1:【不分页查询活动评论列表】(ActivityCommentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<ActivityComment> list = activityCommentService.selectList(req);
		logger.info("===step2:【不分页查询活动评论列表】(ActivityCommentController-selectList)-不分页查询活动评论列表, list.size:{}", list == null ? null : list.size());
		List<ActivityCommentVo> activityCommentVoList = new ActivityCommentVo().convertToActivityCommentVoList(list);

		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		activityCommentResponse.put(PageConstants.DATA_LIST, activityCommentVoList);
		logger.info("===step3:【不分页查询活动评论列表】(ActivityCommentController-selectList)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 据id查询活动评论
	 * @param activityCommentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询活动评论")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer activityCommentId) {
		logger.info("===step1:【据id查询活动评论】(ActivityCommentController-selectById)-传入参数, activityCommentId:{}", activityCommentId);

		if(activityCommentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "activityCommentId不能为空");
		}

		ActivityComment activityComment = activityCommentService.selectById(activityCommentId);
		logger.info("===step2:【据id查询活动评论】(ActivityCommentController-selectById)-根据id查询活动评论, activityComment:{}", activityComment);
		ActivityCommentVo activityCommentVo = new ActivityCommentVo().convertToActivityCommentVo(activityComment);

		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		activityCommentResponse.putAll((JSONObject) JSONObject.toJSON(activityCommentVo));
		logger.info("===step3:【据id查询活动评论】(ActivityCommentController-selectById)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 添加活动评论
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加活动评论")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody ActivityCommentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加活动评论】(ActivityCommentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		ActivityComment activityComment = req.convertToActivityComment();
		int i = activityCommentService.insert(activityComment);
		logger.info("===step2:【添加活动评论】(ActivityCommentController-insert)-插入活动评论, i:{}", i);

		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加活动评论】(ActivityCommentController-insert)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 根据id删除活动评论
	 * @param activityCommentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除活动评论")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer activityCommentId) {
		logger.info("===step1:【根据id删除活动评论】(selectById-deleteById)-传入参数, activityCommentId:{}", activityCommentId);

		if(activityCommentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "activityCommentId不能为空");
		}

		int i = activityCommentService.deleteById(activityCommentId);
		logger.info("===step2:【根据id删除活动评论】(ActivityCommentController-deleteById)-根据id查询活动评论, i:{}", i);

		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除活动评论】(ActivityCommentController-deleteById)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

	/**
	 * 修改活动评论
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改活动评论")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody ActivityCommentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改活动评论】(ActivityCommentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityCommentId = req.getActivityCommentId();
		ActivityComment activityComment = req.convertToActivityComment();
		activityComment.setId(activityCommentId);
		int i = activityCommentService.modify(activityComment);
		logger.info("===step2:【修改活动评论】(ActivityCommentController-modify)-修改活动评论, i:{}", i);

		BaseRestMapResponse activityCommentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改活动评论】(ActivityCommentController-modify)-返回信息, activityCommentResponse:{}", activityCommentResponse);
		return activityCommentResponse;
	}

}