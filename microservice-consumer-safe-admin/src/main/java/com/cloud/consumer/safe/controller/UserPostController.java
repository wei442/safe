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
import com.cloud.consumer.safe.rest.request.UserPostRequest;
import com.cloud.consumer.safe.rest.request.page.UserPostPageRequest;
import com.cloud.consumer.safe.service.IUserPostService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.UserPostVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户岗位管理 UserPostController
 * @author wei.yong
 * @ClassName: UserPostController
 */
@Api(tags = "用户岗位")
@RestController
@RequestMapping("/user/userPost")
public class UserPostController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户岗位 Service
	@Autowired
	private IUserPostService userPostService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户岗位列表")
	@RequestMapping(value="/getUserPostListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserPostListByPage(
		@RequestBody UserPostPageRequest req) {
		logger.info("===step1:【分页查询】(UserPostController-getUserPostListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserPost = userPostService.getUserPostListByPage(req);
		logger.info("===step2:【分页查询】(UserPostController-getUserPostListByPage)-分页查询用户岗位列表, jsonUserPost:{}", jsonUserPost);
		String dataListStr = JSONObject.toJSONString(jsonUserPost.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserPost.getJSONObject(PageConstants.PAGE));
		List<UserPostVo> userPostVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserPostVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userPostVoList);
		//返回信息
		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserPostController-getUserPostListByPage)-返回信息, userPostResponse:{}", userPostResponse);
	    return userPostResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户岗位列表")
	@RequestMapping(value="/getUserPostList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserPostList(
		@RequestBody UserPostPageRequest req) {
		logger.info("===step1:【不分页查询】(UserPostController-getUserPostList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserPost = userPostService.getUserPostListByPage(req);
		logger.info("===step2:【不分页查询】(UserPostController-getUserPostList)-不分页查询用户岗位列表, jsonUserPost:{}", jsonUserPost);
		String dataListStr = JSONObject.toJSONString(jsonUserPost.getJSONArray(PageConstants.DATA_LIST));
		List<UserPostVo> userPostVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserPostVo>>(){});

		//返回信息
		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(RetSafeConstants.RESULT, userPostVoList);
		logger.info("===step3:【不分页查询】(UserPostController-getUserPostList)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 获取用户岗位详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户岗位详情")
	@RequestMapping(value="/getUserPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserPost(
		@RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户岗位】(UserPostController-getUserPost)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userPostId = req.getUserPostId();
		JSONObject jsonUserPost = userPostService.getUserPostById(userPostId);
		logger.info("===step2:【获取用户岗位】(UserPostController-getUserPost)-根据userPostId获取用户岗位, jsonUserPost:{}", jsonUserPost);
		UserPostVo userPostVo = JSONObject.toJavaObject(jsonUserPost, UserPostVo.class);

		//返回信息
		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(RetSafeConstants.RESULT, userPostVo);
	    logger.info("===step3:【获取用户岗位】(UserPostController-getUserPost)-返回信息, userPostResponse:{}", userPostResponse);
	    return userPostResponse;
	}

	/**
	 * 新增用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户岗位")
	@RequestMapping(value="/addUserPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addUserPost(
		@Validated @RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户岗位】(UserPostController-addUserPost)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserPost = userPostService.addUserPost(req);
		logger.info("===step2:【新增用户岗位】(UserPostController-addUserPost)-分页查询用户岗位列表, jsonUserPost:{}", jsonUserPost);
		UserPostVo userPostVo = JSONObject.toJavaObject(jsonUserPost, UserPostVo.class);

		//返回信息
		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(RetSafeConstants.RESULT, userPostVo);
	    logger.info("===step3:【新增用户岗位】(UserPostController-addUserPost)-返回信息, userPostResponse:{}", userPostResponse);
	    return userPostResponse;
	}

	/**
	 * 删除用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户岗位")
	@RequestMapping(value="/deleteUserPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserPost(
		@RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户岗位】(UserPostController-deleteUserPost)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userPostId = req.getUserPostId();
		JSONObject jsonUserPost = userPostService.deleteUserPostById(userPostId);
		logger.info("===step2:【删除用户岗位】(UserPostController-deleteUserPost)-根据userPostId删除用户岗位, jsonUserPost:{}", jsonUserPost);
		UserPostVo userPostVo = JSONObject.toJavaObject(jsonUserPost, UserPostVo.class);

		//返回信息
		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(RetSafeConstants.RESULT, userPostVo);
		logger.info("===step3:【删除用户岗位】(UserPostController-deleteUserPost)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 修改用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户岗位")
	@RequestMapping(value="/updateUserPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateUserPost(
		@Validated({ UpdateGroup.class }) @RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户岗位】(UserPostController-updateUserPost)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserPost = userPostService.addUserPost(req);
		logger.info("===step2:【修改用户岗位】(UserPostController-updateUserPost)-修改用户岗位, jsonUserPost:{}", jsonUserPost);
		UserPostVo userPostVo = JSONObject.toJavaObject(jsonUserPost, UserPostVo.class);

		//返回信息
		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(RetSafeConstants.RESULT, userPostVo);
		logger.info("===step3:【修改用户岗位】(UserPostController-updateUserPost)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

}