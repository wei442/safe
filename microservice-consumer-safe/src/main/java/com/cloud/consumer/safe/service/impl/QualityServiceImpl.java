package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IQualityService;

/**
 * 用户职务 QualityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class QualityServiceImpl extends BaseService implements IQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityListByPage(Object params) {
		logger.info("(QualityService-getQualityListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality+"/selectQualityListByPage", null, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityList(Object params) {
		logger.info("(QualityService-getQualityList)-获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality+"/selectQualityList", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getQualityById(Integer id) {
		logger.info("(QualityService-getQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality+"/selectQualityById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addQuality(Object params) {
		logger.info("(QualityService-addQuality)-新增用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality+"/insertQuality", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteQualityById(Integer id) {
		logger.info("(QualityService-deleteQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality+"/deleteQualityById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateQuality(Object params) {
		logger.info("(QualityService-updateQuality)-修改用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.quality+"/modifyQuality", null, JSONObject.class);
		return response;
	}

}