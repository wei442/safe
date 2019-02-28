package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.UserCoinAddrMapper;
import com.ochain.provider.wheel.po.UserCoinAddr;
import com.ochain.provider.wheel.po.UserCoinAddrExample;
import com.ochain.provider.wheel.service.IBootUserCoinAddrService;

@Service
public class BootUserCoinAddrServiceImpl implements IBootUserCoinAddrService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户货币地址 Mapper
	@Autowired
	private UserCoinAddrMapper userCoinAddrMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param userCoinAddr
	 * @return List<UserCoinAddr>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserCoinAddr>selectUserCoinAddrListByPage(Page<UserCoinAddr> page, UserCoinAddr userCoinAddr) throws BootServiceException {
		logger.info("(BootUserCoinAddrService-selectUserCoinAddrListByPage)-分页查询-传入参数, page:{}, userCoinAddr:{}", page, userCoinAddr);
		UserCoinAddrExample example = new UserCoinAddrExample();
		UserCoinAddrExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_COIN_ADDR_STATUS_NORMAL);
		if(null != userCoinAddr) {
			if(StringUtils.isNotBlank(userCoinAddr.getCoinCode())) {
				criteria.andCoinCodeEqualTo(userCoinAddr.getCoinCode());
			}
			if(StringUtils.isNotBlank(userCoinAddr.getCoinName())) {
				criteria.andCoinNameEqualTo(userCoinAddr.getCoinName());
			}
			if(null != userCoinAddr.getType()) {
				criteria.andTypeEqualTo(userCoinAddr.getType());
			}
			if(null != userCoinAddr.getUserId()) {
				criteria.andUserIdEqualTo(userCoinAddr.getUserId());
			}
			if(null != userCoinAddr.getUserId()) {
				criteria.andStatusEqualTo(userCoinAddr.getStatus());
			}
		}
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-selectUserCoinAddrListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userCoinAddr
	 * @return List<UserCoinAddr>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserCoinAddr> selectUserCoinAddrList(UserCoinAddr userCoinAddr) throws BootServiceException {
		logger.info("(BootUserCoinAddrService-selectUserCoinAddrList)-不分页查询-传入参数, userCoinAddr:{}", userCoinAddr);
		UserCoinAddrExample example = new UserCoinAddrExample();
		UserCoinAddrExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_COIN_ADDR_STATUS_NORMAL);
		if(null != userCoinAddr) {
			if(StringUtils.isNotBlank(userCoinAddr.getCoinCode())) {
				criteria.andCoinCodeEqualTo(userCoinAddr.getCoinCode());
			}
			if(StringUtils.isNotBlank(userCoinAddr.getCoinName())) {
				criteria.andCoinNameEqualTo(userCoinAddr.getCoinName());
			}
			if(null != userCoinAddr.getType()) {
				criteria.andTypeEqualTo(userCoinAddr.getType());
			}
			if(null != userCoinAddr.getUserId()) {
				criteria.andUserIdEqualTo(userCoinAddr.getUserId());
			}
			if(null != userCoinAddr.getUserId()) {
				criteria.andStatusEqualTo(userCoinAddr.getStatus());
			}
		}
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-selectUserCoinAddrList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据类型查询用户货币地址列表
	 * @param type
	 * @return List<UserCoinAddr>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserCoinAddr> selectUserCoinAddrListByType(Integer type) throws BootServiceException {
		logger.info("(BootUserCoinAddrService-selectUserCoinAddrListByType)-根据类型查询用户货币地址列表-传入参数, type:{}", type);
		UserCoinAddrExample example = new UserCoinAddrExample();
		UserCoinAddrExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_COIN_ADDR_STATUS_NORMAL);
		criteria.andTypeEqualTo(type);
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-selectUserCoinAddrListByType)-根据类型查询用户货币地址列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询用户货币地址表信息
	 * @param id
	 * @return DiamondConfig
	 * @throws BootServiceException
	 */
	@Override
	public UserCoinAddr selectUserCoinAddrById(Integer id) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectDiamondConfigById)-根据id查询用户货币地址表信息-传入参数, id:{}", id);
		UserCoinAddr userCoinAddr = null;
		try {
			userCoinAddr = userCoinAddrMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-selectDiamondConfigById)-根据id查询用户货币地址表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return userCoinAddr;
	}

	/**
	 * 根据coinCode查询用户货币地址
	 * @param coinCode
	 * @return UserCoinAddr
	 * @throws BootServiceException
	 */
	@Override
	public UserCoinAddr selectUserCoinAddrByCoinCode(String coinCode) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectUserCoinAddrByCoinCode)-根据coinCode查询用户货币地址-传入参数, coinCode:{}", coinCode);
		UserCoinAddrExample example = new UserCoinAddrExample();
		UserCoinAddrExample.Criteria criteria = example.createCriteria();
		criteria.andCoinCodeEqualTo(coinCode);
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_COIN_ADDR_STATUS_NORMAL);
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-selectUserCoinAddrByCoinCode)-根据coinCode查询用户货币地址-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		UserCoinAddr userCoinAddr = null;
		if(list != null && !list.isEmpty()) {
			userCoinAddr = list.get(0);
		}
		return userCoinAddr;
	}

	/**
	 * 根据publicKey查询用户货币地址
	 * @param publicKey
	 * @return UserCoinAddr
	 * @throws BootServiceException
	 */
	public UserCoinAddr selectUserCoinAddrByPublicKey(String publicKey) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectUserCoinAddrByPublicKey)-根据publicKey查询用户货币地址-传入参数, publicKey:{}", publicKey);
		UserCoinAddrExample example = new UserCoinAddrExample();
		UserCoinAddrExample.Criteria criteria = example.createCriteria();
		criteria.andPublicKeyEqualTo(publicKey);
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_COIN_ADDR_STATUS_NORMAL);
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-selectUserCoinAddrByPublicKey)-根据publicKey查询用户货币地址-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		UserCoinAddr userCoinAddr = null;
		if(list != null && !list.isEmpty()) {
			userCoinAddr = list.get(0);
		}
		return userCoinAddr;
	}

	/**
	 * 新增用户货币地址数据
	 * @param UserCoinAddr
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertUserCoinAddr(UserCoinAddr userCoinAddr) throws BootServiceException {
		logger.info("(BootUserCoinAddrService-insertUserCoinAddr)-插入用户货币地址数据-传入参数, userCoinAddr:{}", userCoinAddr);
		userCoinAddr.setStatus(SqlWheelConstants.SQL_USER_COIN_ADDR_STATUS_NORMAL);
		userCoinAddr.setCreateTime(new Date());
		userCoinAddr.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userCoinAddrMapper.insertSelective(userCoinAddr);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-insertUserCoinAddr)-插入用户货币地址数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 修改用户货币地址数据
	 * @param UserCoinAddr
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyUserCoinAddr(UserCoinAddr userCoinAddr) throws BootServiceException {
		logger.info("(BootUserCoinAddrService-modifyUserCoinAddr)-修改用户货币地址数据-传入参数, userCoinAddr:{}", userCoinAddr);
		userCoinAddr.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userCoinAddrMapper.updateByPrimaryKeySelective(userCoinAddr);
		} catch (Exception e) {
			logger.error("(BootUserCoinAddrService-modifyUserCoinAddr)-修改用户货币地址数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}