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
	public JSONObject getUserInfoListByPage(Object params) {
		logger.info("(UserInfoService-getUserInfoListByPage)-分页获取用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectUserInfoListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserInfoList(Object params) {
		logger.info("(UserInfoService-getUserInfoList)-获取用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectUserInfoList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserInfoById(Integer id) {
		logger.info("(UserInfoService-getUserInfoById)-根据id获取用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/selectUserInfoById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserInfo(Object params) {
		logger.info("(UserInfoService-addUserInfo)-新增用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/insertUserInfo", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserInfoById(Integer id) {
		logger.info("(UserInfoService-deleteUserInfoById)-根据id获取用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/deleteUserInfoById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserInfo(Object params) {
		logger.info("(UserInfoService-updateUserInfo)-修改用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_info+"/modifyUserInfo", params, JSONObject.class);
		return response;
	}

}