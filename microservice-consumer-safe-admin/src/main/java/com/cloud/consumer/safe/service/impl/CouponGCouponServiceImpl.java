package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.ICouponGCouponService;

@Service
public class CouponGCouponServiceImpl extends BaseService implements ICouponGCouponService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据couponId查询优惠券关联
	 * @param couponId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCouponGCouponById(Integer couponGCouponId) {
		logger.info("(CouponGCouponService-getCouponGCouponById)-根据couponGCouponId查询优惠券关联-传入参数, couponGCouponId:{}", couponGCouponId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_couponGCoupon+"/selectCouponGCouponById/"+couponGCouponId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据couponId查询优惠券关联
	 * @param couponId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCouponGCouponByCouponId(Integer couponId) {
		logger.info("(CouponGCouponService-getCouponGCouponByCouponId)-根据couponId查询优惠券关联-传入参数, couponId:{}", couponId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_couponGCoupon+"/selectCouponGCouponByCouponId/"+couponId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据gCouponId查询优惠券关联
	 * @param gCouponId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCouponGCouponByGCouponId(String gCouponId) {
		logger.info("(CouponGCouponService-getCouponGCouponByGCouponId)-根据gCouponId查询优惠券关联-传入参数, gCouponId:{}", gCouponId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_couponGCoupon+"/selectCouponGCouponByGCouponId/"+gCouponId, httpEntity, JSONObject.class);
		return response;
	}

}