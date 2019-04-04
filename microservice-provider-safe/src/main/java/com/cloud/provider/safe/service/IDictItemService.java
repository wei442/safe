package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.DictItem;
import com.cloud.provider.safe.rest.request.page.dict.DictItemPageRequest;
import com.github.pagehelper.Page;

public interface IDictItemService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<DictItem>
	 */
	public List<DictItem> selectListByPage(Page<?> page, DictItemPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DictItem>
	 */
	public List<DictItem> selectList(DictItemPageRequest param);

    /**
     * 根据id查询字典子项
     * @param id
     * @return DictItem
     */
	public DictItem selectById(Integer id);

    /**
     * 插入字典子项
     * @param dictItem
     * @return Integer
     */
	public Integer insert(DictItem dictItem);

 	/**
  	 * 根据id删除字典子项
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改字典子项
     * @param dictItem
     * @return Integer
     */
	public Integer modify(DictItem dictItem);

}