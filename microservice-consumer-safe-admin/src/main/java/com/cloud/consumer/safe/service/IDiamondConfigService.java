package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IDiamondConfigService {

	/**
	 * 获取能量列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDiamondList(Map<String, Object> params);

	/**
	 * 根据diamondCode获取能量配置
	 * @param diamondCode
	 * @return JSONObject
	 */
	public JSONObject getDiamondConfigByCode(String diamondCode);

}