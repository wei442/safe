package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.PostAttachmentMapper;
import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.po.PostAttachmentExample;
import com.cloud.provider.safe.service.IBootPostAttachmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户附件 BootPostAttachmentService
 * @author wei.yong
 */
@Service
public class BootPostAttachmentServiceImpl implements IBootPostAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户附件 Mapper
    @Autowired
    private PostAttachmentMapper postAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param postAttachment
	 * @return List<PostAttachment>
	 */
	@Override
	public List<PostAttachment> selectPostAttachmentListByPage(Page<?> page, PostAttachment postAttachment) {
		logger.info("(BootPostAttachmentService-selectPostAttachmentListByPage)-分页查询-传入参数, page:{}, postAttachment:{}", page, postAttachment);
		PageHelper.startPage(page);
		PostAttachmentExample example = new PostAttachmentExample();
		example.setOrderByClause(" id desc ");
		PostAttachmentExample.Criteria criteria = example.createCriteria();
		if(postAttachment != null) {
		}
		List<PostAttachment> list = null;
		try {
			list = postAttachmentMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootPostAttachmentService-selectPostAttachmentListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param postAttachment
	 * @return List<PostAttachment>
	 */
	@Override
	public List<PostAttachment> selectPostAttachmentList(PostAttachment postAttachment) {
		logger.info("(BootPostAttachmentService-selectPostAttachmentList)-不分页查询-传入参数, postAttachment:{}", postAttachment);
		PostAttachmentExample example = new PostAttachmentExample();
		PostAttachmentExample.Criteria criteria = example.createCriteria();
		if(postAttachment != null) {
		}
		List<PostAttachment> list = null;
		try {
			list = postAttachmentMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootPostAttachmentService-selectPostAttachmentList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户附件
     * @param id
     * @return PostAttachment
     */
	@Override
	public PostAttachment selectPostAttachmentById(Integer id) {
    	logger.info("(BootPostAttachmentService-selectPostAttachmentById)-根据id查询用户附件-传入参数, id:{}", id);
    	PostAttachment postAttachment = null;
    	try {
    		postAttachment = postAttachmentMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootPostAttachmentService-selectPostAttachmentById)-根据id查询用户附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return postAttachment;
    }

    /**
     * 插入用户附件
     * @param postAttachment
     * @return Integer
     */
	@Override
	public Integer insertPostAttachment(PostAttachment postAttachment) {
    	logger.info("(BootPostAttachmentService-insertPostAttachment)-插入用户附件-传入参数, postAttachment:{}", postAttachment);
    	postAttachment.setCreateTime(new Date());
    	postAttachment.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = postAttachmentMapper.insertSelective(postAttachment);
    	} catch (Exception e) {
    		logger.error("(BootPostAttachmentService-insertPostAttachment)-插入用户附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改用户附件
     * @param postAttachment
     * @return Integer
     */
	@Override
	public Integer modifyPostAttachment(PostAttachment postAttachment) {
    	logger.info("(BootPostAttachmentService-modifyPostAttachment)-修改用户附件-传入参数, postAttachment:{}", postAttachment);
    	postAttachment.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = postAttachmentMapper.updateByPrimaryKeySelective(postAttachment);
    	} catch (Exception e) {
    		logger.error("(BootPostAttachmentService-modifyPostAttachment)-修改用户附件-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}