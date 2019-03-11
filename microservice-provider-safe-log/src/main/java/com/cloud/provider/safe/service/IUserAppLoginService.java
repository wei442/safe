package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAppLogin;
import com.cloud.provider.safe.rest.request.page.UserAppLoginPageRequest;
import com.github.pagehelper.Page;

public interface IUserAppLoginService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAppLogin>
	 */
	public List<UserAppLogin> selectUserAppLoginListByPage(Page<?> page, UserAppLoginPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAppLogin>
	 */
	public List<UserAppLogin> selectUserAppLoginList(UserAppLoginPageRequest param);

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
  	 * 根据id删除用户应用登录
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserAppLoginById(Integer id);

    /**
     * 修改用户应用登录
     * @param userAppLogin
     * @return Integer
     */
	public Integer modifyUserAppLogin(UserAppLogin userAppLogin);

}