package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserPostService;

/**
 * 用户岗位 UserPostService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserPostServiceImpl extends BaseService implements IUserPostService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostListByPage(Object params) {
		logger.info("(UserPostService-getUserPostListByPage)-分页获取用户岗位列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/selectUserPostListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostList(Object params) {
		logger.info("(UserPostService-getUserPostList)-获取用户岗位列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/selectUserPostList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostById(Integer id) {
		logger.info("(UserPostService-getUserPostById)-根据id获取用户岗位-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/selectUserPostById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户岗位
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserPostByUserId(Integer userId) {
		logger.info("(UserPostService-getUserPostByUserId)-根据userId获取用户岗位-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserPostByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserPost(Object params) {
		logger.info("(UserPostService-addUserPost)-新增用户岗位-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/insertUserPost", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserPostById(Integer id) {
		logger.info("(UserPostService-deleteUserPostById)-根据id获取用户岗位-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/deleteUserPostById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserPost(Object params) {
		logger.info("(UserPostService-updateUserPost)-修改用户岗位-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/modifyUserPost", params, JSONObject.class);
		return response;
	}

}