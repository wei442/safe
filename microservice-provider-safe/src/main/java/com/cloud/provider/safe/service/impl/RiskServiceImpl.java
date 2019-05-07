package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.RiskMapper;
import com.cloud.provider.safe.po.Risk;
import com.cloud.provider.safe.po.RiskExample;
import com.cloud.provider.safe.rest.request.page.risk.RiskPageRequest;
import com.cloud.provider.safe.service.IRiskService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 风险 RiskService
 * @author wei.yong
 */
@Service
public class RiskServiceImpl implements IRiskService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //风险 Mapper
    @Autowired
    private RiskMapper riskMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Risk>
	 */
	@Override
	public List<Risk> selectListByPage(Page<?> page, RiskPageRequest param) {
		logger.info("(RiskService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		RiskExample example = new RiskExample();
		example.setOrderByClause(" id desc ");
		RiskExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_DICT_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null && param.getEnterpriseId() != -2) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Risk> list = riskMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Risk>
	 */
	@Override
	public List<Risk> selectList(RiskPageRequest param) {
		logger.info("(RiskService-selectList)-不分页查询-传入参数, param:{}", param);
		RiskExample example = new RiskExample();
		example.setOrderByClause(" id desc ");
		RiskExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_DICT_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null && param.getEnterpriseId() != -2) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Risk> list = riskMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询风险
     * @param id
     * @return Risk
     */
	@Override
	public Risk selectById(Integer id) {
    	logger.info("(RiskService-selectById)-根据id查询风险-传入参数, id:{}", id);
		Risk risk = riskMapper.selectByPrimaryKey(id);
		return risk;
    }

    /**
     * 插入风险
     * @param risk
     * @return Integer
     */
	@Override
	public Integer insert(Risk risk) {
    	logger.info("(RiskService-insert)-插入风险-传入参数, risk:{}", risk);
    	risk.setCreateTime(new Date());
    	risk.setUpdateTime(new Date());
    	int i = riskMapper.insertSelective(risk);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除风险
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(RiskService-deleteById)-根据id删除风险-传入参数, id:{}", id);
		int i = riskMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除风险
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除风险-传入参数, ids:{}", ids);
  		RiskExample example = new RiskExample();
  		RiskExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = riskMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改风险
     * @param risk
     * @return Integer
     */
	@Override
	public Integer modify(Risk risk) {
    	logger.info("(RiskService-modify)-修改风险-传入参数, risk:{}", risk);
    	risk.setUpdateTime(new Date());
		int i = riskMapper.updateByPrimaryKeySelective(risk);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}