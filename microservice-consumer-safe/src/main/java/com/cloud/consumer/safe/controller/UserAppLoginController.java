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
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.page.user.UserAppLoginPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserAppLoginIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserAppLoginRequest;
import com.cloud.consumer.safe.service.IUserAppLoginService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserAppLoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户应用登录管理 UserAppLoginController
 * @author wei.yong
 * @ClassName: UserAppLoginController
 */
@Api(tags = "用户应用登录")
@RestController
@RequestMapping("/user/app/login")
public class UserAppLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用登录 Service
	@Autowired
	private IUserAppLoginService userAppLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户应用登录列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserAppLoginPageRequest req) {
		logger.info("===step1:【分页查询】(UserAppLoginController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppLogin = userAppLoginService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserAppLoginController-getListByPage)-分页查询用户应用登录列表, jsonUserAppLogin:{}", jsonUserAppLogin);
		String dataListStr = JSONObject.toJSONString(jsonUserAppLogin.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserAppLogin.getJSONObject(PageConstants.PAGE));
		List<UserAppLoginVo> userAppLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserAppLoginVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userAppLoginVoList);
		//返回信息
		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserAppLoginController-getListByPage)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
	    return userAppLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户应用登录列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserAppLoginPageRequest req) {
		logger.info("===step1:【不分页查询】(UserAppLoginController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppLogin = userAppLoginService.getListByPage(req);
		logger.info("===step2:【不分页查询】(UserAppLoginController-getList)-不分页查询用户应用登录列表, jsonUserAppLogin:{}", jsonUserAppLogin);
		String dataListStr = JSONObject.toJSONString(jsonUserAppLogin.getJSONArray(PageConstants.DATA_LIST));
		List<UserAppLoginVo> userAppLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserAppLoginVo>>(){});

		BaseResultVo result = new BaseResultVo(userAppLoginVoList);
		//返回信息
		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserAppLoginController-getList)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 获取用户应用登录详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户应用登录详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody UserAppLoginIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户应用登录】(UserAppLoginController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAppLoginId = req.getUserAppLoginId();
		JSONObject jsonUserAppLogin = userAppLoginService.getById(userAppLoginId);
		logger.info("===step2:【获取用户应用登录】(UserAppLoginController-get)-根据userAppLoginId获取用户应用登录, jsonUserAppLogin:{}", jsonUserAppLogin);
		UserAppLoginVo userAppLoginVo = JSONObject.toJavaObject(jsonUserAppLogin, UserAppLoginVo.class);

		//返回信息
		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(CommConstants.RESULT, userAppLoginVo);
	    logger.info("===step3:【获取用户应用登录】(UserAppLoginController-get)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
	    return userAppLoginResponse;
	}

	/**
	 * 新增用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户应用登录")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserAppLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户应用登录】(UserAppLoginController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppLogin = userAppLoginService.add(req);
		logger.info("===step2:【新增用户应用登录】(UserAppLoginController-add)-分页查询用户应用登录列表, jsonUserAppLogin:{}", jsonUserAppLogin);
		UserAppLoginVo userAppLoginVo = JSONObject.toJavaObject(jsonUserAppLogin, UserAppLoginVo.class);

		//返回信息
		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(CommConstants.RESULT, userAppLoginVo);
	    logger.info("===step3:【新增用户应用登录】(UserAppLoginController-add)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
	    return userAppLoginResponse;
	}

	/**
	 * 删除用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户应用登录")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserAppLoginIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户应用登录】(UserAppLoginController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAppLoginId = req.getUserAppLoginId();
		JSONObject jsonUserAppLogin = userAppLoginService.deleteById(userAppLoginId);
		logger.info("===step2:【删除用户应用登录】(UserAppLoginController-delete)-根据userAppLoginId删除用户应用登录, jsonUserAppLogin:{}", jsonUserAppLogin);
		UserAppLoginVo userAppLoginVo = JSONObject.toJavaObject(jsonUserAppLogin, UserAppLoginVo.class);

		//返回信息
		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(CommConstants.RESULT, userAppLoginVo);
		logger.info("===step3:【删除用户应用登录】(UserAppLoginController-delete)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 修改用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户应用登录")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserAppLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户应用登录】(UserAppLoginController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAppLogin = userAppLoginService.update(req);
		logger.info("===step2:【修改用户应用登录】(UserAppLoginController-update)-修改用户应用登录, jsonUserAppLogin:{}", jsonUserAppLogin);
		UserAppLoginVo userAppLoginVo = JSONObject.toJavaObject(jsonUserAppLogin, UserAppLoginVo.class);

		//返回信息
		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(CommConstants.RESULT, userAppLoginVo);
		logger.info("===step3:【修改用户应用登录】(UserAppLoginController-update)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

}