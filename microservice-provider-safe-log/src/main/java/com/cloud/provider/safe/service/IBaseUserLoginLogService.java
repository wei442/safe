package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.cloud.provider.safe.rest.request.page.BaseUserLoginLogPageRequest;
import com.github.pagehelper.Page;

public interface IBaseUserLoginLogService {

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUserLoginLog>
	 */
	public List<BaseUserLoginLog> selectBaseUserLoginLogListByPage(Page<?> page, BaseUserLoginLogPageRequest param);

	/**
	 * 插入用户登录日志
	 * @param baseUserLoginLog
	 * @return Integer
	 */
	public Integer insertBaseUserLoginLog(BaseUserLoginLog baseUserLoginLog);

}