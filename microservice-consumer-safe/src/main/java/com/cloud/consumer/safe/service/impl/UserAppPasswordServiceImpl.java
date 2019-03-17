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
	public JSONObject getUserAppPasswordById(Integer id) {
		logger.info("(UserAppPasswordService-getUserAppPasswordById)-根据id获取用户应用密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/selectUserAppPasswordById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAppPasswordByUserId(Object params) {
		logger.info("(UserAppPasswordService-getUserAppPasswordByUserId)-根据userId获取用户应用密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/selectUserAppPasswordByUserId", params, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserAppPassword(Object params) {
		logger.info("(UserAppPasswordService-addUserAppPassword)-新增用户应用密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/insertUserAppPassword", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户应用密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserAppPasswordById(Integer id) {
		logger.info("(UserAppPasswordService-deleteUserAppPasswordById)-根据id获取用户应用密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/deleteUserAppPasswordById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户应用密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserAppPassword(Object params) {
		logger.info("(UserAppPasswordService-updateUserAppPassword)-修改用户应用密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_password+"/modifyUserAppPassword", params, JSONObject.class);
		return response;
	}

}