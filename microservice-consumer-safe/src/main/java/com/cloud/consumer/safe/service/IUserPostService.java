package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserPostService {

	/**
	 * 分页获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserPostListByPage(Object params);

	/**
	 * 获取用户岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserPostList(Object params);

	/**
	 * 根据id获取用户岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getUserPostById(Integer id);

	/**
	 * 根据userId获取用户岗位
	 * @param userId
	 * @return JSONObject
	 */
	public JSONObject getUserPostByUserId(Integer userId);

	/**
	 * 新增用户岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addUserPost(Object params);

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
	public JSONObject updateUserPost(Object params);

}