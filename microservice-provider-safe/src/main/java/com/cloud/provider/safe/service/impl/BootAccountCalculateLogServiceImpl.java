package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.AccountCalculateLogMapper;
import com.ochain.provider.wheel.po.AccountCalculateLog;
import com.ochain.provider.wheel.po.AccountCalculateLogExample;
import com.ochain.provider.wheel.service.IBootAccountCalculateLogService;

/**
 * 账户算力日志接口 BootAccountCalculateLogService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootAccountCalculateLogServiceImpl implements IBootAccountCalculateLogService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //账户算力日志 Mapper
    @Autowired
    private AccountCalculateLogMapper accountCalculateLogMapper;

    /**
     * 分页查询账户算力日志列表
     * @param page
     * @return List<AccountCalculateLog>
     * @throws BootServiceException
     */
	@Override
	public List<AccountCalculateLog> selectAccountCalculateLogListByPage(Page<?> page,AccountCalculateLog accountCalculateLog) throws BootServiceException {
		logger.info("(BootAccountCalculateLogService-selectAccountCalculateLogListByPageAndAccountId)-分页查询账户算力日志列表-传入参数, page:{}, accountCalculateLog:{}", page, accountCalculateLog);
		AccountCalculateLogExample example = new AccountCalculateLogExample();
		example.setOrderByClause(" id desc ");
		AccountCalculateLogExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_ACCOUNT_CALCULATE_LOG_STATUS_SUCESS);
		if(accountCalculateLog != null) {
			if(accountCalculateLog.getAccountCalculateId() != null) {
				criteria.andAccountCalculateIdEqualTo(accountCalculateLog.getAccountCalculateId());
			}
			if(accountCalculateLog.getType() != null) {
				criteria.andTypeEqualTo(accountCalculateLog.getType());
			}
			if(accountCalculateLog.getCalculateType() != null) {
				criteria.andCalculateTypeEqualTo(accountCalculateLog.getCalculateType());
			}
		}

		List<AccountCalculateLog> list = null;
		try {
			list = accountCalculateLogMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateLogService-selectAccountCalculateLogListByPage)-分页查询账户算力日志列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

    /**
     * 根据id查询账户算力日志
     * @param id
     * @return AccountCalculateLog
     * @throws BootServiceException
     */
	@Override
	public AccountCalculateLog selectAccountCalculateLogById(Long id) throws BootServiceException {
    	logger.info("(BootAccountCalculateLogService-selectAccountCalculateLogById)-根据id查询账户算力日志-传入参数, id:{}", id);
    	AccountCalculateLog accountCalculateLog = null;
    	try {
    		accountCalculateLog = accountCalculateLogMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateLogService-selectAccountCalculateLogById)-根据id查询账户算力日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return accountCalculateLog;
    }

    /**
     * 插入账户算力日志
     * @param accountCalculateLog
     * @return Integer
     * @throws BootServiceException
     */
	@Override
	public Integer insertAccountCalculateLog(AccountCalculateLog accountCalculateLog) throws BootServiceException {
    	logger.info("(BootAccountCalculateLogService-insertAccountCalculateLog)-插入账户算力日志-传入参数, accountCalculateLog:{}", accountCalculateLog);
    	accountCalculateLog.setCreateTime(new Date());
    	accountCalculateLog.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = accountCalculateLogMapper.insertSelective(accountCalculateLog);
    	} catch (Exception e) {
    		logger.error("(BootAccountCalculateLogService-insertAccountCalculateLog)-插入账户算力日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

	/**
	 * 修改账户算力日志
	 * @param accountCalculateLog
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyAccountCalculateLog(AccountCalculateLog accountCalculateLog) throws BootServiceException {
		logger.info("(BootAccountCalculateLogService-modifyAccountCalculateLog)-修改账户算力日志-传入参数, accountCalculateLog:{}", accountCalculateLog);
		accountCalculateLog.setUpdateTime(new Date());
		int i = 0;
		try {
			i = accountCalculateLogMapper.updateByPrimaryKey(accountCalculateLog);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateLogService-modifyAccountCalculateLog)-修改账户算力日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}