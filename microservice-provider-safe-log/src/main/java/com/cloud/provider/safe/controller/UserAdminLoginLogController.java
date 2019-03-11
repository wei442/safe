package com.cloud.provider.safe.controller;

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
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.UserAdminLoginLog;
import com.cloud.provider.safe.rest.request.UserAdminLoginLogRequest;
import com.cloud.provider.safe.rest.request.page.UserAdminLoginLogPageRequest;
import com.cloud.provider.safe.service.IUserAdminLoginLogService;
import com.cloud.provider.safe.vo.UserAdminLoginLogVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理登录日志 UserAdminLoginLogController
 * @author wei.yong
 */
@Api(tags = "用户管理登录日志")
@RestController
@RequestMapping(value="/base/userLoginLog")
public class UserAdminLoginLogController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理登录日志 Service
	@Autowired
	private IUserAdminLoginLogService userAdminLoginLogService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理登录日志列表")
	@RequestMapping(value="/selectUserAdminLoginLogListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminLoginLogListByPage(
		@RequestBody UserAdminLoginLogPageRequest req) {
		logger.info("===step1:【分页查询用户管理登录日志列表】(UserAdminLoginLogController-selectUserAdminLoginLogListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAdminLoginLog> list = userAdminLoginLogService.selectUserAdminLoginLogListByPage(page, req);
		logger.info("===step2:【分页查询用户管理登录日志列表】(UserAdminLoginLogController-selectUserAdminLoginLogListByPage)-分页查询用户管理登录日志列表, list.size:{}", list == null ? null : list.size());
		List<UserAdminLoginLogVo> userAdminLoginLogVoList = new UserAdminLoginLogVo().convertToUserAdminLoginLogVoList(list);

		BaseRestMapResponse userAdminLoginLogResponse = new BaseRestMapResponse();
		userAdminLoginLogResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userAdminLoginLogVoList));
		logger.info("===step3:【分页查询用户管理登录日志列表】(UserAdminLoginLogController-selectUserAdminLoginLogListByPage)-返回信息, userAdminLoginLogResponse:{}", userAdminLoginLogResponse);
		return userAdminLoginLogResponse;
	}

	/**
	 * 添加用户管理登录日志
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理登录日志")
	@RequestMapping(value="/insertUserAdminLoginLog",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserAdminLoginLog(
		@Validated @RequestBody UserAdminLoginLogRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理登录日志】(UserAdminLoginLogController-insertUserAdminLoginLog)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserAdminLoginLog userAdminLoginLog = req.convertToUserAdminLoginLog();
		int i = userAdminLoginLogService.insertUserAdminLoginLog(userAdminLoginLog);
		logger.info("===step2:【添加用户管理登录日志】(UserAdminLoginLogController-insertUserAdminLoginLog)-插入用户管理登录日志, i:{}", i);

		BaseRestMapResponse userAdminLoginLogResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户管理登录日志】(UserAdminLoginLogController-insertUserAdminLoginLog)-返回信息, userAdminLoginLogResponse:{}", userAdminLoginLogResponse);
		return userAdminLoginLogResponse;
	}

}