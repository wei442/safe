package com.ochain.consumer.wheel.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.ochain.consumer.wheel.service.IUserCalculateConfigService;

/**
 * 用户能量配置 UserCalculateConfigService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class UserCalculateConfigServiceImpl extends BaseService implements IUserCalculateConfigService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取用户算力配置列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserCalculateConfigList(Map<String, Object> params) {
		logger.info("(UserCalculateConfigService-getUserCalculateConfigList)-获取用户算力配置列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_calculateConfig+"/selectUserCalculateConfigListByUserId", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userCalculateConfigId获取用户算力配置
	 * @param userCalculateConfigId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserCalculateConfigById(Long userCalculateConfigId) {
		logger.info("(UserCalculateConfigService-getUserCalculateConfigById)-根据userCalculateConfigId获取用户算力配置-传入参数, userCalculateConfigId:{}", userCalculateConfigId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_calculateConfig+"/selectUserCalculateConfigById/"+userCalculateConfigId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId和calculateCode获取用户算力配置
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserCalculateConfigByUserId(Map<String, Object> params) {
		logger.info("(UserCalculateConfigService-getUserCalculateConfigByUserId)-根据userId和calculateCode获取用户算力配置-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_calculateConfig+"/selectUserCalculateConfigByUserId", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户算力配置
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserCalculateConfig(Map<String, Object> params) {
		logger.info("(UserCalculateConfigService-addUserCalculateConfig)-新增用户算力配置-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_calculateConfig+"/insertUserCalculateConfig", httpEntity, JSONObject.class);
        return response;
    }

}