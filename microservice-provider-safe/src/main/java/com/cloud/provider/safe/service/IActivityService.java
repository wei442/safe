package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Activity;
import com.cloud.provider.safe.po.ActivityAttachment;
import com.cloud.provider.safe.rest.request.page.activity.ActivityPageRequest;
import com.github.pagehelper.Page;

public interface IActivityService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Activity>
	 */
	public List<Activity> selectListByPage(Page<?> page, ActivityPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Activity>
	 */
	public List<Activity> selectList(ActivityPageRequest param);

    /**
     * 根据id查询活动
     * @param id
     * @return Activity
     */
	public Activity selectById(Integer id);

    /**
     * 插入活动及附件
     * @param activity
     * @param activityAttachmentList
     * @return Integer
     */
	public Integer insert(Activity activity, List<ActivityAttachment> activityAttachmentList);

	/**
  	 * 根据id删除活动
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除活动
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改活动及附件
     * @param activity
     * @param activityAttachmentList
     * @return Integer
     */
	public Integer modify(Activity activity, List<ActivityAttachment> activityAttachmentList);

}