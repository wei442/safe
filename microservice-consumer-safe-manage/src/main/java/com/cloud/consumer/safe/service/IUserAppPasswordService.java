package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserAppPasswordService {

	/**
	 * 根据id获取用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserAppPasswordById(Integer id);

	/**
	 * 根据userId获取用户应用密码
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getUserAppPasswordByUserId(Integer userId);

	/**
	 * 新增用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserAppPassword(Object params);

	/**
	 * 根据id删除用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserAppPasswordById(Integer id);

	/**
	 * 修改用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserAppPassword(Object params);

}