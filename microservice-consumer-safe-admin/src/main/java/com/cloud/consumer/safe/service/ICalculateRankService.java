package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface ICalculateRankService {

	/**
	 * 获取分页算力排名列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getCalculateRankContentListByPage(Map<String, Object> params);

	/**
	 * 根据userAccount获取算力排名
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getCalculateRankByUserAccount(Map<String, Object> params);

	/**
	 * 新增算力排名
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addCalculateRank(Map<String, Object> params);

}