package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.RiskCheckMapper;
import com.cloud.provider.safe.po.RiskCheck;
import com.cloud.provider.safe.po.RiskCheckExample;
import com.cloud.provider.safe.rest.request.page.risk.RiskCheckPageRequest;
import com.cloud.provider.safe.service.IRiskCheckService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 风险排查 RiskCheckService
 * @author wei.yong
 */
@Service
public class RiskCheckServiceImpl implements IRiskCheckService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //风险排查 Mapper
    @Autowired
    private RiskCheckMapper riskCheckMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RiskCheck>
	 */
	@Override
	public List<RiskCheck> selectListByPage(Page<?> page, RiskCheckPageRequest param) {
		logger.info("(RiskCheckService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		RiskCheckExample example = new RiskCheckExample();
		example.setOrderByClause(" id desc ");
		RiskCheckExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<RiskCheck> list = riskCheckMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RiskCheck>
	 */
	@Override
	public List<RiskCheck> selectList(RiskCheckPageRequest param) {
		logger.info("(RiskCheckService-selectList)-不分页查询-传入参数, param:{}", param);
		RiskCheckExample example = new RiskCheckExample();
		example.setOrderByClause(" id desc ");
		RiskCheckExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<RiskCheck> list = riskCheckMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询风险排查
     * @param id
     * @return RiskCheck
     */
	@Override
	public RiskCheck selectById(Integer id) {
    	logger.info("(RiskCheckService-selectById)-根据id查询风险排查-传入参数, id:{}", id);
		RiskCheck riskCheck = riskCheckMapper.selectByPrimaryKey(id);
		return riskCheck;
    }

    /**
     * 插入风险排查
     * @param riskCheck
     * @return Integer
     */
	@Override
	public Integer insert(RiskCheck riskCheck) {
    	logger.info("(RiskCheckService-insert)-插入风险排查-传入参数, riskCheck:{}", riskCheck);
    	riskCheck.setCreateTime(new Date());
    	riskCheck.setUpdateTime(new Date());
    	int i = riskCheckMapper.insertSelective(riskCheck);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除风险排查
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(RiskCheckService-deleteById)-根据id删除风险排查-传入参数, id:{}", id);
		int i = riskCheckMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除风险排查
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除风险排查-传入参数, ids:{}", ids);
  		RiskCheckExample example = new RiskCheckExample();
  		RiskCheckExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = riskCheckMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改风险排查
     * @param riskCheck
     * @return Integer
     */
	@Override
	public Integer modify(RiskCheck riskCheck) {
    	logger.info("(RiskCheckService-modify)-修改风险排查-传入参数, riskCheck:{}", riskCheck);
    	riskCheck.setUpdateTime(new Date());
		int i = riskCheckMapper.updateByPrimaryKeySelective(riskCheck);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}