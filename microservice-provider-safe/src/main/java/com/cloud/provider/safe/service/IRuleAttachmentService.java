package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.rest.request.page.RuleAttachmentPageRequest;
import com.github.pagehelper.Page;

public interface IRuleAttachmentService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RuleAttachment>
	 */
	public List<RuleAttachment> selectListByPage(Page<?> page, RuleAttachmentPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RuleAttachment>
	 */
	public List<RuleAttachment> selectList(RuleAttachmentPageRequest param);

    /**
     * 根据id查询规范文件附件
     * @param id
     * @return RuleAttachment
     */
	public RuleAttachment selectById(Integer id);

    /**
     * 插入规范文件附件
     * @param RuleAttachment
     * @return Integer
     */
	public Integer insert(RuleAttachment ruleAttachment);

 	/**
  	 * 根据id删除规范文件附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改规范文件附件
     * @param RuleAttachment
     * @return Integer
     */
	public Integer modify(RuleAttachment ruleAttachment);

}