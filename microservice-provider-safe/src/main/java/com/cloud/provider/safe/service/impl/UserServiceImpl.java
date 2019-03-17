package com.cloud.provider.safe.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.EnterpriseMapper;
import com.cloud.provider.safe.dao.UserAdminMapper;
import com.cloud.provider.safe.dao.UserAdminPasswordMapper;
import com.cloud.provider.safe.dao.UserInfoMapper;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminPassword;
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

    //用户管理 Mapper
    @Autowired
    private UserAdminMapper userAdminMapper;

    //用户管理密码 Mapper
    @Autowired
    private UserAdminPasswordMapper userAdminPasswordMapper;

    /**
     * 插入用户
     * @param enterprise
     * @param userInfo
     * @param userAdmin
     * @param userAdminPassword
     * @return Integer
     */
	public Integer insertUser(Enterprise enterprise,UserInfo userInfo,UserAdmin userAdmin,UserAdminPassword userAdminPassword) {
    	logger.info("(UserInfoService-insertUserInfo)-插入用户-传入参数, enterprise:{}, userInfo:{}, userAdmin:{}, userAdminPassword:{}", enterprise, userInfo, userAdmin, userAdminPassword);

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
    	Integer userId = userInfo.getId();

    	userAdmin.setUserId(userId);
    	userAdmin.setAdminType(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	i = userAdminMapper.insertSelective(userAdmin);

    	userAdminPassword.setUserId(userId);
    	userAdminPassword.setCreateTime(new Date());
    	userAdminPassword.setUpdateTime(new Date());
    	i = userAdminPasswordMapper.insertSelective(userAdminPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

    	return i;
    }



}