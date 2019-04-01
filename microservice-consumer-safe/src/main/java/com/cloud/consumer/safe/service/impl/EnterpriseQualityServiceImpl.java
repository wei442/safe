package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IEnterpriseQualityService;

/**
 * 企业资质 Service (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class EnterpriseQualityServiceImpl extends BaseService implements IEnterpriseQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(EnterpriseQualityService-getListByPage)-分页获取企业资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(EnterpriseQualityService-getList)-获取企业资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取企业资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(EnterpriseQualityService-getById)-根据id获取企业资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增企业资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(EnterpriseQualityService-add)-新增企业资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除企业资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(EnterpriseQualityService-deleteById)-根据id获取企业资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改企业资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(EnterpriseQualityService-update)-修改企业资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/modify", params, JSONObject.class);
		return response;
	}

}