package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IQualityAttachmentService {

	/**
	 * 分页获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取资质附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增资质附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除资质附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改资质附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}