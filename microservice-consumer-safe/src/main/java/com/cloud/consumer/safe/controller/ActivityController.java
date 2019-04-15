package com.cloud.consumer.safe.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.activity.ActivityAttachmentRequest;
import com.cloud.consumer.safe.rest.request.activity.ActivityIdRequest;
import com.cloud.consumer.safe.rest.request.activity.ActivityRequest;
import com.cloud.consumer.safe.rest.request.page.activity.ActivityPageRequest;
import com.cloud.consumer.safe.service.IActivityService;
import com.cloud.consumer.safe.service.IFastdfsClientService;
import com.cloud.consumer.safe.vo.activity.ActivityVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 安全活动管理 ActivityController
 * @author wei.yong
 * @ClassName: ActivityController
 */
@Api(tags = "安全活动")
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//安全活动 Service
	@Autowired
	private IActivityService activityService;

	//fastdfs Service
	@Autowired
	private IFastdfsClientService fastdfsClientService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询安全活动列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody ActivityPageRequest req) {
		logger.info("===step1:【分页查询】(ActivityController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonActivity = activityService.getListByPage(req);
		logger.info("===step2:【分页查询】(ActivityController-getListByPage)-分页查询安全活动列表, jsonActivity:{}", jsonActivity);
		String dataListStr = JSONObject.toJSONString(jsonActivity.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonActivity.getJSONObject(PageConstants.PAGE));
		List<ActivityVo> activityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<ActivityVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, activityVoList);
		//返回信息
		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(ActivityController-getListByPage)-返回信息, activityResponse:{}", activityResponse);
	    return activityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询安全活动列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody ActivityPageRequest req) {
		logger.info("===step1:【不分页查询】(ActivityController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonActivity = activityService.getList(req);
		logger.info("===step2:【不分页查询】(ActivityController-getList)-不分页查询安全活动列表, jsonActivity:{}", jsonActivity);
		String dataListStr = JSONObject.toJSONString(jsonActivity.getJSONArray(PageConstants.DATA_LIST));
		List<ActivityVo> activityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<ActivityVo>>(){});

		BaseResultVo result = new BaseResultVo(activityVoList);
		//返回信息
		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(ActivityController-getList)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 获取安全活动详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取安全活动详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody ActivityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取安全活动】(ActivityController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityId = req.getActivityId();
		JSONObject jsonActivity = activityService.getById(activityId);
		logger.info("===step2:【获取安全活动】(ActivityController-getDetail)-根据activityId获取安全活动, jsonActivity:{}", jsonActivity);
		ActivityVo activityVo = JSONObject.toJavaObject(jsonActivity, ActivityVo.class);

		//返回信息
		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(CommConstants.RESULT, activityVo);
	    logger.info("===step3:【获取安全活动】(ActivityController-getDetail)-返回信息, activityResponse:{}", activityResponse);
	    return activityResponse;
	}

	/**
	 * 新增安全活动
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增安全活动")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		ActivityRequest req, @RequestPart("fileList") MultipartFile[] multipartFiles,
		BindingResult bindingResult) {
		logger.info("===step1:【新增安全活动】(ActivityController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		List<ActivityAttachmentRequest> activityAttachmentList = null;
		ActivityAttachmentRequest activityAttachmentRequest = null;
		if(multipartFiles != null && multipartFiles.length >0) {
			activityAttachmentList = new ArrayList<ActivityAttachmentRequest>();
			for (MultipartFile multipartFile : multipartFiles) {
				activityAttachmentRequest = new ActivityAttachmentRequest();

				String fileUrl = fastdfsClientService.uploadFile(multipartFile);
				String filename = multipartFile.getOriginalFilename();
				activityAttachmentRequest.setName(filename);
				activityAttachmentRequest.setUrl(fileUrl);
				activityAttachmentList.add(activityAttachmentRequest);
			}
		}
		req.setActivityAttachmentList(activityAttachmentList);

		JSONObject jsonActivity = activityService.add(req);
		logger.info("===step2:【新增安全活动】(ActivityController-add)-分页查询安全活动列表, jsonActivity:{}", jsonActivity);
		ActivityVo activityVo = JSONObject.toJavaObject(jsonActivity, ActivityVo.class);

		//返回信息
		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(CommConstants.RESULT, activityVo);
	    logger.info("===step3:【新增安全活动】(ActivityController-add)-返回信息, activityResponse:{}", activityResponse);
	    return activityResponse;
	}

	/**
	 * 删除安全活动
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除安全活动")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody ActivityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除安全活动】(ActivityController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer activityId = req.getActivityId();
		JSONObject jsonActivity = activityService.deleteById(activityId);
		logger.info("===step2:【删除安全活动】(ActivityController-delete)-根据activityId删除安全活动, jsonActivity:{}", jsonActivity);
		ActivityVo activityVo = JSONObject.toJavaObject(jsonActivity, ActivityVo.class);

		//返回信息
		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(CommConstants.RESULT, activityVo);
		logger.info("===step3:【删除安全活动】(ActivityController-delete)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

	/**
	 * 修改安全活动
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改安全活动")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		ActivityRequest req, @RequestPart("fileList") MultipartFile[] multipartFiles,
		BindingResult bindingResult) {
		logger.info("===step1:【修改安全活动】(ActivityController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		List<ActivityAttachmentRequest> activityAttachmentList = null;
		ActivityAttachmentRequest activityAttachmentRequest = null;
		if(multipartFiles != null && multipartFiles.length >0) {
			activityAttachmentList = new ArrayList<ActivityAttachmentRequest>();
			for (MultipartFile multipartFile : multipartFiles) {
				activityAttachmentRequest = new ActivityAttachmentRequest();

				String fileUrl = fastdfsClientService.uploadFile(multipartFile);
				String filename = multipartFile.getOriginalFilename();
				activityAttachmentRequest.setName(filename);
				activityAttachmentRequest.setUrl(fileUrl);
				activityAttachmentList.add(activityAttachmentRequest);
			}
		}
		req.setActivityAttachmentList(activityAttachmentList);

		JSONObject jsonActivity = activityService.update(req);
		logger.info("===step2:【修改安全活动】(ActivityController-update)-修改安全活动, jsonActivity:{}", jsonActivity);
		ActivityVo activityVo = JSONObject.toJavaObject(jsonActivity, ActivityVo.class);

		//返回信息
		BaseRestMapResponse activityResponse = new BaseRestMapResponse();
		activityResponse.put(CommConstants.RESULT, activityVo);
		logger.info("===step3:【修改安全活动】(ActivityController-update)-返回信息, activityResponse:{}", activityResponse);
		return activityResponse;
	}

}