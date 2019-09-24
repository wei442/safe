package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserInfoMapper;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserInfoExample;
import com.cloud.provider.safe.rest.request.page.user.UserInfoPageRequest;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户信息 UserInfoService
 * @author wei.yong
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户信息 Mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserInfo>
	 */
	@Override
	public List<UserInfo> selectListByPage(Page<?> page, UserInfoPageRequest param) {
		logger.info("(UserInfoService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
		if(param != null) {
			if(StringUtils.isNotBlank(param.getUserName())) {
				criteria.andUserNameLike(param.getUserName()+"%");
			}
			if(StringUtils.isNotBlank(param.getUserAccount())) {
				criteria.andUserAccountLike(param.getUserAccount()+"%");
			}
		}
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserInfo>
	 */
	@Override
	public List<UserInfo> selectList(UserInfoPageRequest param) {
		logger.info("(UserInfoService-selectList)-不分页查询-传入参数, param:{}", param);
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
		if(param != null) {
			if(StringUtils.isNotBlank(param.getUserName())) {
				criteria.andUserNameLike(param.getUserName()+"%");
			}
			if(StringUtils.isNotBlank(param.getUserAccount())) {
				criteria.andUserAccountLike(param.getUserAccount()+"%");
			}
		}
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
	@Override
	public UserInfo selectById(Integer id) {
    	logger.info("(UserInfoService-selectById)-根据id查询用户信息-传入参数, id:{}", id);
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
		return userInfo;
    }

	/**
	 * 根据userAccount查询用户信息
	 * @param userAccount
	 * @return UserInfo
	 */
	@Override
	public UserInfo selectByUserAccount(String userAccount) {
		logger.info("(UserInfoService-selectByUserAccount)-根据userAccount查询用户信息-传入参数, userAccount:{}", userAccount);
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
		criteria.andUserAccountEqualTo(userAccount);

		List<UserInfo> list = userInfoMapper.selectByExample(example);
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
     */
	@Override
	public Integer insert(UserInfo userInfo) {
    	logger.info("(UserInfoService-insert)-插入用户信息-传入参数, userInfo:{}", userInfo);
    	userInfo.setUserStatus(SqlSafeConstants.SQL_USER_STATUS_NORMAL);
    	userInfo.setIsDelete(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
    	userInfo.setCreateTime(new Date());
    	userInfo.setUpdateTime(new Date());
    	int i = 0;
    	try {
			i = userInfoMapper.insertSelective(userInfo);
    	} catch (DataIntegrityViolationException e) {
			logger.error("(UserInfoService-insert)-插入用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.USER_MOBILE_EXIST);
		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户信息
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserInfoService-deleteById)-根据id删除用户信息-传入参数, id:{}", id);
  		int i = userInfoMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户信息
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer modify(UserInfo userInfo) {
    	logger.info("(UserInfoService-modify)-修改用户信息-传入参数, userInfo:{}", userInfo);
    	userInfo.setUpdateTime(new Date());

    	int i = 0;
    	try {
			i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
    	} catch (DataIntegrityViolationException e) {
			logger.error("(UserInfoService-modify)-修改用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.USER_MOBILE_EXIST);
		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}