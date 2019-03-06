package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.EnterpriseQualityMapper;
import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.po.EnterpriseQualityExample;
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
	 * @param enterpriseQuality
	 * @return List<EnterpriseQuality>
	 */
	@Override
	public List<EnterpriseQuality> selectEnterpriseQualityListByPage(Page<?> page, EnterpriseQuality enterpriseQuality) {
		logger.info("(EnterpriseQualityService-selectEnterpriseQualityListByPage)-分页查询-传入参数, page:{}, enterpriseQuality:{}", page, enterpriseQuality);
		PageHelper.startPage(page);
		EnterpriseQualityExample example = new EnterpriseQualityExample();
		example.setOrderByClause(" id desc ");
		EnterpriseQualityExample.Criteria criteria = example.createCriteria();
		if(enterpriseQuality != null) {
		}
		List<EnterpriseQuality> list = enterpriseQualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param enterpriseQuality
	 * @return List<EnterpriseQuality>
	 */
	@Override
	public List<EnterpriseQuality> selectEnterpriseQualityList(EnterpriseQuality enterpriseQuality) {
		logger.info("(EnterpriseQualityService-selectEnterpriseQualityList)-不分页查询-传入参数, enterpriseQuality:{}", enterpriseQuality);
		EnterpriseQualityExample example = new EnterpriseQualityExample();
		EnterpriseQualityExample.Criteria criteria = example.createCriteria();
		if(enterpriseQuality != null) {
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
	public EnterpriseQuality selectEnterpriseQualityById(Integer id) {
    	logger.info("(EnterpriseQualityService-selectEnterpriseQualityById)-根据id查询企业资质-传入参数, id:{}", id);
		EnterpriseQuality enterpriseQuality = enterpriseQualityMapper.selectByPrimaryKey(id);
		return enterpriseQuality;
    }

    /**
     * 插入企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	@Override
	public Integer insertEnterpriseQuality(EnterpriseQuality enterpriseQuality) {
    	logger.info("(EnterpriseQualityService-insertEnterpriseQuality)-插入企业资质-传入参数, enterpriseQuality:{}", enterpriseQuality);
    	enterpriseQuality.setCreateTime(new Date());
    	enterpriseQuality.setUpdateTime(new Date());
    	int i = enterpriseQualityMapper.insertSelective(enterpriseQuality);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除企业资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteEnterpriseQualityById(Integer id) {
  		logger.info("(EnterpriseQualityService-deleteEnterpriseQualityById)-根据id删除企业资质-传入参数, id:{}", id);
  		int i = enterpriseQualityMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	@Override
	public Integer modifyEnterpriseQuality(EnterpriseQuality enterpriseQuality) {
    	logger.info("(EnterpriseQualityService-modifyEnterpriseQuality)-修改企业资质-传入参数, enterpriseQuality:{}", enterpriseQuality);
    	enterpriseQuality.setUpdateTime(new Date());
		int i = enterpriseQualityMapper.updateByPrimaryKeySelective(enterpriseQuality);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}