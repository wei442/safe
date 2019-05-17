package com.cloud.queue.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeLogUrlConstants;
import com.cloud.queue.safe.service.IUserAppLoginLogService;

/**
 * 用户app登录日志 UserAppLoginLogService (microservice-provider-safe-log)
 * @author wei.yong
 */
@Service
public class UserAppLoginLogServiceImpl extends BaseService implements IUserAppLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户app登录日志列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserAppLoginLogService-getListByPage)-分页获取用户app登录日志列表-传入参数, params:{}", params);
		JSONObject response = this.safeLogPostForObject(SafeLogUrlConstants.user_app_login_log+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户app登录日志
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserAppLoginLogService-add)-新增用户app登录日志-传入参数, params:{}", params);
		JSONObject response = this.safeLogPostForObject(SafeLogUrlConstants.user_app_login_log+"/insert", params, JSONObject.class);
		return response;
	}

}