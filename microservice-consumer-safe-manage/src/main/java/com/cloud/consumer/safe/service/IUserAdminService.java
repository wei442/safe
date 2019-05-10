package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserAdminService {

	/**
	 * 分页获取用户管理列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getManageListByPage(Object params);

	/**
	 * 获取用户管理列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getManageList(Object params);

	/**
	 * 根据id获取用户管理
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 获取用户主管理员
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getMaster(Object params);

	/**
	 * 新增用户管理
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除用户管理
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改用户管理
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

	/**
	 * 更改用户主管理员
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject changeMaster(Object params);

}