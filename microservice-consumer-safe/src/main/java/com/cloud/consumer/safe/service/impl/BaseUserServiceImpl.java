package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IBaseUserService;

/**
 * 基础用户 BaseUserService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class BaseUserServiceImpl extends BaseService implements IBaseUserService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取基础用户列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserListByPage(Object params) {
		logger.info("(BaseUserService-getBaseUserListByPage)-分页获取基础用户列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/selectBaseUserListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取基础用户列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserList(Object params) {
		logger.info("(BaseUserService-getBaseUserList)-获取基础用户列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/selectBaseUserList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取基础用户
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserById(Integer id) {
		logger.info("(BaseUserService-getBaseUserById)-根据id获取基础用户-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/selectBaseUserById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addBaseUser(Object params) {
		logger.info("(BaseUserService-addBaseUser)-新增基础用户-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/insertBaseUser", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除基础用户
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteBaseUserById(Integer id) {
		logger.info("(BaseUserService-deleteBaseUserById)-根据id获取基础用户-传入参数, id:{}", id);


		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/deleteBaseUserById/"+id, null, JSONObject.class);

		return response;
	}

	/**
	 * 修改基础用户
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateBaseUser(Object params) {
		logger.info("(BaseUserService-updateBaseUser)-修改基础用户-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user+"/modifyBaseUser", params, JSONObject.class);
		return response;
	}

}