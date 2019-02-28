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
import com.ochain.provider.wheel.dao.AccountCalculateMapper;
import com.ochain.provider.wheel.param.AccountCalculateParam;
import com.ochain.provider.wheel.po.AccountCalculate;
import com.ochain.provider.wheel.po.AccountCalculateExample;
import com.ochain.provider.wheel.service.IBootAccountCalculateService;
import com.ochain.provider.wheel.vo.account.AccountCalculateUserVo;

/**
 * 账户算力接口 BootAccountCalculateService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootAccountCalculateServiceImpl implements IBootAccountCalculateService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //账户算力 Mapper
    @Autowired
    private AccountCalculateMapper accountCalculateMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param accountCalculate
	 * @return List<AccountCalculate>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountCalculate> selectAccountCalculateListByPage(Page<AccountCalculate> page, AccountCalculate accountCalculate) throws BootServiceException {
		logger.info("(BootAccountCalculateService-selectAccountCalculateListByPage)-分页查询-传入参数, page:{}, accountCalculate:{}", page, accountCalculate);
		AccountCalculateExample example = new AccountCalculateExample();
		example.setOrderByClause(" id desc ");
		AccountCalculateExample.Criteria criteria = example.createCriteria();
		if(accountCalculate != null) {
		}
		List<AccountCalculate> list = null;
		try {
			list = accountCalculateMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param accountCalculate
	 * @return List<AccountCalculate>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountCalculate> selectAccountCalculateList(AccountCalculate accountCalculate) throws BootServiceException {
		logger.info("(BootAccountCalculateService-selectAccountCalculateList)-不分页查询-传入参数, accountCalculate:{}", accountCalculate);
		AccountCalculateExample example = new AccountCalculateExample();
		AccountCalculateExample.Criteria criteria = example.createCriteria();
		if(accountCalculate != null) {
		}
		List<AccountCalculate> list = null;
		try {
			list = accountCalculateMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 分页查询倒序账户算力用户列表
	 * @param page
	 * @return List<AccountCalculateUserVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountCalculateUserVo> selectAccountCalculateVoListSortCalculateByPage(Page<AccountCalculate> page) throws BootServiceException {
		logger.info("(BootAccountCalculateService-selectAccountCalculateVoListSortCalculateByPage)-分页查询倒序账户算力用户列表-传入参数, page:{}", page);
		List<AccountCalculateUserVo> list = null;
		try {
			list = accountCalculateMapper.selectAccountCalculateUserVoListByCalculate(page);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateVoListSortCalculateByPage)-分页查询倒序账户算力用户列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 分页查询账户算力用户列表
	 * @param param
	 * @return List<AccountCalculateUserVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<AccountCalculateUserVo> selectAccountCalculateUserVoListByPage(AccountCalculateParam param) throws BootServiceException {
		logger.info("(BootAccountCalculateService-selectAccountCalculateUserVoListByPage)-分页查询账户算力用户列表-传入参数, param:{}", param);
		List<AccountCalculateUserVo> list = null;
		try {
			list = accountCalculateMapper.selectAccountCalculateUserVoListByPage(param);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateUserVoListByPage)-分页查询账户算力用户列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 查询倒序账户算力用户总条数
	 * @return Long
	 * @throws BootServiceException
	 */
	@Override
	public Long selectAccountCalculateUserVoRowsByCalculate() throws BootServiceException {
		logger.info("(BootAccountCalculateService-selectAccountCalculateUserVoRowsByCalculate)-查询倒序账户算力用户总条数-传入参数");
		long rows = 0;
		try {
			rows = accountCalculateMapper.selectAccountCalculateUserVoRowsByCalculate();
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateUserVoRowsByCalculate)-查询倒序账户算力用户总条数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return rows;
	}

    /**
     * 根据用userId查询账户算力
     * @param userId
     * @return AccountCalculate
     * @throws BootServiceException
     */
    @Override
	public AccountCalculate selectAccountCalculateByUserId(Integer userId) throws BootServiceException {
		logger.info("(BootAccountCalculateService-selectAccountCalculateByUserId)-根据userId查询账户算力-传入参数, userId:{}", userId);

		AccountCalculateExample example = new AccountCalculateExample();
		AccountCalculateExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<AccountCalculate> list = null;
		try {
			list = accountCalculateMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateByUserId)-根据userId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		AccountCalculate accountCalculate = null;
		if(list != null && !list.isEmpty()) {
			accountCalculate = list.get(0);
		}
		return accountCalculate;
	}

    /**
     * 根据id查询账户算力
     * @param id
     * @return AccountCalculate
     * @throws BootServiceException
     */
    @Override
	public AccountCalculate selectAccountCalculateById(Integer id) throws BootServiceException {
    	logger.info("(BootAccountCalculateService-selectAccountCalculateById)-根据id查询账户算力-传入参数, id:{}", id);
    	AccountCalculate accountCalculate = null;
    	try {
    		accountCalculate = accountCalculateMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootAccountCalculateService-selectAccountCalculateById)-根据id查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		return accountCalculate;
    }

    /**
     * 插入账户算力
     * @param accountCalculate
     * @return Integer
     * @throws BootServiceException
     */
    @Override
	public Integer insertAccountCalculate(AccountCalculate accountCalculate) throws BootServiceException {
    	logger.info("(BootAccountCalculateService-insertAccountCalculate)-插入账户算力-传入参数, accountCalculate:{}", accountCalculate);
    	accountCalculate.setCreateTime(new Date());
    	accountCalculate.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = accountCalculateMapper.insertSelective(accountCalculate);
    	} catch (Exception e) {
    		logger.error("(BootAccountCalculateService-insertAccountCalculate)-插入账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

    /**
     * 修改账户算力
     * @param accountCalculate
     * @return Integer
     * @throws BootServiceException
     */
    @Override
	public Integer modifyAccountCalculate(AccountCalculate accountCalculate) throws BootServiceException {
    	logger.info("(BootAccountCalculateService-modifyAccountCalculate)-修改账户算力-传入参数, accountCalculate:{}", accountCalculate);
    	accountCalculate.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = accountCalculateMapper.updateByPrimaryKeySelective(accountCalculate);
    	} catch (Exception e) {
    		logger.error("(BootAccountCalculateService-modifyAccountCalculate)-修改账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

}