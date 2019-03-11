package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserService {

	/**
	 * 分页获取基础用户列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getBaseUserListByPage(Object params);

	/**
	 * 获取基础用户列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getBaseUserList(Object params);

	/**
	 * 根据id获取基础用户
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getBaseUserById(Integer id);

	/**
	 * 新增基础用户
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addBaseUser(Object params);

	/**
	 * 根据id删除基础用户
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteBaseUserById(Integer id);

	/**
	 * 修改基础用户
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateBaseUser(Object params);

}