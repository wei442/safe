package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserInfoService;

/**
 * 用户信息 UserInfoService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserInfoServiceImpl extends BaseService implements IUserInfoService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserInfoListByPage(Object params) {
		logger.info("(UserInfoService-getUserInfoListByPage)-分页获取用户信息列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserInfoListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserInfoList(Object params) {
		logger.info("(UserInfoService-getUserInfoList)-获取用户信息列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserInfoList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserInfoById(Integer id) {
		logger.info("(UserInfoService-getUserInfoById)-根据id获取用户信息-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserInfoById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserInfo(Object params) {
		logger.info("(UserInfoService-addUserInfo)-新增用户信息-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/insertUserInfo", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserInfoById(Integer id) {
		logger.info("(UserInfoService-deleteUserInfoById)-根据id获取用户信息-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/deleteUserInfoById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserInfo(Object params) {
		logger.info("(UserInfoService-updateUserInfo)-修改用户信息-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/modifyUserInfo", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}