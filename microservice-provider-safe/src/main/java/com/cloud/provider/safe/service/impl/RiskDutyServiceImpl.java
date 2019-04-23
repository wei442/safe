package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.RiskDutyMapper;
import com.cloud.provider.safe.po.RiskDuty;
import com.cloud.provider.safe.po.RiskDutyExample;
import com.cloud.provider.safe.rest.request.page.risk.RiskDutyPageRequest;
import com.cloud.provider.safe.service.IRiskDutyService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 风险责任 RiskDutyService
 * @author wei.yong
 */
@Service
public class RiskDutyServiceImpl implements IRiskDutyService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //风险责任 Mapper
    @Autowired
    private RiskDutyMapper riskDutyMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RiskDuty>
	 */
	@Override
	public List<RiskDuty> selectListByPage(Page<?> page, RiskDutyPageRequest param) {
		logger.info("(RiskDutyService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		RiskDutyExample example = new RiskDutyExample();
		example.setOrderByClause(" id desc ");
		RiskDutyExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<RiskDuty> list = riskDutyMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RiskDuty>
	 */
	@Override
	public List<RiskDuty> selectList(RiskDutyPageRequest param) {
		logger.info("(RiskDutyService-selectList)-不分页查询-传入参数, param:{}", param);
		RiskDutyExample example = new RiskDutyExample();
		example.setOrderByClause(" id desc ");
		RiskDutyExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<RiskDuty> list = riskDutyMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询风险责任
     * @param id
     * @return RiskDuty
     */
	@Override
	public RiskDuty selectById(Integer id) {
    	logger.info("(RiskDutyService-selectById)-根据id查询风险责任-传入参数, id:{}", id);
		RiskDuty riskDuty = riskDutyMapper.selectByPrimaryKey(id);
		return riskDuty;
    }

    /**
     * 插入风险责任
     * @param riskDuty
     * @return Integer
     */
	@Override
	public Integer insert(RiskDuty riskDuty) {
    	logger.info("(RiskDutyService-insert)-插入风险责任-传入参数, riskDuty:{}", riskDuty);
    	riskDuty.setCreateTime(new Date());
    	riskDuty.setUpdateTime(new Date());
    	int i = riskDutyMapper.insertSelective(riskDuty);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除风险责任
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(RiskDutyService-deleteById)-根据id删除风险责任-传入参数, id:{}", id);
		int i = riskDutyMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除风险责任
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除风险责任-传入参数, ids:{}", ids);
  		RiskDutyExample example = new RiskDutyExample();
  		RiskDutyExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = riskDutyMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改风险责任
     * @param riskDuty
     * @return Integer
     */
	@Override
	public Integer modify(RiskDuty riskDuty) {
    	logger.info("(RiskDutyService-modify)-修改风险责任-传入参数, riskDuty:{}", riskDuty);
    	riskDuty.setUpdateTime(new Date());
		int i = riskDutyMapper.updateByPrimaryKeySelective(riskDuty);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}