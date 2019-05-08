package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IBaseUserInfoService;

/**
 * 基础用户信息 BaseUserInfoService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class BaseUserInfoServiceImpl extends BaseService implements IBaseUserInfoService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(BaseUserInfoService-getListByPage)-分页获取基础用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(BaseUserInfoService-getList)-获取基础用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(BaseUserInfoService-getById)-根据id获取基础用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(BaseUserInfoService-add)-新增基础用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(BaseUserInfoService-deleteById)-根据id获取基础用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(BaseUserInfoService-update)-修改基础用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/modify", params, JSONObject.class);
		return response;
	}

}