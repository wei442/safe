package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.DangerAttachmentMapper;
import com.cloud.provider.safe.dao.DangerMapper;
import com.cloud.provider.safe.po.Danger;
import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.po.DangerAttachmentExample;
import com.cloud.provider.safe.po.DangerExample;
import com.cloud.provider.safe.rest.request.page.danger.DangerPageRequest;
import com.cloud.provider.safe.service.IDangerService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 隐患 DangerService
 * @author wei.yong
 */
@Service
public class DangerServiceImpl implements IDangerService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //隐患 Mapper
    @Autowired
    private DangerMapper dangerMapper;

    //隐患附件 Mapper
    @Autowired
    private DangerAttachmentMapper dangerAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Danger>
	 */
	@Override
	public List<Danger> selectListByPage(Page<?> page, DangerPageRequest param) {
		logger.info("(DangerService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		DangerExample example = new DangerExample();
		example.setOrderByClause(" id desc ");
		DangerExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ORG_QUALITY_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Danger> list = dangerMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Danger>
	 */
	@Override
	public List<Danger> selectList(DangerPageRequest param) {
		logger.info("(DangerService-selectList)-不分页查询-传入参数, param:{}", param);
		DangerExample example = new DangerExample();
		example.setOrderByClause(" id desc ");
		DangerExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ORG_QUALITY_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Danger> list = dangerMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询隐患
     * @param id
     * @return Danger
     */
	@Override
	public Danger selectById(Integer id) {
    	logger.info("(DangerService-selectById)-根据id查询隐患-传入参数, id:{}", id);
		Danger danger = dangerMapper.selectByPrimaryKey(id);
		return danger;
    }

    /**
     * 插入隐患及附件
     * @param danger
     * @param dangerAttachmentList
     * @return Integer
     */
	@Override
	public Integer insert(Danger danger, List<DangerAttachment> dangerAttachmentList) {
    	logger.info("(DangerService-insert)-插入隐患及附件-传入参数, danger:{}, dangerAttachmentList:{}", danger, dangerAttachmentList);
    	danger.setCreateTime(new Date());
    	danger.setUpdateTime(new Date());
    	int i = dangerMapper.insertSelective(danger);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer dangerId = danger.getId();

    	if(dangerAttachmentList != null && !dangerAttachmentList.isEmpty()) {
    		for (DangerAttachment dangerAttachment : dangerAttachmentList) {
    			dangerAttachment.setDangerId(dangerId);
    			dangerAttachment.setCreateTime(new Date());
    			dangerAttachment.setUpdateTime(new Date());
    			i = dangerAttachmentMapper.insertSelective(dangerAttachment);
			}
    	}
    	return i;
    }

 	/**
  	 * 根据id删除隐患
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(DangerService-deleteById)-根据id删除隐患-传入参数, id:{}", id);
  		int i = dangerMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

  		DangerAttachmentExample example = new DangerAttachmentExample();
  		DangerAttachmentExample.Criteria criteria = example.createCriteria();
		criteria.andDangerIdEqualTo(id);
		i = dangerAttachmentMapper.deleteByExample(example);
  		return i;
  	}

 	/**
  	 * 根据ids删除隐患
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(DangerService-deleteByIds)-根据ids删除隐患-传入参数, ids:{}", ids);
  		DangerAttachmentExample example = new DangerAttachmentExample();
  		DangerAttachmentExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = dangerAttachmentMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改隐患及附件
     * @param danger
     * @param dangerAttachmentIds
     * @param dangerAttachmentList
     * @return Integer
     */
	@Override
	public Integer modify(Danger danger, List<Integer> dangerAttachmentIds, List<DangerAttachment> dangerAttachmentList) {
    	logger.info("(DangerService-modify)-修改隐患及附件-传入参数, danger:{}, dangerAttachmentIds:{}, dangerAttachmentList:{}", danger, dangerAttachmentIds, dangerAttachmentList);
    	danger.setUpdateTime(new Date());
		int i = dangerMapper.updateByPrimaryKeySelective(danger);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer dangerId = danger.getId();

    	DangerAttachmentExample example = new DangerAttachmentExample();
  		DangerAttachmentExample.Criteria criteria = example.createCriteria();
		criteria.andDangerIdEqualTo(dangerId);
		if(dangerAttachmentIds != null && !dangerAttachmentIds.isEmpty()) {
    		criteria.andIdNotIn(dangerAttachmentIds);
    	}
		i = dangerAttachmentMapper.deleteByExample(example);

    	if(dangerAttachmentList != null && !dangerAttachmentList.isEmpty()) {
    		for (DangerAttachment dangerAttachment : dangerAttachmentList) {
    			dangerAttachment.setDangerId(dangerId);
    			dangerAttachment.setCreateTime(new Date());
    			dangerAttachment.setUpdateTime(new Date());
    			i = dangerAttachmentMapper.insertSelective(dangerAttachment);
			}
    	}
    	return i;
    }

}