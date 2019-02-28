package com.ochain.consumer.wheel.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.ochain.consumer.wheel.service.ICalculateConfigService;

/**
 * 算力配置 CalculateConfigService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class CalculateConfigServiceImpl extends BaseService implements ICalculateConfigService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取算力配置列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCalculateConfigList(Map<String, Object> params) {
		logger.info("(CalculateService-getCalculateConfigList)-获取算力配置列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_calculateConfig+"/selectCalculateConfigList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据calculateCode获取算力配置
	 * @param calculateCode
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCalculateConfigByCode(String calculateCode) {
		logger.info("(CalculateConfigService-getCalculateConfigByCode)-根据calculateCode获取算力配置-传入参数, calculateCode:{}", calculateCode);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_calculateConfig+"/selectCalculateConfigByCode/"+calculateCode, httpEntity, JSONObject.class);
		return response;
	}

}