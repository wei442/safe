package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IQualityAttachmentService;

/**
 * 资质附件 Service (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class QualityAttachmentServiceImpl extends BaseService implements IQualityAttachmentService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(QualityAttachmentService-getListByPage)-分页获取资质附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(QualityAttachmentService-getList)-获取资质附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取资质附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(QualityAttachmentService-getById)-根据id获取资质附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增资质附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(QualityAttachmentService-add)-新增资质附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除资质附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(QualityAttachmentService-deleteById)-根据id获取资质附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改资质附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(QualityAttachmentService-update)-修改资质附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/modify", params, JSONObject.class);
		return response;
	}

}