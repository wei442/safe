package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IDictService;

/**
 * 字典 DictService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class DictServiceImpl extends BaseService implements IDictService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取字典列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictListByPage(Object params) {
		logger.info("(DictService-getDictListByPage)-分页获取字典列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/selectDictListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取字典列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictList(Object params) {
		logger.info("(DictService-getDictList)-获取字典列表-传入参数, params:{}", params);


		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/selectDictList", params, JSONObject.class);

		return response;
	}

	/**
	 * 根据id获取字典
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDictById(Integer id) {
		logger.info("(DictService-getDictById)-根据id获取字典-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/selectDictById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增字典
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addDict(Object params) {
		logger.info("(DictService-addDict)-新增字典-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/insertDict", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除字典
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteDictById(Integer id) {
		logger.info("(DictService-deleteDictById)-根据id获取字典-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/deleteDictById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改字典
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateDict(Object params) {
		logger.info("(DictService-updateDict)-修改字典-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.dict+"/modifyDict", params, JSONObject.class);
		return response;
	}

}