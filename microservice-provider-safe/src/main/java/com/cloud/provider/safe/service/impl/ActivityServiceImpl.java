package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.ActivityMapper;
import com.cloud.provider.safe.po.Activity;
import com.cloud.provider.safe.po.ActivityExample;
import com.cloud.provider.safe.rest.request.page.activity.ActivityPageRequest;
import com.cloud.provider.safe.service.IActivityService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 活动 ActivityService
 * @author wei.yong
 */
@Service
public class ActivityServiceImpl implements IActivityService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //活动 Mapper
    @Autowired
    private ActivityMapper activityMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Activity>
	 */
	@Override
	public List<Activity> selectListByPage(Page<?> page, ActivityPageRequest param) {
		logger.info("(ActivityService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		ActivityExample example = new ActivityExample();
		example.setOrderByClause(" id desc ");
		ActivityExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Activity> list = activityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Activity>
	 */
	@Override
	public List<Activity> selectList(ActivityPageRequest param) {
		logger.info("(ActivityService-selectList)-不分页查询-传入参数, param:{}", param);
		ActivityExample example = new ActivityExample();
		example.setOrderByClause(" id desc ");
		ActivityExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_USER_ADMIN_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Activity> list = activityMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询活动
     * @param id
     * @return Activity
     */
	@Override
	public Activity selectById(Integer id) {
    	logger.info("(ActivityService-selectById)-根据id查询活动-传入参数, id:{}", id);
		Activity activity = activityMapper.selectByPrimaryKey(id);
		return activity;
    }

    /**
     * 插入活动
     * @param activity
     * @return Integer
     */
	@Override
	public Integer insert(Activity activity) {
    	logger.info("(ActivityService-insertActivity)-插入活动-传入参数, activity:{}", activity);
    	activity.setCreateTime(new Date());
    	activity.setUpdateTime(new Date());
    	int i = activityMapper.insertSelective(activity);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除活动
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(ActivityService-deleteById)-根据id删除活动-传入参数, id:{}", id);
		int i = activityMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除活动
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteById)-根据ids删除活动-传入参数, ids:{}", ids);
  		ActivityExample example = new ActivityExample();
  		ActivityExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = activityMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改活动
     * @param activity
     * @return Integer
     */
	@Override
	public Integer modify(Activity activity) {
    	logger.info("(ActivityService-modifyActivity)-修改活动-传入参数, activity:{}", activity);
    	activity.setUpdateTime(new Date());
		int i = activityMapper.updateByPrimaryKeySelective(activity);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}