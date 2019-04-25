package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserService {

	/**
	 * 用户登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject login(Object params);

}