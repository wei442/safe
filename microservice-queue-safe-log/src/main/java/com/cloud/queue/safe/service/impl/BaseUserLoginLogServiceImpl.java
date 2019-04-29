package com.cloud.queue.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.queue.safe.service.IBaseUserLoginLogService;

/**
 * 基础用户登录日志 BaseUserLoginLogService (microservice-provider-safe-log)
 * @author wei.yong
 */
@Service
public class BaseUserLoginLogServiceImpl extends BaseService implements IBaseUserLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取基础用户登录日志列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(BaseUserLoginLogService-getListByPage)-分页获取基础用户登录日志列表-传入参数, params:{}", params);
		JSONObject response = this.safeLogPostForObject(SafeUrlConstants.attachment_log+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户登录日志
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(BaseUserLoginLogService-add)-新增基础用户登录日志-传入参数, params:{}", params);
		JSONObject response = this.safeLogPostForObject(SafeUrlConstants.attachment_log+"/insert", params, JSONObject.class);
		return response;
	}

}