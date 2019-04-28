package com.cloud.queue.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserSignService {

	/**
	 * 根据userId和signTimeStr获取用户签到
	 * @param userId
	 * @param signTimeStr
	 * @return JSONObject
	 */
	public JSONObject getUserSignByUserId(Integer userId,String signTimeStr);

	/**
	 * 根据userId和signTimeStr获取用户签到天数
	 * @param userId
	 * @param signTimeStr
	 * @return JSONObject
	 */
	public JSONObject getUserSignDaysByUserId(Integer userId,String signTimeStr);

	/**
	 * 根据userId、signTimeStart和signTimeEnd查询条数
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getRowsByUserIdSignTime(Map<String, Object> params);
	/**
	 * 新增用户签到
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserSign(Map<String, Object> params);

}