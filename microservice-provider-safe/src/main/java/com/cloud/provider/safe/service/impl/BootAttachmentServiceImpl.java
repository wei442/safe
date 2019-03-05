package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.AttachmentMapper;
import com.cloud.provider.safe.po.Attachment;
import com.cloud.provider.safe.po.AttachmentExample;
import com.cloud.provider.safe.service.IBootAttachmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 附件 BootAttachmentService
 * @author wei.yong
 */
@Service
public class BootAttachmentServiceImpl implements IBootAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //附件 Mapper
    @Autowired
    private AttachmentMapper attachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param attachment
	 * @return List<Attachment>
	 */
	@Override
	public List<Attachment> selectAttachmentListByPage(Page<?> page, Attachment attachment) {
		logger.info("(BootAttachmentService-selectAttachmentListByPage)-分页查询-传入参数, page:{}, attachment:{}", page, attachment);
		PageHelper.startPage(page);
		AttachmentExample example = new AttachmentExample();
		example.setOrderByClause(" id desc ");
		AttachmentExample.Criteria criteria = example.createCriteria();
		if(attachment != null) {
		}
		List<Attachment> list = null;
		try {
			list = attachmentMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootAttachmentService-selectAttachmentListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param attachment
	 * @return List<Attachment>
	 */
	@Override
	public List<Attachment> selectAttachmentList(Attachment attachment) {
		logger.info("(BootAttachmentService-selectAttachmentList)-不分页查询-传入参数, attachment:{}", attachment);
		AttachmentExample example = new AttachmentExample();
		AttachmentExample.Criteria criteria = example.createCriteria();
		if(attachment != null) {
		}
		List<Attachment> list = null;
		try {
			list = attachmentMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootAttachmentService-selectAttachmentList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询附件
     * @param id
     * @return Attachment
     */
	@Override
	public Attachment selectAttachmentById(Integer id) {
    	logger.info("(BootAttachmentService-selectAttachmentById)-根据id查询附件-传入参数, id:{}", id);
    	Attachment attachment = null;
    	try {
    		attachment = attachmentMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootAttachmentService-selectAttachmentById)-根据id查询附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return attachment;
    }

    /**
     * 插入附件
     * @param attachment
     * @return Integer
     */
	@Override
	public Integer insertAttachment(Attachment attachment) {
    	logger.info("(BootAttachmentService-insertAttachment)-插入附件-传入参数, attachment:{}", attachment);
    	attachment.setCreateTime(new Date());
    	attachment.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = attachmentMapper.insertSelective(attachment);
    	} catch (Exception e) {
    		logger.error("(BootAttachmentService-insertAttachment)-插入附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除附件
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteAttachmentById(Integer id) {
  		logger.info("(BootAttachmentService-deleteAttachmentById)-根据id删除附件-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = attachmentMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootAttachmentService-deleteAttachmentById)-根据id删除附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改附件
     * @param attachment
     * @return Integer
     */
	@Override
	public Integer modifyAttachment(Attachment attachment) {
    	logger.info("(BootAttachmentService-modifyAttachment)-修改附件-传入参数, attachment:{}", attachment);
    	attachment.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = attachmentMapper.updateByPrimaryKeySelective(attachment);
    	} catch (Exception e) {
    		logger.error("(BootAttachmentService-modifyAttachment)-修改附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}