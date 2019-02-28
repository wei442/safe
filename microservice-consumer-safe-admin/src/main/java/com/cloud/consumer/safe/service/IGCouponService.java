package com.ochain.consumer.wheel.service;

import com.alibaba.fastjson.JSONObject;

public interface IGCouponService {

	/**
	 * 根据couponId查询gofun优惠券
	 * @param gCouponId
	 * @return JSONObject
	 */
	public JSONObject getGCouponById(String gCouponId);

}