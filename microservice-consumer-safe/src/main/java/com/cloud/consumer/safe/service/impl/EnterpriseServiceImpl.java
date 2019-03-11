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
	public JSONObject getEnterpriseListByPage(Object params) {
		logger.info("(EnterpriseService-getEnterpriseListByPage)-分页获取企业列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/selectEnterpriseListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseList(Object params) {
		logger.info("(EnterpriseService-getEnterpriseList)-获取企业列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/selectEnterpriseList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取企业
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseById(Integer id) {
		logger.info("(EnterpriseService-getEnterpriseById)-根据id获取企业-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/selectEnterpriseById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增企业
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addEnterprise(Object params) {
		logger.info("(EnterpriseService-addEnterprise)-新增企业-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/insertEnterprise", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除企业
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteEnterpriseById(Integer id) {
		logger.info("(EnterpriseService-deleteEnterpriseById)-根据id获取企业-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/deleteEnterpriseById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改企业
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateEnterprise(Object params) {
		logger.info("(EnterpriseService-updateEnterprise)-修改企业-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise+"/modifyEnterprise", params, JSONObject.class);
		return response;
	}

}