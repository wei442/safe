package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.UserQualityAttachmentMapper;
import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.po.UserQualityAttachmentExample;
import com.cloud.provider.safe.rest.request.page.user.UserQualityAttachmentPageRequest;
import com.cloud.provider.safe.service.IUserQualityAttachmentService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户资质附件 UserQualityAttachmentService
 * @author wei.yong
 */
@Service
public class UserQualityAttachmentServiceImpl implements IUserQualityAttachmentService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户资质附件 Mapper
    @Autowired
    private UserQualityAttachmentMapper userQualityAttachmentMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserQualityAttachment>
	 */
	@Override
	public List<UserQualityAttachment> selectListByPage(Page<?> page, UserQualityAttachmentPageRequest param) {
		logger.info("(UserQualityAttachmentService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		UserQualityAttachmentExample example = new UserQualityAttachmentExample();
		example.setOrderByClause(" id asc ");
		UserQualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getUserQualityId() != null) {
				criteria.andUserQualityIdEqualTo(param.getUserQualityId());
			}
		}
		List<UserQualityAttachment> list = userQualityAttachmentMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQualityAttachment>
	 */
	@Override
	public List<UserQualityAttachment> selectList(UserQualityAttachmentPageRequest param) {
		logger.info("(UserQualityAttachmentService-selectList)-不分页查询-传入参数, param:{}", param);
		UserQualityAttachmentExample example = new UserQualityAttachmentExample();
		example.setOrderByClause(" id asc ");
		UserQualityAttachmentExample.Criteria criteria = example.createCriteria();
		if(param != null) {
			if(param.getUserQualityId() != null) {
				criteria.andUserQualityIdEqualTo(param.getUserQualityId());
			}
		}
		List<UserQualityAttachment> list = userQualityAttachmentMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询用户资质附件
     * @param id
     * @return UserQualityAttachment
     */
	@Override
	public UserQualityAttachment selectById(Integer id) {
    	logger.info("(UserQualityAttachmentService-selectById)-根据id查询用户资质附件-传入参数, id:{}", id);
		UserQualityAttachment userQualityAttachment = userQualityAttachmentMapper.selectByPrimaryKey(id);
		return userQualityAttachment;
    }

    /**
     * 插入用户资质附件
     * @param userQualityAttachment
     * @return Integer
     */
	@Override
	public Integer insert(UserQualityAttachment userQualityAttachment) {
    	logger.info("(UserQualityAttachmentService-insert)-插入用户资质附件-传入参数, userQualityAttachment:{}", userQualityAttachment);
    	userQualityAttachment.setCreateTime(new Date());
    	userQualityAttachment.setUpdateTime(new Date());
    	int i = userQualityAttachmentMapper.insertSelective(userQualityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除用户资质附件
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(UserQualityAttachmentService-deleteById)-根据id删除用户资质附件-传入参数, id:{}", id);
		int i = userQualityAttachmentMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除用户资质附件
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除用户资质附件-传入参数, ids:{}", ids);
  		UserQualityAttachmentExample example = new UserQualityAttachmentExample();
  		UserQualityAttachmentExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = userQualityAttachmentMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改用户资质附件
     * @param userQualityAttachment
     * @return Integer
     */
	@Override
	public Integer modify(UserQualityAttachment userQualityAttachment) {
    	logger.info("(UserQualityAttachmentService-modify)-修改用户资质附件-传入参数, userQualityAttachment:{}", userQualityAttachment);
    	userQualityAttachment.setUpdateTime(new Date());
		int i = userQualityAttachmentMapper.updateByPrimaryKeySelective(userQualityAttachment);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}