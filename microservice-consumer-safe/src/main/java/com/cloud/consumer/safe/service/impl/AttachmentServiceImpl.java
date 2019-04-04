package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public JSONObject getListByPage(Object params) {
		logger.info("( AttachmentService-getListByPage)-分页获取附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.attachment+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("( AttachmentService-getList)-获取附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.attachment+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("( AttachmentService-getById)-根据id获取附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.attachment+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("( AttachmentService-add)-新增附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.attachment+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("( AttachmentService-deleteById)-根据id获取附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.attachment+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("( AttachmentService-update)-修改附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.attachment+"/modify", params, JSONObject.class);
		return response;
	}

}