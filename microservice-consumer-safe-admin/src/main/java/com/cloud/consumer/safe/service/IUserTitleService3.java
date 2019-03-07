package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserTitleService3 {

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserTitleListByPage(Map<String, Object> params);

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserTitleList(Map<String, Object> params);

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserTitleById(Integer id);

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserTitle(Map<String, Object> params);

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserTitleById(Integer id);

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserTitle(Map<String, Object> params);

}