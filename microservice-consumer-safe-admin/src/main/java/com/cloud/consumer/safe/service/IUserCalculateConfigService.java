package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserCalculateConfigService {

	/**
	 * 获取用户算力配置列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserCalculateConfigList(Map<String, Object> params);

	/**
	 * 根据userCalculateConfigId获取用户算力配置
	 * @param userCalculateConfigId
	 * @return JSONObject
	 */
	public JSONObject getUserCalculateConfigById(Long userCalculateConfigId);

	/**
	 * 根据userId和calculateCode获取用户算力配置
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserCalculateConfigByUserId(Map<String, Object> params);

	/**
	 * 新增用户算力配置
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserCalculateConfig(Map<String, Object> params);

}