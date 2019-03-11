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
import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.rest.request.PostRequest;
import com.cloud.provider.safe.rest.request.page.PostPageRequest;
import com.cloud.provider.safe.service.IPostService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.PostVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 岗位 PostController
 * @author wei.yong
 */
@Api(tags = "岗位")
@RestController
@RequestMapping(value="/post")
public class PostController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//岗位Service
	@Autowired
	private IPostService postService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询岗位列表")
	@RequestMapping(value="/selectPostListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectPostListByPage(
		@RequestBody PostPageRequest req) {
		logger.info("===step1:【分页查询岗位列表】(PostController-selectPostListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Post> list = postService.selectPostListByPage(page, req);
		logger.info("===step2:【分页查询岗位列表】(PostController-selectPostListByPage)-分页查询岗位列表, list.size:{}", list == null ? null : list.size());
		List<PostVo> postVoList = new PostVo().convertToPostVoList(list);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(postVoList));
		logger.info("===step3:【分页查询岗位列表】(PostController-selectPostListByPage)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询岗位列表")
	@RequestMapping(value="/selectPostList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectPostList(
		@RequestBody PostPageRequest req) {
		logger.info("===step1:【不分页查询岗位列表】(PostController-selectPostList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Post> list = postService.selectPostList(req);
		logger.info("===step2:【不分页查询岗位列表】(PostController-selectPostList)-不分页查询岗位列表, list.size:{}", list == null ? null : list.size());
		List<PostVo> postVoList = new PostVo().convertToPostVoList(list);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(PageConstants.DATA_LIST, postVoList);
		logger.info("===step3:【不分页查询岗位列表】(PostController-selectPostList)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 据id查询岗位
	 * @param postId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询岗位")
	@RequestMapping(value="/selectPostById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectPostById(
		@PathVariable(value="id",required=false) Integer postId) {
		logger.info("===step1:【据id查询岗位】(selectPostById-selectPostById)-传入参数, postId:{}", postId);

		if(postId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postId为空");
		}

		Post post = postService.selectPostById(postId);
		logger.info("===step2:【据id查询岗位】(PostController-selectPostById)-根据id查询岗位, post:{}", post);
		if(post == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		PostVo postVo = new PostVo().convertToPostVo(post);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.putAll((JSONObject) JSONObject.toJSON(postVo));
		logger.info("===step3:【据id查询岗位】(PostController-selectPostById)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 添加岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加岗位")
	@RequestMapping(value="/insertPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertPost(
		@Validated @RequestBody PostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加岗位】(PostController-insertPost)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Post post = req.convertToPost();
		int i = postService.insertPost(post);
		logger.info("===step2:【添加岗位】(PostController-insertPost)-插入岗位, i:{}", i);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加岗位】(PostController-insertPost)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 根据id删除岗位
	 * @param postId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除岗位")
	@RequestMapping(value="/deletePostById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deletePostById(
		@PathVariable(value="id",required=false) Integer postId) {
		logger.info("===step1:【根据id删除岗位】(selectPostById-deletePostById)-传入参数, postId:{}", postId);

		if(postId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postId为空");
		}

		int i = postService.deletePostById(postId);
		logger.info("===step2:【根据id删除岗位】(PostController-deletePostById)-根据id查询岗位, i:{}", i);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除岗位】(PostController-deletePostById)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 修改岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改岗位")
	@RequestMapping(value="/modifyPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyPost(
		@Validated({ ModifyGroup.class }) @RequestBody PostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改岗位】(PostController-modifyPost)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer postId = req.getPostId();
		Post post = req.convertToPost();
		post.setId(postId);
		int i = postService.modifyPost(post);
		logger.info("===step2:【修改岗位】(PostController-modifyPost)-修改岗位, i:{}", i);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改岗位】(PostController-modifyPost)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}


}