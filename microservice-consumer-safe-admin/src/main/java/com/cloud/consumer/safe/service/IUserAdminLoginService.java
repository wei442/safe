package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserAdminLoginService {

	/**
	 * 分页获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAdminLoginListByPage(Map<String, Object> params);

	/**
	 * 获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAdminLoginList(Map<String, Object> params);

	/**
	 * 根据id获取用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserAdminLoginById(Integer id);

	/**
	 * 新增用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserAdminLogin(Map<String, Object> params);

	/**
	 * 根据id删除用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserAdminLoginById(Integer id);

	/**
	 * 修改用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserAdminLogin(Map<String, Object> params);

}