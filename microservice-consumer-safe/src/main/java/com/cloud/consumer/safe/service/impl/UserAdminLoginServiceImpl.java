package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminLoginService;

/**
 * 用户管理登录 UserAdminLoginService (microservice-provider-safe)
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
	public JSONObject getUserAdminLoginListByPage(Object params) {
		logger.info("(UserAdminLoginService-getUserAdminLoginListByPage)-分页获取用户管理登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_adminLogin+"/selectUserAdminLoginListByPage", null, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户管理登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminLoginList(Object params) {
		logger.info("(UserAdminLoginService-getUserAdminLoginList)-获取用户管理登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_adminLogin+"/selectUserAdminLoginList", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserAdminLoginById(Integer id) {
		logger.info("(UserAdminLoginService-getUserAdminLoginById)-根据id获取用户管理登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_adminLogin+"/selectUserAdminLoginById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserAdminLogin(Object params) {
		logger.info("(UserAdminLoginService-addUserAdminLogin)-新增用户管理登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_adminLogin+"/insertUserAdminLogin", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户管理登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserAdminLoginById(Integer id) {
		logger.info("(UserAdminLoginService-deleteUserAdminLoginById)-根据id获取用户管理登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_adminLogin+"/deleteUserAdminLoginById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserAdminLogin(Object params) {
		logger.info("(UserAdminLoginService-updateUserAdminLogin)-修改用户管理登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_adminLogin+"/modifyUserAdminLogin", null, JSONObject.class);
		return response;
	}

}