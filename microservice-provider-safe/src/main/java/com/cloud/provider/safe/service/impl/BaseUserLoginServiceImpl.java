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
import com.cloud.provider.safe.rest.request.page.BaseUserLoginPageRequest;
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
	public List<BaseUserLogin> selectBaseUserLoginListByPage(Page<?> page, BaseUserLoginPageRequest param) {
		logger.info("(BaseUserLoginService-selectBaseUserLoginListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
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
	public List<BaseUserLogin> selectBaseUserLoginList(BaseUserLoginPageRequest param) {
		logger.info("(BaseUserLoginService-selectBaseUserLoginList)-不分页查询-传入参数, param:{}", param);
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
	public BaseUserLogin selectBaseUserLoginById(Integer id) {
    	logger.info("(BaseUserLoginService-selectBaseUserLoginById)-根据id查询基础用户登录-传入参数, id:{}", id);
		BaseUserLogin baseUserLogin = baseUserLoginMapper.selectByPrimaryKey(id);
		return baseUserLogin;
    }

    /**
     * 插入基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	@Override
	public Integer insertBaseUserLogin(BaseUserLogin baseUserLogin) {
    	logger.info("(BaseUserLoginService-insertBaseUserLogin)-插入基础用户登录-传入参数, baseUserLogin:{}", baseUserLogin);
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
	public Integer deleteBaseUserLoginById(Integer id) {
  		logger.info("(BaseUserLoginService-deleteBaseUserLoginById)-根据id删除基础用户登录-传入参数, id:{}", id);
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
	public Integer modifyBaseUserLogin(BaseUserLogin baseUserLogin) {
    	logger.info("(BaseUserLoginService-modifyBaseUserLogin)-修改基础用户登录-传入参数, baseUserLogin:{}", baseUserLogin);
    	baseUserLogin.setUpdateTime(new Date());
		int i = baseUserLoginMapper.updateByPrimaryKeySelective(baseUserLogin);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}