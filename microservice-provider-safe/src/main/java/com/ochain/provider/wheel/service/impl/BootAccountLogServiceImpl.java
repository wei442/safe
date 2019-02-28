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
import com.ochain.provider.wheel.dao.AccountLogMapper;
import com.ochain.provider.wheel.po.AccountLog;
import com.ochain.provider.wheel.po.AccountLogExample;
import com.ochain.provider.wheel.service.IBootAccountLogService;

/**
 * 账户日志接口 BootAccountLogService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootAccountLogServiceImpl implements IBootAccountLogService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //账户日志 Mapper
    @Autowired
    private AccountLogMapper accountLogMapper;

	/**
	 * 分页查询账户日志列表
	 * @param page
	 * @return List<AccountLog>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountLog> selectAccountLogListByPage(Page<?> page,AccountLog accountLog) throws BootServiceException {
		logger.info("(BootAccountLogService-selectAccountLogListByPageAndAccountId)-分页查询账户日志列表-传入参数, page:{},", page);
		AccountLogExample example = new AccountLogExample();
		example.setOrderByClause(" id desc ");
		AccountLogExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_ACCOUNT_LOG_STATUS_SUCESS);
		if(accountLog != null) {
			if(accountLog.getAccountId() != null) {
				criteria.andAccountIdEqualTo(accountLog.getAccountId());
			}
			if(accountLog.getType() != null) {
				criteria.andTypeEqualTo(accountLog.getType());
			}
		}

		List<AccountLog> list = null;
		try {
			list = accountLogMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootAccountLogService-selectAccountLogListByPage)-分页查询账户日志列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

    /**
     * 根据id查询账户日志
     * @param id
     * @return AccountLog
     * @throws BootServiceException
     */
	@Override
	public AccountLog selectAccountLogById(Long id) throws BootServiceException {
    	logger.info("(BootAccountLogService-selectAccountLogById)-根据id查询账户日志-传入参数, id:{}", id);
    	AccountLog accountLog = null;
    	try {
    		accountLog = accountLogMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootAccountLogService-selectAccountLogById)-根据id查询账户日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return accountLog;
    }

    /**
     * 插入账户日志
     * @param accountLog
     * @return Integer
     * @throws BootServiceException
     */
	@Override
	public Integer insertAccountLog(AccountLog accountLog) throws BootServiceException {
    	logger.info("(BootAccountLogService-insertAccountLog)-插入账户日志-传入参数, accountLog:{}", accountLog);
    	accountLog.setCreateTime(new Date());
    	accountLog.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = accountLogMapper.insertSelective(accountLog);
    	} catch (Exception e) {
    		logger.error("(BootAccountLogService-insertAccountLog)-插入账户日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

	/**
	 * 修改账户日志
	 * @param accountLog
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyAccountLog(AccountLog accountLog) throws BootServiceException {
		logger.info("(BootAccountLogService-modifyAccountLog)-修改账户日志-传入参数, accountLog:{}", accountLog);
		accountLog.setUpdateTime(new Date());
		int i = 0;
		try {
			i = accountLogMapper.updateByPrimaryKey(accountLog);
		} catch (Exception e) {
			logger.error("(BootAccountLogService-modifyAccountLog)-修改账户日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}