package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.UserAppPassword;

public interface IUserAppPasswordService {

    /**
     * 根据id查询用户应用密码
     * @param id
     * @return UserAppPassword
     */
	public UserAppPassword selectUserAppPasswordById(Integer id);

	/**
	 * 根据userId查询用户应用密码
	 * @param userId
	 * @return UserAppPassword
	 */
	public UserAppPassword selectUserAppPasswordByUserId(Integer userId);

    /**
     * 插入用户应用密码
     * @param userAppPassword
     * @return Integer
     */
	public Integer insertUserAppPassword(UserAppPassword userAppPassword);

	/**
  	 * 根据id删除用户应用密码
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserAppPasswordById(Integer id);

    /**
     * 修改用户应用密码
     * @param userAppPassword
     * @return Integer
     */
	public Integer modifyUserAppPassword(UserAppPassword userAppPassword);

}