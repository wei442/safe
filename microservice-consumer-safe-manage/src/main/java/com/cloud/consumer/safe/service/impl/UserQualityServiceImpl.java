package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserQualityService;

/**
 * 用户资质 UserQualityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserQualityServiceImpl extends BaseService implements IUserQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserQualityListByPage(Object params) {
		logger.info("(UserQualityService-getUserQualityListByPage)-分页获取用户职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/selectUserQualityListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserQualityList(Object params) {
		logger.info("(UserQualityService-getUserQualityList)-获取用户职务列表-传入参数, params:{}", params);


		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/selectUserQualityList", params, JSONObject.class);

		return response;
	}

	/**
	 * 根据id获取用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserQualityById(Integer id) {
		logger.info("(UserQualityService-getUserQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/selectUserQualityById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserQuality(Object params) {
		logger.info("(UserQualityService-addUserQuality)-新增用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/insertUserQuality", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserQualityById(Integer id) {
		logger.info("(UserQualityService-deleteUserQualityById)-根据id获取用户职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/deleteUserQualityById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserQuality(Object params) {
		logger.info("(UserQualityService-updateUserQuality)-修改用户职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/modifyUserQuality", params, JSONObject.class);
		return response;
	}

}