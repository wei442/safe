package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IDiamondRankService;

/**
 * 能量排名 DiamondRankService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class DiamondRankServiceImpl extends BaseService implements IDiamondRankService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取分页能量排名列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDiamondRankContentListByPage(Map<String, Object> params) {
		logger.info("(DiamondRankService-getDiamondRankContentListByPage)-获取分页能量排名列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRank+"/selectDiamondRankContentListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userAccount获取能量排名
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDiamondRankByUserAccount(Map<String, Object> params) {
		logger.info("(DiamondRankService-getDiamondRankByUserAccount)-根据userAccount获取能量排名-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_diamondRank+"/selectDiamondRankByUserAccount", httpEntity, JSONObject.class);
		return response;
	}

}