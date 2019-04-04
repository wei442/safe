package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.BaseUserInfoMapper;
import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.po.BaseUserInfoExample;
import com.cloud.provider.safe.rest.request.page.base.user.BaseUserInfoPageRequest;
import com.cloud.provider.safe.service.IBaseUserInfoService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户信息 BaseUserInfoService
 * @author wei.yong
 */
@Service
public class BaseUserInfoServiceImpl implements IBaseUserInfoService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //基础用户信息 Mapper
    @Autowired
    private BaseUserInfoMapper baseUserInfoMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUserInfo>
	 */
	@Override
	public List<BaseUserInfo> selectListByPage(Page<?> page, BaseUserInfoPageRequest param) {
		logger.info("(BaseUserInfoService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		BaseUserInfoExample example = new BaseUserInfoExample();
		example.setOrderByClause(" id desc ");
		BaseUserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_BASE_USER_IS_DELETE_NO);
		if(param != null) {
		}
		List<BaseUserInfo> list = baseUserInfoMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<BaseUserInfo>
	 */
	@Override
	public List<BaseUserInfo> selectList(BaseUserInfoPageRequest param) {
		logger.info("(BaseUserInfoService-selectList)-不分页查询-传入参数, param:{}", param);
		BaseUserInfoExample example = new BaseUserInfoExample();
		example.setOrderByClause(" id desc ");
		BaseUserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_BASE_USER_IS_DELETE_NO);
		if(param != null) {
		}
		List<BaseUserInfo> list = baseUserInfoMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询基础用户信息
     * @param id
     * @return BaseUserInfo
     */
	@Override
	public BaseUserInfo selectById(Integer id) {
    	logger.info("(BaseUserInfoService-selectById)-根据id查询基础用户信息-传入参数, id:{}", id);
		BaseUserInfo baseUserInfo = baseUserInfoMapper.selectByPrimaryKey(id);
		return baseUserInfo;
    }

    /**
     * 插入基础用户信息
     * @param baseUserInfo
     * @return Integer
     */
	@Override
	public Integer insert(BaseUserInfo baseUserInfo) {
    	logger.info("(BaseUserInfoService-insertBaseUserInfo)-插入基础用户信息-传入参数, baseUserInfo:{}", baseUserInfo);
    	baseUserInfo.setUserStatus(SqlSafeConstants.SQL_BASE_USER_STATUS_NORMAL);
    	baseUserInfo.setIsDelete(SqlSafeConstants.SQL_BASE_USER_IS_DELETE_NO);
    	baseUserInfo.setCreateTime(new Date());
    	baseUserInfo.setUpdateTime(new Date());
    	int i = baseUserInfoMapper.insertSelective(baseUserInfo);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除基础用户信息
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(BaseUserInfoService-deleteById)-根据id删除基础用户信息-传入参数, id:{}", id);
  		int i = baseUserInfoMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改基础用户信息
     * @param baseUserInfo
     * @return Integer
     */
	@Override
	public Integer modify(BaseUserInfo baseUserInfo) {
    	logger.info("(BaseUserInfoService-modifyBaseUserInfo)-修改基础用户信息-传入参数, baseUserInfo:{}", baseUserInfo);
    	baseUserInfo.setUpdateTime(new Date());
    	int i = baseUserInfoMapper.updateByPrimaryKeySelective(baseUserInfo);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}