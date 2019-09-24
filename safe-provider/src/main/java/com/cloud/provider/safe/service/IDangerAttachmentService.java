package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.rest.request.page.danger.DangerAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IDangerAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<DangerAttachment>
	 */
	public List<DangerAttachment> selectListByPage(Page<?> page, DangerAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DangerAttachment>
	 */
	public List<DangerAttachment> selectList(DangerAttachmentPageRequest param);

    /**
     * 根据id查询隐患附件
     * @param id
     * @return DangerAttachment
     */
	public DangerAttachment selectById(Integer id);

    /**
     * 插入隐患附件
     * @param dangerAttachment
     * @return Integer
     */
	public Integer insert(DangerAttachment dangerAttachment);

	/**
  	 * 根据id删除隐患附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除隐患附件
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改隐患附件
     * @param dangerAttachment
     * @return Integer
     */
	public Integer modify(DangerAttachment dangerAttachment);

}