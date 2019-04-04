package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserAppLoginService;

/**
 * 用户应用登录 UserAppLoginService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserAppLoginServiceImpl extends BaseService implements IUserAppLoginService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户应用登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserAppLoginService-getListByPage)-分页获取用户应用登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_login+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户应用登录列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserAppLoginService-getList)-获取用户应用登录列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_login+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户应用登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserAppLoginService-getById)-根据id获取用户应用登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_login+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户应用登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserAppLoginService-add)-新增用户应用登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_login+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户应用登录
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserAppLoginService-deleteById)-根据id获取用户应用登录-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_login+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户应用登录
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserAppLoginService-update)-修改用户应用登录-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_app_login+"/modify", params, JSONObject.class);
		return response;
	}

}