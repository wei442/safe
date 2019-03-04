package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.UserPostMapper;
import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.po.UserPostExample;
import com.cloud.provider.safe.service.IBootUserPostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户岗位 BootUserPostService
 * @author wei.yong
 */
@Service
public class BootUserPostServiceImpl implements IBootUserPostService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户岗位 Mapper
    @Autowired
    private UserPostMapper userPostMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param userPost
	 * @return List<UserPost>
	 */
	@Override
	public List<UserPost> selectUserPostListByPage(Page<?> page, UserPost userPost) {
		logger.info("(BootUserPostService-selectUserPostListByPage)-分页查询-传入参数, page:{}, userPost:{}", page, userPost);
		PageHelper.startPage(page);
		UserPostExample example = new UserPostExample();
		example.setOrderByClause(" id desc ");
		UserPostExample.Criteria criteria = example.createCriteria();
		if(userPost != null) {
		}
		List<UserPost> list = null;
		try {
			list = userPostMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserPostService-selectUserPostListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param userPost
	 * @return List<UserPost>
	 */
	@Override
	public List<UserPost> selectUserPostList(UserPost userPost) {
		logger.info("(BootUserPostService-selectUserPostList)-不分页查询-传入参数, userPost:{}", userPost);
		UserPostExample example = new UserPostExample();
		UserPostExample.Criteria criteria = example.createCriteria();
		if(userPost != null) {
		}
		List<UserPost> list = null;
		try {
			list = userPostMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootUserPostService-selectUserPostList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询用户岗位
     * @param id
     * @return UserPost
     */
	@Override
	public UserPost selectUserPostById(Integer id) {
    	logger.info("(BootUserPostService-selectUserPostById)-根据id查询用户岗位-传入参数, id:{}", id);
    	UserPost userPost = null;
    	try {
    		userPost = userPostMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootUserPostService-selectUserPostById)-根据id查询用户岗位-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return userPost;
    }

    /**
     * 插入用户岗位
     * @param userPost
     * @return Integer
     */
	@Override
	public Integer insertUserPost(UserPost userPost) {
    	logger.info("(BootUserPostService-insertUserPost)-插入用户岗位-传入参数, userPost:{}", userPost);
    	userPost.setCreateTime(new Date());
    	userPost.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userPostMapper.insertSelective(userPost);
    	} catch (Exception e) {
    		logger.error("(BootUserPostService-insertUserPost)-插入用户岗位-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改用户岗位
     * @param userPost
     * @return Integer
     */
	@Override
	public Integer modifyUserPost(UserPost userPost) {
    	logger.info("(BootUserPostService-modifyUserPost)-修改用户岗位-传入参数, userPost:{}", userPost);
    	userPost.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = userPostMapper.updateByPrimaryKeySelective(userPost);
    	} catch (Exception e) {
    		logger.error("(BootUserPostService-modifyUserPost)-修改用户岗位-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}