package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IDiamondRankService {

	/**
	 * 获取分页能量排名列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDiamondRankContentListByPage(Map<String, Object> params);

	/**
	 * 根据userAccount获取能量排名
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDiamondRankByUserAccount(Map<String, Object> params);

}