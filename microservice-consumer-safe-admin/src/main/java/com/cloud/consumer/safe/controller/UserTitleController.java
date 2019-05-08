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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.page.user.UserTitlePageRequest;
import com.cloud.consumer.safe.rest.request.user.UserInfoIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserTitleIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserTitleIdsRequest;
import com.cloud.consumer.safe.rest.request.user.UserTitleListRequest;
import com.cloud.consumer.safe.rest.request.user.UserTitleRequest;
import com.cloud.consumer.safe.service.IUserTitleService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserTitleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户职务管理 UserTitleController
 * @author wei.yong
 * @ClassName: UserTitleController
 */
@Api(tags = "用户职务")
@RestController
@RequestMapping("/user/title")
public class UserTitleController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户职务 Service
	@Autowired
	private IUserTitleService userTitleService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户职务列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserTitlePageRequest req) {
		logger.info("===step1:【分页查询】(UserTitleController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserTitle = userTitleService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserTitleController-getListByPage)-分页查询用户职务列表, jsonUserTitle:{}", jsonUserTitle);
		String dataListStr = JSONObject.toJSONString(jsonUserTitle.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserTitle.getJSONObject(PageConstants.PAGE));
		List<UserTitleVo> userTitleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserTitleVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userTitleVoList);
		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserTitleController-getListByPage)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户职务列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserTitlePageRequest req) {
		logger.info("===step1:【不分页查询】(UserTitleController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserTitle = userTitleService.getList(req);
		logger.info("===step2:【不分页查询】(UserTitleController-getList)-不分页查询用户职务列表, jsonUserTitle:{}", jsonUserTitle);
		String dataListStr = JSONObject.toJSONString(jsonUserTitle.getJSONArray(PageConstants.DATA_LIST));
		List<UserTitleVo> userTitleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserTitleVo>>(){});

		BaseResultVo result = new BaseResultVo(userTitleVoList);
		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserTitleController-getList)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 获取用户职务详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户职务详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserTitleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户职务】(UserTitleController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userTitleId = req.getUserTitleId();
		JSONObject jsonUserTitle = userTitleService.getById(userTitleId);
		logger.info("===step2:【获取用户职务】(UserTitleController-getDetail)-根据userTitleId获取用户职务, jsonUserTitle:{}", jsonUserTitle);
		UserTitleVo userTitleVo = JSONObject.toJavaObject(jsonUserTitle, UserTitleVo.class);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(CommConstants.RESULT, userTitleVo);
	    logger.info("===step3:【获取用户职务】(UserTitleController-getDetail)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 新增用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户职务")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户职务】(UserTitleController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserTitle = userTitleService.add(req);
		logger.info("===step2:【新增用户职务】(UserTitleController-add)-分页查询用户职务列表, jsonUserTitle:{}", jsonUserTitle);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增用户职务】(UserTitleController-add)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 批量新增用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量新增用户职务")
	@RequestMapping(value="/addList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addList(
		@Validated @RequestBody UserTitleListRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【批量新增用户职务】(UserTitleController-addList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		Integer postId = req.getTitleId();

		List<UserTitleRequest> userTitleList = null;
		List<UserInfoIdRequest> userList = req.getUserList();
		if(userList != null && !userList.isEmpty()) {
			userTitleList = new ArrayList<UserTitleRequest>();
			UserTitleRequest userTitleRequest = null;
			for (UserInfoIdRequest userInfoIdRequest : userList) {
				userTitleRequest = new UserTitleRequest();
				userTitleRequest.setEnterpriseId(enterpriseId);
				userTitleRequest.setUserId(userInfoIdRequest.getUserId());
				userTitleRequest.setTitleId(postId);
				userTitleList.add(userTitleRequest);
			}
		}
		req.setUserTitleList(userTitleList);

		JSONObject jsonUserTitle = userTitleService.addList(req);
		logger.info("===step2:【批量新增用户职务】(UserTitleController-addList)-批量新增用户职务列表, jsonUserTitle:{}", jsonUserTitle);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
	    logger.info("===step3:【批量新增用户职务】(UserTitleController-addList)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 删除用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除用户职务")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserTitleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户职务】(UserTitleController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userTitleId = req.getUserTitleId();
		JSONObject jsonUserTitle = userTitleService.deleteById(userTitleId);
		logger.info("===step2:【删除用户职务】(UserTitleController-delete)-根据userTitleId删除用户职务, jsonUserTitle:{}", jsonUserTitle);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除用户职务】(UserTitleController-delete)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 批量删除用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除用户职务")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody UserTitleIdsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【批量删除用户职务】(UserTitleController-batchDelete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserTitle = userTitleService.batchDelete(req);
		logger.info("===step2:【批量删除用户职务】(UserTitleController-batchDelete)-根据userTitleIds删除用户职务, jsonUserTitle:{}", jsonUserTitle);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除用户职务】(UserTitleController-batchDelete)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 修改用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户职务")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户职务】(UserTitleController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserTitle = userTitleService.update(req);
		logger.info("===step2:【修改用户职务】(UserTitleController-update)-修改用户职务, jsonUserTitle:{}", jsonUserTitle);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户职务】(UserTitleController-update)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

}