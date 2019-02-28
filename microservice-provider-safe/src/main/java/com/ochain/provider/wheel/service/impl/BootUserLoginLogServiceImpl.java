package com.ochain.provider.wheel.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.exception.BootServiceException;
import com.ochain.provider.wheel.dao.UserLoginLogMapper;
import com.ochain.provider.wheel.po.UserLoginLog;
import com.ochain.provider.wheel.service.IBootUserLoginLogService;

@Service
public class BootUserLoginLogServiceImpl implements IBootUserLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录日志 Mapper
	@Autowired
	private UserLoginLogMapper userLoginLogMapper;

	/**
	 * 插入用户登录日志
	 * @param record
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertUserLoginLog(UserLoginLog record) throws BootServiceException {
		if(logger.isInfoEnabled())logger.info("(BootUserLoginLogService-insertUserLoginLog)-插入一条记录-传入参数, record:{}",record);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		int i = 0;
		try {
			i = userLoginLogMapper.insertSelective(record);
		} catch (Exception e) {
			logger.error("(BootUserLoginLogService-insertUserLoginLog)-插入用户登录日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}
		return i;
	}

}