package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserAdminService {

	/**
	 * 分页获取用户管理列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAdminListByPage(Object params);

	/**
	 * 获取用户管理列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAdminList(Object params);

	/**
	 * 根据id获取用户管理
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserAdminById(Integer id);

	/**
	 * 新增用户管理
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserAdmin(Object params);

	/**
	 * 根据id删除用户管理
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserAdminById(Integer id);

	/**
	 * 修改用户管理
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserAdmin(Object params);

}