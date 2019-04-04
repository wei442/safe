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
import com.cloud.consumer.safe.rest.request.page.user.UserAdminLoginPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserAdminLoginIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserAdminLoginRequest;
import com.cloud.consumer.safe.service.IUserAdminLoginService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserAdminLoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理登录管理 UserAdminLoginController
 * @author wei.yong
 * @ClassName: UserAdminLoginController
 */
@Api(tags = "用户管理登录")
@RestController
@RequestMapping("/user/adminLogin")
public class UserAdminLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理登录 Service
	@Autowired
	private IUserAdminLoginService userAdminLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理登录列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserAdminLoginPageRequest req) {
		logger.info("===step1:【分页查询】(UserAdminLoginController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAdminLogin = userAdminLoginService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserAdminLoginController-getListByPage)-分页查询用户管理登录列表, jsonUserAdminLogin:{}", jsonUserAdminLogin);
		String dataListStr = JSONObject.toJSONString(jsonUserAdminLogin.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserAdminLogin.getJSONObject(PageConstants.PAGE));
		List<UserAdminLoginVo> userAdminLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserAdminLoginVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userAdminLoginVoList);
		//返回信息
		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserAdminLoginController-getListByPage)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
	    return userAdminLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户管理登录列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserAdminLoginPageRequest req) {
		logger.info("===step1:【不分页查询】(UserAdminLoginController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAdminLogin = userAdminLoginService.getListByPage(req);
		logger.info("===step2:【不分页查询】(UserAdminLoginController-getList)-不分页查询用户管理登录列表, jsonUserAdminLogin:{}", jsonUserAdminLogin);
		String dataListStr = JSONObject.toJSONString(jsonUserAdminLogin.getJSONArray(PageConstants.DATA_LIST));
		List<UserAdminLoginVo> userAdminLoginVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserAdminLoginVo>>(){});

		BaseResultVo result = new BaseResultVo(userAdminLoginVoList);
		//返回信息
		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(RetSafeConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserAdminLoginController-getList)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 获取用户管理登录详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户管理登录详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody UserAdminLoginIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户管理登录】(UserAdminLoginController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminLoginId = req.getUserAdminLoginId();
		JSONObject jsonUserAdminLogin = userAdminLoginService.getById(userAdminLoginId);
		logger.info("===step2:【获取用户管理登录】(UserAdminLoginController-get)-根据userAdminLoginId获取用户管理登录, jsonUserAdminLogin:{}", jsonUserAdminLogin);
		UserAdminLoginVo userAdminLoginVo = JSONObject.toJavaObject(jsonUserAdminLogin, UserAdminLoginVo.class);

		//返回信息
		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(RetSafeConstants.RESULT, userAdminLoginVo);
	    logger.info("===step3:【获取用户管理登录】(UserAdminLoginController-get)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
	    return userAdminLoginResponse;
	}

	/**
	 * 新增用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户管理登录")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserAdminLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户管理登录】(UserAdminLoginController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAdminLogin = userAdminLoginService.add(req);
		logger.info("===step2:【新增用户管理登录】(UserAdminLoginController-add)-分页查询用户管理登录列表, jsonUserAdminLogin:{}", jsonUserAdminLogin);
		UserAdminLoginVo userAdminLoginVo = JSONObject.toJavaObject(jsonUserAdminLogin, UserAdminLoginVo.class);

		//返回信息
		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(RetSafeConstants.RESULT, userAdminLoginVo);
	    logger.info("===step3:【新增用户管理登录】(UserAdminLoginController-add)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
	    return userAdminLoginResponse;
	}

	/**
	 * 删除用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新删除用户管理登录")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserAdminLoginIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户管理登录】(UserAdminLoginController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminLoginId = req.getUserAdminLoginId();
		JSONObject jsonUserAdminLogin = userAdminLoginService.deleteById(userAdminLoginId);
		logger.info("===step2:【删除用户管理登录】(UserAdminLoginController-delete)-根据userAdminLoginId删除用户管理登录, jsonUserAdminLogin:{}", jsonUserAdminLogin);
		UserAdminLoginVo userAdminLoginVo = JSONObject.toJavaObject(jsonUserAdminLogin, UserAdminLoginVo.class);

		//返回信息
		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(RetSafeConstants.RESULT, userAdminLoginVo);
		logger.info("===step3:【删除用户管理登录】(UserAdminLoginController-delete)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 修改用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理登录")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserAdminLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理登录】(UserAdminLoginController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserAdminLogin = userAdminLoginService.update(req);
		logger.info("===step2:【修改用户管理登录】(UserAdminLoginController-update)-修改用户管理登录, jsonUserAdminLogin:{}", jsonUserAdminLogin);
		UserAdminLoginVo userAdminLoginVo = JSONObject.toJavaObject(jsonUserAdminLogin, UserAdminLoginVo.class);

		//返回信息
		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(RetSafeConstants.RESULT, userAdminLoginVo);
		logger.info("===step3:【修改用户管理登录】(UserAdminLoginController-update)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

}