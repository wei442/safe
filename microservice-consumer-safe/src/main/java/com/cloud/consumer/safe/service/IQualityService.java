package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IQualityService {

	/**
	 * 分页获取资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getQualityListByPage(Object params);

	/**
	 * 获取资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getQualityList(Object params);

	/**
	 * 根据id获取资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getQualityById(Integer id);

	/**
	 * 新增资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addQuality(Object params);

	/**
	 * 根据id删除资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteQualityById(Integer id);

	/**
	 * 修改资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateQuality(Object params);

}