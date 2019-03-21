package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserInfoService {

	/**
	 * 分页获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 根据userAccount获取用户信息
	 * @param userAccount
	 * @return JSONObject
	 */
	public JSONObject getByUserAccount(String userAccount);

	/**
	 * 新增用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}