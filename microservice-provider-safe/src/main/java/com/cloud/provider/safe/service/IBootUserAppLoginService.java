package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAppLogin;
import com.github.pagehelper.Page;

public interface IBootUserAppLoginService {

    /**
	 * 分页查询
	 * @param page
	 * @param userAppLogin
	 * @return List<UserAppLogin>
	 */
	public List<UserAppLogin> selectUserAppLoginListByPage(Page<?> page, UserAppLogin userAppLogin);

	/**
	 * 不分页查询
	 * @param userAppLogin
	 * @return List<UserAppLogin>
	 */
	public List<UserAppLogin> selectUserAppLoginList(UserAppLogin userAppLogin);

    /**
     * 根据id查询用户应用登录
     * @param id
     * @return UserAppLogin
     */
	public UserAppLogin selectUserAppLoginById(Integer id);

    /**
     * 插入用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	public Integer insertUserAppLogin(UserAppLogin userAppLogin);

    /**
     * 修改用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	public Integer modifyUserAppLogin(UserAppLogin userAppLogin);

}