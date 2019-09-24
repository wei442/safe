package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAppPasswordService;

/**
 * 用户应用密码 UserAppPasswordService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAppPasswordServiceImpl extends BaseService implements IUserAppPasswordService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据id获取用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserAppPasswordService-getById)-根据id获取用户应用密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId和password获取用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserIdPassword(Object params) {
		logger.info("(UserAdminPasswordService-getByUserIdPassword)-根据userId和password获取用户应用密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/selectByUserIdPassword", params, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserAppPasswordService-add)-新增用户应用密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserAppPasswordService-deleteById)-根据id获取用户应用密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserAppPasswordService-update)-修改用户应用密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/modify", params, JSONObject.class);
		return response;
	}

}