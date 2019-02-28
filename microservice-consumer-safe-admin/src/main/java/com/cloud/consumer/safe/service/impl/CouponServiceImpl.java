package com.ochain.consumer.wheel.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.ochain.consumer.wheel.service.ICouponService;

@Service
public class CouponServiceImpl extends BaseService implements ICouponService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取优惠券列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCouponList(Map<String, Object> params) {
		logger.info("(CouponService-getCouponList)-获取优惠券列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_coupon+"/selectCouponList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取优惠券
	 * @param couponId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCouponById(Integer couponId) {
		logger.info("(CouponService-getCouponById)-根据id获取优惠券-传入参数, accountId:{}", couponId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_coupon+"/selectCouponById/"+couponId, httpEntity, JSONObject.class);
		return response;
	}

}