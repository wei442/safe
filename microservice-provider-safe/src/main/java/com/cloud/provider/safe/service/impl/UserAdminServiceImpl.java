package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.constants.Constants;
import com.cloud.provider.safe.dao.UserAdminLoginMapper;
import com.cloud.provider.safe.dao.UserAdminMapper;
import com.cloud.provider.safe.dao.UserAdminPasswordMapper;
import com.cloud.provider.safe.dao.dao.UserAdminDao;
import com.cloud.provider.safe.param.UserAdminParam;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminExample;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminLoginExample;
import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserAdminPasswordExample;
import com.cloud.provider.safe.rest.request.page.user.UserAdminPageRequest;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.vo.user.UserAdminVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理 UserAdminService
 * @author wei.yong
 */
@Service
public class UserAdminServiceImpl implements IUserAdminService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户管理 Mapper
    @Autowired
    private UserAdminMapper userAdminMapper;

    //用户管理 Dao
    @Autowired
    private UserAdminDao userAdminDao;

    //用户管理密码 Mapper
    @Autowired
    private UserAdminPasswordMapper userAdminPasswordMapper;

    //用户管理登录 Mapper
    @Autowired
    private UserAdminLoginMapper userAdminLoginMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdmin>
	 */
	@Override
	public List<UserAdminVo> selectListByPage(Page<?> page, UserAdminPageRequest param) {
		logger.info("(UserAdminService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserAdminParam userAdminParam = new UserAdminParam();
//		userTitleParam.setOrderByClause("  ");
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				userAdminParam.setEnterpriseId(param.getEnterpriseId());
			}
		}
		List<UserAdminVo> list = userAdminDao.selectList(userAdminParam);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdmin>
	 */
	@Override
	public List<UserAdminVo> selectList(UserAdminPageRequest param) {
		logger.info("(UserAdminService-selectList)-不分页查询-传入参数, param:{}", param);
		UserAdminParam userAdminParam = new UserAdminParam();
//		userTitleParam.setOrderByClause("  ");
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				userAdminParam.setEnterpriseId(param.getEnterpriseId());
			}
		}
		List<UserAdminVo> list = userAdminDao.selectList(userAdminParam);
		return list;
	}

    /**
     * 根据id查询用户管理
     * @param id
     * @return UserAdmin
     */
	@Override
	public UserAdmin selectById(Integer id) {
    	logger.info("(UserAdminService-selectById)-根据id查询用户管理-传入参数, id:{}", id);
		UserAdmin userAdmin = userAdminMapper.selectByPrimaryKey(id);
		return userAdmin;
    }

	/**
	 * 根据userId查询用户管理
	 * @param userId
	 * @return UserAdmin
	 */
	@Override
	public UserAdmin selectByUserId(Integer userId) {
		logger.info("(UserAdminService-selectByUserId)-根据userId查询用户管理-传入参数, userId:{}", userId);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		criteria.andUserIdEqualTo(userId);

		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		UserAdmin userAdmin = null;
		if(list != null && !list.isEmpty()) {
			userAdmin = list.get(0);
		}
		return userAdmin;
	}

	/**
	 * 根据enterpriseId和userId查询用户管理
	 * @param enterpriseId
	 * @param userId
	 * @return UserAdmin
	 */
	@Override
	public UserAdmin selectByEnterpriseIdUserId(Integer enterpriseId,Integer userId) {
		logger.info("(UserAdminService-selectByEnterpriseIdUserId)-根据enterpriseId和userId查询用户管理-传入参数, enterpriseId:{}, userId:{}", enterpriseId, userId);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		criteria.andEnterpriseIdEqualTo(enterpriseId);
		criteria.andUserIdEqualTo(userId);

		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		UserAdmin userAdmin = null;
		if(list != null && !list.isEmpty()) {
			userAdmin = list.get(0);
		}
		return userAdmin;
	}

	/**
	 * 根据enterpriseId和adminType查询用户管理
	 * @param enterpriseId
	 * @param adminType
	 * @return UserAdmin
	 */
	@Override
	public UserAdmin selectByEnterpriseIdAdminType(Integer enterpriseId,Integer adminType) {
		logger.info("(UserAdminService-selectByEnterpriseIdAdminType)-根据enterpriseId和adminType查询用户管理-传入参数, enterpriseId:{}, adminType:{}", enterpriseId, adminType);
		UserAdminExample example = new UserAdminExample();
		UserAdminExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		criteria.andEnterpriseIdEqualTo(enterpriseId);
		criteria.andAdminTypeEqualTo(adminType);

		List<UserAdmin> list = userAdminMapper.selectByExample(example);
		UserAdmin userAdmin = null;
		if(list != null && !list.isEmpty()) {
			userAdmin = list.get(0);
		}
		return userAdmin;
	}

    /**
     * 插入用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer insert(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-insert)-插入用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setIsDelete(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.insertSelective(userAdmin);
    	return i;
    }

 	/**
  	 * 根据id删除用户管理
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserAdminService-deleteById)-根据id删除用户管理-传入参数, id:{}", id);
  		UserAdmin userAdmin = userAdminMapper.selectByPrimaryKey(id);
  		Integer userId = userAdmin.getUserId();

  		int i = userAdminMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

  		UserAdminPasswordExample example = new UserAdminPasswordExample();
		UserAdminPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		i = userAdminPasswordMapper.deleteByExample(example);

		UserAdminLoginExample userAdminLoginExample = new UserAdminLoginExample();
		UserAdminLoginExample.Criteria criteria2 = userAdminLoginExample.createCriteria();
		criteria2.andUserIdEqualTo(userId);
		userAdminLoginMapper.deleteByExample(userAdminLoginExample);
  		return i;
  	}

    /**
     * 修改用户管理
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer modify(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-modify)-修改用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.updateByPrimaryKeySelective(userAdmin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

    /**
     * 更改主管理员
     * @param oldUserAdmin
     * @param newUserAdmin
     * @return Integer
     */
	@Override
	public Integer changeAdminMaster(UserAdmin oldUserAdmin,UserAdmin newUserAdmin) {
    	logger.info("(UserAdminService-changeAdminMaster)-更改主管理员-传入参数, oldUserAdmin:{}, newUserAdmin:{}", oldUserAdmin, newUserAdmin);
    	Integer oldUserAdminId = oldUserAdmin.getId();
    	Integer userId = oldUserAdmin.getUserId();
    	Integer enterpriseId = oldUserAdmin.getEnterpriseId();
    	int i = userAdminMapper.deleteByPrimaryKey(oldUserAdminId);

    	UserAdminPasswordExample example = new UserAdminPasswordExample();
		UserAdminPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		i = userAdminPasswordMapper.deleteByExample(example);

    	newUserAdmin.setEnterpriseId(enterpriseId);
    	newUserAdmin.setUserId(userId);
    	newUserAdmin.setAdminName(Constants.ADMIN_NAME_MASTER);
    	newUserAdmin.setAdminType(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER);
    	newUserAdmin.setIsDelete(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
    	newUserAdmin.setCreateTime(new Date());
    	newUserAdmin.setUpdateTime(new Date());
    	i = userAdminMapper.insertSelective(newUserAdmin);

    	return i;
    }

    /**
     * 插入子管理员
     * @param userAdmin
     * @return Integer
     */
	@Override
	public Integer insertAdminSlave(UserAdmin userAdmin) {
    	logger.info("(UserAdminService-insert)-插入用户管理-传入参数, userAdmin:{}", userAdmin);
    	userAdmin.setAdminType(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE);
    	userAdmin.setIsDelete(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
    	userAdmin.setCreateTime(new Date());
    	userAdmin.setUpdateTime(new Date());
    	int i = userAdminMapper.insertSelective(userAdmin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer userId = userAdmin.getUserId();

    	UserAdminLogin userAdminLogin = new UserAdminLogin();
    	userAdminLogin.setUserId(userId);
    	userAdminLogin.setFirstLogin(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_NO);
    	userAdminLogin.setCreateTime(new Date());
    	userAdminLogin.setUpdateTime(new Date());
    	i = userAdminLoginMapper.insertSelective(userAdminLogin);

    	//首次注册密码为空
    	UserAdminPassword userAdminPassword = new UserAdminPassword();
    	userAdminPassword.setUserId(userId);
    	userAdminPassword.setPassword(DigestUtils.sha256Hex(Constants.PASSWORD_INIT));
    	//过期时间暂为100年
    	Date lastPassTime = new DateTime().plus(Period.years(100)).toDate();
    	userAdminPassword.setLastPassTime(lastPassTime);
    	userAdminPassword.setCreateTime(new Date());
    	userAdminPassword.setUpdateTime(new Date());
    	i = userAdminPasswordMapper.insertSelective(userAdminPassword);
    	return i;
    }

}