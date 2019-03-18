package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IQualityService {

	/**
	 * 分页获取资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}