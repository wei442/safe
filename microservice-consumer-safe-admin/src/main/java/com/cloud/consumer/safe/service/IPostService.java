package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IPostService {

	/**
	 * 分页获取岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getPostListByPage(Object params);

	/**
	 * 获取岗位列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getPostList(Object params);

	/**
	 * 根据id获取岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getPostById(Integer id);

	/**
	 * 新增岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addPost(Object params);

	/**
	 * 根据id删除岗位
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deletePostById(Integer id);

	/**
	 * 修改岗位
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updatePost(Object params);

}