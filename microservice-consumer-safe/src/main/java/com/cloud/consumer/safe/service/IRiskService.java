package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IRiskService {

	/**
	 * 分页获取风险列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取风险列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取风险
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增风险
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除风险
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改风险
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}