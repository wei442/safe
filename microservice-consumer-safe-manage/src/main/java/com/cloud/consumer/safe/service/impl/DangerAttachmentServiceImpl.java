package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDangerAttachmentService;

/**
 * 隐患附件 DangerAttachmentService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DangerAttachmentServiceImpl extends BaseService implements IDangerAttachmentService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取隐患附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(DangerAttachmentService-getListByPage)-分页获取隐患附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_attachment+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取隐患附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(DangerAttachmentService-getList)-获取隐患附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_attachment+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取隐患附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(DangerAttachmentService-getById)-根据id获取隐患附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_attachment+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增隐患附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(DangerAttachmentService-add)-新增隐患附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_attachment+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除隐患附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(DangerAttachmentService-deleteById)-根据id获取隐患附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_attachment+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改隐患附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(DangerAttachmentService-update)-修改隐患附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_attachment+"/modify", params, JSONObject.class);
		return response;
	}

}