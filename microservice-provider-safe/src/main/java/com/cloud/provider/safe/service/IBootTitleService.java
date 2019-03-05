package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Title;
import com.github.pagehelper.Page;

public interface IBootTitleService {

    /**
	 * 分页查询
	 * @param page
	 * @param title
	 * @return List<Title>
	 */
	public List<Title> selectTitleListByPage(Page<?> page, Title title);

	/**
	 * 不分页查询
	 * @param title
	 * @return List<Title>
	 */
	public List<Title> selectTitleList(Title title);

    /**
     * 根据id查询职务
     * @param id
     * @return Title
     */
	public Title selectTitleById(Integer id);

    /**
     * 插入职务
     * @param title
     * @return Integer
     */
	public Integer insertTitle(Title title);

 	/**
  	 * 根据id删除职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteTitleById(Integer id);

    /**
     * 修改职务
     * @param title
     * @return Integer
     */
	public Integer modifyTitle(Title title);

}