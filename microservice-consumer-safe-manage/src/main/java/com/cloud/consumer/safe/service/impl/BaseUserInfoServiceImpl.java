package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IBaseUserInfoService;

/**
 * 基础用户信息 BaseUserInfoService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class BaseUserInfoServiceImpl extends BaseService implements IBaseUserInfoService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserInfoListByPage(Object params) {
		logger.info("(BaseUserInfoService-getBaseUserInfoListByPage)-分页获取基础用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/selectBaseUserInfoListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserInfoList(Object params) {
		logger.info("(BaseUserInfoService-getBaseUserInfoList)-获取基础用户信息列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/selectBaseUserInfoList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getBaseUserInfoById(Integer id) {
		logger.info("(BaseUserInfoService-getBaseUserInfoById)-根据id获取基础用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/selectBaseUserInfoById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addBaseUserInfo(Object params) {
		logger.info("(BaseUserInfoService-addBaseUserInfo)-新增基础用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/insertBaseUserInfo", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteBaseUserInfoById(Integer id) {
		logger.info("(BaseUserInfoService-deleteBaseUserInfoById)-根据id获取基础用户信息-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/deleteBaseUserInfoById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateBaseUserInfo(Object params) {
		logger.info("(BaseUserInfoService-updateBaseUserInfo)-修改基础用户信息-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.base_user_info+"/modifyBaseUserInfo", params, JSONObject.class);
		return response;
	}

}