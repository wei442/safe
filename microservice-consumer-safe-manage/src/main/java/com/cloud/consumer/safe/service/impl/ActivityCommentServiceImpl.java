package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IActivityCommentService;

/**
 * 安全活动评论 ActivityCommentService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class ActivityCommentServiceImpl extends BaseService implements IActivityCommentService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取安全活动评论列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(ActivityService-getListByPage)-分页获取安全活动评论列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_comment+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取安全活动评论列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(ActivityService-getList)-获取安全活动评论列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_comment+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取安全活动评论
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(ActivityService-getById)-根据id获取安全活动评论-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_comment+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增安全活动评论
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(ActivityService-add)-新增安全活动评论-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_comment+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除安全活动评论
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(ActivityService-deleteById)-根据id获取安全活动评论-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_comment+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改安全活动评论
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(ActivityService-update)-修改安全活动评论-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity_comment+"/modify", params, JSONObject.class);
		return response;
	}

}