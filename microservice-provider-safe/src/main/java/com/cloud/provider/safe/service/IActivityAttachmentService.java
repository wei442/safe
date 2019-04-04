package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.ActivityAttachment;
import com.cloud.provider.safe.rest.request.page.ActivityAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IActivityAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<ActivityAttachment>
	 */
	public List<ActivityAttachment> selectListByPage(Page<?> page, ActivityAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<ActivityAttachment>
	 */
	public List<ActivityAttachment> selectList(ActivityAttachmentPageRequest param);

	/**
	 * 根据activityId查询活动附件列表
	 * @param activityId
	 * @return List<ActivityAttachment>
	 */
	public List<ActivityAttachment> selectListByActivityId(Integer activityId);

    /**
     * 根据id查询活动附件
     * @param id
     * @return ActivityAttachment
     */
	public ActivityAttachment selectById(Integer id);

    /**
     * 插入活动附件
     * @param activityAttachment
     * @return Integer
     */
	public Integer insert(ActivityAttachment activityAttachment);

	/**
  	 * 根据id删除活动附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除活动附件
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改活动附件
     * @param activityAttachment
     * @return Integer
     */
	public Integer modify(ActivityAttachment activityAttachment);

}