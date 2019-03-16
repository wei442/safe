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
import com.cloud.consumer.safe.rest.request.UserTitleIdRequest;
import com.cloud.consumer.safe.rest.request.UserTitleRequest;
import com.cloud.consumer.safe.rest.request.page.UserTitlePageRequest;
import com.cloud.consumer.safe.service.IUserTitleService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.UserTitleVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

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
	@RequestMapping(value="/getUserTitleListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserTitleListByPage(
		@RequestBody UserTitlePageRequest req) {
		logger.info("===step1:【分页查询】(UserTitleController-getUserTitleListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserTitle = userTitleService.getUserTitleListByPage(req);
		logger.info("===step2:【分页查询】(UserTitleController-getUserTitleListByPage)-分页查询用户职务列表, jsonUserTitle:{}", jsonUserTitle);
		String dataListStr = JSONObject.toJSONString(jsonUserTitle.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserTitle.getJSONObject(PageConstants.PAGE));
		List<UserTitleVo> userTitleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserTitleVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userTitleVoList);
		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserTitleController-getUserTitleListByPage)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户职务列表")
	@RequestMapping(value="/getUserTitleList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserTitleList(
		@RequestBody UserTitlePageRequest req) {
		logger.info("===step1:【不分页查询】(UserTitleController-getUserTitleList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserTitle = userTitleService.getUserTitleListByPage(req);
		logger.info("===step2:【不分页查询】(UserTitleController-getUserTitleList)-不分页查询用户职务列表, jsonUserTitle:{}", jsonUserTitle);
		String dataListStr = JSONObject.toJSONString(jsonUserTitle.getJSONArray(PageConstants.DATA_LIST));
		List<UserTitleVo> userTitleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserTitleVo>>(){});

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(RetSafeConstants.RESULT, userTitleVoList);
		logger.info("===step3:【不分页查询】(UserTitleController-getUserTitleList)-返回信息, userTitleResponse:{}", userTitleResponse);
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
	@RequestMapping(value="/getUserTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserTitle(
		@Validated @RequestBody UserTitleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户职务】(UserTitleController-getUserTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userTitleId = req.getUserTitleId();
		JSONObject jsonUserTitle = userTitleService.getUserTitleById(userTitleId);
		logger.info("===step2:【获取用户职务】(UserTitleController-getUserTitle)-根据userTitleId获取用户职务, jsonUserTitle:{}", jsonUserTitle);
		UserTitleVo userTitleVo = JSONObject.toJavaObject(jsonUserTitle, UserTitleVo.class);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(RetSafeConstants.RESULT, userTitleVo);
	    logger.info("===step3:【获取用户职务】(UserTitleController-getUserTitle)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 新增用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户职务")
	@RequestMapping(value="/addUserTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addUserTitle(
		@Validated @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户职务】(UserTitleController-addUserTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserTitle = userTitleService.addUserTitle(req);
		logger.info("===step2:【新增用户职务】(UserTitleController-addUserTitle)-分页查询用户职务列表, jsonUserTitle:{}", jsonUserTitle);
		UserTitleVo userTitleVo = JSONObject.toJavaObject(jsonUserTitle, UserTitleVo.class);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(RetSafeConstants.RESULT, userTitleVo);
	    logger.info("===step3:【新增用户职务】(UserTitleController-addUserTitle)-返回信息, userTitleResponse:{}", userTitleResponse);
	    return userTitleResponse;
	}

	/**
	 * 删除用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户职务")
	@RequestMapping(value="/deleteUserTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserTitle(
		@Validated @RequestBody UserTitleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户职务】(UserTitleController-deleteUserTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userTitleId = req.getUserTitleId();
		JSONObject jsonUserTitle = userTitleService.deleteUserTitleById(userTitleId);
		logger.info("===step2:【删除用户职务】(UserTitleController-deleteUserTitle)-根据userTitleId删除用户职务, jsonUserTitle:{}", jsonUserTitle);
		UserTitleVo userTitleVo = JSONObject.toJavaObject(jsonUserTitle, UserTitleVo.class);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(RetSafeConstants.RESULT, userTitleVo);
		logger.info("===step3:【删除用户职务】(UserTitleController-deleteUserTitle)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 修改用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户职务")
	@RequestMapping(value="/updateUserTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateUserTitle(
		@Validated({ UpdateGroup.class }) @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户职务】(UserTitleController-updateUserTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserTitle = userTitleService.addUserTitle(req);
		logger.info("===step2:【修改用户职务】(UserTitleController-updateUserTitle)-修改用户职务, jsonUserTitle:{}", jsonUserTitle);
		UserTitleVo userTitleVo = JSONObject.toJavaObject(jsonUserTitle, UserTitleVo.class);

		//返回信息
		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(RetSafeConstants.RESULT, userTitleVo);
		logger.info("===step3:【修改用户职务】(UserTitleController-updateUserTitle)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

}