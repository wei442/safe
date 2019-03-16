package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IDictItemService {

	/**
	 * 分页获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDictItemListByPage(Object params);

	/**
	 * 获取字典子项列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getDictItemList(Object params);

	/**
	 * 根据id获取字典子项
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getDictItemById(Integer id);

	/**
	 * 新增字典子项
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addDictItem(Object params);

	/**
	 * 根据id删除字典子项
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteDictItemById(Integer id);

	/**
	 * 修改字典子项
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateDictItem(Object params);

}