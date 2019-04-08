package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.ActivityCommentMapper;
import com.cloud.provider.safe.po.ActivityComment;
import com.cloud.provider.safe.po.ActivityCommentExample;
import com.cloud.provider.safe.rest.request.page.activity.ActivityCommentPageRequest;
import com.cloud.provider.safe.service.IActivityCommentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 活动评论 ActivityCommentService
 * @author wei.yong
 */
@Service
public class ActivityCommentServiceImpl implements IActivityCommentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //活动评论 Mapper
    @Autowired
    private ActivityCommentMapper activityCommentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<ActivityComment>
	 */
	@Override
	public List<ActivityComment> selectListByPage(Page<?> page, ActivityCommentPageRequest param) {
		logger.info("(ActivityCommentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		ActivityCommentExample example = new ActivityCommentExample();
		example.setOrderByClause(" id desc ");
		ActivityCommentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<ActivityComment> list = activityCommentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<ActivityComment>
	 */
	@Override
	public List<ActivityComment> selectList(ActivityCommentPageRequest param) {
		logger.info("(ActivityCommentService-selectList)-不分页查询-传入参数, param:{}", param);
		ActivityCommentExample example = new ActivityCommentExample();
		example.setOrderByClause(" id desc ");
		ActivityCommentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<ActivityComment> list = activityCommentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 根据activityId查询活动评论列表
	 * @param activityId
	 * @return List<ActivityComment>
	 */
	@Override
	public List<ActivityComment> selectListByActivityId(Integer activityId) {
		logger.info("(ActivityCommentService-selectListByActivityId)-根据activityId查询活动评论列表-传入参数, activityId:{}", activityId);
		ActivityCommentExample example = new ActivityCommentExample();
		example.setOrderByClause(" id desc ");
		ActivityCommentExample.Criteria criteria = example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		List<ActivityComment> list = activityCommentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询活动评论
     * @param id
     * @return ActivityComment
     */
	@Override
	public ActivityComment selectById(Integer id) {
    	logger.info("(ActivityCommentService-selectById)-根据id查询活动评论-传入参数, id:{}", id);
		ActivityComment activityComment = activityCommentMapper.selectByPrimaryKey(id);
		return activityComment;
    }

    /**
     * 插入活动评论
     * @param activityComment
     * @return Integer
     */
	@Override
	public Integer insert(ActivityComment activityComment) {
    	logger.info("(ActivityCommentService-insert)-插入活动评论-传入参数, activityComment:{}", activityComment);
    	activityComment.setCreateTime(new Date());
    	activityComment.setUpdateTime(new Date());
    	int i = activityCommentMapper.insertSelective(activityComment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除活动评论
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(ActivityCommentService-deleteById)-根据id删除活动评论-传入参数, id:{}", id);
		int i = activityCommentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除活动评论
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除活动评论-传入参数, ids:{}", ids);
  		ActivityCommentExample example = new ActivityCommentExample();
  		ActivityCommentExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = activityCommentMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改活动评论
     * @param activityComment
     * @return Integer
     */
	@Override
	public Integer modify(ActivityComment activityComment) {
    	logger.info("(ActivityCommentService-modify)-修改活动评论-传入参数, activityComment:{}", activityComment);
    	activityComment.setUpdateTime(new Date());
		int i = activityCommentMapper.updateByPrimaryKeySelective(activityComment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}