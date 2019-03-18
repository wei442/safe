package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.UserAppPassword;

public interface IUserAppPasswordService {

    /**
     * 根据id查询用户应用密码
     * @param id
     * @return UserAppPassword
     */
	public UserAppPassword selectById(Integer id);

	/**
	 * 根据userId和password查询用户应用密码
	 * @param userId
	 * @param password
	 * @return UserAppPassword
	 */
	public UserAppPassword selectByUserId(Integer userId,String password);

    /**
     * 插入用户应用密码
     * @param userAppPassword
     * @return Integer
     */
	public Integer insert(UserAppPassword userAppPassword);

	/**
  	 * 根据id删除用户应用密码
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户应用密码
     * @param userAppPassword
     * @return Integer
     */
	public Integer modify(UserAppPassword userAppPassword);

}