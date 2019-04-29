package com.cloud.queue.safe.service;

import com.alibaba.fastjson.JSONObject;

public interface IAttachmentLogService {

	/**
	 * 分页获取附件日志列表
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getListByPage(Object params);

	/**
	 * 新增附件日志
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject add(Object params);

}