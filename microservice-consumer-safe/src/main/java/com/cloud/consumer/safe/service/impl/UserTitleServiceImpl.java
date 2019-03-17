package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserTitleService;

/**
 * 用户职务 UserTitleService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserTitleServiceImpl extends BaseService implements IUserTitleService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleListByPage(Object params) {
		logger.info("(UserTitleService-getUserTitleListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserTitleListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleList(Object params) {
		logger.info("(UserTitleService-getUserTitleList)-获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserTitleList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleById(Integer id) {
		logger.info("(UserTitleService-getUserTitleById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserTitleById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户职务
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTitleByUserId(Integer userId) {
		logger.info("(UserTitleService-getUserTitleByUserId)-根据userId获取用户职务-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserTitleByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserTitle(Object params) {
		logger.info("(UserTitleService-addUserTitle)-新增用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/insertUserTitle", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserTitleById(Integer id) {
		logger.info("(UserTitleService-deleteUserTitleById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/deleteUserTitleById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserTitle(Object params) {
		logger.info("(UserTitleService-updateUserTitle)-修改用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/modifyUserTitle", params, JSONObject.class);
		return response;
	}

}