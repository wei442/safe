package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserAdminPasswordMapper;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserAdminPasswordExample;
import com.cloud.provider.safe.service.IUserAdminPasswordService;
import com.cloud.provider.safe.util.Assert;

/**
 * 用户管理密码 UserAdminPasswordService
 * @author wei.yong
 */
@Service
public class UserAdminPasswordServiceImpl implements IUserAdminPasswordService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户管理密码 Mapper
    @Autowired
    private UserAdminPasswordMapper userAdminPasswordMapper;

    /**
     * 根据id查询用户管理密码
     * @param id
     * @return UserAdminPassword
     */
	@Override
	public UserAdminPassword selectById(Integer id) {
    	logger.info("(UserAdminPasswordService-selectById)-根据id查询用户管理密码-传入参数, id:{}", id);
		UserAdminPassword userAdminPassword = userAdminPasswordMapper.selectByPrimaryKey(id);
		return userAdminPassword;
    }

	/**
	 * 根据userId查询用户管理密码
	 * @param userId
	 * @return UserAdminPassword
	 */
	@Override
	public UserAdminPassword selectByUserId(Integer userId) {
		logger.info("(UserAdminPasswordService-selectByUserId)-根据userId查询用户管理密码-传入参数, userId:{}", userId);
		UserAdminPasswordExample example = new UserAdminPasswordExample();
		UserAdminPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);

		List<UserAdminPassword> list = userAdminPasswordMapper.selectByExample(example);
		UserAdminPassword userAdminPassword = null;
		if(list != null && !list.isEmpty()) {
			userAdminPassword = list.get(0);
		}
		return userAdminPassword;
	}

	/**
	 * 根据userId和password查询用户管理密码
	 * @param userId
	 * @param password
	 * @return UserAdminPassword
	 */
	@Override
	public UserAdminPassword selectByUserIdPassword(Integer userId,String password) {
		logger.info("(UserAdminPasswordService-selectByUserIdPassword)-根据userId和password查询用户管理密码-传入参数, userId:{}, password:{}", userId, password);
		UserAdminPasswordExample example = new UserAdminPasswordExample();
		UserAdminPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andPasswordEqualTo(password);

		List<UserAdminPassword> list = userAdminPasswordMapper.selectByExample(example);
		UserAdminPassword userAdminPassword = null;
		if(list != null && !list.isEmpty()) {
			userAdminPassword = list.get(0);
		}
		return userAdminPassword;
	}

    /**
     * 插入用户管理密码
     * @param userAdminPassword
     * @return Integer
     */
	@Override
	public Integer insert(UserAdminPassword userAdminPassword) {
    	logger.info("(UserAdminPasswordService-insert)-插入用户管理密码-传入参数, userAdminPassword:{}", userAdminPassword);
    	userAdminPassword.setCreateTime(new Date());
    	userAdminPassword.setUpdateTime(new Date());
    	int i = userAdminPasswordMapper.insertSelective(userAdminPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户管理密码
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserAdminPasswordService-deleteById)-根据id删除用户管理密码-传入参数, id:{}", id);
		int i = userAdminPasswordMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户管理密码
     * @param userAdminPassword
     * @return Integer
     */
	@Override
	public Integer modify(UserAdminPassword userAdminPassword) {
    	logger.info("(UserAdminPasswordService-modify)-修改用户管理密码-传入参数, userAdminPassword:{}", userAdminPassword);
    	userAdminPassword.setUpdateTime(new Date());
		int i = userAdminPasswordMapper.updateByPrimaryKeySelective(userAdminPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}