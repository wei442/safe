package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IAccountLogService {

	/**
	 * 获取分页账户日志列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getAccountLogListByPage(Map<String, Object> params);

	/**
	 * 新增账户日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addAccountLog(Map<String, Object> params);

}