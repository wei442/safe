package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserAdminLoginMapper;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminLoginExample;
import com.cloud.provider.safe.rest.request.page.UserAdminLoginPageRequest;
import com.cloud.provider.safe.service.IUserAdminLoginService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理登录 UserAdminLoginService
 * @author wei.yong
 */
@Service
public class UserAdminLoginServiceImpl implements IUserAdminLoginService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户管理登录 Mapper
    @Autowired
    private UserAdminLoginMapper userAdminLoginMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdminLogin>
	 */
	@Override
	public List<UserAdminLogin> selectUserAdminLoginListByPage(Page<?> page, UserAdminLoginPageRequest param) {
		logger.info("(UserAdminLoginService-selectUserAdminLoginListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		UserAdminLoginExample example = new UserAdminLoginExample();
		example.setOrderByClause(" id desc ");
		UserAdminLoginExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserAdminLogin> list = userAdminLoginMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdminLogin>
	 */
	@Override
	public List<UserAdminLogin> selectUserAdminLoginList(UserAdminLoginPageRequest param) {
		logger.info("(UserAdminLoginService-selectUserAdminLoginList)-不分页查询-传入参数, param:{}", param);
		UserAdminLoginExample example = new UserAdminLoginExample();
		UserAdminLoginExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserAdminLogin> list = userAdminLoginMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户管理登录
     * @param id
     * @return UserAdminLogin
     */
	@Override
	public UserAdminLogin selectUserAdminLoginById(Integer id) {
    	logger.info("(UserAdminLoginService-selectUserAdminLoginById)-根据id查询用户管理登录-传入参数, id:{}", id);
		UserAdminLogin userAdminLogin = userAdminLoginMapper.selectByPrimaryKey(id);
		return userAdminLogin;
    }

    /**
     * 插入用户管理登录
     * @param userAdminLogin
     * @return Integer
     */
	@Override
	public Integer insertUserAdminLogin(UserAdminLogin userAdminLogin) {
    	logger.info("(UserAdminLoginService-insertUserAdminLogin)-插入用户管理登录-传入参数, userAdminLogin:{}", userAdminLogin);
    	userAdminLogin.setCreateTime(new Date());
    	userAdminLogin.setUpdateTime(new Date());
    	int i = userAdminLoginMapper.insertSelective(userAdminLogin);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户管理登录
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteUserAdminLoginById(Integer id) {
  		logger.info("(UserAdminLoginService-deleteUserAdminLoginById)-根据id删除用户管理登录-传入参数, id:{}", id);
  		int i = userAdminLoginMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户管理登录
     * @param userAdminLogin
     * @return Integer
     */
	@Override
	public Integer modifyUserAdminLogin(UserAdminLogin userAdminLogin) {
    	logger.info("(UserAdminLoginService-modifyUserAdminLogin)-修改用户管理登录-传入参数, userAdminLogin:{}", userAdminLogin);
    	userAdminLogin.setUpdateTime(new Date());
    	int i = userAdminLoginMapper.updateByPrimaryKeySelective(userAdminLogin);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}