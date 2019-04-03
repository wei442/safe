package com.cloud.consumer.safe.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserQualityService;

/**
 * 用户资质 Service (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserQualityServiceImpl extends BaseService implements IUserQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(UserQualityService-getListByPage)-分页获取用户资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(UserQualityService-getList)-获取用户资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(UserQualityService-getById)-根据id获取用户资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据userId获取用户资质
	 * @param userId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByUserId(Integer userId) {
		logger.info("(UserQualityService-getByUserId)-根据userId获取用户资质-传入参数, userId:{}", userId);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_title+"/selectByUserId/"+userId, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(UserQualityService-add)-新增用户资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(UserQualityService-deleteById)-根据id获取用户资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 根据ids删除用户资质
	 * @param ids
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteByIds(List<Integer> ids) {
		logger.info("(UserQualityService-deleteByIds)-根据ids获取用户资质-传入参数, ids:{}", ids);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/deleteByIds/"+ids, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(UserQualityService-update)-修改用户资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.user_quality+"/modify", params, JSONObject.class);
		return response;
	}

}