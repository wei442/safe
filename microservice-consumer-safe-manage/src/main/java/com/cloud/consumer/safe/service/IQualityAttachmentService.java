package com.cloud.consumer.safe.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IQualityAttachmentService {

	/**
	 * 分页获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getQualityAttachmentListByPage(Object params);

	/**
	 * 获取资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getQualityAttachmentList(Object params);

	/**
	 * 根据id获取资质附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getQualityAttachmentById(Integer id);

	/**
	 * 新增资质附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject addQualityAttachment(Object params);

	/**
	 * 根据id删除资质附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteQualityAttachmentById(Integer id);

	/**
	 * 修改资质附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject updateQualityAttachment(Object params);

}