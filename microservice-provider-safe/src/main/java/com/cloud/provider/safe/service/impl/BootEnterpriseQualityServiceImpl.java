package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.EnterpriseQualityMapper;
import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.po.EnterpriseQualityExample;
import com.cloud.provider.safe.service.IBootEnterpriseQualityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 企业资质 BootEnterpriseQualityService
 * @author wei.yong
 */
@Service
public class BootEnterpriseQualityServiceImpl implements IBootEnterpriseQualityService {

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
		logger.info("(BootEnterpriseQualityService-selectEnterpriseQualityListByPage)-分页查询-传入参数, page:{}, enterpriseQuality:{}", page, enterpriseQuality);
		PageHelper.startPage(page);
		EnterpriseQualityExample example = new EnterpriseQualityExample();
		example.setOrderByClause(" id desc ");
		EnterpriseQualityExample.Criteria criteria = example.createCriteria();
		if(enterpriseQuality != null) {
		}
		List<EnterpriseQuality> list = null;
		try {
			list = enterpriseQualityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootEnterpriseQualityService-selectEnterpriseQualityListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param enterpriseQuality
	 * @return List<EnterpriseQuality>
	 */
	@Override
	public List<EnterpriseQuality> selectEnterpriseQualityList(EnterpriseQuality enterpriseQuality) {
		logger.info("(BootEnterpriseQualityService-selectEnterpriseQualityList)-不分页查询-传入参数, enterpriseQuality:{}", enterpriseQuality);
		EnterpriseQualityExample example = new EnterpriseQualityExample();
		EnterpriseQualityExample.Criteria criteria = example.createCriteria();
		if(enterpriseQuality != null) {
		}
		List<EnterpriseQuality> list = null;
		try {
			list = enterpriseQualityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootEnterpriseQualityService-selectEnterpriseQualityList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询企业资质
     * @param id
     * @return EnterpriseQuality
     */
	@Override
	public EnterpriseQuality selectEnterpriseQualityById(Integer id) {
    	logger.info("(BootEnterpriseQualityService-selectEnterpriseQualityById)-根据id查询企业资质-传入参数, id:{}", id);
    	EnterpriseQuality enterpriseQuality = null;
    	try {
    		enterpriseQuality = enterpriseQualityMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootEnterpriseQualityService-selectEnterpriseQualityById)-根据id查询企业资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return enterpriseQuality;
    }

    /**
     * 插入企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	@Override
	public Integer insertEnterpriseQuality(EnterpriseQuality enterpriseQuality) {
    	logger.info("(BootEnterpriseQualityService-insertEnterpriseQuality)-插入企业资质-传入参数, enterpriseQuality:{}", enterpriseQuality);
    	enterpriseQuality.setCreateTime(new Date());
    	enterpriseQuality.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = enterpriseQualityMapper.insertSelective(enterpriseQuality);
    	} catch (Exception e) {
    		logger.error("(BootEnterpriseQualityService-insertEnterpriseQuality)-插入企业资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除企业资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteEnterpriseQualityById(Integer id) {
  		logger.info("(BootEnterpriseQualityService-deleteEnterpriseQualityById)-根据id删除企业资质-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = enterpriseQualityMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootEnterpriseQualityService-deleteEnterpriseQualityById)-根据id删除企业资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	@Override
	public Integer modifyEnterpriseQuality(EnterpriseQuality enterpriseQuality) {
    	logger.info("(BootEnterpriseQualityService-modifyEnterpriseQuality)-修改企业资质-传入参数, enterpriseQuality:{}", enterpriseQuality);
    	enterpriseQuality.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = enterpriseQualityMapper.updateByPrimaryKeySelective(enterpriseQuality);
    	} catch (Exception e) {
    		logger.error("(BootEnterpriseQualityService-modifyEnterpriseQuality)-修改企业资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}