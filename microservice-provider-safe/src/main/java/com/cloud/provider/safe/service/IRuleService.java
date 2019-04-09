package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Rule;
import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.rest.request.page.activity.RulePageRequest;
import com.github.pagehelper.Page;

public interface IRuleService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Rule>
	 */
	public List<Rule> selectListByPage(Page<?> page, RulePageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Rule>
	 */
	public List<Rule> selectList(RulePageRequest param);

    /**
     * 根据id查询规范文件
     * @param id
     * @return Rule
     */
	public Rule selectById(Integer id);

    /**
     * 插入规范文件及附件
     * @param rule
     * @param ruleAttachments
     * @return Integer
     */
	public Integer insert(Rule rule, List<RuleAttachment> ruleAttachments);

 	/**
  	 * 根据id删除规范文件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改规范文件及附件
     * @param rule
     * @param ruleAttachments
     * @return Integer
     */
	public Integer modify(Rule rule, List<RuleAttachment> ruleAttachments);

}