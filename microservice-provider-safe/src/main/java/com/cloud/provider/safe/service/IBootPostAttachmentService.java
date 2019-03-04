package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.PostAttachment;
import com.github.pagehelper.Page;

public interface IBootPostAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param postAttachment
	 * @return List<PostAttachment>
	 */
	public List<PostAttachment> selectPostAttachmentListByPage(Page<?> page, PostAttachment postAttachment);

	/**
	 * 不分页查询
	 * @param postAttachment
	 * @return List<PostAttachment>
	 */
	public List<PostAttachment> selectPostAttachmentList(PostAttachment postAttachment);

    /**
     * 根据id查询用户附件
     * @param id
     * @return PostAttachment
     */
	public PostAttachment selectPostAttachmentById(Integer id);

    /**
     * 插入用户附件
     * @param postAttachment
     * @return Integer
     */
	public Integer insertPostAttachment(PostAttachment postAttachment);

    /**
     * 修改用户附件
     * @param postAttachment
     * @return Integer
     */
	public Integer modifyPostAttachment(PostAttachment postAttachment);

}