package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IAccountService {

	/**
	 * 根据id获取账户
	 * @param accountId
	 * @return JSONObject
	 */
	public JSONObject getAccountById(Integer accountId);

	/**
	 * 根据用户id获取账户
	 * @param accountId
	 * @return JSONObject
	 */
	public JSONObject getAccountByUserId(Integer userId);

	/**
	 * 修改账户余额
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateAccountBalance(Map<String, Object> params);

}