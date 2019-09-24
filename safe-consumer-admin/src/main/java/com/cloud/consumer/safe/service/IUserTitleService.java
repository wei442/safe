package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserTitleService {

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 根据userId获取用户职务
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getByUserId(Integer userId);

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 新增批量用户职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addList(Object params);

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 批量删除用户职务
	 * @param ids
	 * @return JSONObject
	 */
	public JSONObject batchDelete(Object params);

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}