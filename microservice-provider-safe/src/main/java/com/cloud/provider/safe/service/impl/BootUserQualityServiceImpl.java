package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserQualityMapper;
import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.po.UserQualityExample;
import com.cloud.provider.safe.service.IBootUserQualityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户资质 BootUserQualityService
 * @author wei.yong
 */
@Service
public class BootUserQualityServiceImpl implements IBootUserQualityService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户资质 Mapper
    @Autowired
    private UserQualityMapper userQualityMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userQuality
	 * @return List<UserQuality>
	 */
	@Override
	public List<UserQuality> selectUserQualityListByPage(Page<?> page, UserQuality userQuality) {
		logger.info("(BootUserQualityService-selectUserQualityListByPage)-分页查询-传入参数, page:{}, userQuality:{}", page, userQuality);
		PageHelper.startPage(page);
		UserQualityExample example = new UserQualityExample();
		example.setOrderByClause(" id desc ");
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(userQuality != null) {
		}
		List<UserQuality> list = null;
		try {
			list = userQualityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserQualityService-selectUserQualityListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userQuality
	 * @return List<UserQuality>
	 */
	@Override
	public List<UserQuality> selectUserQualityList(UserQuality userQuality) {
		logger.info("(BootUserQualityService-selectUserQualityList)-不分页查询-传入参数, userQuality:{}", userQuality);
		UserQualityExample example = new UserQualityExample();
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(userQuality != null) {
		}
		List<UserQuality> list = null;
		try {
			list = userQualityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserQualityService-selectUserQualityList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户资质
     * @param id
     * @return UserQuality
     */
	@Override
	public UserQuality selectUserQualityById(Integer id) {
    	logger.info("(BootUserQualityService-selectUserQualityById)-根据id查询用户资质-传入参数, id:{}", id);
    	UserQuality userQuality = null;
    	try {
    		userQuality = userQualityMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserQualityService-selectUserQualityById)-根据id查询用户资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userQuality;
    }

    /**
     * 插入用户资质
     * @param userQuality
     * @return Integer
     */
	@Override
	public Integer insertUserQuality(UserQuality userQuality) {
    	logger.info("(BootUserQualityService-insertUserQuality)-插入用户资质-传入参数, userQuality:{}", userQuality);
    	userQuality.setCreateTime(new Date());
    	userQuality.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userQualityMapper.insertSelective(userQuality);
    	} catch (Exception e) {
    		logger.error("(BootUserQualityService-insertUserQuality)-插入用户资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserQualityById(Integer id) {
  		logger.info("(BootUserQualityService-deleteUserQualityById)-根据id删除用户资质-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userQualityMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserQualityService-deleteUserQualityById)-根据id删除用户资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改用户资质
     * @param userQuality
     * @return Integer
     */
	@Override
	public Integer modifyUserQuality(UserQuality userQuality) {
    	logger.info("(BootUserQualityService-modifyUserQuality)-修改用户资质-传入参数, userQuality:{}", userQuality);
    	userQuality.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userQualityMapper.updateByPrimaryKeySelective(userQuality);
    	} catch (Exception e) {
    		logger.error("(BootUserQualityService-modifyUserQuality)-修改用户资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}