package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserOrgService;

/**
 * 用户机构 UserOrgService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserOrgServiceImpl extends BaseService implements IUserOrgService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserOrgListByPage(Object params) {
		logger.info("(UserOrgService-getUserOrgListByPage)-分页获取用户机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserOrgListByPage", null, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserOrgList(Object params) {
		logger.info("(UserOrgService-getUserOrgList)-获取用户机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserOrgList", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserOrgById(Integer id) {
		logger.info("(UserOrgService-getUserOrgById)-根据id获取用户机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectUserOrgById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserOrg(Object params) {
		logger.info("(UserOrgService-addUserOrg)-新增用户机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/insertUserOrg", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserOrgById(Integer id) {
		logger.info("(UserOrgService-deleteUserOrgById)-根据id获取用户机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/deleteUserOrgById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserOrg(Object params) {
		logger.info("(UserOrgService-updateUserOrg)-修改用户机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/modifyUserOrg", null, JSONObject.class);
		return response;
	}

}