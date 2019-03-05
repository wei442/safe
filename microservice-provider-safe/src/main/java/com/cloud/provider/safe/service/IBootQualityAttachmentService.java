package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.QualityAttachment;
import com.github.pagehelper.Page;

public interface IBootQualityAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param qualityAttachment
	 * @return List<QualityAttachment>
	 */
	public List<QualityAttachment> selectQualityAttachmentListByPage(Page<?> page, QualityAttachment qualityAttachment);

	/**
	 * 不分页查询
	 * @param qualityAttachment
	 * @return List<QualityAttachment>
	 */
	public List<QualityAttachment> selectQualityAttachmentList(QualityAttachment qualityAttachment);

    /**
     * 根据id查询资质附件
     * @param id
     * @return QualityAttachment
     */
	public QualityAttachment selectQualityAttachmentById(Integer id);

    /**
     * 插入资质附件
     * @param qualityAttachment
     * @return Integer
     */
	public Integer insertQualityAttachment(QualityAttachment qualityAttachment);

 	/**
  	 * 根据id删除资质附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteQualityAttachmentById(Integer id);

    /**
     * 修改资质附件
     * @param qualityAttachment
     * @return Integer
     */
	public Integer modifyQualityAttachment(QualityAttachment qualityAttachment);

}