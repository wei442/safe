package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserAppLoginMapper;
import com.cloud.provider.safe.po.UserAppLogin;
import com.cloud.provider.safe.po.UserAppLoginExample;
import com.cloud.provider.safe.service.IBootUserAppLoginService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户应用登录 BootUserAppLoginService
 * @author wei.yong
 */
@Service
public class BootUserAppLoginServiceImpl implements IBootUserAppLoginService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户应用登录 Mapper
    @Autowired
    private UserAppLoginMapper userAppLoginMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userAppLogin
	 * @return List<UserAppLogin>
	 */
	@Override
	public List<UserAppLogin> selectUserAppLoginListByPage(Page<?> page, UserAppLogin userAppLogin) {
		logger.info("(BootUserAppLoginService-selectUserAppLoginListByPage)-分页查询-传入参数, page:{}, userAppLogin:{}", page, userAppLogin);
		PageHelper.startPage(page);
		UserAppLoginExample example = new UserAppLoginExample();
		example.setOrderByClause(" id desc ");
		UserAppLoginExample.Criteria criteria = example.createCriteria();
		if(userAppLogin != null) {
		}
		List<UserAppLogin> list = null;
		try {
			list = userAppLoginMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAppLoginService-selectUserAppLoginListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userAppLogin
	 * @return List<UserAppLogin>
	 */
	@Override
	public List<UserAppLogin> selectUserAppLoginList(UserAppLogin userAppLogin) {
		logger.info("(BootUserAppLoginService-selectUserAppLoginList)-不分页查询-传入参数, userAppLogin:{}", userAppLogin);
		UserAppLoginExample example = new UserAppLoginExample();
		UserAppLoginExample.Criteria criteria = example.createCriteria();
		if(userAppLogin != null) {
		}
		List<UserAppLogin> list = null;
		try {
			list = userAppLoginMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAppLoginService-selectUserAppLoginList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户应用登录
     * @param id
     * @return UserAppLogin
     */
	@Override
	public UserAppLogin selectUserAppLoginById(Integer id) {
    	logger.info("(BootUserAppLoginService-selectUserAppLoginById)-根据id查询用户应用登录-传入参数, id:{}", id);
    	UserAppLogin userAppLogin = null;
    	try {
    		userAppLogin = userAppLoginMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserAppLoginService-selectUserAppLoginById)-根据id查询用户应用登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userAppLogin;
    }

    /**
     * 插入用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	@Override
	public Integer insertUserAppLogin(UserAppLogin userAppLogin) {
    	logger.info("(BootUserAppLoginService-insertUserAppLogin)-插入用户应用登录-传入参数, userAppLogin:{}", userAppLogin);
    	userAppLogin.setCreateTime(new Date());
    	userAppLogin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userAppLoginMapper.insertSelective(userAppLogin);
    	} catch (Exception e) {
    		logger.error("(BootUserAppLoginService-insertUserAppLogin)-插入用户应用登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserTitleById(Integer id) {
  		logger.info("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userTitleMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	@Override
	public Integer modifyUserAppLogin(UserAppLogin userAppLogin) {
    	logger.info("(BootUserAppLoginService-modifyUserAppLogin)-修改用户应用登录-传入参数, userAppLogin:{}", userAppLogin);
    	userAppLogin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userAppLoginMapper.updateByPrimaryKeySelective(userAppLogin);
    	} catch (Exception e) {
    		logger.error("(BootUserAppLoginService-modifyUserAppLogin)-修改用户应用登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}