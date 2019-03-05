package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAdmin;
import com.github.pagehelper.Page;

public interface IBootUserAdminService {

    /**
	 * 分页查询
	 * @param page
	 * @param userAdmin
	 * @return List<UserAdmin>
	 */
	public List<UserAdmin> selectUserAdminListByPage(Page<?> page, UserAdmin userAdmin);

	/**
	 * 不分页查询
	 * @param userAdmin
	 * @return List<UserAdmin>
	 */
	public List<UserAdmin> selectUserAdminList(UserAdmin userAdmin);

    /**
     * 根据id查询用户管理
     * @param id
     * @return UserAdmin
     */
	public UserAdmin selectUserAdminById(Integer id);

    /**
     * 插入用户管理
     * @param userAdmin
     * @return Integer
     */
	public Integer insertUserAdmin(UserAdmin userAdmin);

 	/**
  	 * 根据id删除用户管理
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserAdminById(Integer id);

    /**
     * 修改用户管理
     * @param userAdmin
     * @return Integer
     */
	public Integer modifyUserAdmin(UserAdmin userAdmin);

}