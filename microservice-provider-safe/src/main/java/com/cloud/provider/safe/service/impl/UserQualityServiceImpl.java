package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserQualityAttachmentMapper;
import com.cloud.provider.safe.dao.UserQualityMapper;
import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.po.UserQualityAttachmentExample;
import com.cloud.provider.safe.po.UserQualityExample;
import com.cloud.provider.safe.rest.request.page.user.UserQualityPageRequest;
import com.cloud.provider.safe.service.IUserQualityService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户资质 UserQualityService
 * @author wei.yong
 */
@Service
public class UserQualityServiceImpl implements IUserQualityService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户资质 Mapper
    @Autowired
    private UserQualityMapper userQualityMapper;

    //用户资质附件 Mapper
    @Autowired
    private UserQualityAttachmentMapper userQualityAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserQuality>
	 */
	@Override
	public List<UserQuality> selectListByPage(Page<?> page, UserQualityPageRequest param) {
		logger.info("(UserQualityService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserQualityExample example = new UserQualityExample();
		example.setOrderByClause(" id desc ");
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQuality>
	 */
	@Override
	public List<UserQuality> selectList(UserQualityPageRequest param) {
		logger.info("(UserQualityService-selectList)-不分页查询-传入参数, param:{}", param);
		UserQualityExample example = new UserQualityExample();
		example.setOrderByClause(" id desc ");
		UserQualityExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户资质
     * @param id
     * @return UserQuality
     */
	@Override
	public UserQuality selectById(Integer id) {
    	logger.info("(UserQualityService-selectById)-根据id查询用户资质-传入参数, id:{}", id);
		UserQuality userQuality = userQualityMapper.selectByPrimaryKey(id);
		return userQuality;
    }

	/**
	 * 根据userId查询用户资质
	 * @param userId
	 * @return UserQuality
	 */
	@Override
	public UserQuality selectByUserId(Integer userId) {
		logger.info("(UserQualityService-selectByUserId)-根据userId查询用户资质-传入参数, userId:{}", userId);
		UserQualityExample example = new UserQualityExample();
		UserQualityExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserQuality> list = userQualityMapper.selectByExample(example);
		UserQuality userQuality = null;
		if(list != null && !list.isEmpty()) {
			userQuality = list.get(0);
		}
		return userQuality;
	}

    /**
     * 插入用户资质及附件
     * @param userQuality
     * @param userQualityAttachmentList
     * @return Integer
     */
	@Override
	public Integer insert(UserQuality userQuality, List<UserQualityAttachment> userQualityAttachmentList) {
    	logger.info("(UserQualityService-insert)-插入用户资质及附件-传入参数, userQuality:{}, userQualityAttachmentList:{}", userQuality, userQualityAttachmentList);
    	userQuality.setCreateTime(new Date());
    	userQuality.setUpdateTime(new Date());
    	int i = userQualityMapper.insertSelective(userQuality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer userQualityId = userQuality.getId();

    	if(userQualityAttachmentList != null && !userQualityAttachmentList.isEmpty()) {
    		for (UserQualityAttachment userQualityAttachment : userQualityAttachmentList) {
    			userQualityAttachment.setUserQualityId(userQualityId);
    			userQualityAttachment.setCreateTime(new Date());
    			userQualityAttachment.setUpdateTime(new Date());
    			i = userQualityAttachmentMapper.insertSelective(userQualityAttachment);
			}
    	}

    	return i;
    }

 	/**
  	 * 根据id删除用户资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserQualityService-deleteById)-根据id删除用户资质-传入参数, id:{}", id);
		int i = userQualityMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

  		UserQualityAttachmentExample example = new UserQualityAttachmentExample();
  		UserQualityAttachmentExample.Criteria criteria = example.createCriteria();
		criteria.andUserQualityIdEqualTo(id);
		i = userQualityAttachmentMapper.deleteByExample(example);
  		return i;
  	}

 	/**
  	 * 根据ids删除用户资质
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除用户资质-传入参数, ids:{}", ids);
  		UserQualityExample example = new UserQualityExample();
  		UserQualityExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = userQualityMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户资质及附件
     * @param userQuality
     * @param userQualityAttachmentList
     * @return Integer
     */
	@Override
	public Integer modify(UserQuality userQuality, List<UserQualityAttachment> userQualityAttachmentList) {
    	logger.info("(UserQualityService-modify)-修改用户资质及附件-传入参数, userQuality:{}, userQualityAttachmentList:{}", userQuality, userQualityAttachmentList);
    	userQuality.setUpdateTime(new Date());
		int i = userQualityMapper.updateByPrimaryKeySelective(userQuality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	Integer userQualityId = userQuality.getId();

    	UserQualityAttachmentExample example = new UserQualityAttachmentExample();
  		UserQualityAttachmentExample.Criteria criteria = example.createCriteria();
		criteria.andUserQualityIdEqualTo(userQualityId);
		i = userQualityAttachmentMapper.deleteByExample(example);
		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

		if(userQualityAttachmentList != null && !userQualityAttachmentList.isEmpty()) {
    		for (UserQualityAttachment userQualityAttachment : userQualityAttachmentList) {
    			userQualityAttachment.setUserQualityId(userQualityId);
    			userQualityAttachment.setCreateTime(new Date());
    			userQualityAttachment.setUpdateTime(new Date());
    			i = userQualityAttachmentMapper.insertSelective(userQualityAttachment);
			}
    	}
    	return i;
    }

}