package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IEnterpriseService {

	/**
	 * 分页获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getEnterpriseListByPage(Map<String, Object> params);

	/**
	 * 获取企业列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getEnterpriseList(Map<String, Object> params);

	/**
	 * 根据id获取企业
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getEnterpriseById(Integer id);

	/**
	 * 新增企业
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addEnterprise(Map<String, Object> params);

	/**
	 * 根据id删除企业
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteEnterpriseById(Integer id);

	/**
	 * 修改企业
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateEnterprise(Map<String, Object> params);

}