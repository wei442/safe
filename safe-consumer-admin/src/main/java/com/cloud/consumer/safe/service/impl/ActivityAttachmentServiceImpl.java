package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IActivityAttachmentService;

/**
 * 安全活动附件 ActivityCommentService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class ActivityAttachmentServiceImpl extends BaseService implements IActivityAttachmentService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取安全活动附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(ActivityService-getListByPage)-分页获取安全活动附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_attachment+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取安全活动附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(ActivityService-getList)-获取安全活动附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_attachment+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取安全活动附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(ActivityService-getById)-根据id获取安全活动附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_attachment+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增安全活动附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(ActivityService-add)-新增安全活动附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_attachment+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除安全活动附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(ActivityService-deleteById)-根据id获取安全活动附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_attachment+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改安全活动附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(ActivityService-update)-修改安全活动附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_attachment+"/modify", params, JSONObject.class);
		return response;
	}

}