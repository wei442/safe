package com.cloud.queue.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeLogUrlConstants;
import com.cloud.queue.safe.service.IAttachmentLogService;

/**
 * 附件日志 AttachmentLogService (microservice-provider-safe-log)
 * @author wei.yong
 */
@Service
public class AttachmentLogServiceImpl extends BaseService implements IAttachmentLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取附件日志列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(AttachmentLogService-getListByPage)-分页获取附件日志列表-传入参数, params:{}", params);
		JSONObject response = this.safeLogPostForObject(SafeLogUrlConstants.attachment_log+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 新增附件日志
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(AttachmentLogService-add)-新增附件日志-传入参数, params:{}", params);
		JSONObject response = this.safeLogPostForObject(SafeLogUrlConstants.attachment_log+"/insert", params, JSONObject.class);
		return response;
	}

}