package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDictService;

/**
 * 字典 DictService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DictServiceImpl extends BaseService implements IDictService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取字典列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictListByPage(Object params) {
		logger.info("(DictService-getDictListByPage)-分页获取字典列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/selectDictListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取字典列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictList(Object params) {
		logger.info("(DictService-getDictList)-获取字典列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/selectDictList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取字典
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictById(Integer id) {
		logger.info("(DictService-getDictById)-根据id获取字典-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/selectDictById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增字典
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addDict(Object params) {
		logger.info("(DictService-addDict)-新增字典-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/insertDict", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除字典
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteDictById(Integer id) {
		logger.info("(DictService-deleteDictById)-根据id获取字典-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/deleteDictById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改字典
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateDict(Object params) {
		logger.info("(DictService-updateDict)-修改字典-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/modifyDict", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}