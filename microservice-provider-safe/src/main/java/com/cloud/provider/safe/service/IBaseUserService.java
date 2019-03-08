package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.BaseUser;
import com.cloud.provider.safe.rest.request.page.BaseUserPageRequest;
import com.github.pagehelper.Page;

public interface IBaseUserService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUser>
	 */
	public List<BaseUser> selectBaseUserListByPage(Page<?> page, BaseUserPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<BaseUser>
	 */
	public List<BaseUser> selectBaseUserList(BaseUserPageRequest param);

    /**
     * 根据id查询用户信息
     * @param id
     * @return BaseUser
     */
	public BaseUser selectBaseUserById(Integer id);

    /**
     * 插入用户信息
     * @param baseUser
     * @return Integer
     */
	public Integer insertBaseUser(BaseUser baseUser);

 	/**
  	 * 根据id删除基础用户
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteBaseUserById(Integer id);

    /**
     * 修改用户信息
     * @param baseUser
     * @return Integer
     */
	public Integer modifyBaseUser(BaseUser baseUser);

}