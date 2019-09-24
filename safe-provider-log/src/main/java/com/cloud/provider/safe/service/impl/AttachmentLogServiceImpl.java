package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.provider.safe.dao.AttachmentLogMapper;
import com.cloud.provider.safe.po.AttachmentLog;
import com.cloud.provider.safe.po.AttachmentLogExample;
import com.cloud.provider.safe.rest.request.page.AttachmentLogPageRequest;
import com.cloud.provider.safe.service.IAttachmentLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户应用登录日志 AttachmentLogService
 * @author wei.yong
 */
@Service
public class AttachmentLogServiceImpl implements IAttachmentLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用登录日志 Mapper
	@Autowired
	private AttachmentLogMapper attachmentLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<AttachmentLog>
	 */
	@Override
	public List<AttachmentLog> selectListByPage(Page<?> page, AttachmentLogPageRequest param) {
		logger.info("(AttachmentLogService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		AttachmentLogExample example = new AttachmentLogExample();
		example.setOrderByClause(" id desc ");
		AttachmentLogExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}

		List<AttachmentLog> list = attachmentLogMapper.selectByExample(example);
		return list;
	}

	/**
	 * 插入附件日志
	 * @param attachmentLog
	 * @return Integer
	 */
	@Override
	public Integer insert(AttachmentLog attachmentLog) {
		logger.info("(AttachmentLogService-insert)-插入用户应用登录日志-传入参数, attachmentLog:{}", attachmentLog);
		attachmentLog.setCreateTime(new Date());
		attachmentLog.setUpdateTime(new Date());
		int i = attachmentLogMapper.insertSelective(attachmentLog);
		return i;
	}

}