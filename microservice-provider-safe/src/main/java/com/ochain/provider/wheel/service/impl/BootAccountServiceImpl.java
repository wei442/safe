package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.AccountMapper;
import com.ochain.provider.wheel.param.AccountParam;
import com.ochain.provider.wheel.po.Account;
import com.ochain.provider.wheel.po.AccountExample;
import com.ochain.provider.wheel.service.IBootAccountService;
import com.ochain.provider.wheel.vo.account.AccountUserVo;

/**
 * 账户接口 BootAccountService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootAccountServiceImpl implements IBootAccountService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //账户 Mapper
    @Autowired
    private AccountMapper accountMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param account
	 * @return List<Account>
	 * @throws BootServiceException
	 */
	@Override
	public List<Account> selectAccountListByPage(Page<Account> page, Account account) throws BootServiceException {
		logger.info("(BootAccountService-selectAccountListByPage)-分页查询-传入参数, page:{}, account:{}", page, account);
		AccountExample example = new AccountExample();
		example.setOrderByClause(" id desc ");
		AccountExample.Criteria criteria = example.createCriteria();
		if(account != null) {
		}
		List<Account> list = null;
		try {
			list = accountMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param account
	 * @return List<Account>
	 * @throws BootServiceException
	 */
	@Override
	public List<Account> selectAccountList(Account account) throws BootServiceException {
		logger.info("(BootAccountService-selectAccountList)-不分页查询-传入参数, account:{}", account);
		AccountExample example = new AccountExample();
		example.setOrderByClause(" id desc ");
		AccountExample.Criteria criteria = example.createCriteria();
		if(account != null) {
		}
		List<Account> list = null;
		try {
			list = accountMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 分页查询倒序账户能量用户列表
	 * @param page
	 * @return List<AccountUserVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountUserVo> selectAccountVoListSortDiamondByPage(Page<Account> page) throws BootServiceException {
		logger.info("(BootAccountService-selectAccountVoListSortDiamondByPage)-分页查询倒序账户能量用户列表-传入参数, page:{}", page);
		List<AccountUserVo> list = null;
		try {
			list = accountMapper.selectAccountVoListByDiamond(page);
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountVoListSortDiamondByPage)-分页查询倒序账户能量用户列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 分页查询账户能量用户列表
	 * @param param
	 * @return List<AccountUserVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountUserVo> selectAccountVoListByPage(AccountParam param) throws BootServiceException {
		logger.info("(BootAccountService-selectAccountVoListByPage)-分页查询账户能量用户列表-传入参数, param:{}", param);
		List<AccountUserVo> list = null;
		try {
			list = accountMapper.selectAccountVoListByPage(param);
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountVoListByPage)-分页查询账户能量用户列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 查询倒序账户能量用户总条数
	 * @throws BootServiceException
	 */
	@Override
	public Long selectAccountVoRowsByDiamond() throws BootServiceException {
		logger.info("(BootAccountService-selectAccountVoRows)-查询倒序账户能量用户总条数-传入参数");
		long rows = 0;
		try {
			rows = accountMapper.selectAccountVoRowsByDiamond();
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountVoRows)-查询倒序账户能量用户总条数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return rows;
	}

    /**
     * 根据userId查询账户
     * @param userId
     * @return Account
     * @throws BootServiceException
     */
    @Override
	public Account selectAccountByUserId(Integer userId) throws BootServiceException {
		logger.info("(BootAccountService-selectAccountByUserId)-根据userId查询账户-传入参数, userId:{}", userId);

		AccountExample example = new AccountExample();
		AccountExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Account> list = null;
		try {
			list = accountMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountByUserId)-根据userId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		Account account = null;
		if(list != null && !list.isEmpty()) {
			account = list.get(0);
		}
		return account;
	}

    /**
     * 根据id查询账户
     * @param id
     * @return Account
     * @throws BootServiceException
     */
    @Override
	public Account selectAccountById(Integer id) throws BootServiceException {
    	logger.info("(BootAccountService-selectAccountById)-根据id查询账户-传入参数, id:{}", id);
    	Account account = null;
    	try {
    		account = accountMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootAccountService-selectAccountById)-根据id查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return account;
    }

    /**
     * 插入账户
     * @param account
     * @return Integer
     * @throws BootServiceException
     */
    @Override
	public Integer insertAccount(Account account) throws BootServiceException {
    	logger.info("(BootAccountService-insertAccount)-插入账户-传入参数, account:{}", account);
    	account.setCreateTime(new Date());
    	account.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = accountMapper.insertSelective(account);
    	} catch (Exception e) {
    		logger.error("(BootAccountService-insertAccount)-插入账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

    /**
     * 修改账户
     * @param account
     * @return Integer
     * @throws BootServiceException
     */
    @Override
	public Integer modifyAccount(Account account) throws BootServiceException {
    	logger.info("(BootAccountService-modifyAccount)-修改账户-传入参数, account:{}", account);
    	account.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = accountMapper.updateByPrimaryKeySelective(account);
    	} catch (Exception e) {
    		logger.error("(BootAccountService-modifyAccount)-修改账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

}