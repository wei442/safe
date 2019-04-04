package com.cloud.consumer.safe.service.impl;

import java.util.List;

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
	public JSONObject getListByPage(Object params) {
		logger.info("(UserPostService-getListByPage)-分页获取用户岗位列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserPostService-getList)-获取用户岗位列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserPostService-getById)-根据id获取用户岗位-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户岗位
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserPostService-getByUserId)-根据userId获取用户岗位-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserPostService-add)-新增用户岗位-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户岗位
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserPostService-deleteById)-根据id获取用户岗位-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据ids删除用户岗位
	 * @param ids
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteByIds(List<Integer> ids) {
		logger.info("(UserPostService-deleteByIds)-根据ids获取用户岗位-传入参数, ids:{}", ids);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/deleteByIds/"+ids, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户岗位
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserPostService-update)-修改用户岗位-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_post+"/modify", params, JSONObject.class);
		return response;
	}

}