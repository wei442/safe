package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.ActivityComment;
import com.cloud.provider.safe.rest.request.page.activity.ActivityCommentPageRequest;
import com.github.pagehelper.Page;

public interface IActivityCommentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<ActivityComment>
	 */
	public List<ActivityComment> selectListByPage(Page<?> page, ActivityCommentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<ActivityComment>
	 */
	public List<ActivityComment> selectList(ActivityCommentPageRequest param);

	/**
	 * 根据activityId查询活动评论列表
	 * @param activityId
	 * @return List<ActivityComment>
	 */
	public List<ActivityComment> selectListByActivityId(Integer activityId);

    /**
     * 根据id查询活动评论
     * @param id
     * @return ActivityComment
     */
	public ActivityComment selectById(Integer id);

    /**
     * 插入活动评论
     * @param activityComment
     * @return Integer
     */
	public Integer insert(ActivityComment activityComment);

	/**
  	 * 根据id删除活动评论
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除活动评论
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改活动评论
     * @param activityComment
     * @return Integer
     */
	public Integer modify(ActivityComment activityComment);

}