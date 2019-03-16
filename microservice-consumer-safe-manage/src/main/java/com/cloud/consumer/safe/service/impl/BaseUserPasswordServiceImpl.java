package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IBaseUserPasswordService;

/**
 * 基础用户密码 BaseUserPasswordService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class BaseUserPasswordServiceImpl extends BaseService implements IBaseUserPasswordService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据id获取基础用户密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserPasswordById(Integer id) {
		logger.info("(BaseUserPasswordService-getBaseUserPasswordById)-根据id获取基础用户密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_password+"/selectBaseUserPasswordById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据baseUserId获取基础用户密码
	 * @param baseUserId
	 * @return JSONObject
	 */
	public JSONObject getBaseUserPasswordByBaseUserId(Integer baseUserId) {
		logger.info("(BaseUserPasswordService-getBaseUserPasswordByBaseUserId)-根据baseUserId获取基础用户密码-传入参数, baseUserId:{}", baseUserId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_password+"/selectBaseUserPasswordByBaseUserId/"+baseUserId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addBaseUserPassword(Object params) {
		logger.info("(BaseUserPasswordService-addBaseUserPassword)-新增基础用户密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_password+"/insertBaseUserPassword", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除基础用户密码
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteBaseUserPasswordById(Integer id) {
		logger.info("(BaseUserPasswordService-deleteBaseUserPasswordById)-根据id获取基础用户密码-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_password+"/deleteBaseUserPasswordById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改基础用户密码
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateBaseUserPassword(Object params) {
		logger.info("(BaseUserPasswordService-updateBaseUserPassword)-修改基础用户密码-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_password+"/modifyBaseUserPassword", params, JSONObject.class);
		return response;
	}

}