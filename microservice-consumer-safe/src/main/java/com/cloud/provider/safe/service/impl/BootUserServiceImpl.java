package com.ochain.provider.wheel.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.AccountCalculateMapper;
import com.ochain.provider.wheel.dao.AccountMapper;
import com.ochain.provider.wheel.dao.UserInfoMapper;
import com.ochain.provider.wheel.param.UserParam;
import com.ochain.provider.wheel.po.Account;
import com.ochain.provider.wheel.po.AccountCalculate;
import com.ochain.provider.wheel.po.UserInfo;
import com.ochain.provider.wheel.po.UserInfoExample;
import com.ochain.provider.wheel.service.IBootUserService;
import com.ochain.provider.wheel.vo.user.UserAccountCalcluateVo;
import com.ochain.provider.wheel.vo.user.UserAccountVo;
import com.ochain.provider.wheel.vo.user.UserCalcluateListVo;
import com.ochain.provider.wheel.vo.user.UserVo;

/**
 * 用户实现接口信息 BootUserService
 * @author wei.yong
 * @date 2017/3/1
 */
@Service
public class BootUserServiceImpl implements IBootUserService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户信息 Mapper
	@Autowired
	private UserInfoMapper userInfoMapper;

	//账户 Mapper
    @Autowired
    private AccountMapper accountMapper;

    //账户算力 Mapper
    @Autowired
    private AccountCalculateMapper accountCalculateMapper;

  	/**
	 * 分页查询
	 * @param page
	 * @param userInfo
	 * @return List<UserInfo>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserInfo> selectUserInfoListByPage(Page<UserInfo> page, UserInfo userInfo) throws BootServiceException {
		logger.info("(BootUserService-selectUserInfoListByPage)-分页查询-传入参数, page:{}, userInfo:{}", page, userInfo);
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_STATUS_NORMAL);
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_USER_IS_DELETE_NO);
		if(userInfo != null) {
		}

		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserInfoListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userInfo
	 * @return List<UserInfo>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserInfo> selectUserInfoList(UserInfo userInfo) throws BootServiceException {
		logger.info("(BootUserService-selectUserInfoList)-不分页查询-传入参数, userInfo:{}", userInfo);
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_STATUS_NORMAL);
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_USER_IS_DELETE_NO);
		if(userInfo != null) {
		}

		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserInfoList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据status查询用户信息列表
	 * @param status
	 * @return List<UserInfo>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserInfo> selectUserInfoListByStatus(Integer status) throws BootServiceException {
		logger.info("(BootUserService-selectUserInfoListByStatus)-根据status查询用户信息列表-传入参数, status:{}", status);
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserInfoListByStatus)-根据status查询用户信息列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		return list;
	}

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return UserInfo
	 * @throws BootServiceException
	 */
	@Override
	public UserInfo selectUserInfoById(Integer id) throws BootServiceException {
		logger.info("(BootUserService-selectUserInfoById)-根据id查询用户信息-传入参数, id:{}", id);
		UserInfo userInfo = null;
		try {
			userInfo = userInfoMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserInfoById)-根据id查询用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return userInfo;
	}

	/**
	 * 根据userAccount查询用户信息
	 * @param userAccount
	 * @return UserInfo
	 * @throws BootServiceException
	 */
	@Override
	public UserInfo selectUserInfoByUserAccount(String userAccount) throws BootServiceException {
		logger.info("(BootUserService-selectUserInfoByCode)-根据userAccount查询用户信息-传入参数, userAccount:{}", userAccount);
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andUserAccountEqualTo(userAccount);
		criteria.andStatusEqualTo(SqlWheelConstants.SQL_USER_STATUS_NORMAL);
		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserInfoByCode)-根据code查询用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		UserInfo userInfo = null;
		if(list != null && !list.isEmpty()) {
			userInfo = list.get(0);
		}
		return userInfo;
	}

	/**
	 * 根据gId查询用户信息
	 * @param gId
	 * @return UserInfo
	 * @throws BootServiceException
	 */
	@Override
	public UserInfo selectUserInfoByGId(String gId) throws BootServiceException {
		logger.info("(BootUserService-selectUserInfoByGId)-根据gId查询用户信息-传入参数, gId:{}", gId);
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andGIdEqualTo(gId);
		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserInfoByGId)-根据gId查询用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		UserInfo userInfo = null;
		if(list != null && !list.isEmpty()) {
			userInfo = list.get(0);
		}
		return userInfo;
	}

	/**
	 * 插入用户信息
	 * @param userInfo
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertUserInfo(UserInfo userInfo) throws BootServiceException {
		logger.info("(BootUserService-insertUserInfo)-插入用户信息-传入参数, userInfo:{}", userInfo);
		userInfo.setStatus(SqlWheelConstants.SQL_USER_STATUS_NORMAL);
		userInfo.setIsDelete(SqlWheelConstants.SQL_USER_IS_DELETE_NO);
		userInfo.setCreateTime(new Date());
		userInfo.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userInfoMapper.insertSelective(userInfo);
		} catch (Exception e) {
			logger.error("(BootUserService-insertUserInfo)-插入用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 插入用户信息和用户账户
	 * @param userInfo
	 * @return UserVo
	 * @throws BootServiceException
	 */
	@Override
	public UserVo insertUser(UserInfo userInfo) throws BootServiceException {
		logger.info("(BootUserService-insertUser)-插入用户信息和用户账户-传入参数, userInfo:{}", userInfo);
		userInfo.setStatus(SqlWheelConstants.SQL_USER_STATUS_NORMAL);
		userInfo.setIsDelete(SqlWheelConstants.SQL_USER_IS_DELETE_NO);
		userInfo.setCreateTime(new Date());
		userInfo.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userInfoMapper.insertSelective(userInfo);
		} catch (Exception e) {
			logger.error("(BootUserService-insertUser)-插入用户信息和用户账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		Integer userId = userInfo.getUserId();

		Account account = new Account();
		account.setUserId(userId);
		account.setDiamond(new BigDecimal("0"));
		account.setCreateTime(new Date());
    	account.setUpdateTime(new Date());
    	i = 0;
    	try {
    		i = accountMapper.insertSelective(account);
    	} catch (Exception e) {
    		logger.error("(BootAccountService-insertUser)-插入账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}

		AccountCalculate accountCalculate = new AccountCalculate();
		accountCalculate.setUserId(userId);
		accountCalculate.setCalculate(0);
		accountCalculate.setCivilizeCalculate(0);
		accountCalculate.setTaskCalculate(0);
		accountCalculate.setCreateTime(new Date());
		accountCalculate.setUpdateTime(new Date());
		i = 0;
		try {
			i = accountCalculateMapper.insertSelective(accountCalculate);
		} catch (Exception e) {
			logger.error("(BootAccountService-insertUser)-插入账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}

		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(userInfo, userVo);
		BeanUtils.copyProperties(account, userVo);
		BeanUtils.copyProperties(accountCalculate, userVo);
		return userVo;
	}


	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyUserInfo(UserInfo userInfo) throws BootServiceException {
		logger.info("(BootUserService-modifyUserInfo)-修改用户信息-传入参数, userInfo:{}", userInfo);
		userInfo.setUpdateTime(new Date());
		int i = 0;
		try{
			i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
		} catch (Exception e) {
			logger.error("(BootUserService-modifyUserInfo)-修改用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer deleteUserInfoById(Integer id) throws BootServiceException {
		logger.info("(BootUserService-deleteUserInfoById)-根据id删除用户信息-传入参数, id:{}", id);
		int i = 0;
		try {
			i = userInfoMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserService-deleteUserInfoById)-根据id删除用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 分页查询用户信息/账户/账户日志列表
	 * @param page
	 * @param param
	 * @return List<UserAccountVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserAccountVo> selectUserAccountVoListByPage(Page<UserInfo> page, UserParam param) throws BootServiceException {
		logger.info("(BootUserService-selectUserAccountVoListByPage)-分页查询用户信息/账户/账户日志列表-传入参数, page:{}, param:{}", page, param);
		List<UserAccountVo> list = null;
		try {
			list = userInfoMapper.selectUserAccountVoListByParam(page, param);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserAccountVoListByPage)-分页查询用户信息/账户/账户日志列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 分页查询用户信息/账户算力/账户算力日志列表
	 * @param page
	 * @param param
	 * @return List<UserAccountCalcluateVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserAccountCalcluateVo> selectUserAccountCalcluateVoListByPage(Page<UserInfo> page, UserParam param) throws BootServiceException {
		logger.info("(BootUserService-selectUserAccountCalcluateVoListByPage)-分页查询用户信息/账户算力/账户算力日志列表-传入参数, page:{}, param:{}", page, param);
		List<UserAccountCalcluateVo> list = null;
		try {
			list = userInfoMapper.selectUserAccountCalcluateVoListByParam(page, param);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserAccountCalcluateVoListByPage)-分页查询用户信息/账户算力/账户算力日志列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}
	/**
	 * 分页查询用户信息/账户算力列表
	 * @param page
	 * @param param
	 * @return List<UserAccountCalcluateVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<UserCalcluateListVo> selectUserCalcluateListByPage(Page<UserInfo> page, UserParam param) throws BootServiceException{
		logger.info("(BootUserService-selectUserCalcluateListByPage)-分页查询用户信息/账户算力列表-传入参数, page:{}, param:{}", page, param);
		List<UserCalcluateListVo> list = null;
		try {
			list = userInfoMapper.selectUserCalcluateListByParam(page, param);
		} catch (Exception e) {
			logger.error("(BootUserService-selectUserCalcluateListByPage)-分页查询用户信息/账户算力列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}
}