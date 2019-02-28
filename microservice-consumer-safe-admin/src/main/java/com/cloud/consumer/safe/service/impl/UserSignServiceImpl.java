package com.ochain.consumer.wheel.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.ochain.consumer.wheel.service.IUserSignService;

/**
 * 用户签到 UserSignService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class UserSignServiceImpl extends BaseService implements IUserSignService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据userId和signTimeStr获取用户签到
	 * @param userId
	 * @param signTimeStr
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserSignByUserId(Integer userId,String signTimeStr) {
		logger.info("(UserSignService-getUserSignByUserId)-根据userId和signTimeStr获取用户签到-传入参数, userId:{}, signTimeStr:{}", userId, signTimeStr);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_sign+"/selectUserSignByUserId/"+userId+"/"+signTimeStr, httpEntity, JSONObject.class);
        return response;
    }

	/**
	 * 根据userId和signTimeStr获取用户签到天数
	 * @param userId
	 * @param signTimeStr
	 * @return JSONObject
	 */
	public JSONObject getUserSignDaysByUserId(Integer userId,String signTimeStr) {
		logger.info("(UserSignService-getUserSignDaysByUserId)-根据userId和signTimeStr获取用户签到天数-传入参数, userId:{}, signTimeStr:{}", userId, signTimeStr);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_sign+"/selectUserSignDaysByUserId/"+userId+"/"+signTimeStr, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId、signTimeStart和signTimeEnd查询条数
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getRowsByUserIdSignTime(Map<String, Object> params) {
		logger.info("(UserSignService-getRowsByUserIdSignTime)-根据userId、signTimeStart和signTimeEnd获取用户签到记录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_sign+"/selectRowsByUserIdSignTime", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户签到
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserSign(Map<String, Object> params) {
		logger.info("(UserSignService-addUserSign)-新增用户签到-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user_sign+"/insertUserSign", httpEntity, JSONObject.class);
		return response;
	}

}