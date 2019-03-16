package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserPasswordService {

	/**
	 * 根据id获取基础用户密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getBaseUserPasswordById(Integer id);

	/**
	 * 根据baseUserId获取基础用户密码
	 * @param baseUserId
	 * @return JSONObject
	 */
	public JSONObject getBaseUserPasswordByBaseUserId(Integer baseUserId);

	/**
	 * 新增基础用户密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addBaseUserPassword(Object params);

	/**
	 * 根据id删除基础用户密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteBaseUserPasswordById(Integer id);

	/**
	 * 修改基础用户密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateBaseUserPassword(Object params);

}