package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserAdminLoginMapper;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminLoginExample;
import com.cloud.provider.safe.service.IBootUserAdminLoginService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理登录 BootUserAdminLoginService
 * @author wei.yong
 */
@Service
public class BootUserAdminLoginServiceImpl implements IBootUserAdminLoginService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户管理登录 Mapper
    @Autowired
    private UserAdminLoginMapper userAdminLoginMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userAdminLogin
	 * @return List<UserAdminLogin>
	 */
	@Override
	public List<UserAdminLogin> selectUserAdminLoginListByPage(Page<?> page, UserAdminLogin userAdminLogin) {
		logger.info("(BootUserAdminLoginService-selectUserAdminLoginListByPage)-分页查询-传入参数, page:{}, userAdminLogin:{}", page, userAdminLogin);
		PageHelper.startPage(page);
		UserAdminLoginExample example = new UserAdminLoginExample();
		example.setOrderByClause(" id desc ");
		UserAdminLoginExample.Criteria criteria = example.createCriteria();
		if(userAdminLogin != null) {
		}
		List<UserAdminLogin> list = null;
		try {
			list = userAdminLoginMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAdminLoginService-selectUserAdminLoginListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userAdminLogin
	 * @return List<UserAdminLogin>
	 */
	@Override
	public List<UserAdminLogin> selectUserAdminLoginList(UserAdminLogin userAdminLogin) {
		logger.info("(BootUserAdminLoginService-selectUserAdminLoginList)-不分页查询-传入参数, userAdminLogin:{}", userAdminLogin);
		UserAdminLoginExample example = new UserAdminLoginExample();
		UserAdminLoginExample.Criteria criteria = example.createCriteria();
		if(userAdminLogin != null) {
		}
		List<UserAdminLogin> list = null;
		try {
			list = userAdminLoginMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAdminLoginService-selectUserAdminLoginList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户管理登录
     * @param id
     * @return UserAdminLogin
     */
	@Override
	public UserAdminLogin selectUserAdminLoginById(Integer id) {
    	logger.info("(BootUserAdminLoginService-selectUserAdminLoginById)-根据id查询用户管理登录-传入参数, id:{}", id);
    	UserAdminLogin userAdminLogin = null;
    	try {
    		userAdminLogin = userAdminLoginMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserAdminLoginService-selectUserAdminLoginById)-根据id查询用户管理登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userAdminLogin;
    }

    /**
     * 插入用户管理登录
     * @param userAdminLogin
     * @return Integer
     */
	@Override
	public Integer insertUserAdminLogin(UserAdminLogin userAdminLogin) {
    	logger.info("(BootUserAdminLoginService-insertUserAdminLogin)-插入用户管理登录-传入参数, userAdminLogin:{}", userAdminLogin);
    	userAdminLogin.setCreateTime(new Date());
    	userAdminLogin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userAdminLoginMapper.insertSelective(userAdminLogin);
    	} catch (Exception e) {
    		logger.error("(BootUserAdminLoginService-insertUserAdminLogin)-插入用户管理登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改用户管理登录
     * @param userAdminLogin
     * @return Integer
     */
	@Override
	public Integer modifyUserAdminLogin(UserAdminLogin userAdminLogin) {
    	logger.info("(BootUserAdminLoginService-modifyUserAdminLogin)-修改用户管理登录-传入参数, userAdminLogin:{}", userAdminLogin);
    	userAdminLogin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userAdminLoginMapper.updateByPrimaryKeySelective(userAdminLogin);
    	} catch (Exception e) {
    		logger.error("(BootUserAdminLoginService-modifyUserAdminLogin)-修改用户管理登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}