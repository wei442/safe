package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.BaseUserLoginMapper;
import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.po.BaseUserLoginExample;
import com.cloud.provider.safe.service.IBootBaseUserLoginService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 基础用户登录 BootBaseUserLoginService
 * @author wei.yong
 */
@Service
public class BootBaseUserLoginServiceImpl implements IBootBaseUserLoginService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //基础用户登录 Mapper
    @Autowired
    private BaseUserLoginMapper baseUserLoginMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param baseUserLogin
	 * @return List<BaseUserLogin>
	 */
	@Override
	public List<BaseUserLogin> selectBaseUserLoginListByPage(Page<?> page, BaseUserLogin baseUserLogin) {
		logger.info("(BootBaseUserLoginService-selectBaseUserLoginListByPage)-分页查询-传入参数, page:{}, baseUserLogin:{}", page, baseUserLogin);
		PageHelper.startPage(page);
		BaseUserLoginExample example = new BaseUserLoginExample();
		example.setOrderByClause(" id desc ");
		BaseUserLoginExample.Criteria criteria = example.createCriteria();
		if(baseUserLogin != null) {
		}
		List<BaseUserLogin> list = null;
		try {
			list = baseUserLoginMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootBaseUserLoginService-selectBaseUserLoginListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param baseUserLogin
	 * @return List<BaseUserLogin>
	 */
	@Override
	public List<BaseUserLogin> selectBaseUserLoginList(BaseUserLogin baseUserLogin) {
		logger.info("(BootBaseUserLoginService-selectBaseUserLoginList)-不分页查询-传入参数, baseUserLogin:{}", baseUserLogin);
		BaseUserLoginExample example = new BaseUserLoginExample();
		BaseUserLoginExample.Criteria criteria = example.createCriteria();
		if(baseUserLogin != null) {
		}
		List<BaseUserLogin> list = null;
		try {
			list = baseUserLoginMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootBaseUserLoginService-selectBaseUserLoginList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询基础用户登录
     * @param id
     * @return BaseUserLogin
     */
	@Override
	public BaseUserLogin selectBaseUserLoginById(Integer id) {
    	logger.info("(BootBaseUserLoginService-selectBaseUserLoginById)-根据id查询基础用户登录-传入参数, id:{}", id);
    	BaseUserLogin baseUserLogin = null;
    	try {
    		baseUserLogin = baseUserLoginMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootBaseUserLoginService-selectBaseUserLoginById)-根据id查询基础用户登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return baseUserLogin;
    }

    /**
     * 插入基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	@Override
	public Integer insertBaseUserLogin(BaseUserLogin baseUserLogin) {
    	logger.info("(BootBaseUserLoginService-insertBaseUserLogin)-插入基础用户登录-传入参数, baseUserLogin:{}", baseUserLogin);
    	baseUserLogin.setCreateTime(new Date());
    	baseUserLogin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = baseUserLoginMapper.insertSelective(baseUserLogin);
    	} catch (Exception e) {
    		logger.error("(BootBaseUserLoginService-insertBaseUserLogin)-插入基础用户登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除基础用户登录
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteBaseUserLoginById(Integer id) {
  		logger.info("(BootBaseUserLoginService-deleteBaseUserLoginById)-根据id删除基础用户登录-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = baseUserLoginMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootBaseUserLoginService-deleteBaseUserLoginById)-根据id删除基础用户登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	@Override
	public Integer modifyBaseUserLogin(BaseUserLogin baseUserLogin) {
    	logger.info("(BootBaseUserLoginService-modifyBaseUserLogin)-修改基础用户登录-传入参数, baseUserLogin:{}", baseUserLogin);
    	baseUserLogin.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = baseUserLoginMapper.updateByPrimaryKeySelective(baseUserLogin);
    	} catch (Exception e) {
    		logger.error("(BootBaseUserLoginService-modifyBaseUserLogin)-修改基础用户登录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}