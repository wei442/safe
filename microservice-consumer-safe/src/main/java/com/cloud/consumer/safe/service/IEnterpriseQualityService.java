package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IEnterpriseQualityService {

	/**
	 * 分页获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取企业资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增企业资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除企业资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改企业资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}