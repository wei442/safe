package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.rest.request.page.UserAdminLoginPageRequest;
import com.github.pagehelper.Page;

public interface IUserAdminLoginService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdminLogin>
	 */
	public List<UserAdminLogin> selectUserAdminLoginListByPage(Page<?> page, UserAdminLoginPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdminLogin>
	 */
	public List<UserAdminLogin> selectUserAdminLoginList(UserAdminLoginPageRequest param);

    /**
     * 根据id查询用户管理登录
     * @param id
     * @return UserAdminLogin
     */
	public UserAdminLogin selectUserAdminLoginById(Integer id);

    /**
     * 插入用户管理登录
     * @param userAdminLogin
     * @return Integer
     */
	public Integer insertUserAdminLogin(UserAdminLogin userAdminLogin);

 	/**
  	 * 根据id删除用户管理登录
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserAdminLoginById(Integer id);

    /**
     * 修改用户管理登录
     * @param userAdminLogin
     * @return Integer
     */
	public Integer modifyUserAdminLogin(UserAdminLogin userAdminLogin);

}