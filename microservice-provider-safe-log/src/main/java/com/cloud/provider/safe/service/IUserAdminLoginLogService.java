package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAdminLoginLog;
import com.cloud.provider.safe.rest.request.page.UserAdminLoginLogPageRequest;
import com.github.pagehelper.Page;

public interface IUserAdminLoginLogService {

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdminLoginLog>
	 */
	public List<UserAdminLoginLog> selectUserAdminLoginLogListByPage(Page<?> page, UserAdminLoginLogPageRequest param);

	/**
	 * 插入用户登录日志
	 * @param userAdminLoginLog
	 * @return Integer
	 */
	public Integer insertUserAdminLoginLog(UserAdminLoginLog userAdminLoginLog);

}