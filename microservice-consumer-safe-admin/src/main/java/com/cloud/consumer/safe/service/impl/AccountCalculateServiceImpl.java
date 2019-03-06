package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IAccountCalculateService;

/**
 * 账户算力 AccountCalculateService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class AccountCalculateServiceImpl extends BaseService implements IAccountCalculateService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据id获取账户算力
	 * @param accountCalculateId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAccountCalculateById(Integer accountCalculateId) {
		logger.info("(AccountCalculateService-selectAccountCalculateById)-根据id获取账户算力-传入参数, accountCalculateId:{}", accountCalculateId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_accountCalculate+"/selectAccountCalculateById/"+accountCalculateId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据用户id获取账户算力
	 * @param accountCalculateId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAccountCalculateByUserId(Integer userId) {
		logger.info("(AccountCalculateService-getAccountCalculateByUserId)-根据用户id获取账户算力-传入参数, userId:{}", userId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_accountCalculate+"/selectAccountCalculateByUserId/"+userId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增账户算力
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addAccountCalculate(Map<String, Object> params) {
		logger.info("(AccountCalculateService-addAccountCalculate)-新增账户算力-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_accountCalculate+"/insertAccountCalculate", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改账户算力
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateAccountCalculate(Map<String, Object> params) {
		logger.info("(AccountCalculateService-updateAccountCalculate)-修改账户算力-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_accountCalculate+"/modifyAccountCalculate", httpEntity, JSONObject.class);
		return response;
	}

}