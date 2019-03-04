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
import com.cloud.provider.safe.service.IBootDictItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 字典子项 BootDictItemService
 * @author wei.yong
 */
@Service
public class BootDictItemServiceImpl implements IBootDictItemService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //字典子项 Mapper
    @Autowired
    private DictItemMapper dictItemMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param dictItem
	 * @return List<DictItem>
	 */
	@Override
	public List<DictItem> selectDictItemListByPage(Page<?> page, DictItem dictItem) {
		logger.info("(BootDictItemService-selectDictItemListByPage)-分页查询-传入参数, page:{}, dictItem:{}", page, dictItem);
		PageHelper.startPage(page);
		DictItemExample example = new DictItemExample();
		example.setOrderByClause(" id desc ");
		DictItemExample.Criteria criteria = example.createCriteria();
		if(dictItem != null) {
		}
		List<DictItem> list = null;
		try {
			list = dictItemMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootDictItemService-selectDictItemListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param dictItem
	 * @return List<DictItem>
	 */
	@Override
	public List<DictItem> selectDictItemList(DictItem dictItem) {
		logger.info("(BootDictItemService-selectDictItemList)-不分页查询-传入参数, dictItem:{}", dictItem);
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria criteria = example.createCriteria();
		if(dictItem != null) {
		}
		List<DictItem> list = null;
		try {
			list = dictItemMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootDictItemService-selectDictItemList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询字典子项
     * @param id
     * @return DictItem
     */
	@Override
	public DictItem selectDictItemById(Integer id) {
    	logger.info("(BootDictItemService-selectDictItemById)-根据id查询字典子项-传入参数, id:{}", id);
    	DictItem dictItem = null;
    	try {
    		dictItem = dictItemMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootDictItemService-selectDictItemById)-根据id查询字典子项-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
    	logger.info("(BootDictItemService-insertDictItem)-插入字典子项-传入参数, dictItem:{}", dictItem);
    	dictItem.setCreateTime(new Date());
    	dictItem.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = dictItemMapper.insertSelective(dictItem);
    	} catch (Exception e) {
    		logger.error("(BootDictItemService-insertDictItem)-插入字典子项-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改字典子项
     * @param dictItem
     * @return Integer
     */
	@Override
	public Integer modifyDictItem(DictItem dictItem) {
    	logger.info("(BootDictItemService-modifyDictItem)-修改字典子项-传入参数, dictItem:{}", dictItem);
    	dictItem.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = dictItemMapper.updateByPrimaryKeySelective(dictItem);
    	} catch (Exception e) {
    		logger.error("(BootDictItemService-modifyDictItem)-修改字典子项-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}