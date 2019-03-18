package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDictItemService;

/**
 * 字典子项 Service (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DictItemServiceImpl extends BaseService implements IDictItemService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(Service-getListByPage)-分页获取字典子项列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(Service-getList)-获取字典子项列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取字典子项
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(Service-getById)-根据id获取字典子项-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增字典子项
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(Service-add)-新增字典子项-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除字典子项
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(Service-deleteById)-根据id获取字典子项-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改字典子项
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(Service-update)-修改字典子项-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/modify", params, JSONObject.class);
		return response;
	}

}