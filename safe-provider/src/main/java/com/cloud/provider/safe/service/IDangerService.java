package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Danger;
import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.rest.request.page.danger.DangerPageRequest;
import com.github.pagehelper.Page;

public interface IDangerService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Danger>
	 */
	public List<Danger> selectListByPage(Page<?> page, DangerPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Danger>
	 */
	public List<Danger> selectList(DangerPageRequest param);

    /**
     * 根据id查询隐患
     * @param id
     * @return Danger
     */
	public Danger selectById(Integer id);

    /**
     * 插入隐患及附件
     * @param danger
     * @param dangerAttachmentList
     * @return Integer
     */
	public Integer insert(Danger danger, List<DangerAttachment> dangerAttachmentList);

	/**
  	 * 根据id删除隐患
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除隐患
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改隐患及附件
     * @param danger
     * @param dangerAttachmentIds
     * @param dangerAttachmentList
     * @return Integer
     */
	public Integer modify(Danger danger, List<Integer> dangerAttachmentIds, List<DangerAttachment> dangerAttachmentList);

}