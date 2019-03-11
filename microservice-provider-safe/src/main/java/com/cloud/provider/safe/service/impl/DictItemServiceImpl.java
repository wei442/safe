package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.DictItemMapper;
import com.cloud.provider.safe.po.DictItem;
import com.cloud.provider.safe.po.DictItemExample;
import com.cloud.provider.safe.rest.request.page.DictItemPageRequest;
import com.cloud.provider.safe.service.IDictItemService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 字典子项 DictItemService
 * @author wei.yong
 */
@Service
public class DictItemServiceImpl implements IDictItemService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //字典子项 Mapper
    @Autowired
    private DictItemMapper dictItemMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<DictItem>
	 */
	@Override
	public List<DictItem> selectDictItemListByPage(Page<?> page, DictItemPageRequest param) {
		logger.info("(DictItemService-selectDictItemListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		DictItemExample example = new DictItemExample();
		example.setOrderByClause(" id desc ");
		DictItemExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<DictItem> list = dictItemMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DictItem>
	 */
	@Override
	public List<DictItem> selectDictItemList(DictItemPageRequest param) {
		logger.info("(DictItemService-selectDictItemList)-不分页查询-传入参数, dictItem:{}", param);
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria criteria = example.createCriteria();
		if(param != null) {
		}
		List<DictItem> list = dictItemMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询字典子项
     * @param id
     * @return DictItem
     */
	@Override
	public DictItem selectDictItemById(Integer id) {
    	logger.info("(DictItemService-selectDictItemById)-根据id查询字典子项-传入参数, id:{}", id);
    	DictItem dictItem = null;
    	try {
    		dictItem = dictItemMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(DictItemService-selectDictItemById)-根据id查询字典子项-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return dictItem;
    }

    /**
     * 插入字典子项
     * @param dictItem
     * @return Integer
     */
	@Override
	public Integer insertDictItem(DictItem dictItem) {
    	logger.info("(DictItemService-insertDictItem)-插入字典子项-传入参数, dictItem:{}", dictItem);
    	dictItem.setCreateTime(new Date());
    	dictItem.setUpdateTime(new Date());
    	int i = dictItemMapper.insertSelective(dictItem);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除字典子项
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteDictItemById(Integer id) {
  		logger.info("(DictItemService-deleteDictItemById)-根据id删除字典子项-传入参数, id:{}", id);
  		int i = dictItemMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改字典子项
     * @param dictItem
     * @return Integer
     */
	@Override
	public Integer modifyDictItem(DictItem dictItem) {
    	logger.info("(DictItemService-modifyDictItem)-修改字典子项-传入参数, dictItem:{}", dictItem);
    	dictItem.setUpdateTime(new Date());
    	int i = dictItemMapper.updateByPrimaryKeySelective(dictItem);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}