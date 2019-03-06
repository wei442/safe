package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IAccountLogService;

/**
 * 账户日志 Service (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class AccountLogServiceImpl extends BaseService implements IAccountLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取分页账户日志列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAccountLogListByPage(Map<String, Object> params) {
		logger.info("(AccountLogService-getAccountLogListByPage)-获取分页账户日志列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_accountLog+"/selectAccountLogListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增账户日志
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addAccountLog(Map<String, Object> params) {
		logger.info("(AccountLogService-addAccountLog)-新增账户日志-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_accountLog+"/insertAccountLog", httpEntity, JSONObject.class);
		return response;
	}


}