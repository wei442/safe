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
import com.cloud.provider.safe.service.IBootUserAdminLoginLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理登录日志 BootUserAdminLoginLogService
 * @author wei.yong
 */
@Service
public class BootUserAdminLoginLogServiceImpl implements IBootUserAdminLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理登录日志 Mapper
	@Autowired
	private UserAdminLoginLogMapper userAdminLoginLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param userAdminLoginLog
	 * @return List<UserAdminLoginLog>
	 */
	public List<UserAdminLoginLog> selectUserAdminLoginLogListByPage(Page<?> page, UserAdminLoginLog userAdminLoginLog) {
		logger.info("(BootUserAdminLoginLogService-selectUserAdminLoginLogListByPage)-分页查询-传入参数, page:{}, userAdminLoginLog:{}", page, userAdminLoginLog);
		PageHelper.startPage(page);
		UserAdminLoginLogExample example = new UserAdminLoginLogExample();
		example.setOrderByClause(" id desc ");
		UserAdminLoginLogExample.Criteria criteria = example.createCriteria();
		if(userAdminLoginLog != null) {
		}
		List<UserAdminLoginLog> list = null;
		try {
			list = userAdminLoginLogMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserAdminLoginLogService-selectUserAdminLoginLogListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 插入用户登录日志
	 * @param userAdminLoginLog
	 * @return Integer
	 */
	public Integer insertUserAdminLoginLog(UserAdminLoginLog userAdminLoginLog) {
		if(logger.isInfoEnabled())logger.info("(BootUserAdminLoginLogService-insertUserAdminLoginLog)-插入用户管理登录日志-传入参数, userAdminLoginLog:{}", userAdminLoginLog);
		userAdminLoginLog.setCreateTime(new Date());
		userAdminLoginLog.setUpdateTime(new Date());
		int i = 0;
		try {
			i = userAdminLoginLogMapper.insertSelective(userAdminLoginLog);
		} catch (Exception e) {
			logger.error("(BootUserAdminLoginLogService-insertUserAdminLoginLog)-插入用户管理登录日志-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}
		return i;
	}

}