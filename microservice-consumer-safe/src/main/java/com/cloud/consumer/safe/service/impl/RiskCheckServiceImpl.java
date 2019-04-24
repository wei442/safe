package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IRiskCheckService;

/**
 * 风险排查 RiskCheckService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class RiskCheckServiceImpl extends BaseService implements IRiskCheckService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取风险排查列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(RiskCheckService-getListByPage)-分页获取风险排查列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_check+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取风险排查列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(RiskCheckService-getList)-获取风险排查列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_check+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取风险排查
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(RiskCheckService-getById)-根据id获取风险排查-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_check+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增风险排查
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(RiskCheckService-add)-新增风险排查-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_check+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除风险排查
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(RiskCheckService-deleteById)-根据id获取风险排查-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_check+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改风险排查
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(RiskCheckService-update)-修改风险排查-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.risk_check+"/modify", params, JSONObject.class);
		return response;
	}

}