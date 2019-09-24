package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDangerService;

/**
 * 隐患 DangerService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DangerServiceImpl extends BaseService implements IDangerService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取隐患列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(DangerService-getListByPage)-分页获取隐患列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取隐患列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(DangerService-getList)-获取隐患列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取隐患
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(DangerService-getById)-根据id获取隐患-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增隐患
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(DangerService-add)-新增隐患-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除隐患
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(DangerService-deleteById)-根据id获取隐患-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改隐患
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(DangerService-update)-修改隐患-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger+"/modify", params, JSONObject.class);
		return response;
	}

}