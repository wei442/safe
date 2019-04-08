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
import com.cloud.provider.safe.rest.request.page.user.UserPostPageRequest;
import com.cloud.provider.safe.rest.request.user.UserPostRequest;
import com.cloud.provider.safe.service.IUserPostService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserPostVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户岗位 UserPostController
 * @author wei.yong
 */
@Api(tags = "用户岗位")
@RestController
@RequestMapping(value="/user/post")
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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserPostPageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【分页查询用户岗位列表】(UserPostController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserPostVo> list = userPostService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户岗位列表】(UserPostController-selectListByPage)-分页查询用户岗位列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(list));
		logger.info("===step3:【分页查询用户岗位列表】(UserPostController-selectListByPage)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户岗位列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserPostPageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【不分页查询用户岗位列表】(UserPostController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserPostVo> list = userPostService.selectList(req);
		logger.info("===step2:【不分页查询用户岗位列表】(UserPostController-selectList)-不分页查询用户岗位列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用户岗位列表】(UserPostController-selectList)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 据id查询用户岗位
	 * @param userPostId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户岗位")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userPostId) {
		logger.info("===step1:【据id查询用户岗位】(selectById-selectById)-传入参数, userPostId:{}", userPostId);

		if(userPostId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userPostId不能为空");
		}

		UserPost userPost = userPostService.selectById(userPostId);
		logger.info("===step2:【据id查询用户岗位】(UserPostController-selectById)-根据id查询用户岗位, userPost:{}", userPost);
		UserPostVo userPostVo = new UserPostVo().convertToUserPostVo(userPost);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.putAll((JSONObject) JSONObject.toJSON(userPostVo));
		logger.info("===step3:【据id查询用户岗位】(UserPostController-selectById)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 据userId查询用户岗位
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户岗位")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户岗位】(selectById-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userId不能为空");
		}

		UserPost userPost = userPostService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户岗位】(UserPostController-selectByUserId)-根据userId查询用户岗位, userPost:{}", userPost);
		UserPostVo userPostVo = new UserPostVo().convertToUserPostVo(userPost);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		userPostResponse.putAll((JSONObject) JSONObject.toJSON(userPostVo));
		logger.info("===step3:【据userId查询用户岗位】(UserPostController-selectByUserId)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 添加用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户岗位")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户岗位】(UserPostController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserPost userPost = req.convertToUserPost();
		int i = userPostService.insert(userPost);
		logger.info("===step2:【添加用户岗位】(UserPostController-insert)-插入用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户岗位】(UserPostController-insert)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 根据id删除用户岗位
	 * @param userPostId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户岗位")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userPostId) {
		logger.info("===step1:【根据id删除用户岗位】(UserPostController-deleteById)-传入参数, userPostId:{}", userPostId);

		if(userPostId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userPostId不能为空");
		}

		int i = userPostService.deleteById(userPostId);
		logger.info("===step2:【根据id删除用户岗位】(UserPostController-deleteById)-根据id查询用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户岗位】(UserPostController-deleteById)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 根据ids删除用户岗位
	 * @param userPostIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据ids删除用户岗位")
	@RequestMapping(value="/deleteByIds/{ids}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteByIds(
		@PathVariable(value="ids",required=false) List<Integer> userPostIds) {
		logger.info("===step1:【根据ids删除用户岗位】(UserPostController-deleteByIds)-传入参数, userPostIds:{}", userPostIds);

		if(userPostIds == null || userPostIds.isEmpty()) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userPostIds不能为空");
		}

		int i = userPostService.deleteByIds(userPostIds);
		logger.info("===step2:【根据ids删除用户岗位】(UserPostController-deleteByIds)-根据ids删除用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据ids删除用户岗位】(UserPostController-deleteByIds)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

	/**
	 * 修改用户岗位
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户岗位")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserPostRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户岗位】(UserPostController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userPostId = req.getUserPostId();
		UserPost userPost = req.convertToUserPost();
		userPost.setId(userPostId);
		int i = userPostService.modify(userPost);
		logger.info("===step2:【修改用户岗位】(UserPostController-modify)-修改用户岗位, i:{}", i);

		BaseRestMapResponse userPostResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户岗位】(UserPostController-modify)-返回信息, userPostResponse:{}", userPostResponse);
		return userPostResponse;
	}

}