package com.cloud.queue.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserAppLoginLogService {

	/**
	 * 分页获取用户app登录日志列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 新增用户app登录日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

}