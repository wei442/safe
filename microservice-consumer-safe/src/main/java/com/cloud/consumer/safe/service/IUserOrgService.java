package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserOrgService {

	/**
	 * 分页获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserOrgListByPage(Object params);

	/**
	 * 获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserOrgList(Object params);

	/**
	 * 根据id获取用户机构
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserOrgById(Integer id);

	/**
	 * 根据userId获取用户机构
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getUserOrgByUserId(Integer userId);

	/**
	 * 新增用户机构
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserOrg(Object params);

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
	public JSONObject updateUserOrg(Object params);

}