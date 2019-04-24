package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IRiskAcceptService {

	/**
	 * 分页获取风险验收列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取风险验收列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取风险验收
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增风险验收
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除风险验收
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改风险验收
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}