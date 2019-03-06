package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Attachment;
import com.github.pagehelper.Page;

public interface IAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param attachment
	 * @return List<Attachment>
	 */
	public List<Attachment> selectAttachmentListByPage(Page<?> page, Attachment attachment);

	/**
	 * 不分页查询
	 * @param attachment
	 * @return List<Attachment>
	 */
	public List<Attachment> selectAttachmentList(Attachment attachment);

    /**
     * 根据id查询附件
     * @param id
     * @return Attachment
     */
	public Attachment selectAttachmentById(Integer id);

    /**
     * 插入附件
     * @param attachment
     * @return Integer
     */
	public Integer insertAttachment(Attachment attachment);

 	/**
  	 * 根据id删除附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteAttachmentById(Integer id);

    /**
     * 修改附件
     * @param attachment
     * @return Integer
     */
	public Integer modifyAttachment(Attachment attachment);

}