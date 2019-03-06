package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserTitle;
import com.github.pagehelper.Page;

public interface IUserTitleService {

    /**
	 * 分页查询
	 * @param page
	 * @param userTitle
	 * @return List<UserTitle>
	 */
	public List<UserTitle> selectUserTitleListByPage(Page<?> page, UserTitle userTitle);

	/**
	 * 不分页查询
	 * @param userTitle
	 * @return List<UserTitle>
	 */
	public List<UserTitle> selectUserTitleList(UserTitle userTitle);

    /**
     * 根据id查询用户职务
     * @param id
     * @return UserTitle
     */
	public UserTitle selectUserTitleById(Integer id);

    /**
     * 插入用户职务
     * @param userTitle
     * @return Integer
     */
	public Integer insertUserTitle(UserTitle userTitle);

	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserTitleById(Integer id);

    /**
     * 修改用户职务
     * @param userTitle
     * @return Integer
     */
	public Integer modifyUserTitle(UserTitle userTitle);

}