package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserLoginService {

	/**
	 * 分页获取基础用户登录列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getBaseUserLoginListByPage(Map<String, Object> params);

	/**
	 * 获取基础用户登录列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getBaseUserLoginList(Map<String, Object> params);

	/**
	 * 根据id获取基础用户登录
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getBaseUserLoginById(Integer id);

	/**
	 * 新增基础用户登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addBaseUserLogin(Map<String, Object> params);

	/**
	 * 根据id删除基础用户登录
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteBaseUserLoginById(Integer id);

	/**
	 * 修改基础用户登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateBaseUserLogin(Map<String, Object> params);

}