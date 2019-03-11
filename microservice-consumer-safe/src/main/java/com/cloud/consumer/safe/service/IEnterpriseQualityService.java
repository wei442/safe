package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IEnterpriseQualityService {

	/**
	 * 分页获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getEnterpriseQualityListByPage(Object params);

	/**
	 * 获取企业资质列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getEnterpriseQualityList(Object params);

	/**
	 * 根据id获取企业资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getEnterpriseQualityById(Integer id);

	/**
	 * 新增企业资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addEnterpriseQuality(Object params);

	/**
	 * 根据id删除企业资质
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteEnterpriseQualityById(Integer id);

	/**
	 * 修改企业资质
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateEnterpriseQuality(Object params);

}