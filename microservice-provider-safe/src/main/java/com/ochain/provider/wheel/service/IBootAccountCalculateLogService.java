package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.AccountCalculateLog;

public interface IBootAccountCalculateLogService {

    /**
     * 分页查询账户算力日志列表
     * @param page
     * @return List<AccountCalculateLog>
     * @throws BootServiceException
     */
	public List<AccountCalculateLog> selectAccountCalculateLogListByPage(Page<?> page,AccountCalculateLog accountCalculateLog) throws BootServiceException;

    /**
     * 根据id查询账户算力日志
     * @param id
     * @return AccountCalculateLog
     * @throws BootServiceException
     */
	public AccountCalculateLog selectAccountCalculateLogById(Long id) throws BootServiceException;

    /**
     * 插入账户算力日志
     * @param accountCalculateLog
     * @return Integer
     * @throws BootServiceException
     */
	public Integer insertAccountCalculateLog(AccountCalculateLog accountCalculateLog) throws BootServiceException;

	/**
	 * 修改账户算力日志
	 * @param accountCalculateLog
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyAccountCalculateLog(AccountCalculateLog accountCalculateLog) throws BootServiceException;

}