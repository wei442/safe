package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserTitleMapper;
import com.cloud.provider.safe.dao.dao.UserTitleDao;
import com.cloud.provider.safe.param.UserTitleParam;
import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.po.UserTitleExample;
import com.cloud.provider.safe.rest.request.page.user.UserTitlePageRequest;
import com.cloud.provider.safe.service.IUserTitleService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.vo.user.UserTitleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户职务 UserTitleService
 * @author wei.yong
 */
@Service
public class UserTitleServiceImpl implements IUserTitleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户职务 Mapper
    @Autowired
    private UserTitleMapper userTitleMapper;

    //用户职务 Dao
    @Autowired
    private UserTitleDao userTitleDao;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserTitleVo>
	 */
	@Override
	public List<UserTitleVo> selectListByPage(Page<?> page, UserTitlePageRequest param) {
		logger.info("(UserTitleService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserTitleParam userTitleParam = new UserTitleParam();
//		userTitleParam.setOrderByClause("  ");
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				userTitleParam.setEnterpriseId(param.getEnterpriseId());
			}
			if(param.getTitleId() != null) {
				userTitleParam.setTitleId(param.getTitleId());
			}
		}
		List<UserTitleVo> list = userTitleDao.selectList(userTitleParam);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserTitleVo>
	 */
	@Override
	public List<UserTitleVo> selectList(UserTitlePageRequest param) {
		logger.info("(UserTitleService-selectList)-不分页查询-传入参数, param:{}", param);
		UserTitleParam userTitleParam = new UserTitleParam();
//		userTitleParam.setOrderByClause("  ");
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				userTitleParam.setEnterpriseId(param.getEnterpriseId());
			}
			if(param.getTitleId() != null) {
				userTitleParam.setTitleId(param.getTitleId());
			}
		}
		List<UserTitleVo> list = userTitleDao.selectList(userTitleParam);
		return list;
	}

	/**
	 * 根据titleId查询用户职务列表
	 * @param userId
	 * @return List<UserTitle>
	 */
	@Override
	public List<UserTitle> selectListByTitleId(Integer titleId) {
		logger.info("(UserTitleService-selectListByTitleId)-根据titleId查询用户职务列表-传入参数, titleId:{}", titleId);
		UserTitleExample example = new UserTitleExample();
		UserTitleExample.Criteria criteria = example.createCriteria();
		criteria.andTitleIdEqualTo(titleId);
		List<UserTitle> list = userTitleMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户职务
     * @param id
     * @return UserTitle
     */
	@Override
	public UserTitle selectById(Integer id) {
    	logger.info("(UserTitleService-selectById)-根据id查询用户职务-传入参数, id:{}", id);
		UserTitle userTitle = userTitleMapper.selectByPrimaryKey(id);
		return userTitle;
    }

	/**
	 * 根据userId查询用户职务
	 * @param userId
	 * @return UserTitle
	 */
	@Override
	public UserTitle selectByUserId(Integer userId) {
		logger.info("(UserTitleService-selectByUserId)-根据userId查询用户职务-传入参数, userId:{}", userId);
		UserTitleExample example = new UserTitleExample();
		UserTitleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserTitle> list = userTitleMapper.selectByExample(example);
		UserTitle userTitle = null;
		if(list != null && !list.isEmpty()) {
			userTitle = list.get(0);
		}
		return userTitle;
	}

    /**
     * 插入用户职务
     * @param userTitle
     * @return Integer
     */
	@Override
	public Integer insert(UserTitle userTitle) {
    	logger.info("(UserTitleService-insert)-插入用户职务-传入参数, userTitle:{}", userTitle);
    	userTitle.setCreateTime(new Date());
    	userTitle.setUpdateTime(new Date());
    	int i = userTitleMapper.insertSelective(userTitle);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

	/**
	 * 批量插入
	 * @param list
	 * @return Integer
	 */
	@Override
	public Integer insertList(List<UserTitle> list) {
		logger.info("(UserPostService-insertList)-插入用户职务-传入参数, list:{}", list);
		int i = userTitleDao.insertList(list);
		return i;
	}

 	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserTitleService-deleteById)-根据id删除用户职务-传入参数, id:{}", id);
		int i = userTitleMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除用户职务
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除用户职务-传入参数, ids:{}", ids);
  		UserTitleExample example = new UserTitleExample();
  		UserTitleExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = userTitleMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户职务
     * @param userTitle
     * @return Integer
     */
	@Override
	public Integer modify(UserTitle userTitle) {
    	logger.info("(UserTitleService-modify)-修改用户职务-传入参数, userTitle:{}", userTitle);
    	userTitle.setUpdateTime(new Date());
		int i = userTitleMapper.updateByPrimaryKeySelective(userTitle);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}