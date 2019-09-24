package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserInfo;

public interface IUserService {

    /**
     * 插入用户
     * @param userInfo
     * @param enterprise
     * @return Integer
     */
	public Integer insertAdminUser(UserInfo userInfo,Enterprise enterprise);

	/**
	 * 修改用户管理密码
	 * @param userAdminLogin
	 * @param userAdminPassword
	 * @return Integer
	 */
	public Integer modifyAdminUserPassword(UserAdminLogin userAdminLogin,UserAdminPassword userAdminPassword);

	/**
	 * 重设用户管理密码
	 * @param userAdminLogin
	 * @param userAdminPassword
	 * @return Integer
	 */
	public Integer resetAdminUserPassword(UserAdminLogin userAdminLogin,UserAdminPassword userAdminPassword);

}