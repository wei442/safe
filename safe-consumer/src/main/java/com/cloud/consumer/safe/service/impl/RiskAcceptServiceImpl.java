package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IRiskAcceptService;

/**
 * 风险验收 RiskAcceptService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class RiskAcceptServiceImpl extends BaseService implements IRiskAcceptService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取风险验收列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(RiskAcceptService-getListByPage)-分页获取风险验收列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_accept+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取风险验收列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(RiskAcceptService-getList)-获取风险验收列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_accept+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取风险验收
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(RiskAcceptService-getById)-根据id获取风险验收-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_accept+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增风险验收
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(RiskAcceptService-add)-新增风险验收-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_accept+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除风险验收
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(RiskAcceptService-deleteById)-根据id获取风险验收-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_accept+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改风险验收
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(RiskAcceptService-update)-修改风险验收-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_accept+"/modify", params, JSONObject.class);
		return response;
	}

}