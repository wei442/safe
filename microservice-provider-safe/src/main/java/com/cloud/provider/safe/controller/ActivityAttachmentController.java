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
import com.cloud.provider.safe.po.ActivityAttachment;
import com.cloud.provider.safe.rest.request.activity.ActivityAttachmentRequest;
import com.cloud.provider.safe.rest.request.page.activity.ActivityAttachmentPageRequest;
import com.cloud.provider.safe.service.IActivityAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.activity.ActivityAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动附件 ActivityAttachmentController
 * @author wei.yong
 */
@Api(tags = "活动附件")
@RestController
@RequestMapping(value="/activity/attachment")
public class ActivityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//活动附件Service
	@Autowired
	private IActivityAttachmentService activityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询活动附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody ActivityAttachmentPageRequest req) {
		logger.info("===step1:【分页查询活动附件列表】(ActivityAttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<ActivityAttachment> list = activityAttachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询活动附件列表】(ActivityAttachmentController-selectListByPage)-分页查询活动附件列表, list.size:{}", list == null ? null : list.size());
		List<ActivityAttachmentVo> dataList = new ActivityAttachmentVo().convertToActivityAttachmentVoList(list);

		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		activityAttachmentResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		activityAttachmentResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询活动附件列表】(ActivityAttachmentController-selectListByPage)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询活动附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody ActivityAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询活动附件列表】(ActivityAttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<ActivityAttachment> list = activityAttachmentService.selectList(req);
		logger.info("===step2:【不分页查询活动附件列表】(ActivityAttachmentController-selectList)-不分页查询活动附件列表, list.size:{}", list == null ? null : list.size());
		List<ActivityAttachmentVo> dataList = new ActivityAttachmentVo().convertToActivityAttachmentVoList(list);

		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		activityAttachmentResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询活动附件列表】(ActivityAttachmentController-selectList)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 据id查询活动附件
	 * @param activityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询活动附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer activityAttachmentId) {
		logger.info("===step1:【据id查询活动附件】(ActivityAttachmentController-selectById)-传入参数, activityAttachmentId:{}", activityAttachmentId);

		if(activityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "activityAttachmentId不能为空");
		}

		ActivityAttachment activityAttachment = activityAttachmentService.selectById(activityAttachmentId);
		logger.info("===step2:【据id查询活动附件】(ActivityAttachmentController-selectById)-根据id查询活动附件, activityAttachment:{}", activityAttachment);
		ActivityAttachmentVo activityAttachmentVo = new ActivityAttachmentVo().convertToActivityAttachmentVo(activityAttachment);

		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		activityAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(activityAttachmentVo));
		logger.info("===step3:【据id查询活动附件】(ActivityAttachmentController-selectById)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 添加活动附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加活动附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody ActivityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加活动附件】(ActivityAttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		ActivityAttachment activityAttachment = req.convertToActivityAttachment();
		int i = activityAttachmentService.insert(activityAttachment);
		logger.info("===step2:【添加活动附件】(ActivityAttachmentController-insert)-插入活动附件, i:{}", i);

		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加活动附件】(ActivityAttachmentController-insert)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 根据id删除活动附件
	 * @param activityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除活动附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer activityAttachmentId) {
		logger.info("===step1:【根据id删除活动附件】(selectById-deleteById)-传入参数, activityAttachmentId:{}", activityAttachmentId);

		if(activityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "activityAttachmentId不能为空");
		}

		int i = activityAttachmentService.deleteById(activityAttachmentId);
		logger.info("===step2:【根据id删除活动附件】(ActivityAttachmentController-deleteById)-根据id查询活动附件, i:{}", i);

		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除活动附件】(ActivityAttachmentController-deleteById)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

	/**
	 * 修改活动附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改活动附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody ActivityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改活动附件】(ActivityAttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityAttachmentId = req.getActivityAttachmentId();
		ActivityAttachment activityAttachment = req.convertToActivityAttachment();
		activityAttachment.setId(activityAttachmentId);
		int i = activityAttachmentService.modify(activityAttachment);
		logger.info("===step2:【修改活动附件】(ActivityAttachmentController-modify)-修改活动附件, i:{}", i);

		BaseRestMapResponse activityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改活动附件】(ActivityAttachmentController-modify)-返回信息, activityAttachmentResponse:{}", activityAttachmentResponse);
		return activityAttachmentResponse;
	}

}