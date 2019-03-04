package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAdminLoginLog;
import com.github.pagehelper.Page;

public interface IBootUserAdminLoginLogService {

	/**
	 * 分页查询
	 * @param page
	 * @param userAdminLoginLog
	 * @return List<UserAdminLoginLog>
	 */
	public List<UserAdminLoginLog> selectUserAdminLoginLogListByPage(Page<?> page, UserAdminLoginLog userAdminLoginLog);

	/**
	 * 插入用户登录日志
	 * @param userAdminLoginLog
	 * @return Integer
	 */
	public Integer insertUserAdminLoginLog(UserAdminLoginLog userAdminLoginLog);

}