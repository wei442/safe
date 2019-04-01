package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.BaseUserLoginLogMapper;
import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.cloud.provider.safe.po.BaseUserLoginLogExample;
import com.cloud.provider.safe.rest.request.page.BaseUserLoginLogPageRequest;
import com.cloud.provider.safe.service.IBaseUserLoginLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户登录日志 BaseUserLoginLogService
 * @author wei.yong
 */
@Service
public class BaseUserLoginLogServiceImpl implements IBaseUserLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录日志 Mapper
	@Autowired
	private BaseUserLoginLogMapper baseUserLoginLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUserLoginLog>
	 */
	public List<BaseUserLoginLog> selectListByPage(Page<?> page, BaseUserLoginLogPageRequest param) {
		logger.info("(BaseUserLoginLogService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		BaseUserLoginLogExample example = new BaseUserLoginLogExample();
		example.setOrderByClause(" id desc ");
		BaseUserLoginLogExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		
		List<BaseUserLoginLog> list = baseUserLoginLogMapper.selectByExample(example);
		return list;
	}

	/**
	 * 插入用户登录日志
	 * @param baseUserLoginLog
	 * @return Integer
	 */
	@Override
	public Integer insert(BaseUserLoginLog baseUserLoginLog) {
		logger.info("(BaseUserLoginLogService-insert)-插入基础用户登录日志-传入参数, baseUserLoginLog:{}", baseUserLoginLog);
		baseUserLoginLog.setCreateTime(new Date());
		baseUserLoginLog.setUpdateTime(new Date());
		int i = baseUserLoginLogMapper.insertSelective(baseUserLoginLog);
		return i;
	}

}