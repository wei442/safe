package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminService;

/**
 * 用户管理 UserAdminService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAdminServiceImpl extends BaseService implements IUserAdminService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminListByPage(Object params) {
		logger.info("(UserAdminService-getUserAdminListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_admin+"/selectUserAdminListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminList(Object params) {
		logger.info("(UserAdminService-getUserAdminList)-获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_admin+"/selectUserAdminList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminById(Integer id) {
		logger.info("(UserAdminService-getUserAdminById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_admin+"/selectUserAdminById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserAdmin(Object params) {
		logger.info("(UserAdminService-addUserAdmin)-新增用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_admin+"/insertUserAdmin", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserAdminById(Integer id) {
		logger.info("(UserAdminService-deleteUserAdminById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_admin+"/deleteUserAdminById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserAdmin(Object params) {
		logger.info("(UserAdminService-updateUserAdmin)-修改用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_admin+"/modifyUserAdmin", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}