package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserAdminMapper;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminExample;
import com.cloud.provider.safe.rest.request.page.user.UserAdminPageRequest;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理 UserAdminService
 * @author wei.yong
 */
@Service
public class UserAdminServiceImpl implements IUserAdminService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户管理 Mapper
    @Autowired
    private UserAdminMapper userAdminMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdmin>
	 */
	@Override
	public List<UserAdmin> selectListByPage(Page<?> page, UserAdminPageRequest param) {
		logger.info("(UserAdminService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserAdminExample example = new UserAdminExample();
		example.setOrderByClause(" id desc ");
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdmin>
	 */
	@Override
	public List<UserAdmin> selectList(UserAdminPageRequest param) {
		logger.info("(UserAdminService-selectList)-不分页查询-传入参数, param:{}", param);
		UserAdminExample example = new UserAdminExample();
		example.setOrderByClause(" id desc ");
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户管理
     * @param id
     * @return UserAdmin
     */
	@Override
	public UserAdmin selectById(Integer id) {
    	logger.info("(UserAdminService-selectById)-根据id查询用户管理-传入参数, id:{}", id);
		UserAdmin userAdmin = userAdminMapper.selectByPrimaryKey(id);
		return userAdmin;
    }

	/**
	 * 根据userId查询用户管理
	 * @param userId
	 * @return UserAdmin
	 */
	@Override
	public UserAdmin selectByUserId(Integer userId) {
		logger.info("(UserAdminService-selectByUserId)-根据userId查询用户管理-传入参数, userId:{}", userId);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		criteria.andUserIdEqualTo(userId);

		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		UserAdmin userAdmin = null;
		if(list != null && !list.isEmpty()) {
			userAdmin = list.get(0);
		}
		return userAdmin;
	}

	/**
	 * 根据enterpriseId和userId查询用户管理
	 * @param enterpriseId
	 * @param userId
	 * @return UserAdmin
	 */
	@Override
	public UserAdmin selectByEnterpriseIdUserId(Integer enterpriseId,Integer userId) {
		logger.info("(UserAdminService-selectByEnterpriseIdUserId)-根据enterpriseId和userId查询用户管理-传入参数, enterpriseId:{}, userId:{}", enterpriseId, userId);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		criteria.andEnterpriseIdEqualTo(enterpriseId);
		criteria.andUserIdEqualTo(userId);

		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		UserAdmin userAdmin = null;
		if(list != null && list.isEmpty()) {
			userAdmin = list.get(0);
		}
		return userAdmin;
	}

    /**
     * 插入用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer insert(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-insert)-插入用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setIsDelete(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.insertSelective(userAdmin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户管理
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserAdminService-deleteById)-根据id删除用户管理-传入参数, id:{}", id);
  		int i = userAdminMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer modify(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-modify)-修改用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.updateByPrimaryKeySelective(userAdmin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}