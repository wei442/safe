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
	public JSONObject getBaseUserLoginListByPage(Object params) {
		logger.info("(BaseUserLoginService-getBaseUserLoginListByPage)-分页获取基础用户登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/selectBaseUserLoginListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取基础用户登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserLoginList(Object params) {
		logger.info("(BaseUserLoginService-getBaseUserLoginList)-获取基础用户登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/selectBaseUserLoginList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取基础用户登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserLoginById(Integer id) {
		logger.info("(BaseUserLoginService-getBaseUserLoginById)-根据id获取基础用户登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/selectBaseUserLoginById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addBaseUserLogin(Object params) {
		logger.info("(BaseUserLoginService-addBaseUserLogin)-新增基础用户登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/insertBaseUserLogin", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除基础用户登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteBaseUserLoginById(Integer id) {
		logger.info("(BaseUserLoginService-deleteBaseUserLoginById)-根据id获取基础用户登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/deleteBaseUserLoginById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改基础用户登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateBaseUserLogin(Object params) {
		logger.info("(BaseUserLoginService-updateBaseUserLogin)-修改基础用户登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_login+"/modifyBaseUserLogin", params, JSONObject.class);
		return response;
	}

}