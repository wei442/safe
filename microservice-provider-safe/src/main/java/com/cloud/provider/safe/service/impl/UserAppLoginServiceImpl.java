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
import com.cloud.provider.safe.rest.request.page.UserAppLoginPageRequest;
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
	 * @param param
	 * @return List<UserAppLogin>
	 */
	@Override
	public List<UserAppLogin> selectListByPage(Page<?> page, UserAppLoginPageRequest param) {
		logger.info("(UserAppLoginService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		UserAppLoginExample example = new UserAppLoginExample();
		example.setOrderByClause(" id desc ");
		UserAppLoginExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserAppLogin> list = userAppLoginMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAppLogin>
	 */
	@Override
	public List<UserAppLogin> selectList(UserAppLoginPageRequest param) {
		logger.info("(UserAppLoginService-selectList)-不分页查询-传入参数, param:{}", param);
		UserAppLoginExample example = new UserAppLoginExample();
		UserAppLoginExample.Criteria criteria = example.createCriteria();
		if(param != null) {
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
	public UserAppLogin selectById(Integer id) {
    	logger.info("(UserAppLoginService-selectById)-根据id查询用户应用登录-传入参数, id:{}", id);
		UserAppLogin userAppLogin = userAppLoginMapper.selectByPrimaryKey(id);
		return userAppLogin;
    }

    /**
     * 插入用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	@Override
	public Integer insert(UserAppLogin userAppLogin) {
    	logger.info("(UserAppLoginService-insertUserAppLogin)-插入用户应用登录-传入参数, userAppLogin:{}", userAppLogin);
    	userAppLogin.setCreateTime(new Date());
    	userAppLogin.setUpdateTime(new Date());
    	int i = userAppLoginMapper.insertSelective(userAppLogin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户应用登录
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserAppLoginService-deleteById)-根据id删除用户应用登录-传入参数, id:{}", id);
  		int i = userAppLoginMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	@Override
	public Integer modify(UserAppLogin userAppLogin) {
    	logger.info("(UserAppLoginService-modifyUserAppLogin)-修改用户应用登录-传入参数, userAppLogin:{}", userAppLogin);
    	userAppLogin.setUpdateTime(new Date());
    	int i = userAppLoginMapper.updateByPrimaryKeySelective(userAppLogin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}