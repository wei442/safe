package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IQualityService;

/**
 * 用户职务 QualityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class QualityServiceImpl extends BaseService implements IQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityListByPage(Object params) {
		logger.info("(QualityService-getQualityListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.quality+"/selectQualityListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityList(Object params) {
		logger.info("(QualityService-getQualityList)-获取用户职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.quality+"/selectQualityList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityById(Integer id) {
		logger.info("(QualityService-getQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.quality+"/selectQualityById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addQuality(Object params) {
		logger.info("(QualityService-addQuality)-新增用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.quality+"/insertQuality", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteQualityById(Integer id) {
		logger.info("(QualityService-deleteQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.quality+"/deleteQualityById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateQuality(Object params) {
		logger.info("(QualityService-updateQuality)-修改用户职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.quality+"/modifyQuality", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}