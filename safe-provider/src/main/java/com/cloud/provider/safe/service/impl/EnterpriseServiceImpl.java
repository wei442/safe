package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.EnterpriseMapper;
import com.cloud.provider.safe.dao.OrgMapper;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.EnterpriseExample;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.rest.request.page.enterprise.EnterprisePageRequest;
import com.cloud.provider.safe.service.IEnterpriseService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 企业 EnterpriseService
 * @author wei.yong
 */
@Service
public class EnterpriseServiceImpl implements IEnterpriseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //企业 Mapper
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    //组织机构 Mapper
    @Autowired
    private OrgMapper orgMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Enterprise>
	 */
	@Override
	public List<Enterprise> selectListByPage(Page<?> page, EnterprisePageRequest param) {
		logger.info("(EnterpriseService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		EnterpriseExample example = new EnterpriseExample();
		example.setOrderByClause(" id desc ");
		EnterpriseExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ENTERPRISE_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null && param.getEnterpriseId() != -2) {
				criteria.andIdEqualTo(param.getEnterpriseId());
			}
			if(StringUtils.isNotBlank(param.getEnterpriseName())) {
				criteria.andEnterpriseNameLike(param.getEnterpriseName()+"%");
			}
		}
		List<Enterprise> list = enterpriseMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param enterprise
	 * @return List<Enterprise>
	 */
	@Override
	public List<Enterprise> selectList(EnterprisePageRequest param) {
		logger.info("(EnterpriseService-selectList)-不分页查询-传入参数, param:{}", param);
		EnterpriseExample example = new EnterpriseExample();
		example.setOrderByClause(" id desc ");
		EnterpriseExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ENTERPRISE_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null && param.getEnterpriseId() != -2) {
				criteria.andIdEqualTo(param.getEnterpriseId());
			}
			if(StringUtils.isNotBlank(param.getEnterpriseName())) {
				criteria.andEnterpriseNameLike(param.getEnterpriseName()+"%");
			}
		}
		List<Enterprise> list = enterpriseMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询企业
     * @param id
     * @return Enterprise
     */
	@Override
	public Enterprise selectById(Integer id) {
    	logger.info("(EnterpriseService-selectById)-根据id查询企业-传入参数, id:{}", id);
		Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
		return enterprise;
    }

    /**
     * 插入企业
     * @param enterprise
     * @return Integer
     */
	@Override
	public Integer insert(Enterprise enterprise) {
    	logger.info("(EnterpriseService-insert)-插入企业-传入参数, enterprise:{}", enterprise);
    	enterprise.setEnterpriseStatus(SqlSafeConstants.SQL_ENTERPRISE_STATUS_NORMAL);
    	enterprise.setCreateTime(new Date());
    	enterprise.setUpdateTime(new Date());
    	int i = enterpriseMapper.insertSelective(enterprise);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	String enterpriseName = enterprise.getEnterpriseName();

    	Org org = new Org();
    	org.setOrgName(enterpriseName);
    	org.setOrgAlias(enterpriseName);
    	org.setIsDelete(SqlSafeConstants.SQL_ORG_IS_DELETE_NO);
    	org.setCreateTime(new Date());
    	org.setUpdateTime(new Date());
    	i = orgMapper.insertSelective(org);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除企业
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(EnterpriseService-deleteById)-根据id删除企业-传入参数, id:{}", id);
  		int i = enterpriseMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改企业
     * @param enterprise
     * @return Integer
     */
	@Override
	public Integer modify(Enterprise enterprise) {
    	logger.info("(EnterpriseService-modify)-修改企业-传入参数, enterprise:{}", enterprise);
    	enterprise.setUpdateTime(new Date());
    	int i = enterpriseMapper.updateByPrimaryKeySelective(enterprise);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}