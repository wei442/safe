package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IRuleService;

/**
 * 规范文件 RuleService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class RuleServiceImpl extends BaseService implements IRuleService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取规范文件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(PostService-getListByPage)-分页获取规范文件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.rule+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取规范文件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(PostService-getList)-获取规范文件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.rule+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取规范文件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(PostService-getById)-根据id获取规范文件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.rule+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增规范文件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(PostService-add)-新增规范文件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.rule+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除规范文件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(PostService-deleteById)-根据id获取规范文件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.rule+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改规范文件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(PostService-update)-修改规范文件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.rule+"/modify", params, JSONObject.class);
		return response;
	}

}