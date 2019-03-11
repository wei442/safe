package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IOrgService;

/**
 * 组织机构 OrgService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class OrgServiceImpl extends BaseService implements IOrgService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getOrgListByPage(Object params) {
		logger.info("(OrgService-getOrgListByPage)-分页获取组织机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectOrgListByPage", null, JSONObject.class);
		return response;
	}

	/**
	 * 获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getOrgList(Object params) {
		logger.info("(OrgService-getOrgList)-获取组织机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectOrgList", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取组织机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getOrgById(Integer id) {
		logger.info("(OrgService-getOrgById)-根据id获取组织机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectOrgById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增组织机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addOrg(Object params) {
		logger.info("(OrgService-addOrg)-新增组织机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/insertOrg", null, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除组织机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteOrgById(Integer id) {
		logger.info("(OrgService-deleteOrgById)-根据id获取组织机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/deleteOrgById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改组织机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateOrg(Object params) {
		logger.info("(OrgService-updateOrg)-修改组织机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/modifyOrg", null, JSONObject.class);
		return response;
	}

}