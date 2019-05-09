package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserService {

	/**
	 * 新增用户管理
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addAdminUser(Object params);

	/**
	 * 用户管理登录第一步
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject loginAdminFirst(Object params);

	/**
	 * 用户管理登录第二步
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject loginAdminSecond(Object params);

	/**
	 * 修改用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateAdminPassword(Object params);

	/**
	 * 重置用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject resetAdminPassword(Object params);

}