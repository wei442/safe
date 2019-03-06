package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.OrgMapper;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.po.OrgExample;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 组织机构 OrgService
 * @author wei.yong
 */
@Service
public class OrgServiceImpl implements IOrgService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //组织机构 Mapper
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
		logger.info("(OrgService-selectOrgListByPage)-分页查询-传入参数, page:{}, org:{}", page, org);
		PageHelper.startPage(page);
		OrgExample example = new OrgExample();
		example.setOrderByClause(" id desc ");
		OrgExample.Criteria criteria = example.createCriteria();
		if(org != null) {
		}
		List<Org> list = orgMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param org
	 * @return List<Org>
	 */
	@Override
	public List<Org> selectOrgList(Org org) {
		logger.info("(OrgService-selectOrgList)-不分页查询-传入参数, org:{}", org);
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		if(org != null) {
		}
		List<Org> list = orgMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询组织机构
     * @param id
     * @return Org
     */
	@Override
	public Org selectOrgById(Integer id) {
    	logger.info("(OrgService-selectOrgById)-根据id查询组织机构-传入参数, id:{}", id);
		Org org = orgMapper.selectByPrimaryKey(id);
		return org;
    }

    /**
     * 插入组织机构
     * @param org
     * @return Integer
     */
	@Override
	public Integer insertOrg(Org org) {
    	logger.info("(OrgService-insertOrg)-插入组织机构-传入参数, org:{}", org);
    	org.setCreateTime(new Date());
    	org.setUpdateTime(new Date());
    	int i = orgMapper.insertSelective(org);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除组织机构
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteOrgById(Integer id) {
  		logger.info("(OrgService-deleteOrgById)-根据id删除组织机构-传入参数, id:{}", id);
  		int i = orgMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改组织机构
     * @param org
     * @return Integer
     */
	@Override
	public Integer modifyOrg(Org org) {
    	logger.info("(OrgService-modifyOrg)-修改组织机构-传入参数, org:{}", org);
    	org.setUpdateTime(new Date());
    	int i = orgMapper.updateByPrimaryKeySelective(org);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}