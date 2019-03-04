package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.OrgMapper;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.po.OrgExample;
import com.cloud.provider.safe.service.IBootOrgService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 组织机构表 BootOrgService
 * @author wei.yong
 */
@Service
public class BootOrgServiceImpl implements IBootOrgService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //组织机构表 Mapper
    @Autowired
    private OrgMapper orgMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param org
	 * @return List<Org>
	 */
	@Override
	public List<Org> selectOrgListByPage(Page<?> page, Org org) {
		logger.info("(BootOrgService-selectOrgListByPage)-分页查询-传入参数, page:{}, org:{}", page, org);
		PageHelper.startPage(page);
		OrgExample example = new OrgExample();
		example.setOrderByClause(" id desc ");
		OrgExample.Criteria criteria = example.createCriteria();
		if(org != null) {
		}
		List<Org> list = null;
		try {
			list = orgMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootOrgService-selectOrgListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param org
	 * @return List<Org>
	 */
	@Override
	public List<Org> selectOrgList(Org org) {
		logger.info("(BootOrgService-selectOrgList)-不分页查询-传入参数, org:{}", org);
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		if(org != null) {
		}
		List<Org> list = null;
		try {
			list = orgMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootOrgService-selectOrgList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询组织机构表
     * @param id
     * @return Org
     */
	@Override
	public Org selectOrgById(Integer id) {
    	logger.info("(BootOrgService-selectOrgById)-根据id查询组织机构表-传入参数, id:{}", id);
    	Org org = null;
    	try {
    		org = orgMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootOrgService-selectOrgById)-根据id查询组织机构表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return org;
    }

    /**
     * 插入组织机构表
     * @param org
     * @return Integer
     */
	@Override
	public Integer insertOrg(Org org) {
    	logger.info("(BootOrgService-insertOrg)-插入组织机构表-传入参数, org:{}", org);
    	org.setCreateTime(new Date());
    	org.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = orgMapper.insertSelective(org);
    	} catch (Exception e) {
    		logger.error("(BootOrgService-insertOrg)-插入组织机构表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改组织机构表
     * @param org
     * @return Integer
     */
	@Override
	public Integer modifyOrg(Org org) {
    	logger.info("(BootOrgService-modifyOrg)-修改组织机构表-传入参数, org:{}", org);
    	org.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = orgMapper.updateByPrimaryKeySelective(org);
    	} catch (Exception e) {
    		logger.error("(BootOrgService-modifyOrg)-修改组织机构表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}