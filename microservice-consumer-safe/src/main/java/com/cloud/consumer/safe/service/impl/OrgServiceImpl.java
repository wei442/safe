package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IOrgService;

/**
 * 组织机构 OrgService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class OrgServiceImpl extends BaseService implements IOrgService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getOrgListByPage(Object params) {
		logger.info("(OrgService-getOrgListByPage)-分页获取组织机构列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.org+"/selectOrgListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getOrgList(Object params) {
		logger.info("(OrgService-getOrgList)-获取组织机构列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.org+"/selectOrgList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取组织机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getOrgById(Integer id) {
		logger.info("(OrgService-getOrgById)-根据id获取组织机构-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.org+"/selectOrgById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增组织机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addOrg(Object params) {
		logger.info("(OrgService-addOrg)-新增组织机构-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.org+"/insertOrg", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除组织机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteOrgById(Integer id) {
		logger.info("(OrgService-deleteOrgById)-根据id获取组织机构-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.org+"/deleteOrgById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改组织机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateOrg(Object params) {
		logger.info("(OrgService-updateOrg)-修改组织机构-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.org+"/modifyOrg", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}