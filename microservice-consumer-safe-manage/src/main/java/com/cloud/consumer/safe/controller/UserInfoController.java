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
	@RequestMapping(value="/getUserInfoListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserInfoListByPage(
		@RequestBody UserInfoPageRequest req) {
		logger.info("===step1:【分页查询】(UserInfoController-getUserInfoListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserInfo = userInfoService.getUserInfoListByPage(req);
		logger.info("===step2:【分页查询】(UserInfoController-getUserInfoListByPage)-分页查询用户信息列表, jsonUserInfo:{}", jsonUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonUserInfo.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserInfo.getJSONObject(PageConstants.PAGE));
		List<UserInfoVo> userInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserInfoVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userInfoVoList);
		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserInfoController-getUserInfoListByPage)-返回信息, userInfoResponse:{}", userInfoResponse);
	    return userInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户信息列表")
	@RequestMapping(value="/getUserInfoList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserInfoList(
		@RequestBody UserInfoPageRequest req) {
		logger.info("===step1:【不分页查询】(UserInfoController-getUserInfoList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserInfo = userInfoService.getUserInfoListByPage(req);
		logger.info("===step2:【不分页查询】(UserInfoController-getUserInfoList)-不分页查询用户信息列表, jsonUserInfo:{}", jsonUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonUserInfo.getJSONArray(PageConstants.DATA_LIST));
		List<UserInfoVo> userInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserInfoVo>>(){});

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVoList);
		logger.info("===step3:【不分页查询】(UserInfoController-getUserInfoList)-返回信息, userInfoResponse:{}", userInfoResponse);
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
	@RequestMapping(value="/getUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserInfo(
		@Validated @RequestBody UserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户信息】(UserInfoController-getUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userId = req.getUserId();
		JSONObject jsonUserInfo = userInfoService.getUserInfoById(userId);
		logger.info("===step2:【获取用户信息】(UserInfoController-getUserInfo)-根据userInfoId获取用户信息, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
	    logger.info("===step3:【获取用户信息】(UserInfoController-getUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
	    return userInfoResponse;
	}

	/**
	 * 新增用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户信息")
	@RequestMapping(value="/addUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addUserInfo(
		@Validated @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户信息】(UserInfoController-addUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserInfo = userInfoService.addUserInfo(req);
		logger.info("===step2:【新增用户信息】(UserInfoController-addUserInfo)-分页查询用户信息列表, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
	    logger.info("===step3:【新增用户信息】(UserInfoController-addUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
	    return userInfoResponse;
	}

	/**
	 * 删除用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户信息")
	@RequestMapping(value="/deleteUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserInfo(
		@Validated @RequestBody UserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户信息】(UserInfoController-deleteUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userId = req.getUserId();
		JSONObject jsonUserInfo = userInfoService.deleteUserInfoById(userId);
		logger.info("===step2:【删除用户信息】(UserInfoController-deleteUserInfo)-根据userInfoId删除用户信息, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
		logger.info("===step3:【删除用户信息】(UserInfoController-deleteUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 修改用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户信息")
	@RequestMapping(value="/updateUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateUserInfo(
		@Validated({ UpdateGroup.class }) @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户信息】(UserInfoController-updateUserInfo)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserInfo = userInfoService.addUserInfo(req);
		logger.info("===step2:【修改用户信息】(UserInfoController-updateUserInfo)-修改用户信息, jsonUserInfo:{}", jsonUserInfo);
		UserInfoVo userInfoVo = JSONObject.toJavaObject(jsonUserInfo, UserInfoVo.class);

		//返回信息
		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(RetSafeConstants.RESULT, userInfoVo);
		logger.info("===step3:【修改用户信息】(UserInfoController-updateUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

}