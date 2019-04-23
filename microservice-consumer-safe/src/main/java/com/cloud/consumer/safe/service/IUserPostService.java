package com.cloud.consumer.safe.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface IUserPostService {

	/**
	 * 分页获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取用户岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 根据userId获取用户岗位
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getByUserId(Integer userId);

	/**
	 * 新增用户岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 新增批量用户岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addList(Object params);

	/**
	 * 根据id删除用户岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 根据ids删除用户岗位
	 * @param ids
	 * @return JSONObject
	 */
	public JSONObject deleteByIds(List<Integer> ids);

	/**
	 * 修改用户岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}