package com.cloud.queue.safe.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.queue.safe.service.IAttachmentLogService;
import com.cloud.queue.safe.service.IBaseUserLoginLogService;
import com.cloud.queue.safe.service.IUserAdminLoginLogService;
import com.cloud.queue.safe.service.IUserAppLoginLogService;
import com.cloud.queue.safe.vo.AttachmentLogVo;
import com.cloud.queue.safe.vo.BaseUserLoginLogVo;
import com.cloud.queue.safe.vo.UserAdminLoginLogVo;
import com.cloud.queue.safe.vo.UserAppLoginLogVo;

/**
 * 数据 DataBaseService
 * @author wei.yong
 */
@Service
public class DataBaseService extends BaseService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//附件日志 Service
	@Autowired
	private IAttachmentLogService attachmentLogService;

	//用户管理登录日志 Service
	@Autowired
	private IUserAdminLoginLogService userAdminLoginLogService;

	//用户app登录日志 Service
	@Autowired
	private IUserAppLoginLogService userAppLoginLogService;

	//基础用户登录日志 Service
	@Autowired
	private IBaseUserLoginLogService baseUserLoginLogService;

	/**
	 * 插入附件日志
	 * @param attachmentLogVo
	 * @return boolean
	 */
	public boolean insertAttachmentLog(AttachmentLogVo attachmentLogVo) {
		String attachmentName = attachmentLogVo.getAttachmentName();
	    String attachmentUrl = attachmentLogVo.getAttachmentUrl();
	    Integer attachmentType = attachmentLogVo.getAttachmentType();
	    String content = attachmentLogVo.getContent();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attachmentName", attachmentName);
		params.put("attachmentUrl", attachmentUrl);
		params.put("attachmentType", attachmentType);
		params.put("content", content);
		JSONObject jsonAttachmentLog = attachmentLogService.add(params);
		logger.info("(DataBaseService-insertAttachmentLog)-插入附件日志-返回信息, jsonAttachmentLog:{}", jsonAttachmentLog);
       	return true;
	}

	/**
	 * 插入用户管理登录日志
	 * @param userAdminLoginLogVo
	 * @return boolean
	 */
	public boolean insertUserAdminLoginLog(UserAdminLoginLogVo userAdminLoginLogVo) {
		Integer userId = userAdminLoginLogVo.getUserId();
		String userAccount = userAdminLoginLogVo.getUserAccount();
		String userName = userAdminLoginLogVo.getUserName();
		Integer loginType = userAdminLoginLogVo.getLoginType();
		Date loginTime = userAdminLoginLogVo.getLoginTime();
		Integer logType = userAdminLoginLogVo.getLogType();
		String loginMode = userAdminLoginLogVo.getLoginMode();
		String loginIp = userAdminLoginLogVo.getLoginIp();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("userAccount", userAccount);
		params.put("userName", userName);
		params.put("loginType", loginType);
		params.put("loginTime", loginTime);
		params.put("logType", logType);
		params.put("loginMode", loginMode);
		params.put("loginIp", loginIp);
		JSONObject jsonUserAdminLoginLog = userAdminLoginLogService.add(params);
		logger.info("(DataBaseService-insertUserAdminLoginLog)-插入用管理登录日志-返回信息, jsonUserAdminLoginLog:{}", jsonUserAdminLoginLog);
       	return true;
	}

	/**
	 * 插入用户app登录日志
	 * @param userAppLoginLogVo
	 * @return boolean
	 */
	public boolean insertUserAppLoginLog(UserAppLoginLogVo userAppLoginLogVo) {
		Integer userId = userAppLoginLogVo.getUserId();
		String userAccount = userAppLoginLogVo.getUserAccount();
		String userName = userAppLoginLogVo.getUserName();
		Integer loginType = userAppLoginLogVo.getLoginType();
		Date loginTime = userAppLoginLogVo.getLoginTime();
		Integer logType = userAppLoginLogVo.getLogType();
		String loginMode = userAppLoginLogVo.getLoginMode();
		String loginIp = userAppLoginLogVo.getLoginIp();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("userAccount", userAccount);
		params.put("userName", userName);
		params.put("loginType", loginType);
		params.put("loginTime", loginTime);
		params.put("logType", logType);
		params.put("loginMode", loginMode);
		params.put("loginIp", loginIp);
		JSONObject jsonUserAppLoginLog = userAppLoginLogService.add(params);
		logger.info("(DataBaseService-insertUserAppnLoginLog)-插入用户app登录日志-返回信息, jsonUserAppLoginLog:{}", jsonUserAppLoginLog);
       	return true;
	}


	/**
	 * 插入基础用户登录日志
	 * @param baseUserLoginLogVo
	 * @return boolean
	 */
	public boolean insertBaseUserLoginLog(BaseUserLoginLogVo baseUserLoginLogVo) {
		Integer baseUserId = baseUserLoginLogVo.getBaseUserId();
		String baseUserAccount = baseUserLoginLogVo.getBaseUserAccount();
		String baseUserName = baseUserLoginLogVo.getBaseUserName();
		Integer loginType = baseUserLoginLogVo.getLoginType();
		Date loginTime = baseUserLoginLogVo.getLoginTime();
		String loginMode = baseUserLoginLogVo.getLoginMode();
		String loginIp = baseUserLoginLogVo.getLoginIp();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("baseUserId", baseUserId);
		params.put("baseUserAccount", baseUserAccount);
		params.put("baseUserName", baseUserName);
		params.put("loginType", loginType);
		params.put("loginTime", loginTime);
		params.put("loginMode", loginMode);
		params.put("loginIp", loginIp);
		JSONObject jsonBaseUserLoginLog = baseUserLoginLogService.add(params);
		logger.info("(DataBaseService-jsonBaseUserLoginLog)-插入基础用户登录日志-返回信息, jsonBaseUserLoginLog:{}", jsonBaseUserLoginLog);
       	return true;
	}




}