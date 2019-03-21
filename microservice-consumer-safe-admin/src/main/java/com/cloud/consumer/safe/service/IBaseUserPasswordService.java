package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IBaseUserPasswordService {

	/**
	 * 根据id获取基础用户密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 根据baseUserId获取基础用户密码
	 * @param baseUserId
	 * @return JSONObject
	 */
	public JSONObject getByBaseUserId(Integer baseUserId);

	/**
	 * 新增基础用户密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除基础用户密码
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改基础用户密码
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}