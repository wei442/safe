package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.DictMapper;
import com.cloud.provider.safe.po.Dict;
import com.cloud.provider.safe.po.DictExample;
import com.cloud.provider.safe.service.IDictService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 字典 DictService
 * @author wei.yong
 */
@Service
public class DictServiceImpl implements IDictService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //字典 Mapper
    @Autowired
    private DictMapper dictMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param dict
	 * @return List<Dict>
	 */
	@Override
	public List<Dict> selectDictListByPage(Page<?> page, Dict dict) {
		logger.info("(DictService-selectDictListByPage)-分页查询-传入参数, page:{}, dict:{}", page, dict);
		PageHelper.startPage(page);
		DictExample example = new DictExample();
		example.setOrderByClause(" id desc ");
		DictExample.Criteria criteria = example.createCriteria();
		if(dict != null) {
		}
		List<Dict> list = dictMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param dict
	 * @return List<Dict>
	 */
	@Override
	public List<Dict> selectDictList(Dict dict) {
		logger.info("(DictService-selectDictList)-不分页查询-传入参数, dict:{}", dict);
		DictExample example = new DictExample();
		DictExample.Criteria criteria = example.createCriteria();
		if(dict != null) {
		}
		List<Dict> list = dictMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询字典
     * @param id
     * @return Dict
     */
	@Override
	public Dict selectDictById(Integer id) {
    	logger.info("(DictService-selectDictById)-根据id查询字典-传入参数, id:{}", id);
    	Dict dict = null;
    	try {
    		dict = dictMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(DictService-selectDictById)-根据id查询字典-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return dict;
    }

    /**
     * 插入字典
     * @param dict
     * @return Integer
     */
	@Override
	public Integer insertDict(Dict dict) {
    	logger.info("(DictService-insertDict)-插入字典-传入参数, dict:{}", dict);
    	dict.setCreateTime(new Date());
    	dict.setUpdateTime(new Date());
    	int i = dictMapper.insertSelective(dict);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除字典
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteDictById(Integer id) {
  		logger.info("(DictService-deleteDictById)-根据id删除字典-传入参数, id:{}", id);
  		int i = dictMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		return i;
  	}

    /**
     * 修改字典
     * @param dict
     * @return Integer
     */
	@Override
	public Integer modifyDict(Dict dict) {
    	logger.info("(DictService-modifyDict)-修改字典-传入参数, dict:{}", dict);
    	dict.setUpdateTime(new Date());
    	int i = dictMapper.updateByPrimaryKeySelective(dict);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}