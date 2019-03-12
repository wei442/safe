package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.AttachmentLog;
import com.cloud.provider.safe.rest.request.page.AttachmentLogPageRequest;
import com.github.pagehelper.Page;

public interface IAttachmentLogService {

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<AttachmentLog>
	 */
	public List<AttachmentLog> selectAttachmentLogListByPage(Page<?> page, AttachmentLogPageRequest param);

	/**
	 * 插入附件日志
	 * @param attachmentLog
	 * @return Integer
	 */
	public Integer insertAttachmentLog(AttachmentLog attachmentLog);

}