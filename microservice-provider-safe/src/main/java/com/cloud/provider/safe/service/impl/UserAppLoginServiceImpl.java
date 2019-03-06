package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserAppLoginMapper;
import com.cloud.provider.safe.po.UserAppLogin;
import com.cloud.provider.safe.po.UserAppLoginExample;
import com.cloud.provider.safe.service.IUserAppLoginService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户应用登录 UserAppLoginService
 * @author wei.yong
 */
@Service
public class UserAppLoginServiceImpl implements IUserAppLoginService {

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
		logger.info("(UserAppLoginService-selectUserAppLoginListByPage)-分页查询-传入参数, page:{}, userAppLogin:{}", page, userAppLogin);
		PageHelper.startPage(page);
		UserAppLoginExample example = new UserAppLoginExample();
		example.setOrderByClause(" id desc ");
		UserAppLoginExample.Criteria criteria = example.createCriteria();
		if(userAppLogin != null) {
		}
		List<UserAppLogin> list = userAppLoginMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param userAppLogin
	 * @return List<UserAppLogin>
	 */
	@Override
	public List<UserAppLogin> selectUserAppLoginList(UserAppLogin userAppLogin) {
		logger.info("(UserAppLoginService-selectUserAppLoginList)-不分页查询-传入参数, userAppLogin:{}", userAppLogin);
		UserAppLoginExample example = new UserAppLoginExample();
		UserAppLoginExample.Criteria criteria = example.createCriteria();
		if(userAppLogin != null) {
		}
		List<UserAppLogin> list = userAppLoginMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户应用登录
     * @param id
     * @return UserAppLogin
     */
	@Override
	public UserAppLogin selectUserAppLoginById(Integer id) {
    	logger.info("(UserAppLoginService-selectUserAppLoginById)-根据id查询用户应用登录-传入参数, id:{}", id);
		UserAppLogin userAppLogin = userAppLoginMapper.selectByPrimaryKey(id);
		return userAppLogin;
    }

    /**
     * 插入用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	@Override
	public Integer insertUserAppLogin(UserAppLogin userAppLogin) {
    	logger.info("(UserAppLoginService-insertUserAppLogin)-插入用户应用登录-传入参数, userAppLogin:{}", userAppLogin);
    	userAppLogin.setCreateTime(new Date());
    	userAppLogin.setUpdateTime(new Date());
    	int i = userAppLoginMapper.insertSelective(userAppLogin);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户应用登录
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteUserAppLoginById(Integer id) {
  		logger.info("(UserAppLoginService-deleteUserAppLoginById)-根据id删除用户应用登录-传入参数, id:{}", id);
  		int i = userAppLoginMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	@Override
	public Integer modifyUserAppLogin(UserAppLogin userAppLogin) {
    	logger.info("(UserAppLoginService-modifyUserAppLogin)-修改用户应用登录-传入参数, userAppLogin:{}", userAppLogin);
    	userAppLogin.setUpdateTime(new Date());
    	int i = userAppLoginMapper.updateByPrimaryKeySelective(userAppLogin);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}