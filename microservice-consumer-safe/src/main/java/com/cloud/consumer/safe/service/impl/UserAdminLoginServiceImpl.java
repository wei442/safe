package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminLoginService;

/**
 * 用户管理登录 Service (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAdminLoginServiceImpl extends BaseService implements IUserAdminLoginService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserAdminLoginService-getListByPage)-分页获取用户管理登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserAdminLoginService-getList)-获取用户管理登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserAdminLoginService-getById)-根据id获取用户管理登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户管理登录
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserAdminLoginService-getByUserId)-根据userId获取用户管理登录-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserAdminLoginService-add)-新增用户管理登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserAdminLoginService-deleteById)-根据id获取用户管理登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserAdminLoginService-update)-修改用户管理登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/modify", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId修改用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateByUserId(Object params) {
		logger.info("(UserAdminLoginService-updateByUserId)-根据userId修改用户管理登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin_login+"/modifyByUserId", params, JSONObject.class);
		return response;
	}

}