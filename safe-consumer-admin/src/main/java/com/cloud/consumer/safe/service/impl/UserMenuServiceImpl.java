package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserMenuService;

/**
 * 用户菜单 UserMenuService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserMenuServiceImpl extends BaseService implements IUserMenuService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户菜单列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserMenuService-getListByPage)-分页获取用户菜单列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户菜单列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserMenuService-getList)-获取用户菜单列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户菜单
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserMenuService-getById)-根据id获取用户菜单-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户菜单
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserMenuService-getByUserId)-根据userId获取用户菜单-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户菜单
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserMenuService-add)-新增用户菜单-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户菜单
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserMenuService-deleteById)-根据id获取用户菜单-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 批量删除用户菜单
	 * @param ids
	 * @return JSONObject
	 */
	@Override
	public JSONObject batchDelete(Object params) {
		logger.info("(UserMenuService-batchDelete)-批量删除用户菜单-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/batchDelete", params, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户菜单
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserMenuService-update)-修改用户菜单-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_menu+"/modify", params, JSONObject.class);
		return response;
	}

}