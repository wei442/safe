package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.QualityAttachmentMapper;
import com.cloud.provider.safe.po.QualityAttachment;
import com.cloud.provider.safe.po.QualityAttachmentExample;
import com.cloud.provider.safe.rest.request.page.QualityAttachmentPageRequest;
import com.cloud.provider.safe.service.IQualityAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 资质附件 QualityAttachmentService
 * @author wei.yong
 */
@Service
public class QualityAttachmentServiceImpl implements IQualityAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //资质附件 Mapper
    @Autowired
    private QualityAttachmentMapper qualityAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<QualityAttachment>
	 */
	public List<QualityAttachment> selectQualityAttachmentListByPage(Page<?> page, QualityAttachmentPageRequest param) {
		logger.info("(QualityAttachmentService-selectQualityAttachmentListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		QualityAttachmentExample example = new QualityAttachmentExample();
		example.setOrderByClause(" id desc ");
		QualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<QualityAttachment> list = qualityAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<QualityAttachment>
	 */
	public List<QualityAttachment> selectQualityAttachmentList(QualityAttachmentPageRequest param) {
		logger.info("(QualityAttachmentService-selectQualityAttachmentList)-不分页查询-传入参数, param:{}", param);
		QualityAttachmentExample example = new QualityAttachmentExample();
		QualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<QualityAttachment> list = qualityAttachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询资质附件
     * @param id
     * @return QualityAttachment
     */
	@Override
	public QualityAttachment selectQualityAttachmentById(Integer id) {
    	logger.info("(QualityAttachmentService-selectQualityAttachmentById)-根据id查询资质附件-传入参数, id:{}", id);
		QualityAttachment qualityAttachment = qualityAttachmentMapper.selectByPrimaryKey(id);
		return qualityAttachment;
    }

    /**
     * 插入资质附件
     * @param qualityAttachment
     * @return Integer
     */
	@Override
	public Integer insertQualityAttachment(QualityAttachment qualityAttachment) {
    	logger.info("(QualityAttachmentService-insertQualityAttachment)-插入资质附件-传入参数, qualityAttachment:{}", qualityAttachment);
    	qualityAttachment.setCreateTime(new Date());
    	qualityAttachment.setUpdateTime(new Date());
    	int i = qualityAttachmentMapper.insertSelective(qualityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除资质附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteQualityAttachmentById(Integer id) {
  		logger.info("(QualityAttachmentService-deleteQualityAttachmentById)-根据id删除资质附件-传入参数, id:{}", id);
  		int i = qualityAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改资质附件
     * @param qualityAttachment
     * @return Integer
     */
	@Override
	public Integer modifyQualityAttachment(QualityAttachment qualityAttachment) {
    	logger.info("(QualityAttachmentService-modifyQualityAttachment)-修改资质附件-传入参数, qualityAttachment:{}", qualityAttachment);
    	qualityAttachment.setUpdateTime(new Date());
    	int i = qualityAttachmentMapper.updateByPrimaryKeySelective(qualityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}