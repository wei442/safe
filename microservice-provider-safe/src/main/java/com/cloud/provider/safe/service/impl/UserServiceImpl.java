package com.cloud.provider.safe.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.EnterpriseMapper;
import com.cloud.provider.safe.dao.UserInfoMapper;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.service.IUserService;
import com.cloud.provider.safe.util.Assert;

/**
 * 用户 UserService
 * @author wei.yong
 */
@Service
public class UserServiceImpl implements IUserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户信息 Mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    //企业 Mapper
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    /**
     * 插入用户
     * @param enterprise
     * @param userInfo
     * @return Integer
     */
	public Integer insertUser(Enterprise enterprise,UserInfo userInfo) {
    	logger.info("(UserInfoService-insertUserInfo)-插入用户-传入参数, enterprise:{}, userInfo:{}", enterprise, userInfo);

    	enterprise.setEnterpriseStatus(SqlSafeConstants.SQL_ENTERPRISE_STATUS_NORMAL);
    	enterprise.setCreateTime(new Date());
    	enterprise.setUpdateTime(new Date());
    	int i = enterpriseMapper.insertSelective(enterprise);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

    	Integer enterpriseId = enterprise.getId();

    	userInfo.setEnterpriseId(enterpriseId);
    	userInfo.setUserStatus(SqlSafeConstants.SQL_USER_STATUS_NORMAL);
    	userInfo.setIsDelete(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
    	userInfo.setCreateTime(new Date());
    	userInfo.setUpdateTime(new Date());
    	i = userInfoMapper.insertSelective(userInfo);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }



}