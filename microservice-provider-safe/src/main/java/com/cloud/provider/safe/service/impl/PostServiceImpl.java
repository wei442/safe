package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.PostMapper;
import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.po.PostExample;
import com.cloud.provider.safe.service.IPostService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 岗位 PostService
 * @author wei.yong
 */
@Service
public class PostServiceImpl implements IPostService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //岗位 Mapper
    @Autowired
    private PostMapper postMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param Post
	 * @return List<Post>
	 */
	@Override
	public List<Post> selectPostListByPage(Page<?> page, Post Post) {
		logger.info("(PostService-selectPostListByPage)-分页查询-传入参数, page:{}, Post:{}", page, Post);
		PageHelper.startPage(page);
		PostExample example = new PostExample();
		example.setOrderByClause(" id desc ");
		PostExample.Criteria criteria = example.createCriteria();
		if(Post != null) {
		}
		List<Post> list = postMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param Post
	 * @return List<Post>
	 */
	@Override
	public List<Post> selectPostList(Post Post) {
		logger.info("(PostService-selectPostList)-不分页查询-传入参数, Post:{}", Post);
		PostExample example = new PostExample();
		PostExample.Criteria criteria = example.createCriteria();
		if(Post != null) {
		}
		List<Post> list = postMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询岗位
     * @param id
     * @return Post
     */
	@Override
	public Post selectPostById(Integer id) {
    	logger.info("(PostService-selectPostById)-根据id查询岗位-传入参数, id:{}", id);
    	Post post = postMapper.selectByPrimaryKey(id);
		return post;
    }

    /**
     * 插入岗位
     * @param Post
     * @return Integer
     */
	@Override
	public Integer insertPost(Post Post) {
    	logger.info("(PostService-insertPost)-插入岗位-传入参数, Post:{}", Post);
    	Post.setCreateTime(new Date());
    	Post.setUpdateTime(new Date());
    	int i = postMapper.insertSelective(Post);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除岗位
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deletePostById(Integer id) {
  		logger.info("(PostService-deletePostById)-根据id删除岗位-传入参数, id:{}", id);
  		int i = postMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改岗位
     * @param Post
     * @return Integer
     */
	@Override
	public Integer modifyPost(Post Post) {
    	logger.info("(PostService-modifyPost)-修改岗位-传入参数, Post:{}", Post);
    	Post.setUpdateTime(new Date());
    	int i = postMapper.updateByPrimaryKeySelective(Post);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}