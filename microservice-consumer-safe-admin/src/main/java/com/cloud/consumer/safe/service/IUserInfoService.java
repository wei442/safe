package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserInfoService {

	/**
	 * 分页获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserInfoListByPage(Map<String, Object> params);

	/**
	 * 获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserInfoList(Map<String, Object> params);

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserInfoById(Integer id);

	/**
	 * 新增用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserInfo(Map<String, Object> params);

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserInfoById(Integer id);

	/**
	 * 修改用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserInfo(Map<String, Object> params);

}