package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Title;
import com.cloud.provider.safe.rest.request.page.post.TitlePageRequest;
import com.github.pagehelper.Page;

public interface ITitleService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Title>
	 */
	public List<Title> selectListByPage(Page<?> page, TitlePageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Title>
	 */
	public List<Title> selectList(TitlePageRequest param);

    /**
     * 根据id查询职务
     * @param id
     * @return Title
     */
	public Title selectById(Integer id);

    /**
     * 插入职务
     * @param title
     * @return Integer
     */
	public Integer insert(Title title);

 	/**
  	 * 根据id删除职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改职务
     * @param title
     * @return Integer
     */
	public Integer modify(Title title);

}