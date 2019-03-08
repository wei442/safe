package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserAdminMapper;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminExample;
import com.cloud.provider.safe.rest.request.page.UserAdminPageRequest;
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
	public List<UserAdmin> selectUserAdminListByPage(Page<?> page, UserAdminPageRequest param) {
		logger.info("(UserAdminService-selectUserAdminListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		UserAdminExample example = new UserAdminExample();
		example.setOrderByClause(" id desc ");
		UserAdminExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdmin>
	 */
	public List<UserAdmin> selectUserAdminList(UserAdminPageRequest param) {
		logger.info("(UserAdminService-selectUserAdminList)-不分页查询-传入参数, param:{}", param);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		if(param != null) {
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
	public UserAdmin selectUserAdminById(Integer id) {
    	logger.info("(UserAdminService-selectUserAdminById)-根据id查询用户管理-传入参数, id:{}", id);
		UserAdmin userAdmin = userAdminMapper.selectByPrimaryKey(id);
		return userAdmin;
    }

    /**
     * 插入用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer insertUserAdmin(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-insertUserAdmin)-插入用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.insertSelective(userAdmin);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户管理
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteUserAdminById(Integer id) {
  		logger.info("(UserAdminService-deleteUserAdminById)-根据id删除用户管理-传入参数, id:{}", id);
  		int i = userAdminMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer modifyUserAdmin(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-modifyUserAdmin)-修改用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.updateByPrimaryKeySelective(userAdmin);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}