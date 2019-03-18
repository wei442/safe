package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.QualityAttachment;
import com.cloud.provider.safe.rest.request.page.QualityAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IQualityAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<QualityAttachment>
	 */
	public List<QualityAttachment> selectListByPage(Page<?> page, QualityAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<QualityAttachment>
	 */
	public List<QualityAttachment> selectList(QualityAttachmentPageRequest param);

    /**
     * 根据id查询资质附件
     * @param id
     * @return QualityAttachment
     */
	public QualityAttachment selectById(Integer id);

    /**
     * 插入资质附件
     * @param qualityAttachment
     * @return Integer
     */
	public Integer insert(QualityAttachment qualityAttachment);

 	/**
  	 * 根据id删除资质附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改资质附件
     * @param qualityAttachment
     * @return Integer
     */
	public Integer modify(QualityAttachment qualityAttachment);

}