package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.rest.request.page.enterprise.OrgQualityAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IOrgQualityAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<OrgQualityAttachment>
	 */
	public List<OrgQualityAttachment> selectListByPage(Page<?> page, OrgQualityAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<OrgQualityAttachment>
	 */
	public List<OrgQualityAttachment> selectList(OrgQualityAttachmentPageRequest param);

	/**
	 * 根据orgQualityId查询机构资质附件列表
	 * @param orgQualityId
	 * @return List<OrgQualityAttachment>
	 */
	public List<OrgQualityAttachment> selectListByOrgQualityId(Integer orgQualityId);

    /**
     * 根据id查询机构资质附件
     * @param id
     * @return OrgQualityAttachment
     */
	public OrgQualityAttachment selectById(Integer id);

    /**
     * 插入机构资质附件
     * @param orgQualityAttachment
     * @return Integer
     */
	public Integer insert(OrgQualityAttachment orgQualityAttachment);

	/**
  	 * 根据id删除机构资质附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除机构资质附件
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改机构资质附件
     * @param orgQualityAttachment
     * @return Integer
     */
	public Integer modify(OrgQualityAttachment orgQualityAttachment);

}