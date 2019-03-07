package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IEnterpriseService;

/**
 * 企业 EnterpriseService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class EnterpriseServiceImpl extends BaseService implements IEnterpriseService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseListByPage(Map<String, Object> params) {
		logger.info("(EnterpriseService-getEnterpriseListByPage)-分页获取企业列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise+"/selectEnterpriseListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseList(Map<String, Object> params) {
		logger.info("(EnterpriseService-getEnterpriseList)-获取企业列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise+"/selectEnterpriseList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取企业
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseById(Integer id) {
		logger.info("(EnterpriseService-getEnterpriseById)-根据id获取企业-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise+"/selectEnterpriseById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增企业
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addEnterprise(Map<String, Object> params) {
		logger.info("(EnterpriseService-addEnterprise)-新增企业-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise+"/insertEnterprise", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除企业
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteEnterpriseById(Integer id) {
		logger.info("(EnterpriseService-deleteEnterpriseById)-根据id获取企业-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise+"/deleteEnterpriseById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改企业
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateEnterprise(Map<String, Object> params) {
		logger.info("(EnterpriseService-updateEnterprise)-修改企业-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise+"/modifyEnterprise", httpEntity, JSONObject.class);
		return response;
	}

}