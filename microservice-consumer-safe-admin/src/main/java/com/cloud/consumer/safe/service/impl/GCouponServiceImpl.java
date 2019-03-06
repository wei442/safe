package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IGCouponService;

@Service
public class GCouponServiceImpl extends BaseService implements IGCouponService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据couponId查询gofun优惠券
	 * @param gCouponId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getGCouponById(String gCouponId) {
		logger.info("(GCouponService-getGCouponById)-根据couponId查询gofun优惠券-传入参数, gCouponId:{}", gCouponId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_gCoupon+"/selectGCouponById/"+gCouponId, httpEntity, JSONObject.class);
		return response;
	}

}