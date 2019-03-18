package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.BaseUserPasswordMapper;
import com.cloud.provider.safe.po.BaseUserPassword;
import com.cloud.provider.safe.po.BaseUserPasswordExample;
import com.cloud.provider.safe.service.IBaseUserPasswordService;
import com.cloud.provider.safe.util.Assert;

/**
 * 基础用户密码 BaseUserPasswordService
 * @author wei.yong
 */
@Service
public class BaseUserPasswordServiceImpl implements IBaseUserPasswordService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //基础用户密码 Mapper
    @Autowired
    private BaseUserPasswordMapper baseUserPasswordMapper;

    /**
     * 根据id查询基础用户密码
     * @param id
     * @return BaseUserPassword
     */
	@Override
	public BaseUserPassword selectById(Integer id) {
    	logger.info("(BaseUserPasswordService-selectById)-根据id查询基础用户密码-传入参数, id:{}", id);
		BaseUserPassword baseUserPassword = baseUserPasswordMapper.selectByPrimaryKey(id);
		return baseUserPassword;
    }

	/**
	 * 根据 baseUserId查询基础用户密码
	 * @param  baseUserId
	 * @return BaseUserPassword
	 */
	@Override
	public BaseUserPassword selectByBaseUserId(Integer baseUserId) {
		logger.info("(BaseUserPasswordService-selectById)-根据baseUserId查询基础用户密码-传入参数,  baseUserId:{}",  baseUserId);
		BaseUserPasswordExample example = new BaseUserPasswordExample();
		BaseUserPasswordExample.Criteria criteria = example.createCriteria();
		criteria.andBaseUserIdEqualTo( baseUserId);

		List<BaseUserPassword> list = baseUserPasswordMapper.selectByExample(example);
		BaseUserPassword baseUserPassword = null;
		if(list != null && !list.isEmpty()) {
			baseUserPassword = list.get(0);
		}
		return baseUserPassword;
	}

    /**
     * 插入基础用户密码
     * @param baseUserPassword
     * @return Integer
     */
	@Override
	public Integer insert(BaseUserPassword baseUserPassword) {
    	logger.info("(BaseUserPasswordService-insertBaseUserPassword)-插入基础用户密码-传入参数, baseUserPassword:{}", baseUserPassword);
    	baseUserPassword.setCreateTime(new Date());
    	baseUserPassword.setUpdateTime(new Date());
    	int i = baseUserPasswordMapper.insertSelective(baseUserPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除基础用户密码
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(BaseUserPasswordService-deleteById)-根据id删除基础用户密码-传入参数, id:{}", id);
		int i = baseUserPasswordMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改基础用户密码
     * @param baseUserPassword
     * @return Integer
     */
	@Override
	public Integer modify(BaseUserPassword baseUserPassword) {
    	logger.info("(BaseUserPasswordService-modifyBaseUserPassword)-修改基础用户密码-传入参数, baseUserPassword:{}", baseUserPassword);
    	baseUserPassword.setUpdateTime(new Date());
		int i = baseUserPasswordMapper.updateByPrimaryKeySelective(baseUserPassword);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}