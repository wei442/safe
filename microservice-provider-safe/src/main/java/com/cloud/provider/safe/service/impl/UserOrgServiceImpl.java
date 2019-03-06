package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserOrgMapper;
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.po.UserOrgExample;
import com.cloud.provider.safe.service.IUserOrgService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户机构 UserOrgService
 * @author wei.yong
 */
@Service
public class UserOrgServiceImpl implements IUserOrgService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户机构 Mapper
    @Autowired
    private UserOrgMapper userOrgMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userOrg
	 * @return List<UserOrg>
	 */
	@Override
	public List<UserOrg> selectUserOrgListByPage(Page<?> page, UserOrg userOrg) {
		logger.info("(UserOrgService-selectUserOrgListByPage)-分页查询-传入参数, page:{}, userOrg:{}", page, userOrg);
		PageHelper.startPage(page);
		UserOrgExample example = new UserOrgExample();
		example.setOrderByClause(" id desc ");
		UserOrgExample.Criteria criteria = example.createCriteria();
		if(userOrg != null) {
		}
		List<UserOrg> list = userOrgMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param userOrg
	 * @return List<UserOrg>
	 */
	@Override
	public List<UserOrg> selectUserOrgList(UserOrg userOrg) {
		logger.info("(UserOrgService-selectUserOrgList)-不分页查询-传入参数, userOrg:{}", userOrg);
		UserOrgExample example = new UserOrgExample();
		UserOrgExample.Criteria criteria = example.createCriteria();
		if(userOrg != null) {
		}
		List<UserOrg> list = userOrgMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户机构
     * @param id
     * @return UserOrg
     */
	@Override
	public UserOrg selectUserOrgById(Integer id) {
    	logger.info("(UserOrgService-selectUserOrgById)-根据id查询用户机构-传入参数, id:{}", id);
		UserOrg userOrg = userOrgMapper.selectByPrimaryKey(id);
		return userOrg;
    }

    /**
     * 插入用户机构
     * @param userOrg
     * @return Integer
     */
	@Override
	public Integer insertUserOrg(UserOrg userOrg) {
    	logger.info("(UserOrgService-insertUserOrg)-插入用户机构-传入参数, userOrg:{}", userOrg);
    	userOrg.setCreateTime(new Date());
    	userOrg.setUpdateTime(new Date());
    	int i = userOrgMapper.insertSelective(userOrg);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户机构
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteUserOrgById(Integer id) {
  		logger.info("(UserOrgService-deleteUserOrgById)-根据id删除用户机构-传入参数, id:{}", id);
  		int i = userOrgMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户机构
     * @param userOrg
     * @return Integer
     */
	@Override
	public Integer modifyUserOrg(UserOrg userOrg) {
    	logger.info("(UserOrgService-modifyUserOrg)-修改用户机构-传入参数, userOrg:{}", userOrg);
    	userOrg.setUpdateTime(new Date());
    	int i = userOrgMapper.updateByPrimaryKeySelective(userOrg);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}