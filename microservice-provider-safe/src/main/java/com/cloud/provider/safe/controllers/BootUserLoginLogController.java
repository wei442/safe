package com.ochain.provider.wheel.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.UserLoginLog;
import com.ochain.provider.wheel.rest.request.user.UserLoginLogRequest;
import com.ochain.provider.wheel.service.IBootUserLoginLogService;

/**
 * 用户登录日志 BootUserLoginLogController
 * @author wei.yong
 * @date 2017/08/13
 */
@RestController
@RequestMapping("/boot/user/loginLog")
public class BootUserLoginLogController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户登录日志 Service
	@Autowired
	private IBootUserLoginLogService userLoginLogService;

	/**
	 * 插入用户登录日志
	 * @param req
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertUserLoginLog",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUserLoginLog(
		@RequestBody UserLoginLogRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入用户登录日志】(BootUserLoginLogController-insertUserLoginLog)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String loginIp = req.getLoginIp();
		Date loginTime = req.getLoginTime();
		Integer loginType = req.getLoginType();
		Integer logType = req.getLogType();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "用户userId为空");
		}

		//创建注册日志表
		UserLoginLog userLoginLog = new UserLoginLog();
		userLoginLog.setUserId(userId);
		userLoginLog.setLoginType(loginType);
		userLoginLog.setLogType(logType);
		userLoginLog.setLoginIp(loginIp);
		userLoginLog.setLoginTime(loginTime);
		int i = 0;
		try {
			i = userLoginLogService.insertUserLoginLog(userLoginLog);
			logger.info("===step2:【插入用户登录日志】(BootUserLoginLogController-insertUserLoginLog)-插入用户登录日志-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入用户登录日志】(BootUserLoginLogController-insertUserLoginLog)-插入用户登录日志-异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse bootRestResponse = new BootRestMapResponse();
		logger.info("===step3:【插入用户登录日志】(BootUserLoginLogController-insertUserLoginLog)-返回信息, bootRestResponse:{}",bootRestResponse);
		return bootRestResponse;
	}

}