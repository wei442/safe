package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserService {

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserById(Integer id);

	/**
	 * 根据gId获取用户信息
	 * @param gId
	 * @return JSONObject
	 */
	public JSONObject getUserByGId(String gId);

	/**
	 * 根据userAccount获取用户信息
	 * @param userAccount
	 * @return JSONObject
	 */
	public JSONObject getUserInfoByUserAccount(String userAccount);

	/**
	 * 新增用户
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUser(Map<String, Object> params);

}