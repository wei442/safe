package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IPostService {

	/**
	 * 分页获取岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}