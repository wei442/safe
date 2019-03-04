package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.PostMapper;
import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.po.PostExample;
import com.cloud.provider.safe.service.IBootPostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 岗位 BootPostService
 * @author wei.yong
 */
@Service
public class BootPostServiceImpl implements IBootPostService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //岗位 Mapper
    @Autowired
    private PostMapper PostMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param Post
	 * @return List<Post>
	 */
	@Override
	public List<Post> selectPostListByPage(Page<?> page, Post Post) {
		logger.info("(BootPostService-selectPostListByPage)-分页查询-传入参数, page:{}, Post:{}", page, Post);
		PageHelper.startPage(page);
		PostExample example = new PostExample();
		example.setOrderByClause(" id desc ");
		PostExample.Criteria criteria = example.createCriteria();
		if(Post != null) {
		}
		List<Post> list = null;
		try {
			list = PostMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootPostService-selectPostListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param Post
	 * @return List<Post>
	 */
	@Override
	public List<Post> selectPostList(Post Post) {
		logger.info("(BootPostService-selectPostList)-不分页查询-传入参数, Post:{}", Post);
		PostExample example = new PostExample();
		PostExample.Criteria criteria = example.createCriteria();
		if(Post != null) {
		}
		List<Post> list = null;
		try {
			list = PostMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootPostService-selectPostList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询岗位
     * @param id
     * @return Post
     */
	@Override
	public Post selectPostById(Integer id) {
    	logger.info("(BootPostService-selectPostById)-根据id查询岗位-传入参数, id:{}", id);
    	Post Post = null;
    	try {
    		Post = PostMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootPostService-selectPostById)-根据id查询岗位-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return Post;
    }

    /**
     * 插入岗位
     * @param Post
     * @return Integer
     */
	@Override
	public Integer insertPost(Post Post) {
    	logger.info("(BootPostService-insertPost)-插入岗位-传入参数, Post:{}", Post);
    	Post.setCreateTime(new Date());
    	Post.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = PostMapper.insertSelective(Post);
    	} catch (Exception e) {
    		logger.error("(BootPostService-insertPost)-插入岗位-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改岗位
     * @param Post
     * @return Integer
     */
	@Override
	public Integer modifyPost(Post Post) {
    	logger.info("(BootPostService-modifyPost)-修改岗位-传入参数, Post:{}", Post);
    	Post.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = PostMapper.updateByPrimaryKeySelective(Post);
    	} catch (Exception e) {
    		logger.error("(BootPostService-modifyPost)-修改岗位-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}