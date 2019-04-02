package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserInfoMapper;
import com.cloud.provider.safe.dao.dao.UserOrgDao;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserInfoExample;
import com.cloud.provider.safe.rest.request.page.UserInfoPageRequest;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户信息 UserInfoService
 * @author wei.yong
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户信息 Mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    //用户组织机构 Dao
    @Autowired
    private UserOrgDao userOrgDao;

//    //用户信息 Dao
//    @Autowired
//    private UserInfoDao userInfoDao;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserInfo>
	 */
	@Override
	public List<UserInfo> selectListByPage(Page<?> page, UserInfoPageRequest param) {
		logger.info("(UserInfoService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
		if(param != null) {
		}
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserInfo>
	 */
	@Override
	public List<UserInfo> selectList(UserInfoPageRequest param) {
		logger.info("(UserInfoService-selectList)-不分页查询-传入参数, param:{}", param);
		UserInfoExample example = new UserInfoExample();
		example.setOrderByClause(" id desc ");
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
		if(param != null) {
		}
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		return list;
	}

//	/**
//	 * 根据orgId查询当前组织机构下的所有人员
//	 * @param param
//	 * @return List<UserInfoVo>
//	 */
//	@Override
//	public List<UserOrgVo> selectListByOrgId(UserOrgParam param) {
//		logger.info("(UserInfoService-selectListByOrgId)-根据orgId查询当前组织机构下的所有人员-传入参数, param:{}", param);
//		param.setOrderByClause(" t2.id asc ");
//		List<UserOrgVo> list = userOrgDao.selectList(param);
//		return list;
//	}

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
	@Override
	public UserInfo selectById(Integer id) {
    	logger.info("(UserInfoService-selectById)-根据id查询用户信息-传入参数, id:{}", id);
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
		return userInfo;
    }

	/**
	 * 根据userAccount查询用户信息
	 * @param userAccount
	 * @return UserInfo
	 */
	@Override
	public UserInfo selectByUserAccount(String userAccount) {
		logger.info("(UserInfoService-selectByUserAccount)-根据userAccount查询用户信息-传入参数, userAccount:{}", userAccount);
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
		criteria.andUserAccountEqualTo(userAccount);

		List<UserInfo> list = userInfoMapper.selectByExample(example);
		UserInfo userInfo = null;
		if(list != null && !list.isEmpty()) {
			userInfo = list.get(0);
		}
		return userInfo;
	}

    /**
     * 插入用户信息
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer insert(UserInfo userInfo) {
    	logger.info("(UserInfoService-insertUserInfo)-插入用户信息-传入参数, userInfo:{}", userInfo);
    	userInfo.setUserStatus(SqlSafeConstants.SQL_USER_STATUS_NORMAL);
    	userInfo.setIsDelete(SqlSafeConstants.SQL_USER_IS_DELETE_NO);
    	userInfo.setCreateTime(new Date());
    	userInfo.setUpdateTime(new Date());
    	int i = userInfoMapper.insertSelective(userInfo);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户信息
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserInfoService-deleteById)-根据id删除用户信息-传入参数, id:{}", id);
  		int i = userInfoMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户信息
     * @param userInfo
     * @return Integer
     */
	@Override
	public Integer modify(UserInfo userInfo) {
    	logger.info("(UserInfoService-modifyUserInfo)-修改用户信息-传入参数, userInfo:{}", userInfo);
    	userInfo.setUpdateTime(new Date());
    	int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}