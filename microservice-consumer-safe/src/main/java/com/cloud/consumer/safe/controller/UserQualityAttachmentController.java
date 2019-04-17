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
import com.cloud.consumer.safe.rest.request.page.user.UserQualityAttachmentPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserQualityAttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserQualityAttachmentRequest;
import com.cloud.consumer.safe.service.IUserQualityAttachmentService;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserQualityAttachmentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户资质附件管理 UserQualityAttachmentController
 * @author wei.yong
 * @ClassName: UserQualityAttachmentController
 */
@Api(tags = "用户资质附件")
@RestController
@RequestMapping("/user/quality/attachment")
public class UserQualityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户资质附件 Service
	@Autowired
	private IUserQualityAttachmentService userQualityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户资质附件列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserQualityAttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(UserQualityAttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserQualityAttachment = userQualityAttachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserQualityAttachmentController-getListByPage)-分页查询用户资质附件列表, jsonUserQualityAttachment:{}", jsonUserQualityAttachment);
		String dataListStr = JSONObject.toJSONString(jsonUserQualityAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserQualityAttachment.getJSONObject(PageConstants.PAGE));
		List<UserQualityAttachmentVo> userQualityAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserQualityAttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userQualityAttachmentVoList);
		//返回信息
		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserQualityAttachmentController-getListByPage)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
	    return userQualityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户资质附件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserQualityAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(UserQualityAttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserQualityAttachment = userQualityAttachmentService.getList(req);
		logger.info("===step2:【不分页查询】(UserQualityAttachmentController-getList)-不分页查询用户资质附件列表, jsonUserQualityAttachment:{}", jsonUserQualityAttachment);
		String dataListStr = JSONObject.toJSONString(jsonUserQualityAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<UserQualityAttachmentVo> userQualityAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserQualityAttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(userQualityAttachmentVoList);
		//返回信息
		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserQualityAttachmentController-getList)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 获取用户资质附件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户资质附件详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserQualityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户资质附件】(UserQualityAttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userQualityAttachmentId = req.getUserQualityAttachmentId();
		JSONObject jsonUserQualityAttachment = userQualityAttachmentService.getById(userQualityAttachmentId);
		logger.info("===step2:【获取用户资质附件】(UserQualityAttachmentController-getDetail)-根据userQualityAttachmentId获取用户资质附件, jsonUserQualityAttachment:{}", jsonUserQualityAttachment);
		UserQualityAttachmentVo userQualityAttachmentVo = JSONObject.toJavaObject(jsonUserQualityAttachment, UserQualityAttachmentVo.class);

		//返回信息
		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(CommConstants.RESULT, userQualityAttachmentVo);
	    logger.info("===step3:【获取用户资质附件】(UserQualityAttachmentController-getDetail)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
	    return userQualityAttachmentResponse;
	}

	/**
	 * 新增用户资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户资质附件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserQualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户资质附件】(UserQualityAttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserQualityAttachment = userQualityAttachmentService.add(req);
		logger.info("===step2:【新增用户资质附件】(UserQualityAttachmentController-add)-分页查询用户资质附件列表, jsonUserQualityAttachment:{}", jsonUserQualityAttachment);
		UserQualityAttachmentVo userQualityAttachmentVo = JSONObject.toJavaObject(jsonUserQualityAttachment, UserQualityAttachmentVo.class);

		//返回信息
		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(CommConstants.RESULT, userQualityAttachmentVo);
	    logger.info("===step3:【新增用户资质附件】(UserQualityAttachmentController-add)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
	    return userQualityAttachmentResponse;
	}

	/**
	 * 删除用户资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户资质附件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserQualityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户资质附件】(UserQualityAttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userQualityAttachmentId = req.getUserQualityAttachmentId();
		JSONObject jsonUserQualityAttachment = userQualityAttachmentService.deleteById(userQualityAttachmentId);
		logger.info("===step2:【删除用户资质附件】(UserQualityAttachmentController-delete)-根据userQualityAttachmentId删除用户资质附件, jsonUserQualityAttachment:{}", jsonUserQualityAttachment);
		UserQualityAttachmentVo userQualityAttachmentVo = JSONObject.toJavaObject(jsonUserQualityAttachment, UserQualityAttachmentVo.class);

		//返回信息
		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(CommConstants.RESULT, userQualityAttachmentVo);
		logger.info("===step3:【删除用户资质附件】(UserQualityAttachmentController-delete)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 修改用户资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户资质附件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated @RequestBody UserQualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户资质附件】(UserQualityAttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserQualityAttachment = userQualityAttachmentService.update(req);
		logger.info("===step2:【修改用户资质附件】(UserQualityAttachmentController-update)-修改用户资质附件, jsonUserQualityAttachment:{}", jsonUserQualityAttachment);
		UserQualityAttachmentVo userQualityAttachmentVo = JSONObject.toJavaObject(jsonUserQualityAttachment, UserQualityAttachmentVo.class);

		//返回信息
		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(CommConstants.RESULT, userQualityAttachmentVo);
		logger.info("===step3:【修改用户资质附件】(UserQualityAttachmentController-update)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

}