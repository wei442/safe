package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IRiskService;

/**
 * 风险 RiskService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class RiskServiceImpl extends BaseService implements IRiskService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取风险列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(RiskService-getListByPage)-分页获取风险列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取风险列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(RiskService-getList)-获取风险列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取风险
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(RiskService-getById)-根据id获取风险-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增风险
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(RiskService-add)-新增风险-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除风险
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(RiskService-deleteById)-根据id获取风险-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改风险
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(RiskService-update)-修改风险-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk+"/modify", params, JSONObject.class);
		return response;
	}

}