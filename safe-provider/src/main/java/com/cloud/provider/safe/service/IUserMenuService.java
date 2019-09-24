package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.rest.request.page.user.UserMenuPageRequest;
import com.github.pagehelper.Page;

public interface IUserMenuService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserMenu>
	 */
	public List<UserMenu> selectListByPage(Page<?> page, UserMenuPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserMenu>
	 */
	public List<UserMenu> selectList(UserMenuPageRequest param);

    /**
     * 根据id查询用户菜单
     * @param id
     * @return UserMenu
     */
	public UserMenu selectById(Integer id);

    /**
     * 插入用户菜单
     * @param userMenu
     * @return Integer
     */
	public Integer insert(UserMenu userMenu);

	/**
	 * 批量插入
	 * @param list
	 * @return Integer
	 */
	public Integer insertList(List<UserMenu> list);

 	/**
  	 * 根据id删除用户菜单
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除用户菜单
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改用户菜单
     * @param userMenu
     * @return Integer
     */
	public Integer modify(UserMenu userMenu);

}