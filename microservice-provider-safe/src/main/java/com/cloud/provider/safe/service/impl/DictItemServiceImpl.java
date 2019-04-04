package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.DictItemMapper;
import com.cloud.provider.safe.po.DictItem;
import com.cloud.provider.safe.po.DictItemExample;
import com.cloud.provider.safe.rest.request.page.dict.DictItemPageRequest;
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
	public List<DictItem> selectListByPage(Page<?> page, DictItemPageRequest param) {
		logger.info("(DictItemService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		DictItemExample example = new DictItemExample();
		example.setOrderByClause(" id desc ");
		DictItemExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_DICT_ITEM_IS_DELETE_NO);
		if(param != null) {
			if(param.getDictId() != null) {
				criteria.andDictIdEqualTo(param.getDictId());
			}
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
	public List<DictItem> selectList(DictItemPageRequest param) {
		logger.info("(DictItemService-selectList)-不分页查询-传入参数, dictItem:{}", param);
		DictItemExample example = new DictItemExample();
		example.setOrderByClause(" id desc ");
		DictItemExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_DICT_ITEM_IS_DELETE_NO);
		if(param != null) {
			if(param.getDictId() != null) {
				criteria.andDictIdEqualTo(param.getDictId());
			}
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
	public DictItem selectById(Integer id) {
    	logger.info("(DictItemService-selectById)-根据id查询字典子项-传入参数, id:{}", id);
		DictItem dictItem = dictItemMapper.selectByPrimaryKey(id);
		return dictItem;
    }

    /**
     * 插入字典子项
     * @param dictItem
     * @return Integer
     */
	@Override
	public Integer insert(DictItem dictItem) {
    	logger.info("(DictItemService-insertDictItem)-插入字典子项-传入参数, dictItem:{}", dictItem);
    	dictItem.setIsDelete(SqlSafeConstants.SQL_DICT_ITEM_IS_DELETE_NO);
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
	public Integer deleteById(Integer id) {
  		logger.info("(DictItemService-deleteById)-根据id删除字典子项-传入参数, id:{}", id);
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
	public Integer modify(DictItem dictItem) {
    	logger.info("(DictItemService-modifyDictItem)-修改字典子项-传入参数, dictItem:{}", dictItem);
    	dictItem.setUpdateTime(new Date());
    	int i = dictItemMapper.updateByPrimaryKeySelective(dictItem);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}