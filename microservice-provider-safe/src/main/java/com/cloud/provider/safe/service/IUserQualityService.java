package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.rest.request.page.user.UserQualityPageRequest;
import com.github.pagehelper.Page;

public interface IUserQualityService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectListByPage(Page<?> page, UserQualityPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectList(UserQualityPageRequest param);

    /**
     * 根据id查询用户资质
     * @param id
     * @return UserQuality
     */
	public UserQuality selectById(Integer id);

	/**
	 * 根据userId查询用户资质
	 * @param userId
	 * @return UserQuality
	 */
	public UserQuality selectByUserId(Integer userId);

    /**
     * 插入用户资质及附件
     * @param userQuality
     * @param userQualityAttachmentList
     * @return Integer
     */
	public Integer insert(UserQuality userQuality, List<UserQualityAttachment> userQualityAttachmentList);

 	/**
  	 * 根据id删除用户资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除用户资质
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改用户资质及附件
     * @param userQuality
     * @param userQualityAttachmentIds
     * @param userQualityAttachmentList
     * @return Integer
     */
	public Integer modify(UserQuality userQuality, List<Integer> userQualityAttachmentIds, List<UserQualityAttachment> userQualityAttachmentList);

}