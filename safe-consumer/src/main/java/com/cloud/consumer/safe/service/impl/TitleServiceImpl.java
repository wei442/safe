package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.ITitleService;

/**
 * 职务 TitleService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class TitleServiceImpl extends BaseService implements ITitleService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(TitleService-getListByPage)-分页获取职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.title+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(TitleService-getList)-获取职务列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.title+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(TitleService-getById)-根据id获取职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.title+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(TitleService-add)-新增职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.title+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除职务
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(TitleService-deleteById)-根据id获取职务-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.title+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改职务
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(TitleService-update)-修改职务-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.title+"/modify", params, JSONObject.class);
		return response;
	}

}