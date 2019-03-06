package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.ICouponLogService;

@Service
public class CouponLogServiceImpl extends BaseService implements ICouponLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 新增优惠券日志
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addCouponLog(Map<String, Object> params) {
		logger.info("(CouponLogService-addCouponLog)-新增优惠券日志-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_couponLog+"/insertCouponLog", httpEntity, JSONObject.class);
		return response;
	}

}