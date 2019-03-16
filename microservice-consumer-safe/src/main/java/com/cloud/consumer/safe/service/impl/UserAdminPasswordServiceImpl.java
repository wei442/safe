package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminPasswordService;

/**
 * 用户管理密码 UserAdminPasswordService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAdminPasswordServiceImpl extends BaseService implements IUserAdminPasswordService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据id获取用户管理密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminPasswordById(Integer id) {
		logger.info("(UserAdminPasswordService-getUserAdminPasswordById)-根据id获取用户管理密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/selectUserAdminPasswordById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户管理密码
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getUserAdminPasswordByUserId(Integer userId) {
		logger.info("(UserAdminPasswordService-getUserAdminPasswordByUserId)-根据userId获取用户管理密码-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/selectUserAdminPasswordByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserAdminPassword(Object params) {
		logger.info("(UserAdminPasswordService-addUserAdminPassword)-新增用户管理密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/insertUserAdminPassword", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户管理密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserAdminPasswordById(Integer id) {
		logger.info("(UserAdminPasswordService-deleteUserAdminPasswordById)-根据id获取用户管理密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/deleteUserAdminPasswordById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserAdminPassword(Object params) {
		logger.info("(UserAdminPasswordService-updateUserAdminPassword)-修改用户管理密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/modifyUserAdminPassword", params, JSONObject.class);
		return response;
	}

}