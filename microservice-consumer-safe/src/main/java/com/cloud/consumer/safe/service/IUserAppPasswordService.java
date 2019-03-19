package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserAppPasswordService {

	/**
	 * 根据id获取用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 根据userId和password获取用户应用密码
	 * @param userId
	 * @param password
	 * @return JSONObject
	 */
	public JSONObject getByUserIdPassword(Integer userId,String password);

	/**
	 * 新增用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}