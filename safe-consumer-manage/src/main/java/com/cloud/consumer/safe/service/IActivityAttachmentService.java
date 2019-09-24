package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IActivityAttachmentService {

	/**
	 * 分页获取安全活动附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取安全活动附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取安全活动附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增安全活动附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除安全活动附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改安全活动附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}