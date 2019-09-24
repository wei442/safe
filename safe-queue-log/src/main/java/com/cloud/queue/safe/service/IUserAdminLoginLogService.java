package com.cloud.queue.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserAdminLoginLogService {

	/**
	 * 分页获取用户管理登录日志列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 新增用户管理登录日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

}