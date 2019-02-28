package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IAccountCalculateService {

	/**
	 * 根据id获取账户算力
	 * @param accountCalculateId
	 * @return JSONObject
	 */
	public JSONObject getAccountCalculateById(Integer accountCalculateId);

	/**
	 * 根据用户id获取账户算力
	 * @param accountCalculateId
	 * @return JSONObject
	 */
	public JSONObject getAccountCalculateByUserId(Integer userId);

	/**
	 * 新增账户算力
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addAccountCalculate(Map<String, Object> params);

	/**
	 * 修改账户算力
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateAccountCalculate(Map<String, Object> params);

}