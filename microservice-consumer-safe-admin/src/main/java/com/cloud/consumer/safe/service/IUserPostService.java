package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IUserPostService {

	/**
	 * 分页获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserPostListByPage(Map<String, Object> params);

	/**
	 * 获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserPostList(Map<String, Object> params);

	/**
	 * 根据id获取用户岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserPostById(Integer id);

	/**
	 * 新增用户岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserPost(Map<String, Object> params);

	/**
	 * 根据id删除用户岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteUserPostById(Integer id);

	/**
	 * 修改用户岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateUserPost(Map<String, Object> params);

}