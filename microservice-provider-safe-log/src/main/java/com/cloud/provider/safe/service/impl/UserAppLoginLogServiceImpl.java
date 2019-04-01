package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserAppLoginLogMapper;
import com.cloud.provider.safe.po.UserAppLoginLog;
import com.cloud.provider.safe.po.UserAppLoginLogExample;
import com.cloud.provider.safe.rest.request.page.UserAppLoginLogPageRequest;
import com.cloud.provider.safe.service.IUserAppLoginLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户应用登录日志 UserAppLoginLogService
 * @author wei.yong
 */
@Service
public class UserAppLoginLogServiceImpl implements IUserAppLoginLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用登录日志 Mapper
	@Autowired
	private UserAppLoginLogMapper userAppLoginLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAppLoginLog>
	 */
	public List<UserAppLoginLog> selectListByPage(Page<?> page, UserAppLoginLogPageRequest param) {
		logger.info("(UserAppLoginLogService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserAppLoginLogExample example = new UserAppLoginLogExample();
		example.setOrderByClause(" id desc ");
		UserAppLoginLogExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		
		List<UserAppLoginLog> list = userAppLoginLogMapper.selectByExample(example);
		return list;
	}

	/**
	 * 插入用户登录日志
	 * @param userAppLoginLog
	 * @return Integer
	 */
	public Integer insert(UserAppLoginLog userAppLoginLog) {
		logger.info("(UserAppLoginLogService-insert)-插入用户应用登录日志-传入参数, userAppLoginLog:{}", userAppLoginLog);
		userAppLoginLog.setCreateTime(new Date());
		userAppLoginLog.setUpdateTime(new Date());
		int i = userAppLoginLogMapper.insertSelective(userAppLoginLog);
		return i;
	}

}