package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.BaseUserMapper;
import com.cloud.provider.safe.po.BaseUser;
import com.cloud.provider.safe.po.BaseUserExample;
import com.cloud.provider.safe.service.IBaseUserService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户 BaseUserService
 * @author wei.yong
 */
@Service
public class BaseUserServiceImpl implements IBaseUserService {

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
		logger.info("(BaseUserService-selectBaseUserListByPage)-分页查询-传入参数, page:{}, baseUser:{}", page, baseUser);
		PageHelper.startPage(page);
		BaseUserExample example = new BaseUserExample();
		example.setOrderByClause(" id desc ");
		BaseUserExample.Criteria criteria = example.createCriteria();
		if(baseUser != null) {
		}
		List<BaseUser> list = baseUserMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param baseUser
	 * @return List<BaseUser>
	 */
	@Override
	public List<BaseUser> selectBaseUserList(BaseUser baseUser) {
		logger.info("(BaseUserService-selectBaseUserList)-不分页查询-传入参数, baseUser:{}", baseUser);
		BaseUserExample example = new BaseUserExample();
		BaseUserExample.Criteria criteria = example.createCriteria();
		if(baseUser != null) {
		}
		List<BaseUser> list = baseUserMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询基础用户
     * @param id
     * @return BaseUser
     */
	@Override
	public BaseUser selectBaseUserById(Integer id) {
    	logger.info("(BaseUserService-selectBaseUserById)-根据id查询基础用户-传入参数, id:{}", id);
		BaseUser baseUser = baseUserMapper.selectByPrimaryKey(id);
		return baseUser;
    }

    /**
     * 插入基础用户
     * @param baseUser
     * @return Integer
     */
	@Override
	public Integer insertBaseUser(BaseUser baseUser) {
    	logger.info("(BaseUserService-insertBaseUser)-插入基础用户-传入参数, baseUser:{}", baseUser);
    	baseUser.setCreateTime(new Date());
    	baseUser.setUpdateTime(new Date());
    	int i = baseUserMapper.insertSelective(baseUser);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除基础用户
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteBaseUserById(Integer id) {
  		logger.info("(BaseUserService-deleteBaseUserById)-根据id删除基础用户-传入参数, id:{}", id);
  		int i = baseUserMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改基础用户
     * @param baseUser
     * @return Integer
     */
	@Override
	public Integer modifyBaseUser(BaseUser baseUser) {
    	logger.info("(BaseUserService-modifyBaseUser)-修改基础用户-传入参数, baseUser:{}", baseUser);
    	baseUser.setUpdateTime(new Date());
    	int i = baseUserMapper.updateByPrimaryKeySelective(baseUser);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}