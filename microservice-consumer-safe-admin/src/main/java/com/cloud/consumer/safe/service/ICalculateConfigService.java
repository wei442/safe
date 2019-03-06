package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface ICalculateConfigService {

	/**
	 * 获取算力配置列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getCalculateConfigList(Map<String, Object> params);

	/**
	 * 根据calculateCode获取算力配置
	 * @param calculateCode
	 * @return JSONObject
	 */
	public JSONObject getCalculateConfigByCode(String calculateCode);

}