package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserOrgMapper;
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.po.UserOrgExample;
import com.cloud.provider.safe.service.IBootUserOrgService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户机构 BootUserOrgService
 * @author wei.yong
 */
@Service
public class BootUserOrgServiceImpl implements IBootUserOrgService {

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
		logger.info("(BootUserOrgService-selectUserOrgListByPage)-分页查询-传入参数, page:{}, userOrg:{}", page, userOrg);
		PageHelper.startPage(page);
		UserOrgExample example = new UserOrgExample();
		example.setOrderByClause(" id desc ");
		UserOrgExample.Criteria criteria = example.createCriteria();
		if(userOrg != null) {
		}
		List<UserOrg> list = null;
		try {
			list = userOrgMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserOrgService-selectUserOrgListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userOrg
	 * @return List<UserOrg>
	 */
	@Override
	public List<UserOrg> selectUserOrgList(UserOrg userOrg) {
		logger.info("(BootUserOrgService-selectUserOrgList)-不分页查询-传入参数, userOrg:{}", userOrg);
		UserOrgExample example = new UserOrgExample();
		UserOrgExample.Criteria criteria = example.createCriteria();
		if(userOrg != null) {
		}
		List<UserOrg> list = null;
		try {
			list = userOrgMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserOrgService-selectUserOrgList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户机构
     * @param id
     * @return UserOrg
     */
	@Override
	public UserOrg selectUserOrgById(Integer id) {
    	logger.info("(BootUserOrgService-selectUserOrgById)-根据id查询用户机构-传入参数, id:{}", id);
    	UserOrg userOrg = null;
    	try {
    		userOrg = userOrgMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserOrgService-selectUserOrgById)-根据id查询用户机构-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userOrg;
    }

    /**
     * 插入用户机构
     * @param userOrg
     * @return Integer
     */
	@Override
	public Integer insertUserOrg(UserOrg userOrg) {
    	logger.info("(BootUserOrgService-insertUserOrg)-插入用户机构-传入参数, userOrg:{}", userOrg);
    	userOrg.setCreateTime(new Date());
    	userOrg.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userOrgMapper.insertSelective(userOrg);
    	} catch (Exception e) {
    		logger.error("(BootUserOrgService-insertUserOrg)-插入用户机构-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户机构
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserOrgById(Integer id) {
  		logger.info("(BootUserOrgService-deleteUserOrgById)-根据id删除用户机构-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userOrgMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserOrgService-deleteUserOrgById)-根据id删除用户机构-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改用户机构
     * @param userOrg
     * @return Integer
     */
	@Override
	public Integer modifyUserOrg(UserOrg userOrg) {
    	logger.info("(BootUserOrgService-modifyUserOrg)-修改用户机构-传入参数, userOrg:{}", userOrg);
    	userOrg.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userOrgMapper.updateByPrimaryKeySelective(userOrg);
    	} catch (Exception e) {
    		logger.error("(BootUserOrgService-modifyUserOrg)-修改用户机构-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}