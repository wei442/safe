package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserTitleMapper;
import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.po.UserTitleExample;
import com.cloud.provider.safe.service.IBootUserTitleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户职务 BootUserTitleService
 * @author wei.yong
 */
@Service
public class BootUserTitleServiceImpl implements IBootUserTitleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户职务 Mapper
    @Autowired
    private UserTitleMapper userTitleMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userTitle
	 * @return List<UserTitle>
	 */
	@Override
	public List<UserTitle> selectUserTitleListByPage(Page<?> page, UserTitle userTitle) {
		logger.info("(BootUserTitleService-selectUserTitleListByPage)-分页查询-传入参数, page:{}, userTitle:{}", page, userTitle);
		PageHelper.startPage(page);
		UserTitleExample example = new UserTitleExample();
		example.setOrderByClause(" id desc ");
		UserTitleExample.Criteria criteria = example.createCriteria();
		if(userTitle != null) {
		}
		List<UserTitle> list = null;
		try {
			list = userTitleMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserTitleService-selectUserTitleListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userTitle
	 * @return List<UserTitle>
	 */
	@Override
	public List<UserTitle> selectUserTitleList(UserTitle userTitle) {
		logger.info("(BootUserTitleService-selectUserTitleList)-不分页查询-传入参数, userTitle:{}", userTitle);
		UserTitleExample example = new UserTitleExample();
		UserTitleExample.Criteria criteria = example.createCriteria();
		if(userTitle != null) {
		}
		List<UserTitle> list = null;
		try {
			list = userTitleMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserTitleService-selectUserTitleList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户职务
     * @param id
     * @return UserTitle
     */
	@Override
	public UserTitle selectUserTitleById(Integer id) {
    	logger.info("(BootUserTitleService-selectUserTitleById)-根据id查询用户职务-传入参数, id:{}", id);
    	UserTitle userTitle = null;
    	try {
    		userTitle = userTitleMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserTitleService-selectUserTitleById)-根据id查询用户职务-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userTitle;
    }

    /**
     * 插入用户职务
     * @param userTitle
     * @return Integer
     */
	@Override
	public Integer insertUserTitle(UserTitle userTitle) {
    	logger.info("(BootUserTitleService-insertUserTitle)-插入用户职务-传入参数, userTitle:{}", userTitle);
    	userTitle.setCreateTime(new Date());
    	userTitle.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userTitleMapper.insertSelective(userTitle);
    	} catch (Exception e) {
    		logger.error("(BootUserTitleService-insertUserTitle)-插入用户职务-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserTitleById(Integer id) {
  		logger.info("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userTitleMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改用户职务
     * @param userTitle
     * @return Integer
     */
	@Override
	public Integer modifyUserTitle(UserTitle userTitle) {
    	logger.info("(BootUserTitleService-modifyUserTitle)-修改用户职务-传入参数, userTitle:{}", userTitle);
    	userTitle.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userTitleMapper.updateByPrimaryKeySelective(userTitle);
    	} catch (Exception e) {
    		logger.error("(BootUserTitleService-modifyUserTitle)-修改用户职务-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}