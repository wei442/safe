package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminPasswordService;

/**
 * 用户管理密码 Service (microservice-provider-safe)
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
	public JSONObject getById(Integer id) {
		logger.info("(Service-getById)-根据id获取用户管理密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId和password获取用户管理密码
	 * @param userId
	 * @param password
	 * @return JSONObject
	 */
	public JSONObject getByUserIdPassword(Integer userId,String password) {
		logger.info("(Service-getByUserId)-根据userId和password获取用户管理密码-传入参数, userId:{}, password:{}", userId, password);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/selectByUserIdPassword/"+userId+"/"+password, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(Service-add)-新增用户管理密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户管理密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(Service-deleteById)-根据id获取用户管理密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(Service-update)-修改用户管理密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_password+"/modify", params, JSONObject.class);
		return response;
	}

}