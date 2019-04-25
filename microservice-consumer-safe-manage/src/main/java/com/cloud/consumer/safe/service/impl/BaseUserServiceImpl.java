package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IBaseUserService;

/**
 * 基础用户 BaseUserService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class BaseUserServiceImpl extends BaseService implements IBaseUserService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 用户登录
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject login(Object params) {
		logger.info("(BaseUserService-login)-用户登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/login", params, JSONObject.class);
		return response;
	}

}