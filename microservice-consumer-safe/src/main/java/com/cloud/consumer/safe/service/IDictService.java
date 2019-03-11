package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IDictService {

	/**
	 * 分页获取字典列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDictListByPage(Object params);

	/**
	 * 获取字典列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDictList(Object params);

	/**
	 * 根据id获取字典
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getDictById(Integer id);

	/**
	 * 新增字典
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addDict(Object params);

	/**
	 * 根据id删除字典
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteDictById(Integer id);

	/**
	 * 修改字典
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateDict(Object params);

}