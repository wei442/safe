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
import com.cloud.provider.safe.po.Activity;
import com.cloud.provider.safe.rest.request.activity.ActivityRequest;
import com.cloud.provider.safe.rest.request.page.activity.ActivityPageRequest;
import com.cloud.provider.safe.service.IActivityService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.activity.ActivityVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动 ActivityController
 * @author wei.yong
 */
@Api(tags = "活动")
@RestController
@RequestMapping(value="/activity/")
public class ActivityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//活动Service
	@Autowired
	private IActivityService activityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询活动列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody ActivityPageRequest req) {
		logger.info("===step1:【分页查询活动列表】(ActivityController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Activity> list = activityService.selectListByPage(page, req);
		logger.info("===step2:【分页查询活动列表】(ActivityController-selectListByPage)-分页查询活动列表, list.size:{}", list == null ? null : list.size());
		List<ActivityVo> activityVoList = new ActivityVo().convertToActivityVoList(list);

		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(activityVoList));
		logger.info("===step3:【分页查询活动列表】(ActivityController-selectListByPage)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询活动列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody ActivityPageRequest req) {
		logger.info("===step1:【不分页查询活动列表】(ActivityController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Activity> list = activityService.selectList(req);
		logger.info("===step2:【不分页查询活动列表】(ActivityController-selectList)-不分页查询活动列表, list.size:{}", list == null ? null : list.size());
		List<ActivityVo> activityVoList = new ActivityVo().convertToActivityVoList(list);

		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(PageConstants.DATA_LIST, activityVoList);
		logger.info("===step3:【不分页查询活动列表】(ActivityController-selectList)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 据id查询活动
	 * @param activityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询活动")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer activityId) {
		logger.info("===step1:【据id查询活动】(selectById-selectById)-传入参数, activityId:{}", activityId);

		if(activityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "activityId不能为空");
		}

		Activity activity = activityService.selectById(activityId);
		logger.info("===step2:【据id查询活动】(ActivityController-selectById)-根据id查询活动, activity:{}", activity);
		ActivityVo activityVo = new ActivityVo().convertToActivityVo(activity);

		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.putAll((JSONObject) JSONObject.toJSON(activityVo));
		logger.info("===step3:【据id查询活动】(ActivityController-selectById)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 添加活动
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加活动")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody ActivityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加活动】(ActivityController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Activity activity = req.convertToActivity();
		int i = activityService.insert(activity);
		logger.info("===step2:【添加活动】(ActivityController-insert)-插入活动, i:{}", i);

		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加活动】(ActivityController-insert)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 根据id删除活动
	 * @param activityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除活动")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer activityId) {
		logger.info("===step1:【根据id删除活动】(selectById-deleteById)-传入参数, activityId:{}", activityId);

		if(activityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "activityId不能为空");
		}

		int i = activityService.deleteById(activityId);
		logger.info("===step2:【根据id删除活动】(ActivityController-deleteById)-根据id查询活动, i:{}", i);

		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除活动】(ActivityController-deleteById)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 修改活动
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改活动")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody ActivityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改活动】(ActivityController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityId = req.getActivityId();
		Activity activity = req.convertToActivity();
		activity.setId(activityId);
		int i = activityService.modify(activity);
		logger.info("===step2:【修改活动】(ActivityController-modify)-修改活动, i:{}", i);

		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改活动】(ActivityController-modify)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

}