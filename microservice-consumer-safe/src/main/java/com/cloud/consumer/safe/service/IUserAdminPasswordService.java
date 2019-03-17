package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserAdminPasswordService {

	/**
	 * 根据id获取用户管理密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserAdminPasswordById(Integer id);

	/**
	 * 根据userId获取用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAdminPasswordByUserId(Object params);

	/**
	 * 新增用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserAdminPassword(Object params);

	/**
	 * 根据id删除用户管理密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserAdminPasswordById(Integer id);

	/**
	 * 修改用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserAdminPassword(Object params);

}