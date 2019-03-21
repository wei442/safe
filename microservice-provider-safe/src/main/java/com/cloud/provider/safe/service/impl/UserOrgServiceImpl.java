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
import com.cloud.provider.safe.rest.request.page.UserOrgPageRequest;
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
	 * @param param
	 * @return List<UserOrg>
	 */
	@Override
	public List<UserOrg> selectListByPage(Page<?> page, UserOrgPageRequest param) {
		logger.info("(UserOrgService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserOrgExample example = new UserOrgExample();
		example.setOrderByClause(" id desc ");
		UserOrgExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserOrg> list = userOrgMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserOrg>
	 */
	@Override
	public List<UserOrg> selectList(UserOrgPageRequest param) {
		logger.info("(UserOrgService-selectList)-不分页查询-传入参数, param:{}", param);
		UserOrgExample example = new UserOrgExample();
		example.setOrderByClause(" id desc ");
		UserOrgExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
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
	public UserOrg selectById(Integer id) {
    	logger.info("(UserOrgService-selectById)-根据id查询用户机构-传入参数, id:{}", id);
		UserOrg userOrg = userOrgMapper.selectByPrimaryKey(id);
		Assert.thanOrEqualZreo(userOrg, SafeResultEnum.DATABASE_NOTEXIST);
		return userOrg;
    }

	/**
	 * 根据userId查询用户机构
	 * @param userId
	 * @return UserOrg
	 */
	@Override
	public UserOrg selectByUserId(Integer userId) {
		logger.info("(UserOrgService-selectById)-根据userId查询用户机构-传入参数, userId:{}", userId);
		UserOrgExample example = new UserOrgExample();
		UserOrgExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserOrg> list = userOrgMapper.selectByExample(example);
		UserOrg userOrg = null;
		if(list != null && !list.isEmpty()) {
			userOrg = list.get(0);
		}
		Assert.thanOrEqualZreo(userOrg, SafeResultEnum.DATABASE_NOTEXIST);
		return userOrg;
	}

    /**
     * 插入用户机构
     * @param userOrg
     * @return Integer
     */
	@Override
	public Integer insert(UserOrg userOrg) {
    	logger.info("(UserOrgService-insertUserOrg)-插入用户机构-传入参数, userOrg:{}", userOrg);
    	userOrg.setCreateTime(new Date());
    	userOrg.setUpdateTime(new Date());
    	int i = userOrgMapper.insertSelective(userOrg);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户机构
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserOrgService-deleteById)-根据id删除用户机构-传入参数, id:{}", id);
  		int i = userOrgMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户机构
     * @param userOrg
     * @return Integer
     */
	@Override
	public Integer modify(UserOrg userOrg) {
    	logger.info("(UserOrgService-modifyUserOrg)-修改用户机构-传入参数, userOrg:{}", userOrg);
    	userOrg.setUpdateTime(new Date());
    	int i = userOrgMapper.updateByPrimaryKeySelective(userOrg);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}