package com.cloud.provider.safe.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.constants.Constants;
import com.cloud.provider.safe.dao.EnterpriseMapper;
import com.cloud.provider.safe.dao.OrgMapper;
import com.cloud.provider.safe.dao.UserAdminLoginMapper;
import com.cloud.provider.safe.dao.UserAdminMapper;
import com.cloud.provider.safe.dao.UserAdminPasswordMapper;
import com.cloud.provider.safe.dao.UserInfoMapper;
import com.cloud.provider.safe.dao.UserOrgMapper;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserOrg;
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

    //组织机构 Mapper
    @Autowired
    private OrgMapper orgMapper;

    //用户管理 Mapper
    @Autowired
    private UserAdminMapper userAdminMapper;

    //用户管理密码 Mapper
    @Autowired
    private UserAdminPasswordMapper userAdminPasswordMapper;

    //用户管理登录 Mapper
    @Autowired
    private UserAdminLoginMapper userAdminLoginMapper;

    //用户机构 Mapper
    @Autowired
    private UserOrgMapper userOrgMapper;

    /**
     * 插入用户企业
     * @param userInfo
     * @param enterprise
     * @return Integer
     */
	@Override
	public Integer insertUserEnterprise(UserInfo userInfo,Enterprise enterprise) {
    	logger.info("(UserInfoService-insertUserEnterprise)-插入用户企业-传入参数, userInfo:{}, enterprise:{}", userInfo, enterprise);

    	if(null != userInfo) {
	    	userInfo.setUserStatus(SqlSafeConstants.SQL_USER_STATUS_NORMAL);
	    	userInfo.setIsDelete(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
	    	userInfo.setCreateTime(new Date());
	    	userInfo.setUpdateTime(new Date());
	    	int i = userInfoMapper.insertSelective(userInfo);
	    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	}
    	Integer userId = userInfo.getId();

    	enterprise.setEnterpriseStatus(SqlSafeConstants.SQL_ENTERPRISE_STATUS_NORMAL);
    	enterprise.setCreateTime(new Date());
    	enterprise.setUpdateTime(new Date());
    	int i = enterpriseMapper.insertSelective(enterprise);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer enterpriseId = enterprise.getId();
    	String enterpriseName = enterprise.getEnterpriseName();

    	UserAdmin userAdmin = new UserAdmin();
    	userAdmin.setEnterpriseId(enterpriseId);
    	userAdmin.setUserId(userId);
    	userAdmin.setAdminName(Constants.ADMIN_NAME_MASTER);
    	userAdmin.setAdminType(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	i = userAdminMapper.insertSelective(userAdmin);

    	UserAdminLogin userAdminLogin = new UserAdminLogin();
    	userAdminLogin.setFirstLogin(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_NO);
    	userAdminLogin.setCreateTime(new Date());
    	userAdminLogin.setUpdateTime(new Date());
    	i = userAdminLoginMapper.insertSelective(userAdminLogin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

    	Org org = new Org();
    	org.setOrgName(enterpriseName);
    	org.setOrgAlias(enterpriseName);
    	org.setIsDelete(SqlSafeConstants.SQL_ORG_IS_DELETE_NO);
    	org.setCreateTime(new Date());
    	org.setUpdateTime(new Date());
    	i = orgMapper.insertSelective(org);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer orgId = org.getId();

    	UserOrg userOrg = new UserOrg();
    	userOrg.setEnterpriseId(enterpriseId);
    	userOrg.setUserId(userId);
    	userOrg.setOrgId(orgId);
    	userOrg.setCreateTime(new Date());
    	userOrg.setUpdateTime(new Date());
    	i = userOrgMapper.insertSelective(userOrg);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

//    	UserAdminPassword userAdminPassword = new UserAdminPassword();
//    	userAdminPassword.setUserId(userId);
//    	//过期时间暂为100年
//    	Date lastPassTime = new DateTime().plus(Period.years(100)).toDate();
//    	userAdminPassword.setLastPassTime(lastPassTime);
//    	userAdminPassword.setCreateTime(new Date());
//    	userAdminPassword.setUpdateTime(new Date());
//    	i = userAdminPasswordMapper.insertSelective(userAdminPassword);
//    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

    	return i;
    }


}