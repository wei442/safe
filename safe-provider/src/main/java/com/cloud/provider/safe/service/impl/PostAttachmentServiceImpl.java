package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.PostAttachmentMapper;
import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.po.PostAttachmentExample;
import com.cloud.provider.safe.rest.request.page.post.PostAttachmentPageRequest;
import com.cloud.provider.safe.service.IPostAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 岗位附件 PostAttachmentService
 * @author wei.yong
 */
@Service
public class PostAttachmentServiceImpl implements IPostAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //岗位附件 Mapper
    @Autowired
    private PostAttachmentMapper postAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<PostAttachment>
	 */
	@Override
	public List<PostAttachment> selectListByPage(Page<?> page, PostAttachmentPageRequest param) {
		logger.info("(PostAttachmentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PostAttachmentExample example = new PostAttachmentExample();
		example.setOrderByClause(" id desc ");
		PostAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<PostAttachment> list = postAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<PostAttachment>
	 */
	@Override
	public List<PostAttachment> selectList(PostAttachmentPageRequest param) {
		logger.info("(PostAttachmentService-selectList)-不分页查询-传入参数, param:{}", param);
		PostAttachmentExample example = new PostAttachmentExample();
		example.setOrderByClause(" id desc ");
		PostAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<PostAttachment> list = postAttachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询岗位附件
     * @param id
     * @return PostAttachment
     */
	@Override
	public PostAttachment selectById(Integer id) {
    	logger.info("(PostAttachmentService-selectById)-根据id查询岗位附件-传入参数, id:{}", id);
		PostAttachment postAttachment = postAttachmentMapper.selectByPrimaryKey(id);
		return postAttachment;
    }

    /**
     * 插入岗位附件
     * @param postAttachment
     * @return Integer
     */
	@Override
	public Integer insert(PostAttachment postAttachment) {
    	logger.info("(PostAttachmentService-insert)-插入岗位附件-传入参数, postAttachment:{}", postAttachment);
    	postAttachment.setCreateTime(new Date());
    	postAttachment.setUpdateTime(new Date());
    	int i = postAttachmentMapper.insertSelective(postAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除岗位附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(PostAttachmentService-deleteById)-根据id删除岗位附件-传入参数, id:{}", id);
  		int i = postAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改岗位附件
     * @param postAttachment
     * @return Integer
     */
	@Override
	public Integer modify(PostAttachment postAttachment) {
    	logger.info("(PostAttachmentService-modify)-修改岗位附件-传入参数, postAttachment:{}", postAttachment);
    	postAttachment.setUpdateTime(new Date());
    	int i = postAttachmentMapper.updateByPrimaryKeySelective(postAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}