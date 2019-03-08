package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserOrgService {

	/**
	 * 分页获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserOrgListByPage(Map<String, Object> params);

	/**
	 * 获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserOrgList(Map<String, Object> params);

	/**
	 * 根据id获取用户机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserOrgById(Integer id);

	/**
	 * 新增用户机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserOrg(Map<String, Object> params);

	/**
	 * 根据id删除用户机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserOrgById(Integer id);

	/**
	 * 修改用户机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserOrg(Map<String, Object> params);

}