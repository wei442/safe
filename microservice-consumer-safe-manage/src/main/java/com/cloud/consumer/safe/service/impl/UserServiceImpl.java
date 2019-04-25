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
	 * 用户登录第一步
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject loginFirst(Object params) {
		logger.info("(UserService-loginFirst)-用户登录第一步-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/login/first", params, JSONObject.class);
		return response;
	}

	/**
	 * 用户登录第二步
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject loginSecond(Object params) {
		logger.info("(UserService-loginSecond)-用户登录第二步-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/login/second", params, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUser(Object params) {
		logger.info("(UserService-addUser)-新增用户-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user+"/insertUser", params, JSONObject.class);
		return response;
	}

}