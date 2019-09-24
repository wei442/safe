package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserService;

/**
 * 用户 UserService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 新增用户管理
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addAdminUser(Object params) {
		logger.info("(UserService-addAdminUser)-新增用户管理-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/admin/insertUser", params, JSONObject.class);
		return response;
	}

	/**
	 * 用户管理登录第一步
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject loginAdminFirst(Object params) {
		logger.info("(UserService-loginAdminFirst)-用户管理登录第一步-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/admin/login/first", params, JSONObject.class);
		return response;
	}

	/**
	 * 用户管理登录第二步
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject loginAdminSecond(Object params) {
		logger.info("(UserService-loginAdminSecond)-用户管理登录第二步-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/admin/login/second", params, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateAdminPassword(Object params) {
		logger.info("(UserService-updateAdminPassword)-修改用户管理密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/admin/modify/password", params, JSONObject.class);
		return response;
	}

	/**
	 * 重置用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject resetAdminPassword(Object params) {
		logger.info("(UserService-resetAdminPassword)-重置用户管理密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/admin/reset/password", params, JSONObject.class);
		return response;
	}

}