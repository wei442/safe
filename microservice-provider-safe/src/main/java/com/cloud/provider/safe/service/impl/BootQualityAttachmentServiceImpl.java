package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.QualityAttachmentMapper;
import com.cloud.provider.safe.po.QualityAttachment;
import com.cloud.provider.safe.po.QualityAttachmentExample;
import com.cloud.provider.safe.service.IBootQualityAttachmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 资质附件 BootQualityAttachmentService
 * @author wei.yong
 */
@Service
public class BootQualityAttachmentServiceImpl implements IBootQualityAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //资质附件 Mapper
    @Autowired
    private QualityAttachmentMapper qualityAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param qualityAttachment
	 * @return List<QualityAttachment>
	 */
	@Override
	public List<QualityAttachment> selectQualityAttachmentListByPage(Page<?> page, QualityAttachment qualityAttachment) {
		logger.info("(BootQualityAttachmentService-selectQualityAttachmentListByPage)-分页查询-传入参数, page:{}, qualityAttachment:{}", page, qualityAttachment);
		PageHelper.startPage(page);
		QualityAttachmentExample example = new QualityAttachmentExample();
		example.setOrderByClause(" id desc ");
		QualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(qualityAttachment != null) {
		}
		List<QualityAttachment> list = null;
		try {
			list = qualityAttachmentMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootQualityAttachmentService-selectQualityAttachmentListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param qualityAttachment
	 * @return List<QualityAttachment>
	 */
	@Override
	public List<QualityAttachment> selectQualityAttachmentList(QualityAttachment qualityAttachment) {
		logger.info("(BootQualityAttachmentService-selectQualityAttachmentList)-不分页查询-传入参数, qualityAttachment:{}", qualityAttachment);
		QualityAttachmentExample example = new QualityAttachmentExample();
		QualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(qualityAttachment != null) {
		}
		List<QualityAttachment> list = null;
		try {
			list = qualityAttachmentMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootQualityAttachmentService-selectQualityAttachmentList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询资质附件
     * @param id
     * @return QualityAttachment
     */
	@Override
	public QualityAttachment selectQualityAttachmentById(Integer id) {
    	logger.info("(BootQualityAttachmentService-selectQualityAttachmentById)-根据id查询资质附件-传入参数, id:{}", id);
    	QualityAttachment qualityAttachment = null;
    	try {
    		qualityAttachment = qualityAttachmentMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootQualityAttachmentService-selectQualityAttachmentById)-根据id查询资质附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return qualityAttachment;
    }

    /**
     * 插入资质附件
     * @param qualityAttachment
     * @return Integer
     */
	@Override
	public Integer insertQualityAttachment(QualityAttachment qualityAttachment) {
    	logger.info("(BootQualityAttachmentService-insertQualityAttachment)-插入资质附件-传入参数, qualityAttachment:{}", qualityAttachment);
    	qualityAttachment.setCreateTime(new Date());
    	qualityAttachment.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = qualityAttachmentMapper.insertSelective(qualityAttachment);
    	} catch (Exception e) {
    		logger.error("(BootQualityAttachmentService-insertQualityAttachment)-插入资质附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除资质附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteQualityAttachmentById(Integer id) {
  		logger.info("(BootQualityAttachmentService-deleteQualityAttachmentById)-根据id删除资质附件-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = qualityAttachmentMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootQualityAttachmentService-deleteQualityAttachmentById)-根据id删除资质附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改资质附件
     * @param qualityAttachment
     * @return Integer
     */
	@Override
	public Integer modifyQualityAttachment(QualityAttachment qualityAttachment) {
    	logger.info("(BootQualityAttachmentService-modifyQualityAttachment)-修改资质附件-传入参数, qualityAttachment:{}", qualityAttachment);
    	qualityAttachment.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = qualityAttachmentMapper.updateByPrimaryKeySelective(qualityAttachment);
    	} catch (Exception e) {
    		logger.error("(BootQualityAttachmentService-modifyQualityAttachment)-修改资质附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}