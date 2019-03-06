package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IDiamondConfigService;

/**
 * 能量配置 DiamondConfigService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class DiamondConfigServiceImpl extends BaseService implements IDiamondConfigService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取能量列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDiamondList(Map<String, Object> params) {
		logger.info("(DiamondService-getDiamondList)-获取能量列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondConfig+"/selectDiamondList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据diamondCode获取能量配置
	 * @param diamondCode
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDiamondConfigByCode(String diamondCode) {
		logger.info("(DiamondConfigService-getDiamondConfigByCode)-根据diamondCode获取能量配置-传入参数, diamondCode:{}", diamondCode);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondConfig+"/selectDiamondConfigByCode/"+diamondCode, httpEntity, JSONObject.class);
		return response;
	}

}