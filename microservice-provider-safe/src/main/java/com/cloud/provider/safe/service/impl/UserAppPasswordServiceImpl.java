package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserAppPasswordMapper;
import com.cloud.provider.safe.po.UserAppPassword;
import com.cloud.provider.safe.po.UserAppPasswordExample;
import com.cloud.provider.safe.service.IUserAppPasswordService;
import com.cloud.provider.safe.util.Assert;

/**
 * 用户应用密码 UserAppPasswordService
 * @author wei.yong
 */
@Service
public class UserAppPasswordServiceImpl implements IUserAppPasswordService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户应用密码 Mapper
    @Autowired
    private UserAppPasswordMapper userAppPasswordMapper;

    /**
     * 根据id查询用户应用密码
     * @param id
     * @return UserAppPassword
     */
	@Override
	public UserAppPassword selectById(Integer id) {
    	logger.info("(UserAppPasswordService-selectById)-根据id查询用户应用密码-传入参数, id:{}", id);
		UserAppPassword userAppPassword = userAppPasswordMapper.selectByPrimaryKey(id);
		return userAppPassword;
    }

	/**
	 * 根据userId和password查询用户应用密码
	 * @param userId
	 * @param password
	 * @return UserAppPassword
	 */
	@Override
	public UserAppPassword selectByUserId(Integer userId,String password) {
		logger.info("(UserAppPasswordService-selectByUserId)-根据userId和password查询用户应用密码-传入参数, userId:{}, password:{}", userId, password);
		UserAppPasswordExample example = new UserAppPasswordExample();
		UserAppPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andPasswordEqualTo(password);

		List<UserAppPassword> list = userAppPasswordMapper.selectByExample(example);
		UserAppPassword userAppPassword = null;
		if(list != null && !list.isEmpty()) {
			userAppPassword = list.get(0);
		}
		return userAppPassword;
	}

    /**
     * 插入用户应用密码
     * @param userAppPassword
     * @return Integer
     */
	@Override
	public Integer insert(UserAppPassword userAppPassword) {
    	logger.info("(UserAppPasswordService-insertUserAppPassword)-插入用户应用密码-传入参数, userAppPassword:{}", userAppPassword);
    	userAppPassword.setCreateTime(new Date());
    	userAppPassword.setUpdateTime(new Date());
    	int i = userAppPasswordMapper.insertSelective(userAppPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户应用密码
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserAppPasswordService-deleteById)-根据id删除用户应用密码-传入参数, id:{}", id);
		int i = userAppPasswordMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户应用密码
     * @param userAppPassword
     * @return Integer
     */
	@Override
	public Integer modify(UserAppPassword userAppPassword) {
    	logger.info("(UserAppPasswordService-modifyUserAppPassword)-修改用户应用密码-传入参数, userAppPassword:{}", userAppPassword);
    	userAppPassword.setUpdateTime(new Date());
		int i = userAppPasswordMapper.updateByPrimaryKeySelective(userAppPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}