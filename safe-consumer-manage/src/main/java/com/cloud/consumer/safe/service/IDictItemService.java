package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IDictItemService {

	/**
	 * 分页获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取字典子项
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增字典子项
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除字典子项
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改字典子项
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}