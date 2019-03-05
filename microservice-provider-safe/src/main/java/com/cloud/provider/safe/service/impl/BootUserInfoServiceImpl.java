package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserInfoMapper;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserInfoExample;
import com.cloud.provider.safe.service.IBootUserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户信息 BootUserInfoService
 * @author wei.yong
 */
@Service
public class BootUserInfoServiceImpl implements IBootUserInfoService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户信息 Mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userInfo
	 * @return List<UserInfo>
	 */
	@Override
	public List<UserInfo> selectUserInfoListByPage(Page<?> page, UserInfo userInfo) {
		logger.info("(BootUserInfoService-selectUserInfoListByPage)-分页查询-传入参数, page:{}, userInfo:{}", page, userInfo);
		PageHelper.startPage(page);
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		if(userInfo != null) {
		}
		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserInfoService-selectUserInfoListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userInfo
	 * @return List<UserInfo>
	 */
	@Override
	public List<UserInfo> selectUserInfoList(UserInfo userInfo) {
		logger.info("(BootUserInfoService-selectUserInfoList)-不分页查询-传入参数, userInfo:{}", userInfo);
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		if(userInfo != null) {
		}
		List<UserInfo> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserInfoService-selectUserInfoList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
	@Override
	public UserInfo selectUserInfoById(Integer id) {
    	logger.info("(BootUserInfoService-selectUserInfoById)-根据id查询用户信息-传入参数, id:{}", id);
    	UserInfo userInfo = null;
    	try {
    		userInfo = userInfoMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserInfoService-selectUserInfoById)-根据id查询用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userInfo;
    }

    /**
     * 插入用户信息
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer insertUserInfo(UserInfo userInfo) {
    	logger.info("(BootUserInfoService-insertUserInfo)-插入用户信息-传入参数, userInfo:{}", userInfo);
    	userInfo.setCreateTime(new Date());
    	userInfo.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userInfoMapper.insertSelective(userInfo);
    	} catch (Exception e) {
    		logger.error("(BootUserInfoService-insertUserInfo)-插入用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户信息
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserInfoById(Integer id) {
  		logger.info("(BootUserInfoService-deleteUserInfoById)-根据id删除用户信息-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userInfoMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserInfoService-deleteUserInfoById)-根据id删除用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改用户信息
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer modifyUserInfo(UserInfo userInfo) {
    	logger.info("(BootUserInfoService-modifyUserInfo)-修改用户信息-传入参数, userInfo:{}", userInfo);
    	userInfo.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
    	} catch (Exception e) {
    		logger.error("(BootUserInfoService-modifyUserInfo)-修改用户信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}