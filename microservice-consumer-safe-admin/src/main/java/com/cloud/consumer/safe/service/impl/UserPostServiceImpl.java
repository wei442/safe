package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserPostService;

/**
 * 用户岗位 UserPostService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserPostServiceImpl extends BaseService implements IUserPostService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostListByPage(Map<String, Object> params) {
		logger.info("(UserPostService-getUserPostListByPage)-分页获取用户岗位列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_post+"/selectUserPostListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostList(Map<String, Object> params) {
		logger.info("(UserPostService-getUserPostList)-获取用户岗位列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_post+"/selectUserPostList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostById(Integer id) {
		logger.info("(UserPostService-getUserPostById)-根据id获取用户岗位-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_post+"/selectUserPostById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserPost(Map<String, Object> params) {
		logger.info("(UserPostService-addUserPost)-新增用户岗位-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_post+"/insertUserPost", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserPostById(Integer id) {
		logger.info("(UserPostService-deleteUserPostById)-根据id获取用户岗位-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_post+"/deleteUserPostById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserPost(Map<String, Object> params) {
		logger.info("(UserPostService-updateUserPost)-修改用户岗位-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_post+"/modifyUserPost", httpEntity, JSONObject.class);
		return response;
	}

}