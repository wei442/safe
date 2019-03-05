package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.DictItem;
import com.github.pagehelper.Page;

public interface IBootDictItemService {

    /**
	 * 分页查询
	 * @param page
	 * @param dictItem
	 * @return List<DictItem>
	 */
	public List<DictItem> selectDictItemListByPage(Page<?> page, DictItem dictItem);

	/**
	 * 不分页查询
	 * @param dictItem
	 * @return List<DictItem>
	 */
	public List<DictItem> selectDictItemList(DictItem dictItem);

    /**
     * 根据id查询字典子项
     * @param id
     * @return DictItem
     */
	public DictItem selectDictItemById(Integer id);

    /**
     * 插入字典子项
     * @param dictItem
     * @return Integer
     */
	public Integer insertDictItem(DictItem dictItem);

 	/**
  	 * 根据id删除字典子项
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteDictItemById(Integer id);

    /**
     * 修改字典子项
     * @param dictItem
     * @return Integer
     */
	public Integer modifyDictItem(DictItem dictItem);

}