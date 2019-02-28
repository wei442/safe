package com.ochain.provider.wheel.service;

import com.ochain.common.exception.BootServiceException;
import com.ochain.provider.wheel.po.UserLoginLog;

public interface IBootUserLoginLogService {

	/**
	 * 插入用户登录日志
	 * @param record
	 * @return int
	 * @throws BootServiceException
	 */
	public Integer insertUserLoginLog(UserLoginLog record) throws BootServiceException;

}