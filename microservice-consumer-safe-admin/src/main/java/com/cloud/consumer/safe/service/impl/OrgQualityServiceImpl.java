package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IOrgQualityService;

/**
 * 机构资质 OrgQualityService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class OrgQualityServiceImpl extends BaseService implements IOrgQualityService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取机构资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(OrgQualityService-getListByPage)-分页获取机构资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org_quality+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取机构资质列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(OrgQualityService-getList)-获取机构资质列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org_quality+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取机构资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(OrgQualityService-getById)-根据id获取机构资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org_quality+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增机构资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(OrgQualityService-add)-新增机构资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org_quality+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除机构资质
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(OrgQualityService-deleteById)-根据id获取机构资质-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org_quality+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改机构资质
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(OrgQualityService-update)-修改机构资质-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org_quality+"/modify", params, JSONObject.class);
		return response;
	}

}