package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserService {

	/**
	 * 新增用户
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUser(Object params);

}