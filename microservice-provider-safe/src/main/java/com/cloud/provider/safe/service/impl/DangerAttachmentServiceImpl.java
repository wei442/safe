package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.DangerAttachmentMapper;
import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.po.DangerAttachmentExample;
import com.cloud.provider.safe.rest.request.page.danger.DangerAttachmentPageRequest;
import com.cloud.provider.safe.service.IDangerAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 隐患附件 DangerAttachmentService
 * @author wei.yong
 */
@Service
public class DangerAttachmentServiceImpl implements IDangerAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //隐患附件 Mapper
    @Autowired
    private DangerAttachmentMapper dangerAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<DangerAttachment>
	 */
	@Override
	public List<DangerAttachment> selectListByPage(Page<?> page, DangerAttachmentPageRequest param) {
		logger.info("(DangerAttachmentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		DangerAttachmentExample example = new DangerAttachmentExample();
		example.setOrderByClause(" id asc ");
		DangerAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getDangerId() != null) {
				criteria.andDangerIdEqualTo(param.getDangerId());
			}
		}
		List<DangerAttachment> list = dangerAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DangerAttachment>
	 */
	@Override
	public List<DangerAttachment> selectList(DangerAttachmentPageRequest param) {
		logger.info("(DangerAttachmentService-selectList)-不分页查询-传入参数, param:{}", param);
		DangerAttachmentExample example = new DangerAttachmentExample();
		example.setOrderByClause(" id asc ");
		DangerAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getDangerId() != null) {
				criteria.andDangerIdEqualTo(param.getDangerId());
			}
		}
		List<DangerAttachment> list = dangerAttachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询隐患附件
     * @param id
     * @return DangerAttachment
     */
	@Override
	public DangerAttachment selectById(Integer id) {
    	logger.info("(DangerAttachmentService-selectById)-根据id查询隐患附件-传入参数, id:{}", id);
		DangerAttachment dangerAttachment = dangerAttachmentMapper.selectByPrimaryKey(id);
		return dangerAttachment;
    }

    /**
     * 插入隐患附件
     * @param dangerAttachment
     * @return Integer
     */
	@Override
	public Integer insert(DangerAttachment dangerAttachment) {
    	logger.info("(DangerAttachmentService-insert)-插入隐患附件-传入参数, dangerAttachment:{}", dangerAttachment);
    	dangerAttachment.setCreateTime(new Date());
    	dangerAttachment.setUpdateTime(new Date());
    	int i = dangerAttachmentMapper.insertSelective(dangerAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除隐患附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(DangerAttachmentService-deleteById)-根据id删除隐患附件-传入参数, id:{}", id);
		int i = dangerAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除隐患附件
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除隐患附件-传入参数, ids:{}", ids);
  		DangerAttachmentExample example = new DangerAttachmentExample();
  		DangerAttachmentExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = dangerAttachmentMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改隐患附件
     * @param dangerAttachment
     * @return Integer
     */
	@Override
	public Integer modify(DangerAttachment dangerAttachment) {
    	logger.info("(DangerAttachmentService-modify)-修改隐患附件-传入参数, dangerAttachment:{}", dangerAttachment);
    	dangerAttachment.setUpdateTime(new Date());
		int i = dangerAttachmentMapper.updateByPrimaryKeySelective(dangerAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}