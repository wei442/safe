package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.BaseUserMapper;
import com.cloud.provider.safe.po.BaseUser;
import com.cloud.provider.safe.po.BaseUserExample;
import com.cloud.provider.safe.service.IBootBaseUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户 BootBaseUserService
 * @author wei.yong
 */
@Service
public class BootBaseUserServiceImpl implements IBootBaseUserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //基础用户 Mapper
    @Autowired
    private BaseUserMapper userInfoMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userInfo
	 * @return List<BaseUser>
	 */
	@Override
	public List<BaseUser> selectBaseUserListByPage(Page<?> page, BaseUser userInfo) {
		logger.info("(BootBaseUserService-selectBaseUserListByPage)-分页查询-传入参数, page:{}, userInfo:{}", page, userInfo);
		PageHelper.startPage(page);
		BaseUserExample example = new BaseUserExample();
		example.setOrderByClause(" id desc ");
		BaseUserExample.Criteria criteria = example.createCriteria();
		if(userInfo != null) {
		}
		List<BaseUser> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootBaseUserService-selectBaseUserListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userInfo
	 * @return List<BaseUser>
	 */
	@Override
	public List<BaseUser> selectBaseUserList(BaseUser userInfo) {
		logger.info("(BootBaseUserService-selectBaseUserList)-不分页查询-传入参数, userInfo:{}", userInfo);
		BaseUserExample example = new BaseUserExample();
		BaseUserExample.Criteria criteria = example.createCriteria();
		if(userInfo != null) {
		}
		List<BaseUser> list = null;
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootBaseUserService-selectBaseUserList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询基础用户
     * @param id
     * @return BaseUser
     */
	@Override
	public BaseUser selectBaseUserById(Integer id) {
    	logger.info("(BootBaseUserService-selectBaseUserById)-根据id查询基础用户-传入参数, id:{}", id);
    	BaseUser userInfo = null;
    	try {
    		userInfo = userInfoMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootBaseUserService-selectBaseUserById)-根据id查询基础用户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userInfo;
    }

    /**
     * 插入基础用户
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer insertBaseUser(BaseUser userInfo) {
    	logger.info("(BootBaseUserService-insertBaseUser)-插入基础用户-传入参数, userInfo:{}", userInfo);
    	userInfo.setCreateTime(new Date());
    	userInfo.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userInfoMapper.insertSelective(userInfo);
    	} catch (Exception e) {
    		logger.error("(BootBaseUserService-insertBaseUser)-插入基础用户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改基础用户
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer modifyBaseUser(BaseUser userInfo) {
    	logger.info("(BootBaseUserService-modifyBaseUser)-修改基础用户-传入参数, userInfo:{}", userInfo);
    	userInfo.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
    	} catch (Exception e) {
    		logger.error("(BootBaseUserService-modifyBaseUser)-修改基础用户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}