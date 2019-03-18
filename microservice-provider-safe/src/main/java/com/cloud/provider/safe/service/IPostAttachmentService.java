package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.rest.request.page.PostAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IPostAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<PostAttachment>
	 */
	public List<PostAttachment> selectListByPage(Page<?> page, PostAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<PostAttachment>
	 */
	public List<PostAttachment> selectList(PostAttachmentPageRequest param);

    /**
     * 根据id查询用户附件
     * @param id
     * @return PostAttachment
     */
	public PostAttachment selectById(Integer id);

    /**
     * 插入用户附件
     * @param postAttachment
     * @return Integer
     */
	public Integer insert(PostAttachment postAttachment);

 	/**
  	 * 根据id删除岗位附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户附件
     * @param postAttachment
     * @return Integer
     */
	public Integer modify(PostAttachment postAttachment);

}