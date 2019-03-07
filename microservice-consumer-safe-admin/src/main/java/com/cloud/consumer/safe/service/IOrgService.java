package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IOrgService {

	/**
	 * 分页获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getOrgListByPage(Map<String, Object> params);

	/**
	 * 获取组织机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getOrgList(Map<String, Object> params);

	/**
	 * 根据id获取组织机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getOrgById(Integer id);

	/**
	 * 新增组织机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addOrg(Map<String, Object> params);

	/**
	 * 根据id删除组织机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteOrgById(Integer id);

	/**
	 * 修改组织机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateOrg(Map<String, Object> params);

}