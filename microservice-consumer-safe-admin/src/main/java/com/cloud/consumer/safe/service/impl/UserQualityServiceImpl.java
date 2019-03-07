package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserQualityService;

/**
 * 用户资质 UserQualityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserQualityServiceImpl extends BaseService implements IUserQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserQualityListByPage(Map<String, Object> params) {
		logger.info("(UserQualityService-getUserQualityListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userQuality+"/selectUserQualityListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserQualityList(Map<String, Object> params) {
		logger.info("(UserQualityService-getUserQualityList)-获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userQuality+"/selectUserQualityList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserQualityById(Integer id) {
		logger.info("(UserQualityService-getUserQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userQuality+"/selectUserQualityById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserQuality(Map<String, Object> params) {
		logger.info("(UserQualityService-addUserQuality)-新增用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userQuality+"/insertUserQuality", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserQualityById(Integer id) {
		logger.info("(UserQualityService-deleteUserQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userQuality+"/deleteUserQualityById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserQuality(Map<String, Object> params) {
		logger.info("(UserQualityService-updateUserQuality)-修改用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.safe_userQuality+"/modifyUserQuality", httpEntity, JSONObject.class);
		return response;
	}

}