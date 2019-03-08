package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.AttachmentMapper;
import com.cloud.provider.safe.po.Attachment;
import com.cloud.provider.safe.po.AttachmentExample;
import com.cloud.provider.safe.rest.request.page.AttachmentPageRequest;
import com.cloud.provider.safe.service.IAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 附件 AttachmentService
 * @author wei.yong
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //附件 Mapper
    @Autowired
    private AttachmentMapper attachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Attachment>
	 */
	public List<Attachment> selectAttachmentListByPage(Page<?> page, AttachmentPageRequest param) {
		logger.info("(AttachmentService-selectAttachmentListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		AttachmentExample example = new AttachmentExample();
		example.setOrderByClause(" id desc ");
		AttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<Attachment> list = attachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Attachment>
	 */
	public List<Attachment> selectAttachmentList(AttachmentPageRequest param) {
		logger.info("(AttachmentService-selectAttachmentList)-不分页查询-传入参数, param:{}", param);
		AttachmentExample example = new AttachmentExample();
		AttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<Attachment> list = attachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询附件
     * @param id
     * @return Attachment
     */
	@Override
	public Attachment selectAttachmentById(Integer id) {
    	logger.info("(AttachmentService-selectAttachmentById)-根据id查询附件-传入参数, id:{}", id);
		Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
		return attachment;
    }

    /**
     * 插入附件
     * @param attachment
     * @return Integer
     */
	@Override
	public Integer insertAttachment(Attachment attachment) {
    	logger.info("(AttachmentService-insertAttachment)-插入附件-传入参数, attachment:{}", attachment);
    	attachment.setCreateTime(new Date());
    	attachment.setUpdateTime(new Date());
    	int i = attachmentMapper.insertSelective(attachment);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteAttachmentById(Integer id) {
  		logger.info("(AttachmentService-deleteAttachmentById)-根据id删除附件-传入参数, id:{}", id);
  		int i = attachmentMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改附件
     * @param attachment
     * @return Integer
     */
	@Override
	public Integer modifyAttachment(Attachment attachment) {
    	logger.info("(AttachmentService-modifyAttachment)-修改附件-传入参数, attachment:{}", attachment);
    	attachment.setUpdateTime(new Date());
		int i = attachmentMapper.updateByPrimaryKeySelective(attachment);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}