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
	@Override
	public List<UserQuality> selectListByPage(Page<?> page, UserQualityPageRequest param) {
		logger.info("(UserQualityService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		UserQualityExample example = new UserQualityExample();
		example.setOrderByClause(" id desc ");
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQuality>
	 */
	@Override
	public List<UserQuality> selectList(UserQualityPageRequest param) {
		logger.info("(UserQualityService-selectList)-不分页查询-传入参数, param:{}", param);
		UserQualityExample example = new UserQualityExample();
		example.setOrderByClause(" id desc ");
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
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
	public UserQuality selectById(Integer id) {
    	logger.info("(UserQualityService-selectById)-根据id查询用户资质-传入参数, id:{}", id);
		UserQuality userQuality = userQualityMapper.selectByPrimaryKey(id);
		Assert.thanOrEqualZreo(userQuality, SafeResultEnum.DATABASE_NOTEXIST);
		return userQuality;
    }

	/**
	 * 根据userId查询用户资质
	 * @param userId
	 * @return UserQuality
	 */
	@Override
	public UserQuality selectByUserId(Integer userId) {
		logger.info("(UserQualityService-selectById)-根据userId查询用户资质-传入参数, userId:{}", userId);
		UserQualityExample example = new UserQualityExample();
		UserQualityExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		UserQuality userQuality = null;
		if(list != null && !list.isEmpty()) {
			userQuality = list.get(0);
		}
		Assert.thanOrEqualZreo(userQuality, SafeResultEnum.DATABASE_NOTEXIST);
		return userQuality;
	}

    /**
     * 插入用户资质
     * @param userQuality
     * @return Integer
     */
	@Override
	public Integer insert(UserQuality userQuality) {
    	logger.info("(UserQualityService-insertUserQuality)-插入用户资质-传入参数, userQuality:{}", userQuality);
    	userQuality.setCreateTime(new Date());
    	userQuality.setUpdateTime(new Date());
    	int i = userQualityMapper.insertSelective(userQuality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserQualityService-deleteById)-根据id删除用户资质-传入参数, id:{}", id);
		int i = userQualityMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户资质
     * @param userQuality
     * @return Integer
     */
	@Override
	public Integer modify(UserQuality userQuality) {
    	logger.info("(UserQualityService-modifyUserQuality)-修改用户资质-传入参数, userQuality:{}", userQuality);
    	userQuality.setUpdateTime(new Date());
		int i = userQualityMapper.updateByPrimaryKeySelective(userQuality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}