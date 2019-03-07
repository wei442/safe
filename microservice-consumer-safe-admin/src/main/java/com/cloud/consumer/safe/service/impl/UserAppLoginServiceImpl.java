package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAppLoginService;

/**
 * 用户应用登录 UserAppLoginService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAppLoginServiceImpl extends BaseService implements IUserAppLoginService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户应用登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAppLoginListByPage(Map<String, Object> params) {
		logger.info("(UserAppLoginService-getUserAppLoginListByPage)-分页获取用户应用登录列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAppLogin+"/selectUserAppLoginListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户应用登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAppLoginList(Map<String, Object> params) {
		logger.info("(UserAppLoginService-getUserAppLoginList)-获取用户应用登录列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAppLogin+"/selectUserAppLoginList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户应用登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAppLoginById(Integer id) {
		logger.info("(UserAppLoginService-getUserAppLoginById)-根据id获取用户应用登录-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAppLogin+"/selectUserAppLoginById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户应用登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserAppLogin(Map<String, Object> params) {
		logger.info("(UserAppLoginService-addUserAppLogin)-新增用户应用登录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAppLogin+"/insertUserAppLogin", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户应用登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserAppLoginById(Integer id) {
		logger.info("(UserAppLoginService-deleteUserAppLoginById)-根据id获取用户应用登录-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAppLogin+"/deleteUserAppLoginById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户应用登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserAppLogin(Map<String, Object> params) {
		logger.info("(UserAppLoginService-updateUserAppLogin)-修改用户应用登录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAppLogin+"/modifyUserAppLogin", httpEntity, JSONObject.class);
		return response;
	}

}