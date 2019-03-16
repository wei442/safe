package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IAttachmentService {

	/**
	 * 分页获取附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getAttachmentListByPage(Object params);

	/**
	 * 获取附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getAttachmentList(Object params);

	/**
	 * 根据id获取附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getAttachmentById(Integer id);

	/**
	 * 新增附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addAttachment(Object params);

	/**
	 * 根据id删除附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteAttachmentById(Integer id);

	/**
	 * 修改附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateAttachment(Object params);

}