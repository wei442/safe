package com.ochain.consumer.wheel.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.ochain.consumer.wheel.service.IDiamondRecordService;

/**
 * 能量记录 DiamondRecordService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class DiamondRecordServiceImpl extends BaseService implements IDiamondRecordService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取3天的获取能量列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDiamondRecordListByThreeDays(Map<String, Object> params) {
		logger.info("(DiamondService-getDiamondList)-获取3天的获取能量列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRecord+"/selectDiamondRecordListByThreeDays", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取能量记录
	 * @param diamondRecordId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDiamondRecordById(Long diamondRecordId) {
		logger.info("(DiamondRecordService-getDiamondRecordById)-根据id获取能量记录-传入参数, diamondRecordId:{}", diamondRecordId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRecord+"/selectDiamondRecordById/"+diamondRecordId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 领取能量方块
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject drawDiamondRecord(Map<String, Object> params) {
		logger.info("(DiamondService-drawDiamond)-领取能量方块-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRecord+"/drawDiamondRecord", httpEntity, JSONObject.class);
		return response;
	}


	/**
	 * 新增能量记录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addDiamondRecord(Map<String, Object> params) {
		logger.info("(DiamondRecordService-addDiamondRecord)-新增能量记录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRecord+"/insertDiamondRecord", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增固定能量记录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addFixDiamondRecord(Map<String, Object> params) {
		logger.info("(DiamondRecordService-addFixDiamondRecord)-新增固定能量记录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRecord+"/insertFixDiamondRecord", httpEntity, JSONObject.class);
		return response;
	}

}