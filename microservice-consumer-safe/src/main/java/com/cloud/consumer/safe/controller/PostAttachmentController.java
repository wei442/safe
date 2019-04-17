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
import com.cloud.consumer.safe.rest.request.page.post.PostAttachmentPageRequest;
import com.cloud.consumer.safe.rest.request.post.PostAttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.post.PostAttachmentRequest;
import com.cloud.consumer.safe.service.IPostAttachmentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.post.PostAttachmentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 岗位附件管理 PostAttachmentController
 * @author wei.yong
 * @ClassName: PostAttachmentController
 */
@Api(tags = "岗位附件")
@RestController
@RequestMapping("/post/attachment")
public class PostAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//岗位附件 Service
	@Autowired
	private IPostAttachmentService postAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询岗位附件列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody PostAttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(PostAttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonPostAttachment = postAttachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(PostAttachmentController-getListByPage)-分页查询岗位附件列表, jsonPostAttachment:{}", jsonPostAttachment);
		String dataListStr = JSONObject.toJSONString(jsonPostAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonPostAttachment.getJSONObject(PageConstants.PAGE));
		List<PostAttachmentVo> postAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<PostAttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, postAttachmentVoList);
		//返回信息
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(PostAttachmentController-getListByPage)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
	    return postAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询岗位附件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody PostAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(PostAttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonPostAttachment = postAttachmentService.getList(req);
		logger.info("===step2:【不分页查询】(PostAttachmentController-getList)-不分页查询岗位附件列表, jsonPostAttachment:{}", jsonPostAttachment);
		String dataListStr = JSONObject.toJSONString(jsonPostAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<PostAttachmentVo> postAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<PostAttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(postAttachmentVoList);
		//返回信息
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(PostAttachmentController-getList)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 获取岗位附件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取岗位附件详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody PostAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取岗位附件】(PostAttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer postAttachmentId = req.getPostAttachmentId();
		JSONObject jsonPostAttachment = postAttachmentService.getById(postAttachmentId);
		logger.info("===step2:【获取岗位附件】(PostAttachmentController-getDetail)-根据postAttachmentId获取岗位附件, jsonPostAttachment:{}", jsonPostAttachment);
		PostAttachmentVo postAttachmentVo = JSONObject.toJavaObject(jsonPostAttachment, PostAttachmentVo.class);

		//返回信息
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.put(CommConstants.RESULT, postAttachmentVo);
	    logger.info("===step3:【获取岗位附件】(PostAttachmentController-getDetail)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
	    return postAttachmentResponse;
	}

	/**
	 * 新增岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增岗位附件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody PostAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增岗位附件】(PostAttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonPostAttachment = postAttachmentService.add(req);
		logger.info("===step2:【新增岗位附件】(PostAttachmentController-add)-分页查询岗位附件列表, jsonPostAttachment:{}", jsonPostAttachment);

		//返回信息
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增岗位附件】(PostAttachmentController-add)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
	    return postAttachmentResponse;
	}

	/**
	 * 删除岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除岗位附件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody PostAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除岗位附件】(PostAttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer postAttachmentId = req.getPostAttachmentId();
		JSONObject jsonPostAttachment = postAttachmentService.deleteById(postAttachmentId);
		logger.info("===step2:【删除岗位附件】(PostAttachmentController-delete)-根据postAttachmentId删除岗位附件, jsonPostAttachment:{}", jsonPostAttachment);

		//返回信息
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除岗位附件】(PostAttachmentController-delete)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 修改岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改岗位附件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody PostAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改岗位附件】(PostAttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonPostAttachment = postAttachmentService.update(req);
		logger.info("===step2:【修改岗位附件】(PostAttachmentController-update)-修改岗位附件, jsonPostAttachment:{}", jsonPostAttachment);

		//返回信息
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改岗位附件】(PostAttachmentController-update)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

}