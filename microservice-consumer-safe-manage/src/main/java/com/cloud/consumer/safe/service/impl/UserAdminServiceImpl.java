package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAdminService;

/**
 * 用户管理 serAdminService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAdminServiceImpl extends BaseService implements IUserAdminService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户管理列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserAdminService-getListByPage)-分页获取用户管理列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户管理列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserAdminService-getList)-获取用户管理列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户管理
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserAdminService-getById)-根据id获取用户管理-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户管理
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserAdminService-getByUserId)-根据userId获取用户管理-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户管理
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserAdminService-add)-新增用户管理-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户管理
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserAdminService-deleteById)-根据id获取用户管理-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户管理
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserAdminService-update)-修改用户管理-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_admin+"/modify", params, JSONObject.class);
		return response;
	}

}