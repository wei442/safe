package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IDiamondRecordService {

	/**
	 * 获取3天的获取能量列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDiamondRecordListByThreeDays(Map<String, Object> params);

	/**
	 * 根据id获取能量记录
	 * @param diamondRecordId
	 * @return JSONObject
	 */
	public JSONObject getDiamondRecordById(Long diamondRecordId);

	/**
	 * 领取能量方块
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject drawDiamondRecord(Map<String, Object> params);

	/**
	 * 新增能量记录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addDiamondRecord(Map<String, Object> params);

	/**
	 * 新增固定能量记录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addFixDiamondRecord(Map<String, Object> params);

}