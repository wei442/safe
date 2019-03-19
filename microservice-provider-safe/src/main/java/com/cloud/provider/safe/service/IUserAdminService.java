package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.rest.request.page.UserAdminPageRequest;
import com.github.pagehelper.Page;

public interface IUserAdminService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdmin>
	 */
	public List<UserAdmin> selectListByPage(Page<?> page, UserAdminPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdmin>
	 */
	public List<UserAdmin> selectList(UserAdminPageRequest param);

	/**
	 * 根据userId查询用户管理
	 * @param userId
	 * @return UserAdmin
	 */
	public UserAdmin selectByUserId(Integer userId);

    /**
     * 根据id查询用户管理
     * @param id
     * @return UserAdmin
     */
	public UserAdmin selectById(Integer id);

    /**
     * 插入用户管理
     * @param userAdmin
     * @return Integer
     */
	public Integer insert(UserAdmin userAdmin);

 	/**
  	 * 根据id删除用户管理
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户管理
     * @param userAdmin
     * @return Integer
     */
	public Integer modify(UserAdmin userAdmin);

}