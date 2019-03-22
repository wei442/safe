package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserService {

	/**
	 * 用户登录第一步
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject loginFirst(Object params);

	/**
	 * 用户登录第二步
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject loginSecond(Object params);

	/**
	 * 用户登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject login(Object params);

	/**
	 * 新增用户企业
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserEnterprise(Object params);

}