package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserTitleService {

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserTitleListByPage(Object params);

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserTitleList(Object params);

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
	public JSONObject addUserTitle(Object params);

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
	public JSONObject updateUserTitle(Object params);

}