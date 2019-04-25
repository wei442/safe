package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IDangerService {

	/**
	 * 分页获取隐患列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取隐患列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取隐患
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增隐患
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除隐患
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改隐患
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}