package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.ICalculateRankService;

/**
 * 算力排名 CalculateRankService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class CalculateRankServiceImpl extends BaseService implements ICalculateRankService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取分页算力排名列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCalculateRankContentListByPage(Map<String, Object> params) {
		logger.info("(CalculateRankService-getCalculateRankContentListByPage)-获取分页算力排名列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_calculateRank+"/selectCalculateRankContentListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userAccount获取算力排名
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getCalculateRankByUserAccount(Map<String, Object> params) {
		logger.info("(CalculateRankService-getCalculateRankByUserAccount)-根据userAccount获取算力排名-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_calculateRank+"/selectCalculateRankByUserAccount", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增算力排名
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addCalculateRank(Map<String, Object> params) {
		logger.info("(CalculateRankService-addCalculateRank)-新增算力排名, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_calculateRank+"/insertCalculateRank", httpEntity, JSONObject.class);
		return response;
	}

}