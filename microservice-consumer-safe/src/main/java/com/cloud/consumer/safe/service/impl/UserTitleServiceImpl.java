package com.cloud.consumer.safe.service.impl;

import java.util.List;

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
	public JSONObject getListByPage(Object params) {
		logger.info("(UserTitleService-getListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserTitleService-getList)-获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserTitleService-getById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户职务
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserTitleService-getByUserId)-根据userId获取用户职务-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserTitleService-add)-新增用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserTitleService-deleteById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据ids删除用户职务
	 * @param ids
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteByIds(List<Integer> ids) {
		logger.info("(UserTitleService-deleteByIds)-根据ids获取用户职务-传入参数, ids:{}", ids);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/deleteByIds/"+ids, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserTitleService-update)-修改用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/modify", params, JSONObject.class);
		return response;
	}

}