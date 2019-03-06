package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IAccountService;

/**
 * 账户 AccountService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class AccountServiceImpl extends BaseService implements IAccountService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据id获取账户
	 * @param accountId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAccountById(Integer accountId) {
		logger.info("(AccountService-selectAccountById)-根据id获取账户-传入参数, accountId:{}", accountId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_account+"/selectAccountById/"+accountId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取账户
	 * @param accountId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAccountByUserId(Integer userId) {
		logger.info("(AccountService-getAccountByUserId)-根据userId获取账户-传入参数, userId:{}", userId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_account+"/selectAccountByUserId/"+userId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改账户余额
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateAccountBalance(Map<String, Object> params) {
		logger.info("(AccountService-updateAccountBalance)-修改账户余额-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_account+"/modifyAccountBalance", httpEntity, JSONObject.class);
		return response;
	}

}