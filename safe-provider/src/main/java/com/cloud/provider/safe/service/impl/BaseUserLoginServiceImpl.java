package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.BaseUserLoginMapper;
import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.po.BaseUserLoginExample;
import com.cloud.provider.safe.rest.request.page.base.user.BaseUserLoginPageRequest;
import com.cloud.provider.safe.service.IBaseUserLoginService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户登录 BaseUserLoginService
 * @author wei.yong
 */
@Service
public class BaseUserLoginServiceImpl implements IBaseUserLoginService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //基础用户登录 Mapper
    @Autowired
    private BaseUserLoginMapper baseUserLoginMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUserLogin>
	 */
	@Override
	public List<BaseUserLogin> selectListByPage(Page<?> page, BaseUserLoginPageRequest param) {
		logger.info("(BaseUserLoginService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		BaseUserLoginExample example = new BaseUserLoginExample();
		example.setOrderByClause(" id desc ");
		BaseUserLoginExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<BaseUserLogin> list = baseUserLoginMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<BaseUserLogin>
	 */
	@Override
	public List<BaseUserLogin> selectList(BaseUserLoginPageRequest param) {
		logger.info("(BaseUserLoginService-selectList)-不分页查询-传入参数, param:{}", param);
		BaseUserLoginExample example = new BaseUserLoginExample();
		example.setOrderByClause(" id desc ");
		BaseUserLoginExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<BaseUserLogin> list = baseUserLoginMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询基础用户登录
     * @param id
     * @return BaseUserLogin
     */
	@Override
	public BaseUserLogin selectById(Integer id) {
    	logger.info("(BaseUserLoginService-selectById)-根据id查询基础用户登录-传入参数, id:{}", id);
		BaseUserLogin baseUserLogin = baseUserLoginMapper.selectByPrimaryKey(id);
		return baseUserLogin;
    }

	/**
	 * 根据baseUserId查询基础用户登录
	 * @param baseUserId
	 * @return UserAdminLogin
	 */
	public BaseUserLogin selectByBaseUserId(Integer baseUserId) {
		logger.info("(BaseUserLoginService-selectByBaseUserId)-根据baseUserId查询基础用户登录-传入参数, baseUserId:{}", baseUserId);
		BaseUserLoginExample example = new BaseUserLoginExample();
		BaseUserLoginExample.Criteria criteria = example.createCriteria();
		criteria.andBaseUserIdEqualTo(baseUserId);
		List<BaseUserLogin> list = baseUserLoginMapper.selectByExample(example);

		BaseUserLogin baseUserLogin = null;
		if(list != null && !list.isEmpty()) {
			baseUserLogin = list.get(0);
		}
		return baseUserLogin;
	}

    /**
     * 插入基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	@Override
	public Integer insert(BaseUserLogin baseUserLogin) {
    	logger.info("(BaseUserLoginService-insert)-插入基础用户登录-传入参数, baseUserLogin:{}", baseUserLogin);
    	baseUserLogin.setCreateTime(new Date());
    	baseUserLogin.setUpdateTime(new Date());
    	int i = baseUserLoginMapper.insertSelective(baseUserLogin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除基础用户登录
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(BaseUserLoginService-deleteById)-根据id删除基础用户登录-传入参数, id:{}", id);
  		int i = baseUserLoginMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	@Override
	public Integer modify(BaseUserLogin baseUserLogin) {
    	logger.info("(BaseUserLoginService-modify)-修改基础用户登录-传入参数, baseUserLogin:{}", baseUserLogin);
    	baseUserLogin.setUpdateTime(new Date());
		int i = baseUserLoginMapper.updateByPrimaryKeySelective(baseUserLogin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}