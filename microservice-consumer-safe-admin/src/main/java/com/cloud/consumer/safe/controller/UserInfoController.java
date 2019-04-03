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
import com.cloud.consumer.safe.rest.request.UserInfoIdRequest;
import com.cloud.consumer.safe.rest.request.UserInfoRequest;
import com.cloud.consumer.safe.rest.request.page.UserInfoPageRequest;
import com.cloud.consumer.safe.service.IUserInfoService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.UserInfoVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息管理 UserInfoController
 * @author wei.yong
 * @ClassName: UserInfoController
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/userinfo")
public class UserInfoController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户信息 Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户信息列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserInfoPageRequest req) {
		logger.info("===step1:【分页查询】(UserInfoController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserInfo = userInfoService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserInfoController-getListByPage)-分页查询用户信息列表, jsonUserInfo:{}", jsonUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonUserInfo.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserInfo.getJSONObject(PageConstants.PAGE));
		List<UserInfoVo> userInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserInfoVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userInfoVoList);
		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserInfoController-getListByPage)-返回信息, userInfoResponse:{}", userInfoResponse);
	    return userInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户信息列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserInfoPageRequest req) {
		logger.info("===step1:【不分页查询】(UserInfoController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserInfo = userInfoService.getListByPage(req);
		logger.info("===step2:【不分页查询】(UserInfoController-getList)-不分页查询用户信息列表, jsonUserInfo:{}", jsonUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonUserInfo.getJSONArray(PageConstants.DATA_LIST));
		List<UserInfoVo> userInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserInfoVo>>(){});

		BaseResultVo result = new BaseResultVo(userInfoVoList);
		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserInfoController-getList)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 获取用户信息详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户信息详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody UserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户信息】(UserInfoController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		JSONObject jsonUserInfo = userInfoService.getById(userId);
		logger.info("===step2:【获取用户信息】(UserInfoController-get)-根据userInfoId获取用户信息, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
	    logger.info("===step3:【获取用户信息】(UserInfoController-get)-返回信息, userInfoResponse:{}", userInfoResponse);
	    return userInfoResponse;
	}

	/**
	 * 新增用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户信息")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户信息】(UserInfoController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserInfo = userInfoService.add(req);
		logger.info("===step2:【新增用户信息】(UserInfoController-add)-分页查询用户信息列表, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
	    logger.info("===step3:【新增用户信息】(UserInfoController-add)-返回信息, userInfoResponse:{}", userInfoResponse);
	    return userInfoResponse;
	}

	/**
	 * 删除用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户信息")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户信息】(UserInfoController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		JSONObject jsonUserInfo = userInfoService.deleteById(userId);
		logger.info("===step2:【删除用户信息】(UserInfoController-delete)-根据userInfoId删除用户信息, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
		logger.info("===step3:【删除用户信息】(UserInfoController-delete)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 修改用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户信息")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户信息】(UserInfoController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserInfo = userInfoService.update(req);
		logger.info("===step2:【修改用户信息】(UserInfoController-update)-修改用户信息, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
		logger.info("===step3:【修改用户信息】(UserInfoController-update)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

}