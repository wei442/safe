package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IAttachmentService;

/**
 * 附件 AttachmentService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class AttachmentServiceImpl extends BaseService implements IAttachmentService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAttachmentListByPage(Object params) {
		logger.info("(AttachmentService-getAttachmentListByPage)-分页获取附件列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.attachment+"/selectAttachmentListByPage", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 获取附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAttachmentList(Object params) {
		logger.info("(AttachmentService-getAttachmentList)-获取附件列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.attachment+"/selectAttachmentList", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id获取附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getAttachmentById(Integer id) {
		logger.info("(AttachmentService-getAttachmentById)-根据id获取附件-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.attachment+"/selectAttachmentById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 新增附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addAttachment(Object params) {
		logger.info("(AttachmentService-addAttachment)-新增附件-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.attachment+"/insertAttachment", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 根据id删除附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteAttachmentById(Integer id) {
		logger.info("(AttachmentService-deleteAttachmentById)-根据id获取附件-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.attachment+"/deleteAttachmentById/"+id, httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

	/**
	 * 修改附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateAttachment(Object params) {
		logger.info("(AttachmentService-updateAttachment)-修改附件-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.attachment+"/modifyAttachment", httpEntity, JSONObject.class);
		this.verifyResponse(response);
		return response;
	}

}