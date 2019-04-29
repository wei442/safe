package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserMenuMapper;
import com.cloud.provider.safe.dao.dao.UserMenuDao;
import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.po.UserMenuExample;
import com.cloud.provider.safe.rest.request.page.user.UserMenuPageRequest;
import com.cloud.provider.safe.service.IUserMenuService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户菜单 UserMenuService
 * @author wei.yong
 */
@Service
public class UserMenuServiceImpl implements IUserMenuService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户菜单 Mapper
    @Autowired
    private UserMenuMapper userMenuMapper;

    //用户菜单 Dao
    @Autowired
    private UserMenuDao userMenuDao;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserMenu>
	 */
	@Override
	public List<UserMenu> selectListByPage(Page<?> page, UserMenuPageRequest param) {
		logger.info("(UserMenuService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserMenuExample example = new UserMenuExample();
		example.setOrderByClause(" id desc ");
		UserMenuExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserMenu> list = userMenuMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserMenu>
	 */
	@Override
	public List<UserMenu> selectList(UserMenuPageRequest param) {
		logger.info("(UserMenuService-selectList)-不分页查询-传入参数, userMenu:{}", param);
		UserMenuExample example = new UserMenuExample();
		example.setOrderByClause(" id desc ");
		UserMenuExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserMenu> list = userMenuMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户菜单
     * @param id
     * @return UserMenu
     */
	@Override
	public UserMenu selectById(Integer id) {
    	logger.info("(UserMenuService-selectById)-根据id查询用户菜单-传入参数, id:{}", id);
		UserMenu userMenu = userMenuMapper.selectByPrimaryKey(id);
		return userMenu;
    }

    /**
     * 插入用户菜单
     * @param userMenu
     * @return Integer
     */
	@Override
	public Integer insert(UserMenu userMenu) {
    	logger.info("(UserMenuService-insert)-插入用户菜单-传入参数, userMenu:{}", userMenu);
    	userMenu.setCreateTime(new Date());
    	userMenu.setUpdateTime(new Date());
    	int i = userMenuMapper.insertSelective(userMenu);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

	/**
	 * 批量插入
	 * @param list
	 * @return Integer
	 */
	@Override
	public Integer insertList(List<UserMenu> list) {
		logger.info("(UserMenuService-insertList)-插入用户菜单-传入参数, list:{}", list);
		int i = userMenuDao.insertList(list);
		return i;
	}

 	/**
  	 * 根据id删除用户菜单
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserMenuService-deleteById)-根据id删除用户菜单-传入参数, id:{}", id);
  		int i = userMenuMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除用户菜单
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除用户菜单-传入参数, ids:{}", ids);
  		UserMenuExample example = new UserMenuExample();
  		UserMenuExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = userMenuMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户菜单
     * @param userMenu
     * @return Integer
     */
	@Override
	public Integer modify(UserMenu userMenu) {
    	logger.info("(UserMenuService-modify)-修改用户菜单-传入参数, userMenu:{}", userMenu);
    	userMenu.setUpdateTime(new Date());
    	int i = userMenuMapper.updateByPrimaryKeySelective(userMenu);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}