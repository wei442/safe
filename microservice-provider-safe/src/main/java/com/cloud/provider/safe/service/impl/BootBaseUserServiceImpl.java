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
    private BaseUserMapper baseUserMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param baseUser
	 * @return List<BaseUser>
	 */
	@Override
	public List<BaseUser> selectBaseUserListByPage(Page<?> page, BaseUser baseUser) {
		logger.info("(BootBaseUserService-selectBaseUserListByPage)-分页查询-传入参数, page:{}, baseUser:{}", page, baseUser);
		PageHelper.startPage(page);
		BaseUserExample example = new BaseUserExample();
		example.setOrderByClause(" id desc ");
		BaseUserExample.Criteria criteria = example.createCriteria();
		if(baseUser != null) {
		}
		List<BaseUser> list = null;
		try {
			list = baseUserMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootBaseUserService-selectBaseUserListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param baseUser
	 * @return List<BaseUser>
	 */
	@Override
	public List<BaseUser> selectBaseUserList(BaseUser baseUser) {
		logger.info("(BootBaseUserService-selectBaseUserList)-不分页查询-传入参数, baseUser:{}", baseUser);
		BaseUserExample example = new BaseUserExample();
		BaseUserExample.Criteria criteria = example.createCriteria();
		if(baseUser != null) {
		}
		List<BaseUser> list = null;
		try {
			list = baseUserMapper.selectByExample(example);
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
    	BaseUser baseUser = null;
    	try {
    		baseUser = baseUserMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootBaseUserService-selectBaseUserById)-根据id查询基础用户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return baseUser;
    }

    /**
     * 插入基础用户
     * @param baseUser
     * @return Integer
     */
	@Override
	public Integer insertBaseUser(BaseUser baseUser) {
    	logger.info("(BootBaseUserService-insertBaseUser)-插入基础用户-传入参数, baseUser:{}", baseUser);
    	baseUser.setCreateTime(new Date());
    	baseUser.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = baseUserMapper.insertSelective(baseUser);
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
  	 * 根据id删除基础用户
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteBaseUserById(Integer id) {
  		logger.info("(BootBaseUserService-deleteBaseUserById)-根据id删除基础用户-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = baseUserMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootBaseUserService-deleteBaseUserById)-根据id删除基础用户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改基础用户
     * @param baseUser
     * @return Integer
     */
	@Override
	public Integer modifyBaseUser(BaseUser baseUser) {
    	logger.info("(BootBaseUserService-modifyBaseUser)-修改基础用户-传入参数, baseUser:{}", baseUser);
    	baseUser.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = baseUserMapper.updateByPrimaryKeySelective(baseUser);
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