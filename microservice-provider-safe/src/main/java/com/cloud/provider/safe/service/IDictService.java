package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Dict;
import com.cloud.provider.safe.rest.request.page.DictPageRequest;
import com.github.pagehelper.Page;

public interface IDictService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Dict>
	 */
	public List<Dict> selectDictListByPage(Page<?> page, DictPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Dict>
	 */
	public List<Dict> selectDictList(DictPageRequest param);

    /**
     * 根据id查询字典
     * @param id
     * @return Dict
     */
	public Dict selectDictById(Integer id);

    /**
     * 插入字典
     * @param dict
     * @return Integer
     */
	public Integer insertDict(Dict dict);

 	/**
  	 * 根据id删除字典
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteDictById(Integer id);

    /**
     * 修改字典
     * @param dict
     * @return Integer
     */
	public Integer modifyDict(Dict dict);

}