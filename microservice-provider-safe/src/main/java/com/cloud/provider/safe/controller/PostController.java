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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody PostPageRequest req) {
		logger.info("===step1:【分页查询岗位列表】(PostController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Post> list = postService.selectListByPage(page, req);
		logger.info("===step2:【分页查询岗位列表】(PostController-selectListByPage)-分页查询岗位列表, list.size:{}", list == null ? null : list.size());
		List<PostVo> postVoList = new PostVo().convertToPostVoList(list);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(postVoList));
		logger.info("===step3:【分页查询岗位列表】(PostController-selectListByPage)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询岗位列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody PostPageRequest req) {
		logger.info("===step1:【不分页查询岗位列表】(PostController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Post> list = postService.selectList(req);
		logger.info("===step2:【不分页查询岗位列表】(PostController-selectList)-不分页查询岗位列表, list.size:{}", list == null ? null : list.size());
		List<PostVo> postVoList = new PostVo().convertToPostVoList(list);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.put(PageConstants.DATA_LIST, postVoList);
		logger.info("===step3:【不分页查询岗位列表】(PostController-selectList)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 据id查询岗位
	 * @param postId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询岗位")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer postId) {
		logger.info("===step1:【据id查询岗位】(selectById-selectById)-传入参数, postId:{}", postId);

		if(postId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postId为空");
		}

		Post post = postService.selectById(postId);
		logger.info("===step2:【据id查询岗位】(PostController-selectById)-根据id查询岗位, post:{}", post);
		PostVo postVo = new PostVo().convertToPostVo(post);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		postResponse.putAll((JSONObject) JSONObject.toJSON(postVo));
		logger.info("===step3:【据id查询岗位】(PostController-selectById)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 添加岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加岗位")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody PostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加岗位】(PostController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Post post = req.convertToPost();
		int i = postService.insert(post);
		logger.info("===step2:【添加岗位】(PostController-insert)-插入岗位, i:{}", i);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加岗位】(PostController-insert)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 根据id删除岗位
	 * @param postId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除岗位")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer postId) {
		logger.info("===step1:【根据id删除岗位】(selectById-deleteById)-传入参数, postId:{}", postId);

		if(postId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postId为空");
		}

		int i = postService.deleteById(postId);
		logger.info("===step2:【根据id删除岗位】(PostController-deleteById)-根据id查询岗位, i:{}", i);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除岗位】(PostController-deleteById)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}

	/**
	 * 修改岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改岗位")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody PostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改岗位】(PostController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer postId = req.getPostId();
		Post post = req.convertToPost();
		post.setId(postId);
		int i = postService.modify(post);
		logger.info("===step2:【修改岗位】(PostController-modify)-修改岗位, i:{}", i);

		BaseRestMapResponse postResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改岗位】(PostController-modify)-返回信息, postResponse:{}", postResponse);
		return postResponse;
	}


}