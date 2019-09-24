package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.RiskAcceptMapper;
import com.cloud.provider.safe.po.RiskAccept;
import com.cloud.provider.safe.po.RiskAcceptExample;
import com.cloud.provider.safe.rest.request.page.risk.RiskAcceptPageRequest;
import com.cloud.provider.safe.service.IRiskAcceptService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 风险验收 RiskAcceptService
 * @author wei.yong
 */
@Service
public class RiskAcceptServiceImpl implements IRiskAcceptService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //风险验收 Mapper
    @Autowired
    private RiskAcceptMapper riskAcceptMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RiskAccept>
	 */
	@Override
	public List<RiskAccept> selectListByPage(Page<?> page, RiskAcceptPageRequest param) {
		logger.info("(RiskAcceptService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		RiskAcceptExample example = new RiskAcceptExample();
		example.setOrderByClause(" id desc ");
		RiskAcceptExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<RiskAccept> list = riskAcceptMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RiskAccept>
	 */
	@Override
	public List<RiskAccept> selectList(RiskAcceptPageRequest param) {
		logger.info("(RiskAcceptService-selectList)-不分页查询-传入参数, param:{}", param);
		RiskAcceptExample example = new RiskAcceptExample();
		example.setOrderByClause(" id desc ");
		RiskAcceptExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<RiskAccept> list = riskAcceptMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询风险验收
     * @param id
     * @return RiskAccept
     */
	@Override
	public RiskAccept selectById(Integer id) {
    	logger.info("(RiskAcceptService-selectById)-根据id查询风险验收-传入参数, id:{}", id);
		RiskAccept riskAccept = riskAcceptMapper.selectByPrimaryKey(id);
		return riskAccept;
    }

    /**
     * 插入风险验收
     * @param riskAccept
     * @return Integer
     */
	@Override
	public Integer insert(RiskAccept riskAccept) {
    	logger.info("(RiskAcceptService-insert)-插入风险验收-传入参数, riskAccept:{}", riskAccept);
    	riskAccept.setCreateTime(new Date());
    	riskAccept.setUpdateTime(new Date());
    	int i = riskAcceptMapper.insertSelective(riskAccept);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除风险验收
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(RiskAcceptService-deleteById)-根据id删除风险验收-传入参数, id:{}", id);
		int i = riskAcceptMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除风险验收
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除风险验收-传入参数, ids:{}", ids);
  		RiskAcceptExample example = new RiskAcceptExample();
  		RiskAcceptExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = riskAcceptMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改风险验收
     * @param riskAccept
     * @return Integer
     */
	@Override
	public Integer modify(RiskAccept riskAccept) {
    	logger.info("(RiskAcceptService-modify)-修改风险验收-传入参数, riskAccept:{}", riskAccept);
    	riskAccept.setUpdateTime(new Date());
		int i = riskAcceptMapper.updateByPrimaryKeySelective(riskAccept);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}