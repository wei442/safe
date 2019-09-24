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
import com.cloud.common.constants.PageConstants;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.UserAppLoginLog;
import com.cloud.provider.safe.rest.request.UserAppLoginLogRequest;
import com.cloud.provider.safe.rest.request.page.UserAppLoginLogPageRequest;
import com.cloud.provider.safe.service.IUserAppLoginLogService;
import com.cloud.provider.safe.vo.UserAppLoginLogVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户应用登录日志 UserAppLoginLogController
 * @author wei.yong
 */
@Api(tags = "用户应用登录日志")
@RestController
@RequestMapping(value="/user/app/login/log")
public class UserAppLoginLogController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用登录日志 Service
	@Autowired
	private IUserAppLoginLogService userAppLoginLogService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户应用登录日志列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserAppLoginLogPageRequest req) {
		logger.info("===step1:【分页查询用户应用登录日志列表】(UserAppLoginLogController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAppLoginLog> list = userAppLoginLogService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户应用登录日志列表】(UserAppLoginLogController-selectListByPage)-分页查询用户应用登录日志列表, list.size:{}", list == null ? null : list.size());
		List<UserAppLoginLogVo> dataList = new UserAppLoginLogVo().convertToUserAppLoginLogVoList(list);

		BaseRestMapResponse userAppLoginLogResponse = new BaseRestMapResponse();
		userAppLoginLogResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		userAppLoginLogResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询用户应用登录日志列表】(UserAppLoginLogController-selectListByPage)-返回信息, userAppLoginLogResponse:{}", userAppLoginLogResponse);
		return userAppLoginLogResponse;
	}

	/**
	 * 添加用户应用登录日志
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户应用登录日志")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAppLoginLogRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户应用登录日志】(UserAppLoginLogController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserAppLoginLog userAppLoginLog = req.convertToUserAppLoginLog();
		int i = userAppLoginLogService.insert(userAppLoginLog);
		logger.info("===step2:【添加用户应用登录日志】(UserAppLoginLogController-insert)-插入用户应用登录日志, i:{}", i);

		BaseRestMapResponse userAppLoginLogResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户应用登录日志】(UserAppLoginLogController-insert)-返回信息, userAppLoginLogResponse:{}", userAppLoginLogResponse);
		return userAppLoginLogResponse;
	}

}