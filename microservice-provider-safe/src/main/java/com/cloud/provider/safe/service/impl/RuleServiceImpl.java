package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.RuleMapper;
import com.cloud.provider.safe.po.Rule;
import com.cloud.provider.safe.po.RuleExample;
import com.cloud.provider.safe.rest.request.page.RulePageRequest;
import com.cloud.provider.safe.service.IRuleService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 规范文件 RuleService
 * @author wei.yong
 */
@Service
public class RuleServiceImpl implements IRuleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //规范文件 Mapper
    @Autowired
    private RuleMapper ruleMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Rule>
	 */
	@Override
	public List<Rule> selectListByPage(Page<?> page, RulePageRequest param) {
		logger.info("(RuleService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		RuleExample example = new RuleExample();
		example.setOrderByClause(" id desc ");
		RuleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_RULE_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Rule> list = ruleMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Rule>
	 */
	@Override
	public List<Rule> selectList(RulePageRequest param) {
		logger.info("(RuleService-selectList)-不分页查询-传入参数, param:{}", param);
		RuleExample example = new RuleExample();
		example.setOrderByClause(" id desc ");
		RuleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_RULE_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Rule> list = ruleMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询规范文件
     * @param id
     * @return Rule
     */
	@Override
	public Rule selectById(Integer id) {
    	logger.info("(RuleService-selectById)-根据id查询规范文件-传入参数, id:{}", id);
    	Rule rule = ruleMapper.selectByPrimaryKey(id);
		return rule;
    }

    /**
     * 插入规范文件
     * @param Rule
     * @return Integer
     */
	@Override
	public Integer insert(Rule rule) {
    	logger.info("(RuleService-insertRule)-插入规范文件-传入参数, rule:{}", rule);
    	rule.setIsDelete(SqlSafeConstants.SQL_POST_IS_DELETE_NO);
    	rule.setCreateTime(new Date());
    	rule.setUpdateTime(new Date());
    	int i = ruleMapper.insertSelective(rule);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除规范文件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(RuleService-deleteById)-根据id删除规范文件-传入参数, id:{}", id);
  		int i = ruleMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改规范文件
     * @param Rule
     * @return Integer
     */
	@Override
	public Integer modify(Rule rule) {
    	logger.info("(RuleService-modifyRule)-修改规范文件-传入参数, rule:{}", rule);
    	rule.setUpdateTime(new Date());
    	int i = ruleMapper.updateByPrimaryKeySelective(rule);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}