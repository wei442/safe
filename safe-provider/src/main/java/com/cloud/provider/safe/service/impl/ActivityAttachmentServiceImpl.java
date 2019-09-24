package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.ActivityAttachmentMapper;
import com.cloud.provider.safe.po.ActivityAttachment;
import com.cloud.provider.safe.po.ActivityAttachmentExample;
import com.cloud.provider.safe.rest.request.page.activity.ActivityAttachmentPageRequest;
import com.cloud.provider.safe.service.IActivityAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 活动附件 ActivityAttachmentService
 * @author wei.yong
 */
@Service
public class ActivityAttachmentServiceImpl implements IActivityAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //活动附件 Mapper
    @Autowired
    private ActivityAttachmentMapper activityAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<ActivityAttachment>
	 */
	@Override
	public List<ActivityAttachment> selectListByPage(Page<?> page, ActivityAttachmentPageRequest param) {
		logger.info("(ActivityAttachmentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		ActivityAttachmentExample example = new ActivityAttachmentExample();
		example.setOrderByClause(" id asc ");
		ActivityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getActivityId() != null) {
				criteria.andActivityIdEqualTo(param.getActivityId());
			}
		}
		List<ActivityAttachment> list = activityAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<ActivityAttachment>
	 */
	@Override
	public List<ActivityAttachment> selectList(ActivityAttachmentPageRequest param) {
		logger.info("(ActivityAttachmentService-selectList)-不分页查询-传入参数, param:{}", param);
		ActivityAttachmentExample example = new ActivityAttachmentExample();
		example.setOrderByClause(" id asc ");
		ActivityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getActivityId() != null) {
				criteria.andActivityIdEqualTo(param.getActivityId());
			}
		}
		List<ActivityAttachment> list = activityAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 根据activityId查询活动附件列表
	 * @param activityId
	 * @return List<ActivityAttachment>
	 */
	@Override
	public List<ActivityAttachment> selectListByActivityId(Integer activityId) {
		logger.info("(ActivityAttachmentService-selectListByActivityId)-根据activityId查询活动附件列表-传入参数, activityId:{}", activityId);
		ActivityAttachmentExample example = new ActivityAttachmentExample();
		example.setOrderByClause(" id desc ");
		ActivityAttachmentExample.Criteria criteria = example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		List<ActivityAttachment> list = activityAttachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询活动附件
     * @param id
     * @return ActivityAttachment
     */
	@Override
	public ActivityAttachment selectById(Integer id) {
    	logger.info("(ActivityAttachmentService-selectById)-根据id查询活动附件-传入参数, id:{}", id);
		ActivityAttachment activityAttachment = activityAttachmentMapper.selectByPrimaryKey(id);
		return activityAttachment;
    }

    /**
     * 插入活动附件
     * @param activityAttachment
     * @return Integer
     */
	@Override
	public Integer insert(ActivityAttachment activityAttachment) {
    	logger.info("(ActivityAttachmentService-insert)-插入活动附件-传入参数, activityAttachment:{}", activityAttachment);
    	activityAttachment.setCreateTime(new Date());
    	activityAttachment.setUpdateTime(new Date());
    	int i = activityAttachmentMapper.insertSelective(activityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除活动附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(ActivityAttachmentService-deleteById)-根据id删除活动附件-传入参数, id:{}", id);
		int i = activityAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除活动附件
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除活动附件-传入参数, ids:{}", ids);
  		ActivityAttachmentExample example = new ActivityAttachmentExample();
  		ActivityAttachmentExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = activityAttachmentMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改活动附件
     * @param activityAttachment
     * @return Integer
     */
	@Override
	public Integer modify(ActivityAttachment activityAttachment) {
    	logger.info("(ActivityAttachmentService-modify)-修改活动附件-传入参数, activityAttachment:{}", activityAttachment);
    	activityAttachment.setUpdateTime(new Date());
		int i = activityAttachmentMapper.updateByPrimaryKeySelective(activityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}