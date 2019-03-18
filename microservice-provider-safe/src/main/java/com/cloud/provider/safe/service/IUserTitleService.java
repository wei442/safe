package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.rest.request.page.UserTitlePageRequest;
import com.github.pagehelper.Page;

public interface IUserTitleService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserTitle>
	 */
	public List<UserTitle> selectListByPage(Page<?> page, UserTitlePageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserTitle>
	 */
	public List<UserTitle> selectList(UserTitlePageRequest param);

    /**
     * 根据id查询用户职务
     * @param id
     * @return UserTitle
     */
	public UserTitle selectById(Integer id);

	/**
	 * 根据userId查询用户职务
	 * @param userId
	 * @return UserTitle
	 */
	public UserTitle selectByUserId(Integer userId);

    /**
     * 插入用户职务
     * @param userTitle
     * @return Integer
     */
	public Integer insert(UserTitle userTitle);

	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户职务
     * @param userTitle
     * @return Integer
     */
	public Integer modify(UserTitle userTitle);

}