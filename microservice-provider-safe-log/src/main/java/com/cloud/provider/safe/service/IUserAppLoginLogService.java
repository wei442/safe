package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAppLoginLog;
import com.cloud.provider.safe.rest.request.page.UserAppLoginLogPageRequest;
import com.github.pagehelper.Page;

public interface IUserAppLoginLogService {

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAppLoginLog>
	 */
	public List<UserAppLoginLog> selectUserAppLoginLogListByPage(Page<?> page, UserAppLoginLogPageRequest param);

	/**
	 * 插入用户登录日志
	 * @param userAppLoginLog
	 * @return Integer
	 */
	public Integer insertUserAppLoginLog(UserAppLoginLog userAppLoginLog);

}