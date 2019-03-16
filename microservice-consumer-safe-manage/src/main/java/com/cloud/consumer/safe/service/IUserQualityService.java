package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserQualityService {

	/**
	 * 分页获取用户资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserQualityListByPage(Object params);

	/**
	 * 获取用户资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserQualityList(Object params);

	/**
	 * 根据id获取用户资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserQualityById(Integer id);

	/**
	 * 新增用户资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserQuality(Object params);

	/**
	 * 根据id删除用户资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserQualityById(Integer id);

	/**
	 * 修改用户资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserQuality(Object params);

}