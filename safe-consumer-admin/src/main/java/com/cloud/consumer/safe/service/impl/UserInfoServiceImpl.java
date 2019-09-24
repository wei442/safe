package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserInfoService;

/**
 * 用户信息 UserInfoService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserInfoServiceImpl extends BaseService implements IUserInfoService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserInfoService-getListByPage)-分页获取用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserInfoService-getList)-获取用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserInfoService-getById)-根据id获取用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userAccount获取用户信息
	 * @param userAccount
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserAccount(String userAccount) {
		logger.info("(UserInfoService-getByUserAccount)-根据userAccount获取用户信息-传入参数, userAccount:{}", userAccount);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectByUserAccount/"+userAccount, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserInfoService-add)-新增用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserInfoService-deleteById)-根据id获取用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserInfoService-update)-修改用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/modify", params, JSONObject.class);
		return response;
	}

}