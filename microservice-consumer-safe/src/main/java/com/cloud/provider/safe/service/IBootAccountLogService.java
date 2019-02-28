package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.AccountLog;

public interface IBootAccountLogService {

	/**
	 * 分页查询账户日志列表
	 * @param page
	 * @return List<AccountLog>
	 * @throws BootServiceException
	 */
	public List<AccountLog> selectAccountLogListByPage(Page<?> page,AccountLog accountLog) throws BootServiceException;

    /**
     * 根据id查询账户日志
     * @param id
     * @return AccountLog
     * @throws BootServiceException
     */
	public AccountLog selectAccountLogById(Long id) throws BootServiceException;

    /**
     * 插入账户日志
     * @param accountLog
     * @return Integer
     * @throws BootServiceException
     */
	public Integer insertAccountLog(AccountLog accountLog) throws BootServiceException;

	/**
	 * 修改账户日志
	 * @param accountLog
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyAccountLog(AccountLog accountLog) throws BootServiceException;

}