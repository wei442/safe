package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.ITitleService;

/**
 * 职务 TitleService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class TitleServiceImpl extends BaseService implements ITitleService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getTitleListByPage(Object params) {
		logger.info("(TitleService-getTitleListByPage)-分页获取职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/selectTitleListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getTitleList(Object params) {
		logger.info("(TitleService-getTitleList)-获取职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/selectTitleList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getTitleById(Integer id) {
		logger.info("(TitleService-getTitleById)-根据id获取职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/selectTitleById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addTitle(Object params) {
		logger.info("(TitleService-addTitle)-新增职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/insertTitle", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteTitleById(Integer id) {
		logger.info("(TitleService-deleteTitleById)-根据id获取职务-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/deleteTitleById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateTitle(Object params) {
		logger.info("(TitleService-updateTitle)-修改职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/modifyTitle", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}