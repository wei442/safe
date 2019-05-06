package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IOrgService {

	/**
	 * 获取组织机构树列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getTreeList(Object params);

	/**
	 * 获取父组织机构树列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getParentTreeList(Object params);

	/**
	 * 分页获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取组织机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增组织机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除组织机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改组织机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}