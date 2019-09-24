package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IBaseUserLoginService;

/**
 * 基础用户登录 BaseUserLoginService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class BaseUserLoginServiceImpl extends BaseService implements IBaseUserLoginService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取基础用户登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(BaseUserLoginService-getListByPage)-分页获取基础用户登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取基础用户登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(BaseUserLoginService-getList)-获取基础用户登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取基础用户登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(BaseUserLoginService-getById)-根据id获取基础用户登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(BaseUserLoginService-add)-新增基础用户登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除基础用户登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(BaseUserLoginService-deleteById)-根据id获取基础用户登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改基础用户登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(BaseUserLoginService-update)-修改基础用户登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/modify", params, JSONObject.class);
		return response;
	}

}