package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.OrgQualityAttachmentMapper;
import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.po.OrgQualityAttachmentExample;
import com.cloud.provider.safe.rest.request.page.enterprise.OrgQualityAttachmentPageRequest;
import com.cloud.provider.safe.service.IOrgQualityAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 机构资质附件 OrgQualityAttachmentService
 * @author wei.yong
 */
@Service
public class OrgQualityAttachmentServiceImpl implements IOrgQualityAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //机构资质附件 Mapper
    @Autowired
    private OrgQualityAttachmentMapper orgQualityAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<OrgQualityAttachment>
	 */
	@Override
	public List<OrgQualityAttachment> selectListByPage(Page<?> page, OrgQualityAttachmentPageRequest param) {
		logger.info("(OrgQualityAttachmentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		OrgQualityAttachmentExample example = new OrgQualityAttachmentExample();
		example.setOrderByClause(" id desc ");
		OrgQualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getOrgQualityId() != null) {
				criteria.andOrgQualityIdEqualTo(param.getOrgQualityId());
			}
		}
		List<OrgQualityAttachment> list = orgQualityAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<OrgQualityAttachment>
	 */
	@Override
	public List<OrgQualityAttachment> selectList(OrgQualityAttachmentPageRequest param) {
		logger.info("(OrgQualityAttachmentService-selectList)-不分页查询-传入参数, param:{}", param);
		OrgQualityAttachmentExample example = new OrgQualityAttachmentExample();
		example.setOrderByClause(" id desc ");
		OrgQualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getOrgQualityId() != null) {
				criteria.andOrgQualityIdEqualTo(param.getOrgQualityId());
			}
		}
		List<OrgQualityAttachment> list = orgQualityAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 根据orgQualityId查询机构资质附件列表
	 * @param orgQualityId
	 * @return List<OrgQualityAttachment>
	 */
//	@Override
//	public List<OrgQualityAttachment> selectListByOrgQualityId(Integer orgQualityId) {
//		logger.info("(OrgQualityAttachmentService-selectListByOrgQualityId)-根据orgQualityId查询机构资质附件列表-传入参数, orgQualityId:{}", orgQualityId);
//		OrgQualityAttachmentExample example = new OrgQualityAttachmentExample();
//		example.setOrderByClause(" id desc ");
//		OrgQualityAttachmentExample.Criteria criteria = example.createCriteria();
//		criteria.andOrgQualityIdEqualTo(orgQualityId);
//		List<OrgQualityAttachment> list = orgQualityAttachmentMapper.selectByExample(example);
//		return list;
//	}

    /**
     * 根据id查询机构资质附件
     * @param id
     * @return OrgQualityAttachment
     */
	@Override
	public OrgQualityAttachment selectById(Integer id) {
    	logger.info("(OrgQualityAttachmentService-selectById)-根据id查询机构资质附件-传入参数, id:{}", id);
		OrgQualityAttachment orgQualityAttachment = orgQualityAttachmentMapper.selectByPrimaryKey(id);
		return orgQualityAttachment;
    }

    /**
     * 插入机构资质附件
     * @param orgQualityAttachment
     * @return Integer
     */
	@Override
	public Integer insert(OrgQualityAttachment orgQualityAttachment) {
    	logger.info("(OrgQualityAttachmentService-insert)-插入机构资质附件-传入参数, orgQualityAttachment:{}", orgQualityAttachment);
    	orgQualityAttachment.setCreateTime(new Date());
    	orgQualityAttachment.setUpdateTime(new Date());
    	int i = orgQualityAttachmentMapper.insertSelective(orgQualityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除机构资质附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(OrgQualityAttachmentService-deleteById)-根据id删除机构资质附件-传入参数, id:{}", id);
		int i = orgQualityAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除机构资质附件
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除机构资质附件-传入参数, ids:{}", ids);
  		OrgQualityAttachmentExample example = new OrgQualityAttachmentExample();
  		OrgQualityAttachmentExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = orgQualityAttachmentMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改机构资质附件
     * @param orgQualityAttachment
     * @return Integer
     */
	@Override
	public Integer modify(OrgQualityAttachment orgQualityAttachment) {
    	logger.info("(OrgQualityAttachmentService-modify)-修改机构资质附件-传入参数, orgQualityAttachment:{}", orgQualityAttachment);
    	orgQualityAttachment.setUpdateTime(new Date());
		int i = orgQualityAttachmentMapper.updateByPrimaryKeySelective(orgQualityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}