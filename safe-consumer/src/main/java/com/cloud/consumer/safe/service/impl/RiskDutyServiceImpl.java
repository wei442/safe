package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IRiskDutyService;

/**
 * 风险验收 RiskDutyService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class RiskDutyServiceImpl extends BaseService implements IRiskDutyService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取风险验收列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(RiskDutyService-getListByPage)-分页获取风险验收列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_duty+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取风险验收列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(RiskDutyService-getList)-获取风险验收列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_duty+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取风险验收
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(RiskDutyService-getById)-根据id获取风险验收-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_duty+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增风险验收
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(RiskDutyService-add)-新增风险验收-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_duty+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除风险验收
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(RiskDutyService-deleteById)-根据id获取风险验收-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_duty+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改风险验收
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(RiskDutyService-update)-修改风险验收-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_duty+"/modify", params, JSONObject.class);
		return response;
	}

}