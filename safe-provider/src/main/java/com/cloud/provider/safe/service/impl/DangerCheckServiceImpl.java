package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.DangerCheckMapper;
import com.cloud.provider.safe.po.DangerCheck;
import com.cloud.provider.safe.po.DangerCheckExample;
import com.cloud.provider.safe.rest.request.page.danger.DangerCheckPageRequest;
import com.cloud.provider.safe.service.IDangerCheckService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 隐患抽查 DangerCheckService
 * @author wei.yong
 */
@Service
public class DangerCheckServiceImpl implements IDangerCheckService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //隐患抽查 Mapper
    @Autowired
    private DangerCheckMapper dangerCheckMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<DangerCheck>
	 */
	@Override
	public List<DangerCheck> selectListByPage(Page<?> page, DangerCheckPageRequest param) {
		logger.info("(DangerCheckService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		DangerCheckExample example = new DangerCheckExample();
		example.setOrderByClause(" id desc ");
		DangerCheckExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<DangerCheck> list = dangerCheckMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DangerCheck>
	 */
	@Override
	public List<DangerCheck> selectList(DangerCheckPageRequest param) {
		logger.info("(DangerCheckService-selectList)-不分页查询-传入参数, param:{}", param);
		DangerCheckExample example = new DangerCheckExample();
		DangerCheckExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<DangerCheck> list = dangerCheckMapper.selectByExample(example);
		return list;
	}


    /**
     * 根据id查询隐患抽查
     * @param id
     * @return DangerCheck
     */
	@Override
	public DangerCheck selectById(Integer id) {
    	logger.info("(DangerCheckService-selectById)-根据id查询隐患抽查-传入参数, id:{}", id);
		DangerCheck dangerCheck = dangerCheckMapper.selectByPrimaryKey(id);
		return dangerCheck;
    }

	/**
	 * 根据userId查询隐患抽查
	 * @param userId
	 * @return DangerCheck
	 */
	@Override
	public DangerCheck selectByUserId(Integer userId) {
		logger.info("(DangerCheckService-selectByUserId)-根据userId查询隐患抽查-传入参数, userId:{}", userId);
		DangerCheckExample example = new DangerCheckExample();
		DangerCheckExample.Criteria criteria = example.createCriteria();
		List<DangerCheck> list = dangerCheckMapper.selectByExample(example);
		DangerCheck dangerCheck = null;
		if(list != null && !list.isEmpty()) {
			dangerCheck = list.get(0);
		}
		return dangerCheck;
	}

    /**
     * 插入隐患抽查
     * @param dangerCheck
     * @return Integer
     */
	@Override
	public Integer insert(DangerCheck dangerCheck) {
    	logger.info("(DangerCheckService-insert)-插入隐患抽查-传入参数, dangerCheck:{}", dangerCheck);
    	dangerCheck.setCreateTime(new Date());
    	dangerCheck.setUpdateTime(new Date());
    	int i = dangerCheckMapper.insertSelective(dangerCheck);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除隐患抽查
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(DangerCheckService-deleteById)-根据id删除隐患抽查-传入参数, id:{}", id);
		int i = dangerCheckMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

 	/**
  	 * 根据ids删除隐患抽查
  	 * @param ids
  	 * @return Integer
  	 */
	@Override
	public Integer deleteByIds(List<Integer> ids) {
  		logger.info("(UserOrgService-deleteByIds)-根据ids删除隐患抽查-传入参数, ids:{}", ids);
  		DangerCheckExample example = new DangerCheckExample();
  		DangerCheckExample.Criteria criteria = example.createCriteria();
  		criteria.andIdIn(ids);
		int i = dangerCheckMapper.deleteByExample(example);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改隐患抽查
     * @param dangerCheck
     * @return Integer
     */
	@Override
	public Integer modify(DangerCheck dangerCheck) {
    	logger.info("(DangerCheckService-modify)-修改隐患抽查-传入参数, dangerCheck:{}", dangerCheck);
    	dangerCheck.setUpdateTime(new Date());
		int i = dangerCheckMapper.updateByPrimaryKeySelective(dangerCheck);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}