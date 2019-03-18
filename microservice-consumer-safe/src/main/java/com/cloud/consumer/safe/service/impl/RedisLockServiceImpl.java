package com.cloud.consumer.safe.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.HttpUrlConstants;
import com.cloud.consumer.safe.service.IRedisLockService;

/**
 * redis lock Service (microservice-provider-redis)
 * @author wei.yong
 */
@Service
public class RedisLockServiceImpl extends BaseService implements IRedisLockService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 锁定
	 * @param key
	 * @return boolean
	 */
	@Override
	public boolean lock(String key) {
		logger.info("(RedisLockService-lock)-锁定-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/redis/distributedLock/lock", httpEntity, JSONObject.class);
		logger.info("(RedisLockService-lock)-锁定-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String retCode = Objects.toString(response.get("retCode"), "");
		boolean result = false;
		if (StringUtils.equals(retCode, "0000000")) {
			result = response.getBooleanValue("result");
		}
		return result;
    }

	/**
	 * 解锁
	 * @param key
	 * @return boolean
	 */
	@Override
	public boolean unlock(String key) {
		logger.info("(RedisLockService-unlock)-解锁-传入参数, key:{}", key);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		HttpHeaders headers = this.getProviderRedisHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_REDIS+"/redis/distributedLock/unlock", httpEntity, JSONObject.class);
		logger.info("(RedisLockService-unlock)-解锁-boot返回信息, response:{}", JSONObject.toJSONString(response));
		String retCode = Objects.toString(response.get("retCode"), "");
		boolean result = false;
		if (StringUtils.equals(retCode, "0000000")) {
			result = response.getBooleanValue("result");
		}
		return result;
	}

}