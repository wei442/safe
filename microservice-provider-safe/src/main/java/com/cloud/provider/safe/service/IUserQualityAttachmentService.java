package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.rest.request.page.user.UserQualityAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IUserQualityAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserQualityAttachment>
	 */
	public List<UserQualityAttachment> selectListByPage(Page<?> page, UserQualityAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQualityAttachment>
	 */
	public List<UserQualityAttachment> selectList(UserQualityAttachmentPageRequest param); 

	/**
	 * 根据userQualityId查询用户资质附件列表
	 * @param userQualityId
	 * @return List<UserQualityAttachment>
	 */
	public List<UserQualityAttachment> selectListByUserQualityId(Integer userQualityId);

    /**
     * 根据id查询用户资质附件
     * @param id
     * @return UserQualityAttachment
     */
	public UserQualityAttachment selectById(Integer id);

    /**
     * 插入用户资质附件
     * @param userQualityAttachment
     * @return Integer
     */
	public Integer insert(UserQualityAttachment userQualityAttachment);

	/**
  	 * 根据id删除用户资质附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除用户资质附件
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改用户资质附件
     * @param userQualityAttachment
     * @return Integer
     */
	public Integer modify(UserQualityAttachment userQualityAttachment);

}