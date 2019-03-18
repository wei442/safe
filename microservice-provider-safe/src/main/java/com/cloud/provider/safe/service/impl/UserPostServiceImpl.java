package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserPostMapper;
import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.po.UserPostExample;
import com.cloud.provider.safe.rest.request.page.UserPostPageRequest;
import com.cloud.provider.safe.service.IUserPostService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户岗位 UserPostService
 * @author wei.yong
 */
@Service
public class UserPostServiceImpl implements IUserPostService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户岗位 Mapper
    @Autowired
    private UserPostMapper userPostMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserPost>
	 */
	@Override
	public List<UserPost> selectListByPage(Page<?> page, UserPostPageRequest param) {
		logger.info("(UserPostService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		UserPostExample example = new UserPostExample();
		example.setOrderByClause(" id desc ");
		UserPostExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserPost>list = userPostMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserPost>
	 */
	@Override
	public List<UserPost> selectList(UserPostPageRequest param) {
		logger.info("(UserPostService-selectList)-不分页查询-传入参数, param:{}", param);
		UserPostExample example = new UserPostExample();
		example.setOrderByClause(" id desc ");
		UserPostExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserPost>list = userPostMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户岗位
     * @param id
     * @return UserPost
     */
	@Override
	public UserPost selectById(Integer id) {
    	logger.info("(UserPostService-selectById)-根据id查询用户岗位-传入参数, id:{}", id);
		UserPost userPost = userPostMapper.selectByPrimaryKey(id);
		Assert.thanOrEqualZreo(userPost, SafeResultEnum.DATABASE_NOTEXIST);
		return userPost;
    }

	/**
	 * 根据userId查询用户岗位
	 * @param userId
	 * @return UserPost
	 */
	@Override
	public UserPost selectByUserId(Integer userId) {
		logger.info("(UserPostService-selectById)-根据userId查询用户岗位-传入参数, userId:{}", userId);
		UserPostExample example = new UserPostExample();
		UserPostExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserPost> list = userPostMapper.selectByExample(example);
		UserPost userPost = null;
		if(list != null && !list.isEmpty()) {
			userPost = list.get(0);
		}
		Assert.thanOrEqualZreo(userPost, SafeResultEnum.DATABASE_NOTEXIST);
		return userPost;
	}

    /**
     * 插入用户岗位
     * @param userPost
     * @return Integer
     */
	@Override
	public Integer insert(UserPost userPost) {
    	logger.info("(UserPostService-insertUserPost)-插入用户岗位-传入参数, userPost:{}", userPost);
    	userPost.setCreateTime(new Date());
    	userPost.setUpdateTime(new Date());
		int i = userPostMapper.insertSelective(userPost);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户岗位
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserPostService-deleteById)-根据id删除用户岗位-传入参数, id:{}", id);
		int i = userPostMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户岗位
     * @param userPost
     * @return Integer
     */
	@Override
	public Integer modify(UserPost userPost) {
    	logger.info("(UserPostService-modifyUserPost)-修改用户岗位-传入参数, userPost:{}", userPost);
    	userPost.setUpdateTime(new Date());
		int i = userPostMapper.updateByPrimaryKeySelective(userPost);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}