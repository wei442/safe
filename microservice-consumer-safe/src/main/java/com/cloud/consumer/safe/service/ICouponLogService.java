package com.ochain.consumer.wheel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface ICouponLogService {

	/**
	 * 新增优惠券日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addCouponLog(Map<String, Object> params);

}