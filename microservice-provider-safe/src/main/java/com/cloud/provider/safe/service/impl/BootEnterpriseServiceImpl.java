package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.EnterpriseMapper;
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.EnterpriseExample;
import com.cloud.provider.safe.service.IBootEnterpriseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 企业 BootEnterpriseService
 * @author wei.yong
 */
@Service
public class BootEnterpriseServiceImpl implements IBootEnterpriseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //企业 Mapper
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param enterprise
	 * @return List<Enterprise>
	 */
	@Override
	public List<Enterprise> selectEnterpriseListByPage(Page<?> page, Enterprise enterprise) {
		logger.info("(BootEnterpriseService-selectEnterpriseListByPage)-分页查询-传入参数, page:{}, enterprise:{}", page, enterprise);
		PageHelper.startPage(page);
		EnterpriseExample example = new EnterpriseExample();
		example.setOrderByClause(" id desc ");
		EnterpriseExample.Criteria criteria = example.createCriteria();
		if(enterprise != null) {
		}
		List<Enterprise> list = null;
		try {
			list = enterpriseMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootEnterpriseService-selectEnterpriseListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param enterprise
	 * @return List<Enterprise>
	 */
	@Override
	public List<Enterprise> selectEnterpriseList(Enterprise enterprise) {
		logger.info("(BootEnterpriseService-selectEnterpriseList)-不分页查询-传入参数, enterprise:{}", enterprise);
		EnterpriseExample example = new EnterpriseExample();
		EnterpriseExample.Criteria criteria = example.createCriteria();
		if(enterprise != null) {
		}
		List<Enterprise> list = null;
		try {
			list = enterpriseMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootEnterpriseService-selectEnterpriseList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询企业
     * @param id
     * @return Enterprise
     */
	@Override
	public Enterprise selectEnterpriseById(Integer id) {
    	logger.info("(BootEnterpriseService-selectEnterpriseById)-根据id查询企业-传入参数, id:{}", id);
    	Enterprise enterprise = null;
    	try {
    		enterprise = enterpriseMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootEnterpriseService-selectEnterpriseById)-根据id查询企业-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return enterprise;
    }

    /**
     * 插入企业
     * @param enterprise
     * @return Integer
     */
	@Override
	public Integer insertEnterprise(Enterprise enterprise) {
    	logger.info("(BootEnterpriseService-insertEnterprise)-插入企业-传入参数, enterprise:{}", enterprise);
    	enterprise.setCreateTime(new Date());
    	enterprise.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = enterpriseMapper.insertSelective(enterprise);
    	} catch (Exception e) {
    		logger.error("(BootEnterpriseService-insertEnterprise)-插入企业-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserTitleById(Integer id) {
  		logger.info("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userTitleMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改企业
     * @param enterprise
     * @return Integer
     */
	@Override
	public Integer modifyEnterprise(Enterprise enterprise) {
    	logger.info("(BootEnterpriseService-modifyEnterprise)-修改企业-传入参数, enterprise:{}", enterprise);
    	enterprise.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = enterpriseMapper.updateByPrimaryKeySelective(enterprise);
    	} catch (Exception e) {
    		logger.error("(BootEnterpriseService-modifyEnterprise)-修改企业-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}