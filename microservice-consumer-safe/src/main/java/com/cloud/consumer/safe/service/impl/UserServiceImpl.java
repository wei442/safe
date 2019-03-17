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