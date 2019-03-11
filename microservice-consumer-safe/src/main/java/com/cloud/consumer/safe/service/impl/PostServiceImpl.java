package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IPostService;

/**
 * 岗位 PostService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class PostServiceImpl extends BaseService implements IPostService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getPostListByPage(Object params) {
		logger.info("(PostService-getPostListByPage)-分页获取岗位列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/selectPostListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getPostList(Object params) {
		logger.info("(PostService-getPostList)-获取岗位列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/selectPostList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getPostById(Integer id) {
		logger.info("(PostService-getPostById)-根据id获取岗位-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/selectPostById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addPost(Object params) {
		logger.info("(PostService-addPost)-新增岗位-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/insertPost", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deletePostById(Integer id) {
		logger.info("(PostService-deletePostById)-根据id获取岗位-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/deletePostById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updatePost(Object params) {
		logger.info("(PostService-updatePost)-修改岗位-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.post+"/modifyPost", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}