package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IRiskCheckService {

	/**
	 * 分页获取风险排查列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取风险排查列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取风险排查
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增风险排查
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除风险排查
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改风险排查
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}