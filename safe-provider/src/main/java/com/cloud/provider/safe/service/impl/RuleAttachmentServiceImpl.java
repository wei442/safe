package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.RuleAttachmentMapper;
import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.po.RuleAttachmentExample;
import com.cloud.provider.safe.rest.request.page.activity.RuleAttachmentPageRequest;
import com.cloud.provider.safe.service.IRuleAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 规范文件附件 RuleAttachmentService
 * @author wei.yong
 */
@Service
public class RuleAttachmentServiceImpl implements IRuleAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //规范文件附件 Mapper
    @Autowired
    private RuleAttachmentMapper ruleAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RuleAttachment>
	 */
	@Override
	public List<RuleAttachment> selectListByPage(Page<?> page, RuleAttachmentPageRequest param) {
		logger.info("(RuleAttachmentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		RuleAttachmentExample example = new RuleAttachmentExample();
		example.setOrderByClause(" id asc ");
		RuleAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getRuleId() != null) {
				criteria.andRuleIdEqualTo(param.getRuleId());
			}
		}
		List<RuleAttachment> list = ruleAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RuleAttachment>
	 */
	@Override
	public List<RuleAttachment> selectList(RuleAttachmentPageRequest param) {
		logger.info("(RuleAttachmentService-selectList)-不分页查询-传入参数, param:{}", param);
		RuleAttachmentExample example = new RuleAttachmentExample();
		example.setOrderByClause(" id asc ");
		RuleAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getRuleId() != null) {
				criteria.andRuleIdEqualTo(param.getRuleId());
			}
		}
		List<RuleAttachment> list = ruleAttachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询规范文件附件
     * @param id
     * @return RuleAttachment
     */
	@Override
	public RuleAttachment selectById(Integer id) {
    	logger.info("(RuleAttachmentService-selectById)-根据id查询规范文件附件-传入参数, id:{}", id);
    	RuleAttachment ruleAttachment = ruleAttachmentMapper.selectByPrimaryKey(id);
		return ruleAttachment;
    }

    /**
     * 插入规范文件附件
     * @param RuleAttachment
     * @return Integer
     */
	@Override
	public Integer insert(RuleAttachment ruleAttachment) {
    	logger.info("(RuleAttachmentService-insert)-插入规范文件附件-传入参数, ruleAttachment:{}", ruleAttachment);
    	ruleAttachment.setCreateTime(new Date());
    	ruleAttachment.setUpdateTime(new Date());
    	int i = ruleAttachmentMapper.insertSelective(ruleAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除规范文件附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(RuleAttachmentService-deleteById)-根据id删除规范文件附件-传入参数, id:{}", id);
  		int i = ruleAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改规范文件附件
     * @param RuleAttachment
     * @return Integer
     */
	@Override
	public Integer modify(RuleAttachment ruleAttachment) {
    	logger.info("(RuleAttachmentService-modify)-修改规范文件附件-传入参数, ruleAttachment:{}", ruleAttachment);
    	ruleAttachment.setUpdateTime(new Date());
    	int i = ruleAttachmentMapper.updateByPrimaryKeySelective(ruleAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}