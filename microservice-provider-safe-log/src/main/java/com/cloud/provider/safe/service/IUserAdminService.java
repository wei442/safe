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
	public List<UserAdmin> selectUserAdminListByPage(Page<?> page, UserAdminPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdmin>
	 */
	public List<UserAdmin> selectUserAdminList(UserAdminPageRequest param);

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