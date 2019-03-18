package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.EnterpriseQualityMapper;
import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.po.EnterpriseQualityExample;
import com.cloud.provider.safe.rest.request.page.EnterpriseQualityPageRequest;
import com.cloud.provider.safe.service.IEnterpriseQualityService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 企业资质 EnterpriseQualityService
 * @author wei.yong
 */
@Service
public class EnterpriseQualityServiceImpl implements IEnterpriseQualityService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //企业资质 Mapper
    @Autowired
    private EnterpriseQualityMapper enterpriseQualityMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<EnterpriseQuality>
	 */
	@Override
	public List<EnterpriseQuality> selectListByPage(Page<?> page, EnterpriseQualityPageRequest param) {
		logger.info("(EnterpriseQualityService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		EnterpriseQualityExample example = new EnterpriseQualityExample();
		example.setOrderByClause(" id desc ");
		EnterpriseQualityExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ENTERPRISE_QUALITY_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<EnterpriseQuality> list = enterpriseQualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<EnterpriseQuality>
	 */
	@Override
	public List<EnterpriseQuality> selectList(EnterpriseQualityPageRequest param) {
		logger.info("(EnterpriseQualityService-selectList)-不分页查询-传入参数, param:{}", param);
		EnterpriseQualityExample example = new EnterpriseQualityExample();
		example.setOrderByClause(" id desc ");
		EnterpriseQualityExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ENTERPRISE_QUALITY_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<EnterpriseQuality> list = enterpriseQualityMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询企业资质
     * @param id
     * @return EnterpriseQuality
     */
	@Override
	public EnterpriseQuality selectById(Integer id) {
    	logger.info("(EnterpriseQualityService-selectById)-根据id查询企业资质-传入参数, id:{}", id);
		EnterpriseQuality enterpriseQuality = enterpriseQualityMapper.selectByPrimaryKey(id);
		Assert.thanOrEqualZreo(enterpriseQuality, SafeResultEnum.DATABASE_NOTEXIST);
		return enterpriseQuality;
    }

    /**
     * 插入企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	@Override
	public Integer insert(EnterpriseQuality enterpriseQuality) {
    	logger.info("(EnterpriseQualityService-insertEnterpriseQuality)-插入企业资质-传入参数, enterpriseQuality:{}", enterpriseQuality);
    	enterpriseQuality.setCreateTime(new Date());
    	enterpriseQuality.setUpdateTime(new Date());
    	int i = enterpriseQualityMapper.insertSelective(enterpriseQuality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除企业资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(EnterpriseQualityService-deleteById)-根据id删除企业资质-传入参数, id:{}", id);
  		int i = enterpriseQualityMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	@Override
	public Integer modify(EnterpriseQuality enterpriseQuality) {
    	logger.info("(EnterpriseQualityService-modifyEnterpriseQuality)-修改企业资质-传入参数, enterpriseQuality:{}", enterpriseQuality);
    	enterpriseQuality.setUpdateTime(new Date());
		int i = enterpriseQualityMapper.updateByPrimaryKeySelective(enterpriseQuality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}