package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserTitleService;

/**
 * 用户职务 UserTitleService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserTitleServiceImpl extends BaseService implements IUserTitleService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleListByPage(Object params) {
		logger.info("(UserTitleService-getUserTitleListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserTitleListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleList(Object params) {
		logger.info("(UserTitleService-getUserTitleList)-获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserTitleList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleById(Integer id) {
		logger.info("(UserTitleService-getUserTitleById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserTitleById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserTitle(Object params) {
		logger.info("(UserTitleService-addUserTitle)-新增用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/insertUserTitle", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserTitleById(Integer id) {
		logger.info("(UserTitleService-deleteUserTitleById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/deleteUserTitleById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserTitle(Object params) {
		logger.info("(UserTitleService-updateUserTitle)-修改用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/modifyUserTitle", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}