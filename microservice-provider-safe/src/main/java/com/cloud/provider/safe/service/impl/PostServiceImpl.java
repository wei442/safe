package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.PostMapper;
import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.po.PostExample;
import com.cloud.provider.safe.rest.request.page.PostPageRequest;
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
	 * @param param
	 * @return List<Post>
	 */
	@Override
	public List<Post> selectListByPage(Page<?> page, PostPageRequest param) {
		logger.info("(PostService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PostExample example = new PostExample();
		example.setOrderByClause(" id desc ");
		PostExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_POST_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Post> list = postMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Post>
	 */
	@Override
	public List<Post> selectList(PostPageRequest param) {
		logger.info("(PostService-selectList)-不分页查询-传入参数, param:{}", param);
		PostExample example = new PostExample();
		example.setOrderByClause(" id desc ");
		PostExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_POST_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
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
	public Post selectById(Integer id) {
    	logger.info("(PostService-selectById)-根据id查询岗位-传入参数, id:{}", id);
    	Post post = postMapper.selectByPrimaryKey(id);
		return post;
    }

    /**
     * 插入岗位
     * @param Post
     * @return Integer
     */
	@Override
	public Integer insert(Post post) {
    	logger.info("(PostService-insertPost)-插入岗位-传入参数, post:{}", post);
    	post.setIsDelete(SqlSafeConstants.SQL_POST_IS_DELETE_NO);
    	post.setCreateTime(new Date());
    	post.setUpdateTime(new Date());
    	int i = postMapper.insertSelective(post);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除岗位
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(PostService-deleteById)-根据id删除岗位-传入参数, id:{}", id);
  		int i = postMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改岗位
     * @param Post
     * @return Integer
     */
	@Override
	public Integer modify(Post post) {
    	logger.info("(PostService-modifyPost)-修改岗位-传入参数, post:{}", post);
    	post.setUpdateTime(new Date());
    	int i = postMapper.updateByPrimaryKeySelective(post);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}