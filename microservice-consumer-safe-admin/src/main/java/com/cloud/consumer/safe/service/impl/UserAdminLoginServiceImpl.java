package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminLoginService;

/**
 * 用户管理登录 UserAdminLoginService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAdminLoginServiceImpl extends BaseService implements IUserAdminLoginService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminLoginListByPage(Map<String, Object> params) {
		logger.info("(UserAdminLoginService-getUserAdminLoginListByPage)-分页获取用户管理登录列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAdminLogin+"/selectUserAdminLoginListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminLoginList(Map<String, Object> params) {
		logger.info("(UserAdminLoginService-getUserAdminLoginList)-获取用户管理登录列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAdminLogin+"/selectUserAdminLoginList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminLoginById(Integer id) {
		logger.info("(UserAdminLoginService-getUserAdminLoginById)-根据id获取用户管理登录-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAdminLogin+"/selectUserAdminLoginById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserAdminLogin(Map<String, Object> params) {
		logger.info("(UserAdminLoginService-addUserAdminLogin)-新增用户管理登录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAdminLogin+"/insertUserAdminLogin", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserAdminLoginById(Integer id) {
		logger.info("(UserAdminLoginService-deleteUserAdminLoginById)-根据id获取用户管理登录-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAdminLogin+"/deleteUserAdminLoginById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserAdminLogin(Map<String, Object> params) {
		logger.info("(UserAdminLoginService-updateUserAdminLogin)-修改用户管理登录-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userAdminLogin+"/modifyUserAdminLogin", httpEntity, JSONObject.class);
		return response;
	}

}