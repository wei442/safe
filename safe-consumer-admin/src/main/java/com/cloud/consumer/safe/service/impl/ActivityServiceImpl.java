package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IActivityService;

/**
 * 安全活动 ActivityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class ActivityServiceImpl extends BaseService implements IActivityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取安全活动列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(ActivityService-getListByPage)-分页获取安全活动列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取安全活动列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(ActivityService-getList)-获取安全活动列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取安全活动
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(ActivityService-getById)-根据id获取安全活动-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增安全活动
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(ActivityService-add)-新增安全活动-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除安全活动
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(ActivityService-deleteById)-根据id获取安全活动-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改安全活动
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(ActivityService-update)-修改安全活动-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.activity+"/modify", params, JSONObject.class);
		return response;
	}

}