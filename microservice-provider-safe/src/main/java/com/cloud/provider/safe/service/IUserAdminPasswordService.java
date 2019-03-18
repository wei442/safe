package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.UserAdminPassword;

public interface IUserAdminPasswordService {

    /**
     * 根据id查询用户管理密码
     * @param id
     * @return UserAdminPassword
     */
	public UserAdminPassword selectById(Integer id);

	/**
	 * 根据userId好和password查询用户管理密码
	 * @param userId
	 * @param password
	 * @return UserAdminPassword
	 */
	public UserAdminPassword selectByUserId(Integer userId,String password);

    /**
     * 插入用户管理密码
     * @param userAdminPassword
     * @return Integer
     */
	public Integer insert(UserAdminPassword userAdminPassword);

	/**
  	 * 根据id删除用户管理密码
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户管理密码
     * @param userAdminPassword
     * @return Integer
     */
	public Integer modify(UserAdminPassword userAdminPassword);

}