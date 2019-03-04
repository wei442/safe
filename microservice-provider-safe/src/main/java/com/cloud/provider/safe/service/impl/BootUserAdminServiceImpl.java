package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserAdminMapper;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminExample;
import com.cloud.provider.safe.service.IBootUserAdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理 BootUserAdminService
 * @author wei.yong
 */
@Service
public class BootUserAdminServiceImpl implements IBootUserAdminService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户管理 Mapper
    @Autowired
    private UserAdminMapper userAdminMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userAdmin
	 * @return List<UserAdmin>
	 */
	@Override
	public List<UserAdmin> selectUserAdminListByPage(Page<?> page, UserAdmin userAdmin) {
		logger.info("(BootUserAdminService-selectUserAdminListByPage)-分页查询-传入参数, page:{}, userAdmin:{}", page, userAdmin);
		PageHelper.startPage(page);
		UserAdminExample example = new UserAdminExample();
		example.setOrderByClause(" id desc ");
		UserAdminExample.Criteria criteria = example.createCriteria();
		if(userAdmin != null) {
		}
		List<UserAdmin> list = null;
		try {
			list = userAdminMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAdminService-selectUserAdminListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userAdmin
	 * @return List<UserAdmin>
	 */
	@Override
	public List<UserAdmin> selectUserAdminList(UserAdmin userAdmin) {
		logger.info("(BootUserAdminService-selectUserAdminList)-不分页查询-传入参数, userAdmin:{}", userAdmin);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		if(userAdmin != null) {
		}
		List<UserAdmin> list = null;
		try {
			list = userAdminMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAdminService-selectUserAdminList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户管理
     * @param id
     * @return UserAdmin
     */
	@Override
	public UserAdmin selectUserAdminById(Integer id) {
    	logger.info("(BootUserAdminService-selectUserAdminById)-根据id查询用户管理-传入参数, id:{}", id);
    	UserAdmin userAdmin = null;
    	try {
    		userAdmin = userAdminMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserAdminService-selectUserAdminById)-根据id查询用户管理-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userAdmin;
    }

    /**
     * 插入用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer insertUserAdmin(UserAdmin userAdmin) {
    	logger.info("(BootUserAdminService-insertUserAdmin)-插入用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userAdminMapper.insertSelective(userAdmin);
    	} catch (Exception e) {
    		logger.error("(BootUserAdminService-insertUserAdmin)-插入用户管理-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer modifyUserAdmin(UserAdmin userAdmin) {
    	logger.info("(BootUserAdminService-modifyUserAdmin)-修改用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userAdminMapper.updateByPrimaryKeySelective(userAdmin);
    	} catch (Exception e) {
    		logger.error("(BootUserAdminService-modifyUserAdmin)-修改用户管理-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}