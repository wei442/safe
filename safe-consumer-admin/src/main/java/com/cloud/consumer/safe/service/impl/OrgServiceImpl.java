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
	 * 获取组织机构树列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getTreeList(Object params) {
		logger.info("(OrgService-getTreeList)-获取组织机构树列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectTreeList", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取父组织机构树列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getParentTreeList(Object params) {
		logger.info("(OrgService-getParentTreeList)-获取父组织机构树列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectParentTreeList", params, JSONObject.class);
		return response;
	}

	/**
	 * 分页获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params) {
		logger.info("(OrgService-getListByPage)-分页获取组织机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params) {
		logger.info("(OrgService-getList)-获取组织机构列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取组织机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(OrgService-getById)-根据id获取组织机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增组织机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(OrgService-add)-新增组织机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除组织机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(OrgService-deleteById)-根据id获取组织机构-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改组织机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(OrgService-update)-修改组织机构-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.org+"/modify", params, JSONObject.class);
		return response;
	}

}