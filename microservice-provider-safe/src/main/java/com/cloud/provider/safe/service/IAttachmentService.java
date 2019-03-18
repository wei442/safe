package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Attachment;
import com.cloud.provider.safe.rest.request.page.AttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Attachment>
	 */
	public List<Attachment> selectListByPage(Page<?> page, AttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Attachment>
	 */
	public List<Attachment> selectList(AttachmentPageRequest param);

    /**
     * 根据id查询附件
     * @param id
     * @return Attachment
     */
	public Attachment selectById(Integer id);

    /**
     * 插入附件
     * @param attachment
     * @return Integer
     */
	public Integer insert(Attachment attachment);

 	/**
  	 * 根据id删除附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改附件
     * @param attachment
     * @return Integer
     */
	public Integer modify(Attachment attachment);

}