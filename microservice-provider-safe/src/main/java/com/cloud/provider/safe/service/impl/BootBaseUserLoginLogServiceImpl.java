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
import com.cloud.provider.safe.service.IBootBaseUserLoginLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户登录日志 BootBaseUserLoginLogService
 * @author wei.yong
 */
@Service
public class BootBaseUserLoginLogServiceImpl implements IBootBaseUserLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录日志 Mapper
	@Autowired
	private BaseUserLoginLogMapper baseUserLoginLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param baseUserLoginLog
	 * @return List<BaseUserLoginLog>
	 */
	public List<BaseUserLoginLog> selectBaseUserLoginLogListByPage(Page<?> page, BaseUserLoginLog baseUserLoginLog) {
		logger.info("(BootBaseUserLoginLogService-selectBaseUserLoginLogListByPage)-分页查询-传入参数, page:{}, baseUserLoginLog:{}", page, baseUserLoginLog);
		PageHelper.startPage(page);
		BaseUserLoginLogExample example = new BaseUserLoginLogExample();
		example.setOrderByClause(" id desc ");
		BaseUserLoginLogExample.Criteria criteria = example.createCriteria();
		if(baseUserLoginLog != null) {
		}
		List<BaseUserLoginLog> list = null;
		try {
			list = baseUserLoginLogMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootBaseUserLoginLogService-selectBaseUserLoginLogListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 插入用户登录日志
	 * @param baseUserLoginLog
	 * @return Integer
	 */
	public Integer insertBaseUserLoginLog(BaseUserLoginLog baseUserLoginLog) {
		if(logger.isInfoEnabled())logger.info("(BootBaseUserLoginLogService-insertBaseUserLoginLog)-插入基础用户登录日志-传入参数, baseUserLoginLog:{}", baseUserLoginLog);
		baseUserLoginLog.setCreateTime(new Date());
		baseUserLoginLog.setUpdateTime(new Date());
		int i = 0;
		try {
			i = baseUserLoginLogMapper.insertSelective(baseUserLoginLog);
		} catch (Exception e) {
			logger.error("(BootBaseUserLoginLogService-insertBaseUserLoginLog)-插入基础用户登录日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}
		return i;
	}

}