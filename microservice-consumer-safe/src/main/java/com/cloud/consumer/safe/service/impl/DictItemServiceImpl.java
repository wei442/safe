package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDictItemService;

/**
 * 字典子项 DictItemService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DictItemServiceImpl extends BaseService implements IDictItemService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictItemListByPage(Object params) {
		logger.info("(DictItemService-getDictItemListByPage)-分页获取字典子项列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/selectDictItemListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictItemList(Object params) {
		logger.info("(DictItemService-getDictItemList)-获取字典子项列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/selectDictItemList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取字典子项
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictItemById(Integer id) {
		logger.info("(DictItemService-getDictItemById)-根据id获取字典子项-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/selectDictItemById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增字典子项
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addDictItem(Object params) {
		logger.info("(DictItemService-addDictItem)-新增字典子项-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/insertDictItem", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除字典子项
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteDictItemById(Integer id) {
		logger.info("(DictItemService-deleteDictItemById)-根据id获取字典子项-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/deleteDictItemById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改字典子项
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateDictItem(Object params) {
		logger.info("(DictItemService-updateDictItem)-修改字典子项-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.dict+"/modifyDictItem", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}