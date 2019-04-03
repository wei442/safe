package com.cloud.consumer.safe.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserOrgService;

/**
 * 用户机构 Service (microservice-provider-safe)
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
	public JSONObject getListByPage(Object params) {
		logger.info("(UserOrgService-getListByPage)-分页获取用户机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserOrgService-getList)-获取用户机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserOrgService-getById)-根据id获取用户机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户机构
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserOrgService-getByUserId)-根据userId获取用户机构-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserOrgService-add)-新增用户机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserOrgService-deleteById)-根据id获取用户机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据ids删除用户机构
	 * @param ids
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteByIds(List<Integer> ids) {
		logger.info("(UserOrgService-deleteByIds)-根据ids获取用户机构-传入参数, ids:{}", ids);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/deleteByIds/"+ids, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserOrgService-update)-修改用户机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_org+"/modify", params, JSONObject.class);
		return response;
	}

}