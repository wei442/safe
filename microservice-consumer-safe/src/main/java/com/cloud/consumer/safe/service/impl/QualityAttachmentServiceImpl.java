package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IQualityAttachmentService;

/**
 * 资质附件 QualityAttachmentService (microservice-provider-safe)
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
	public JSONObject getQualityAttachmentListByPage(Object params) {
		logger.info("(QualityAttachmentService-getQualityAttachmentListByPage)-分页获取资质附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/selectQualityAttachmentListByPage", null, JSONObject.class);
		return response;
	}

	/**
	 * 获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityAttachmentList(Object params) {
		logger.info("(QualityAttachmentService-getQualityAttachmentList)-获取资质附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/selectQualityAttachmentList", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取资质附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityAttachmentById(Integer id) {
		logger.info("(QualityAttachmentService-getQualityAttachmentById)-根据id获取资质附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/selectQualityAttachmentById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增资质附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addQualityAttachment(Object params) {
		logger.info("(QualityAttachmentService-addQualityAttachment)-新增资质附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/insertQualityAttachment", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除资质附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteQualityAttachmentById(Integer id) {
		logger.info("(QualityAttachmentService-deleteQualityAttachmentById)-根据id获取资质附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/deleteQualityAttachmentById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改资质附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateQualityAttachment(Object params) {
		logger.info("(QualityAttachmentService-updateQualityAttachment)-修改资质附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality_attachment+"/modifyQualityAttachment", null, JSONObject.class);
		return response;
	}

}