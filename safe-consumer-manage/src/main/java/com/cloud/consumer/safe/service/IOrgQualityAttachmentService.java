package com.cloud.consumer.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IOrgQualityAttachmentService {

	/**
	 * 分页获取机构资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 获取机构资质附件列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getList(Object params);

	/**
	 * 根据id获取机构资质附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject getById(Integer id);

	/**
	 * 新增机构资质附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

	/**
	 * 根据id删除机构资质附件
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject deleteById(Integer id);

	/**
	 * 修改机构资质附件
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject update(Object params);

}