package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserLoginLogService {

	/**
	 * 新增用户登录日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserLoginLog(Map<String, Object> params);

}
