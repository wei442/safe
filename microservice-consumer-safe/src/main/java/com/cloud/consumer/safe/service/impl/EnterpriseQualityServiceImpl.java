package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IEnterpriseQualityService;

/**
 * 企业资质 EnterpriseQualityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class EnterpriseQualityServiceImpl extends BaseService implements IEnterpriseQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseQualityListByPage(Object params) {
		logger.info("(EnterpriseQualityService-getEnterpriseQualityListByPage)-分页获取企业资质列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise_quality+"/selectEnterpriseQualityListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseQualityList(Object params) {
		logger.info("(EnterpriseQualityService-getEnterpriseQualityList)-获取企业资质列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise_quality+"/selectEnterpriseQualityList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取企业资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseQualityById(Integer id) {
		logger.info("(EnterpriseQualityService-getEnterpriseQualityById)-根据id获取企业资质-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise_quality+"/selectEnterpriseQualityById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增企业资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addEnterpriseQuality(Object params) {
		logger.info("(EnterpriseQualityService-addEnterpriseQuality)-新增企业资质-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise_quality+"/insertEnterpriseQuality", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除企业资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteEnterpriseQualityById(Integer id) {
		logger.info("(EnterpriseQualityService-deleteEnterpriseQualityById)-根据id获取企业资质-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise_quality+"/deleteEnterpriseQualityById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改企业资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateEnterpriseQuality(Object params) {
		logger.info("(EnterpriseQualityService-updateEnterpriseQuality)-修改企业资质-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.enterprise_quality+"/modifyEnterpriseQuality", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}