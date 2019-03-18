package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.rest.request.page.UserOrgPageRequest;
import com.github.pagehelper.Page;

public interface IUserOrgService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserOrg>
	 */
	public List<UserOrg> selectListByPage(Page<?> page, UserOrgPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserOrg>
	 */
	public List<UserOrg> selectList(UserOrgPageRequest param);

    /**
     * 根据id查询用户机构
     * @param id
     * @return UserOrg
     */
	public UserOrg selectById(Integer id);

	/**
	 * 根据userId查询用户机构
	 * @param userId
	 * @return UserOrg
	 */
	public UserOrg selectByUserId(Integer userId);

    /**
     * 插入用户机构
     * @param userOrg
     * @return Integer
     */
	public Integer insert(UserOrg userOrg);

	/**
  	 * 根据id删除用户机构
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户机构
     * @param userOrg
     * @return Integer
     */
	public Integer modify(UserOrg userOrg);

}