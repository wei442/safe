package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserPostMapper;
import com.cloud.provider.safe.dao.dao.UserPostDao;
import com.cloud.provider.safe.param.UserPostParam;
import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.po.UserPostExample;
import com.cloud.provider.safe.rest.request.page.user.UserPostPageRequest;
import com.cloud.provider.safe.service.IUserPostService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.vo.user.UserPostVo;
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

    //用户岗位 Dao
    @Autowired
    private UserPostDao userPostDao;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserPostVo>
	 */
	@Override
	public List<UserPostVo> selectListByPage(Page<?> page, UserPostPageRequest param) {
		logger.info("(UserPostService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserPostParam userPostParam = new UserPostParam();
//		userPostParam.setOrderByClause("  ");
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				userPostParam.setEnterpriseId(param.getEnterpriseId());
			}
			if(param.getPostId() != null) {
				userPostParam.setPostId(param.getPostId());
			}
		}

		List<UserPostVo> list = userPostDao.selectList(userPostParam);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserPostVo>
	 */
	@Override
	public List<UserPostVo> selectList(UserPostPageRequest param) {
		logger.info("(UserPostService-selectList)-不分页查询-传入参数, param:{}", param);
		UserPostParam userPostParam = new UserPostParam();
//		userPostParam.setOrderByClause("  ");
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				userPostParam.setEnterpriseId(param.getEnterpriseId());
			}
			if(param.getPostId() != null) {
				userPostParam.setPostId(param.getPostId());
			}
		}

		List<UserPostVo> list = userPostDao.selectList(userPostParam);
		return list;
	}

	/**
	 * 根据postId查询用户岗位列表
	 * @param postId
	 * @return UserPost List<UserPost>
	 */
	@Override
	public List<UserPost> selectListByPostId(Integer postId) {
		logger.info("(UserPostService-selectListByPostId)-根据postId查询用户岗位列表-传入参数, postId:{}", postId);
		UserPostExample example = new UserPostExample();
		UserPostExample.Criteria criteria = example.createCriteria();
		criteria.andPostIdEqualTo(postId);

		List<UserPost> list = userPostMapper.selectByExample(example);
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
		return userPost;
    }

	/**
	 * 根据userId查询用户岗位
	 * @param userId
	 * @return UserPost
	 */
	@Override
	public UserPost selectByUserId(Integer userId) {
		logger.info("(UserPostService-selectByUserId)-根据userId查询用户岗位-传入参数, userId:{}", userId);
		UserPostExample example = new UserPostExample();
		UserPostExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);

		List<UserPost> list = userPostMapper.selectByExample(example);
		UserPost userPost = null;
		if(list != null && !list.isEmpty()) {
			userPost = list.get(0);
		}
		return userPost;
	}

    /**
     * 插入用户岗位
     * @param userPost
     * @return Integer
     */
	@Override
	public Integer insert(UserPost userPost) {
    	logger.info("(UserPostService-insert)-插入用户岗位-传入参数, userPost:{}", userPost);
    	userPost.setCreateTime(new Date());
    	userPost.setUpdateTime(new Date());
		int i = userPostMapper.insertSelective(userPost);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

	/**
	 * 批量插入
	 * @param list
	 * @return Integer
	 */
	@Override
	public Integer insertList(List<UserPost> list) {
		logger.info("(UserPostService-insertList)-插入用户岗位-传入参数, list:{}", list);
		int i = userPostDao.insertList(list);
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
  	 * 根据ids删除用户岗位
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除用户岗位-传入参数, ids:{}", ids);
  		UserPostExample example = new UserPostExample();
  		UserPostExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = userPostMapper.deleteByExample(example);
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
    	logger.info("(UserPostService-modify)-修改用户岗位-传入参数, userPost:{}", userPost);
    	userPost.setUpdateTime(new Date());
		int i = userPostMapper.updateByPrimaryKeySelective(userPost);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}