package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserAppLoginService {

	/**
	 * 分页获取用户应用登录列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAppLoginListByPage(Object params);

	/**
	 * 获取用户应用登录列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserAppLoginList(Object params);

	/**
	 * 根据id获取用户应用登录
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserAppLoginById(Integer id);

	/**
	 * 新增用户应用登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserAppLogin(Object params);

	/**
	 * 根据id删除用户应用登录
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserAppLoginById(Integer id);

	/**
	 * 修改用户应用登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserAppLogin(Object params);

}