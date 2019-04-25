package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IEnterpriseService;

/**
 * 企业 EnterpriseService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class EnterpriseServiceImpl extends BaseService implements IEnterpriseService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(EnterpriseService-getListByPage)-分页获取企业列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(EnterpriseService-getList)-获取企业列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取企业
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(EnterpriseService-getById)-根据id获取企业-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增企业
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(EnterpriseService-add)-新增企业-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除企业
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(EnterpriseService-deleteById)-根据id获取企业-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改企业
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(EnterpriseService-update)-修改企业-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/modify", params, JSONObject.class);
		return response;
	}

}