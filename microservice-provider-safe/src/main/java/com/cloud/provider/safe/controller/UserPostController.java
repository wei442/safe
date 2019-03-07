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
import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.rest.request.UserPostRequest;
import com.cloud.provider.safe.rest.request.page.UserPostPageRequest;
import com.cloud.provider.safe.service.IUserPostService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserPostVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户岗位 UserPostController
 * @author wei.yong
 */
@Api(tags = "用户岗位")
@RestController
@RequestMapping(value="/userPost")
public class UserPostController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户岗位Service
	@Autowired
	private IUserPostService userPostService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户岗位列表")
	@RequestMapping(value="/selectUserPostListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserPostListByPage(
		@RequestBody UserPostPageRequest req) {
		logger.info("===step1:【分页查询用户岗位列表】(UserPostController-selectUserPostListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserPost userPost = new UserPost();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserPost> list = userPostService.selectUserPostListByPage(page, userPost);
		logger.info("===step2:【分页查询用户岗位列表】(UserPostController-selectUserPostListByPage)-分页查询用户岗位列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<UserPostVo> userPostVoList = new UserPostVo().convertToUserPostVoList(list);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userPostVoList));
		logger.info("===step3:【分页查询用户岗位列表】(UserPostController-selectUserPostListByPage)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户岗位列表")
	@RequestMapping(value="/selectUserPostList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserPostList(
		@RequestBody UserPostPageRequest req) {
		logger.info("===step1:【不分页查询用户岗位列表】(UserPostController-selectUserPostList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserPost userPost = new UserPost();
		List<UserPost> list = null;
		list = userPostService.selectUserPostList(userPost);
		logger.info("===step2:【不分页查询用户岗位列表】(UserPostController-selectUserPostList)-不分页查询用户岗位列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<UserPostVo> userPostVoList = new UserPostVo().convertToUserPostVoList(list);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(PageConstants.DATA_LIST, userPostVoList);
		logger.info("===step3:【不分页查询用户岗位列表】(UserPostController-selectUserPostList)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 据id查询用户岗位
	 * @param userPostId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户岗位")
	@RequestMapping(value="/selectUserPostById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserPostById(
		@PathVariable(value="id",required=false) Integer userPostId) {
		logger.info("===step1:【据id查询用户岗位】(selectUserPostById-selectUserPostById)-传入参数, userPostId:{}", userPostId);

		if(userPostId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userPostId为空");
		}

		UserPost userPost = userPostService.selectUserPostById(userPostId);
		logger.info("===step2:【据id查询用户岗位】(UserPostController-selectUserPostById)-根据id查询用户岗位, userPost:{}", userPost);
		if(userPost == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserPostVo userPostVo = new UserPostVo().convertToUserPostVo(userPost);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.putAll((JSONObject) JSONObject.toJSON(userPostVo));
		logger.info("===step3:【据id查询用户岗位】(UserPostController-selectUserPostById)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 添加用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户岗位")
	@RequestMapping(value="/insertUserPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserPost(
		@Validated @RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户岗位】(UserPostController-insertUserPost)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserPost userPost = req.convertToUserPost();
		int i = userPostService.insertUserPost(userPost);
		logger.info("===step2:【添加用户岗位】(UserPostController-insertUserPost)-插入用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户岗位】(UserPostController-insertUserPost)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 根据id删除用户岗位
	 * @param userPostId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户岗位")
	@RequestMapping(value="/deleteUserPostById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserPostById(
		@PathVariable(value="id",required=false) Integer userPostId) {
		logger.info("===step1:【根据id删除用户岗位】(selectUserPostById-deleteUserPostById)-传入参数, userPostId:{}", userPostId);

		if(userPostId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userPostId为空");
		}

		int i = userPostService.deleteUserPostById(userPostId);
		logger.info("===step2:【根据id删除用户岗位】(UserPostController-deleteUserPostById)-根据id查询用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户岗位】(UserPostController-deleteUserPostById)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 修改用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户岗位")
	@RequestMapping(value="/modifyUserPost",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserPost(
		@Validated({ ModifyGroup.class }) @RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户岗位】(UserPostController-modifyUserPost)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userPostId = req.getUserPostId();
		UserPost userPost = req.convertToUserPost();
		userPost.setId(userPostId);
		int i = userPostService.modifyUserPost(userPost);
		logger.info("===step2:【修改用户岗位】(UserPostController-modifyUserPost)-修改用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户岗位】(UserPostController-modifyUserPost)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

}