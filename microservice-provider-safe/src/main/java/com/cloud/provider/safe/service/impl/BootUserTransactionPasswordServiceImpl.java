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
import com.ochain.provider.wheel.dao.UserTransactionPasswordMapper;
import com.ochain.provider.wheel.param.UserTransactionPasswordParam;
import com.ochain.provider.wheel.po.UserTransactionPassword;
import com.ochain.provider.wheel.po.UserTransactionPasswordExample;
import com.ochain.provider.wheel.service.IBootUserTransactionPasswordService;

@Service
public class BootUserTransactionPasswordServiceImpl implements IBootUserTransactionPasswordService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户交易密码 Mapper
	@Autowired
	private UserTransactionPasswordMapper userTransactionPasswordMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param userTransactionPassword
	 * @return List<UserTransactionPassword>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserTransactionPassword>selectUserTransactionPasswordListByPage(Page<UserTransactionPassword> page, UserTransactionPassword userTransactionPassword) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-selectUserTransactionPasswordListByPage)-分页查询-传入参数, page:{}, userTransactionPassword:{}", page, userTransactionPassword);
		UserTransactionPasswordExample example = new UserTransactionPasswordExample();
		UserTransactionPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
		if(null != userTransactionPassword) {
			if(null != userTransactionPassword.getPassword()) {
				criteria.andPasswordEqualTo(userTransactionPassword.getPassword());
			}
			if(null != userTransactionPassword.getUserId()) {
				criteria.andUserIdEqualTo(userTransactionPassword.getUserId());
			}
			if(null != userTransactionPassword.getUserId()) {
				criteria.andStatusEqualTo(userTransactionPassword.getStatus());
			} else {
				criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
			}
		}
		List<UserTransactionPassword> list = null;
		try {
			list = userTransactionPasswordMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-selectUserTransactionPasswordListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userTransactionPassword
	 * @return List<UserTransactionPassword>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserTransactionPassword> selectUserTransactionPasswordList(UserTransactionPassword userTransactionPassword) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-selectUserTransactionPasswordList)-不分页查询-传入参数, userTransactionPassword:{}", userTransactionPassword);
		UserTransactionPasswordExample example = new UserTransactionPasswordExample();
		UserTransactionPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
		if(null != userTransactionPassword) {
			if(null != userTransactionPassword.getPassword()) {
				criteria.andPasswordEqualTo(userTransactionPassword.getPassword());
			}
			if(null != userTransactionPassword.getUserId()) {
				criteria.andUserIdEqualTo(userTransactionPassword.getUserId());
			}
			if(null != userTransactionPassword.getUserId()) {
				criteria.andStatusEqualTo(userTransactionPassword.getStatus());
			} else {
				criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
			}
		}
		List<UserTransactionPassword> list = null;
		try {
			list = userTransactionPasswordMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-selectUserTransactionPasswordList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询用户交易密码表信息
	 * @param id
	 * @return UserTransactionPassword
	 * @throws BootServiceException
	 */
	@Override
	public UserTransactionPassword selectUserTransactionPasswordById(Integer id) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-selectUserTransactionPasswordById)-根据id查询用户交易密码表信息-传入参数, id:{}", id);
		UserTransactionPassword userTransactionPassword = null;
		try {
			userTransactionPassword = userTransactionPasswordMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-selectUserTransactionPasswordById)-根据id查询用户交易密码表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return userTransactionPassword;
	}

	/**
	 * 根据userId查询用户交易密码
	 * @param userId
	 * @return UserTransactionPassword
	 * @throws BootServiceException
	 */
	@Override
	public UserTransactionPassword selectUserTransactionPasswordByUserId(Integer userId) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-selectUserTransactionPasswordByUserId)-根据userId查询用户交易密码-传入参数, userId:{}", userId);
		UserTransactionPasswordExample example = new UserTransactionPasswordExample();
		UserTransactionPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
		List<UserTransactionPassword> list = null;
		try {
			list = userTransactionPasswordMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-selectUserTransactionPasswordByUserId)-根据userId查询用户交易密码-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		UserTransactionPassword userTransactionPassword = null;
		if(list != null && !list.isEmpty()) {
			userTransactionPassword = list.get(0);
		}
		return userTransactionPassword;
	}

	/**
	 * 新增用户交易密码
	 * @param UserTransactionPassword
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertUserTransactionPassword(UserTransactionPassword userTransactionPassword) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-insertUserTransactionPassword)-插入用户交易密码-传入参数, userTransactionPassword:{}", userTransactionPassword);
		userTransactionPassword.setStatus(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
		userTransactionPassword.setCreateTime(new Date());
		userTransactionPassword.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userTransactionPasswordMapper.insertSelective(userTransactionPassword);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-insertUserTransactionPassword)-插入用户交易密码-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 修改用户交易密码
	 * @param UserTransactionPassword
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyUserTransactionPassword(UserTransactionPassword userTransactionPassword) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-modifyUserTransactionPassword)-修改用户交易密码-传入参数, userTransactionPassword:{}", userTransactionPassword);
		userTransactionPassword.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userTransactionPasswordMapper.updateByPrimaryKeySelective(userTransactionPassword);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-modifyUserTransactionPassword)-修改用户交易密码-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 重设用户交易密码
	 * @param userId
	 * @param newPassword
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer resetUserTransactionPassword(Integer userId,String newPassword) throws BootServiceException {
		logger.info("(BootUserTransactionPasswordService-resetUserTransactionPassword)-重设用户交易密码-传入参数, userId:{}, newPassword:{}", userId, newPassword);

		UserTransactionPasswordParam param = new UserTransactionPasswordParam();
		param.setUserId(userId);
		int i = 0;
		try{
			i = userTransactionPasswordMapper.updateUserTransactionPasswordStatusByUserId(param);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-resetUserTransactionPassword)-根据userId更新用户交易密码正常状态为废弃-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}

		UserTransactionPassword newUserTransactionPassword = new UserTransactionPassword();
		newUserTransactionPassword.setUserId(userId);
		newUserTransactionPassword.setPassword(newPassword);
		newUserTransactionPassword.setStatus(SqlWheelConstants.SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL);
		newUserTransactionPassword.setCreateTime(new Date());
		newUserTransactionPassword.setUpdateTime(new Date());
		try{
			i = userTransactionPasswordMapper.insertSelective(newUserTransactionPassword);
		} catch (Exception e) {
			logger.error("(BootUserTransactionPasswordService-resetUserTransactionPassword)-插入用户交易密码-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}

		return i;
	}

}