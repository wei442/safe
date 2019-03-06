package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface ICouponService {

	/**
	 * 获取优惠券列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getCouponList(Map<String, Object> params);

	/**
	 * 根据id获取优惠券
	 * @param couponId
	 * @return JSONObject
	 */
	public JSONObject getCouponById(Integer couponId);

}