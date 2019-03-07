package com.cloud.consumer.safe.service.impl;

import java.util.Map;

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
	public JSONObject getTitleListByPage(Map<String, Object> params) {
		logger.info("(TitleService-getTitleListByPage)-分页获取职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.title+"/selectTitleListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getTitleList(Map<String, Object> params) {
		logger.info("(TitleService-getTitleList)-获取职务列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.title+"/selectTitleList", httpEntity, JSONObject.class);
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
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.title+"/selectTitleById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addTitle(Map<String, Object> params) {
		logger.info("(TitleService-addTitle)-新增职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.title+"/insertTitle", httpEntity, JSONObject.class);
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
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.title+"/deleteTitleById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateTitle(Map<String, Object> params) {
		logger.info("(TitleService-updateTitle)-修改职务-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.title+"/modifyTitle", httpEntity, JSONObject.class);
		return response;
	}

}