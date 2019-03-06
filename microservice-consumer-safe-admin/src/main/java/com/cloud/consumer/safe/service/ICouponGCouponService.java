package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface ICouponGCouponService {

	/**
	 * 根据couponId查询优惠券关联
	 * @param couponId
	 * @return JSONObject
	 */
	public JSONObject getCouponGCouponById(Integer couponGCouponId);

	/**
	 * 根据couponId查询优惠券关联
	 * @param couponId
	 * @return JSONObject
	 */
	public JSONObject getCouponGCouponByCouponId(Integer couponId);

	/**
	 * 根据gCouponId查询优惠券关联
	 * @param gCouponId
	 * @return JSONObject
	 */
	public JSONObject getCouponGCouponByGCouponId(String gCouponId);

}