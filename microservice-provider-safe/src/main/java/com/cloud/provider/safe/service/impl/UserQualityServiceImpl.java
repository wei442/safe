package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserQualityMapper;
import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.po.UserQualityExample;
import com.cloud.provider.safe.rest.request.page.UserQualityPageRequest;
import com.cloud.provider.safe.service.IUserQualityService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户资质 UserQualityService
 * @author wei.yong
 */
@Service
public class UserQualityServiceImpl implements IUserQualityService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户资质 Mapper
    @Autowired
    private UserQualityMapper userQualityMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectUserQualityListByPage(Page<?> page, UserQualityPageRequest param) {
		logger.info("(UserQualityService-selectUserQualityListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		UserQualityExample example = new UserQualityExample();
		example.setOrderByClause(" id desc ");
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectUserQualityList(UserQualityPageRequest param) {
		logger.info("(UserQualityService-selectUserQualityList)-不分页查询-传入参数, param:{}", param);
		UserQualityExample example = new UserQualityExample();
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户资质
     * @param id
     * @return UserQuality
     */
	@Override
	public UserQuality selectUserQualityById(Integer id) {
    	logger.info("(UserQualityService-selectUserQualityById)-根据id查询用户资质-传入参数, id:{}", id);
		UserQuality userQuality = userQualityMapper.selectByPrimaryKey(id);
		return userQuality;
    }

    /**
     * 插入用户资质
     * @param userQuality
     * @return Integer
     */
	@Override
	public Integer insertUserQuality(UserQuality userQuality) {
    	logger.info("(UserQualityService-insertUserQuality)-插入用户资质-传入参数, userQuality:{}", userQuality);
    	userQuality.setCreateTime(new Date());
    	userQuality.setUpdateTime(new Date());
    	int i = userQualityMapper.insertSelective(userQuality);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteUserQualityById(Integer id) {
  		logger.info("(UserQualityService-deleteUserQualityById)-根据id删除用户资质-传入参数, id:{}", id);
		int i = userQualityMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户资质
     * @param userQuality
     * @return Integer
     */
	@Override
	public Integer modifyUserQuality(UserQuality userQuality) {
    	logger.info("(UserQualityService-modifyUserQuality)-修改用户资质-传入参数, userQuality:{}", userQuality);
    	userQuality.setUpdateTime(new Date());
		int i = userQualityMapper.updateByPrimaryKeySelective(userQuality);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}