package com.cloud.queue.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserLoginLogService {

	/**
	 * 分页获取基础用户登录日志列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 新增基础用户登录日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

}