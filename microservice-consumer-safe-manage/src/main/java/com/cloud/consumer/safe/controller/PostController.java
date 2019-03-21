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
import com.cloud.consumer.safe.rest.request.PostIdRequest;
import com.cloud.consumer.safe.rest.request.PostRequest;
import com.cloud.consumer.safe.rest.request.page.PostPageRequest;
import com.cloud.consumer.safe.service.IPostService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.PostVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 岗位管理 PostController
 * @author wei.yong
 * @ClassName: PostController
 */
@Api(tags = "岗位")
@RestController
@RequestMapping("/post")
public class PostController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//岗位 Service
	@Autowired
	private IPostService postService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询岗位列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody PostPageRequest req) {
		logger.info("===step1:【分页查询】(PostController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonPost = postService.getListByPage(req);
		logger.info("===step2:【分页查询】(PostController-getListByPage)-分页查询岗位列表, jsonPost:{}", jsonPost);
		String dataListStr = JSONObject.toJSONString(jsonPost.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonPost.getJSONObject(PageConstants.PAGE));
		List<PostVo> postVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<PostVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, postVoList);
		//返回信息
		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(PostController-getListByPage)-返回信息, postResponse:{}", postResponse);
	    return postResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询岗位列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody PostPageRequest req) {
		logger.info("===step1:【不分页查询】(PostController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonPost = postService.getListByPage(req);
		logger.info("===step2:【不分页查询】(PostController-getList)-不分页查询岗位列表, jsonPost:{}", jsonPost);
		String dataListStr = JSONObject.toJSONString(jsonPost.getJSONArray(PageConstants.DATA_LIST));
		List<PostVo> postVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<PostVo>>(){});

		//返回信息
		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(RetSafeConstants.RESULT, postVoList);
		logger.info("===step3:【不分页查询】(PostController-getList)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 获取岗位详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取岗位详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody PostIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取岗位】(PostController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer postId = req.getPostId();
		JSONObject jsonPost = postService.getById(postId);
		logger.info("===step2:【获取岗位】(PostController-get)-根据postId获取岗位, jsonPost:{}", jsonPost);
		PostVo postVo = JSONObject.toJavaObject(jsonPost, PostVo.class);

		//返回信息
		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(RetSafeConstants.RESULT, postVo);
	    logger.info("===step3:【获取岗位】(PostController-get)-返回信息, postResponse:{}", postResponse);
	    return postResponse;
	}

	/**
	 * 新增岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增岗位")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody PostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增岗位】(PostController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonPost = postService.add(req);
		logger.info("===step2:【新增岗位】(PostController-add)-分页查询岗位列表, jsonPost:{}", jsonPost);
		PostVo postVo = JSONObject.toJavaObject(jsonPost, PostVo.class);

		//返回信息
		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(RetSafeConstants.RESULT, postVo);
	    logger.info("===step3:【新增岗位】(PostController-add)-返回信息, postResponse:{}", postResponse);
	    return postResponse;
	}

	/**
	 * 删除岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除岗位")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody PostIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除岗位】(PostController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer postId = req.getPostId();
		JSONObject jsonPost = postService.deleteById(postId);
		logger.info("===step2:【删除岗位】(PostController-delete)-根据postId删除岗位, jsonPost:{}", jsonPost);
		PostVo postVo = JSONObject.toJavaObject(jsonPost, PostVo.class);

		//返回信息
		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(RetSafeConstants.RESULT, postVo);
		logger.info("===step3:【删除岗位】(PostController-delete)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 修改岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改岗位")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody PostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改岗位】(PostController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonPost = postService.update(req);
		logger.info("===step2:【修改岗位】(PostController-update)-修改岗位, jsonPost:{}", jsonPost);
		PostVo postVo = JSONObject.toJavaObject(jsonPost, PostVo.class);

		//返回信息
		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(RetSafeConstants.RESULT, postVo);
		logger.info("===step3:【修改岗位】(PostController-update)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

}