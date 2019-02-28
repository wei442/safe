package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IAccountCalculateLogService {

	/**
	 * 获取分页账户算力日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getAccountCalculateLogListByPage(Map<String, Object> params);

	/**
	 * 新增账户算力日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addAccountCalculateLog(Map<String, Object> params);

}