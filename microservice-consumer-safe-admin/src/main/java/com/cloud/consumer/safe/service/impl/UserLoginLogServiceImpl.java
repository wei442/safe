package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.cloud.consumer.safe.service.IUserLoginLogService;

/**
 * 用户登录日志 UserLoginLogService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class UserLoginLogServiceImpl extends BaseService implements IUserLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 新增用户登录日志
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserLoginLog(Map<String, Object> params) {
		logger.info("(UserLoginLogService-addUserLoginLog)-新增用户登录日志-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_loginLog+"/insertUserLoginLog", httpEntity, JSONObject.class);
        return response;
    }

}