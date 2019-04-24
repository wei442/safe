package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IDangerAttachmentService {

	/**
	 * 分页获取隐患附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取隐患附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取隐患附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增隐患附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除隐患附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改隐患附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}