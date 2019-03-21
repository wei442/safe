package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserAdminLoginLogMapper;
import com.cloud.provider.safe.po.UserAdminLoginLog;
import com.cloud.provider.safe.po.UserAdminLoginLogExample;
import com.cloud.provider.safe.rest.request.page.UserAdminLoginLogPageRequest;
import com.cloud.provider.safe.service.IUserAdminLoginLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理登录日志 UserAdminLoginLogService
 * @author wei.yong
 */
@Service
public class UserAdminLoginLogServiceImpl implements IUserAdminLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理登录日志 Mapper
	@Autowired
	private UserAdminLoginLogMapper userAdminLoginLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdminLoginLog>
	 */
	public List<UserAdminLoginLog> selectUserAdminLoginLogListByPage(Page<?> page, UserAdminLoginLogPageRequest param) {
		logger.info("(UserAdminLoginLogService-selectUserAdminLoginLogListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserAdminLoginLogExample example = new UserAdminLoginLogExample();
		example.setOrderByClause(" id desc ");
		UserAdminLoginLogExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserAdminLoginLog> list = null;
		try {
			list = userAdminLoginLogMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(UserAdminLoginLogService-selectUserAdminLoginLogListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 插入用户登录日志
	 * @param userAdminLoginLog
	 * @return Integer
	 */
	@Override
	public Integer insertUserAdminLoginLog(UserAdminLoginLog userAdminLoginLog) {
		if(logger.isInfoEnabled())logger.info("(UserAdminLoginLogService-insertUserAdminLoginLog)-插入用户管理登录日志-传入参数, userAdminLoginLog:{}", userAdminLoginLog);
		userAdminLoginLog.setCreateTime(new Date());
		userAdminLoginLog.setUpdateTime(new Date());
		int i = 0;
		try {
			i = userAdminLoginLogMapper.insertSelective(userAdminLoginLog);
		} catch (Exception e) {
			logger.error("(UserAdminLoginLogService-insertUserAdminLoginLog)-插入用户管理登录日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}
		return i;
	}

}