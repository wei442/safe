package com.ochain.consumer.wheel.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetHttpUrlConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.consumer.wheel.service.IUserService;

/**
 * 用户 UserService (microservice-provider-wheel)
 * @author wei.yong
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserById(Integer id) {
		logger.info("(UserService-getUserById)-根据id获取用户信息-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user+"/selectUserById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据gId获取用户信息
	 * @param gId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserByGId(String gId) {
		logger.info("(UserService-getUserByGId)-根据gId获取用户信息-传入参数, gId:{}", gId);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user+"/selectUserByGId/"+gId, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据userAccount获取用户信息
	 * @param userAccount
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserInfoByUserAccount(String userAccount) {
		logger.info("(UserService-getUserInfoByUserAccount)-根据userAccount获取用户信息-传入参数, userAccount:{}", userAccount);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user+"/selectUserByUserAccount/"+userAccount, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUser(Map<String, Object> params) {
		logger.info("(UserService-addUser)-新增用户-传入参数, params:{}", params);
		params.put("sourceType", WheelConstants.USER_ADD_SOURCE_TYPE_LOGIN);
		HttpHeaders headers = this.getProviderWheelHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(RetHttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_WHEEL+this.wheel_user+"/insertUser", httpEntity, JSONObject.class);
        return response;
    }

}