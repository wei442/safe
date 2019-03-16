package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserInfoService {

	/**
	 * 分页获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getBaseUserInfoListByPage(Object params);

	/**
	 * 获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getBaseUserInfoList(Object params);

	/**
	 * 根据id获取基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getBaseUserInfoById(Integer id);

	/**
	 * 新增基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addBaseUserInfo(Object params);

	/**
	 * 根据id删除基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteBaseUserInfoById(Integer id);

	/**
	 * 修改基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateBaseUserInfo(Object params);

}