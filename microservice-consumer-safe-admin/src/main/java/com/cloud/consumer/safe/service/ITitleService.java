package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface ITitleService {

	/**
	 * 分页获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getTitleListByPage(Map<String, Object> params);

	/**
	 * 获取职务列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getTitleList(Map<String, Object> params);

	/**
	 * 根据id获取职务
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getTitleById(Integer id);

	/**
	 * 新增职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addTitle(Map<String, Object> params);

	/**
	 * 根据id删除职务
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteTitleById(Integer id);

	/**
	 * 修改职务
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateTitle(Map<String, Object> params);

}