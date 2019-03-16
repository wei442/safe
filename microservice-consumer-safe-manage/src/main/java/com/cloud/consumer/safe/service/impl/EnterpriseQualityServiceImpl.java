package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IEnterpriseQualityService;

/**
 * 企业资质 EnterpriseQualityService (microservice-provider-safe)
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
	public JSONObject getEnterpriseQualityListByPage(Object params) {
		logger.info("(EnterpriseQualityService-getEnterpriseQualityListByPage)-分页获取企业资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/selectEnterpriseQualityListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseQualityList(Object params) {
		logger.info("(EnterpriseQualityService-getEnterpriseQualityList)-获取企业资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/selectEnterpriseQualityList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取企业资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getEnterpriseQualityById(Integer id) {
		logger.info("(EnterpriseQualityService-getEnterpriseQualityById)-根据id获取企业资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/selectEnterpriseQualityById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增企业资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addEnterpriseQuality(Object params) {
		logger.info("(EnterpriseQualityService-addEnterpriseQuality)-新增企业资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/insertEnterpriseQuality", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除企业资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteEnterpriseQualityById(Integer id) {
		logger.info("(EnterpriseQualityService-deleteEnterpriseQualityById)-根据id获取企业资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/deleteEnterpriseQualityById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改企业资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateEnterpriseQuality(Object params) {
		logger.info("(EnterpriseQualityService-updateEnterpriseQuality)-修改企业资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.enterprise_quality+"/modifyEnterpriseQuality", params, JSONObject.class);
		return response;
	}

}