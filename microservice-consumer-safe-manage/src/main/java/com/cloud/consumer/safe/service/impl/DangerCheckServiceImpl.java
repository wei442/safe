package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDangerCheckService;

/**
 * 隐患抽查 DangerCheckService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DangerCheckServiceImpl extends BaseService implements IDangerCheckService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取隐患抽查列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(DangerCheckService-getListByPage)-分页获取隐患抽查列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_check+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取隐患抽查列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(DangerCheckService-getList)-获取隐患抽查列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_check+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取隐患抽查
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(DangerCheckService-getById)-根据id获取隐患抽查-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_check+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增隐患抽查
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(DangerCheckService-add)-新增隐患抽查-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_check+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除隐患抽查
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(DangerCheckService-deleteById)-根据id获取隐患抽查-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_check+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改隐患抽查
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(DangerCheckService-update)-修改隐患抽查-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.danger_check+"/modify", params, JSONObject.class);
		return response;
	}

}