package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserInfoService {

	/**
	 * 分页获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取基础用户信息列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除基础用户信息
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改基础用户信息
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}