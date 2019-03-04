package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserOrg;
import com.github.pagehelper.Page;

public interface IBootUserOrgService {

    /**
	 * 分页查询
	 * @param page
	 * @param userOrg
	 * @return List<UserOrg>
	 */
	public List<UserOrg> selectUserOrgListByPage(Page<?> page, UserOrg userOrg);

	/**
	 * 不分页查询
	 * @param userOrg
	 * @return List<UserOrg>
	 */
	public List<UserOrg> selectUserOrgList(UserOrg userOrg);

    /**
     * 根据id查询用户机构
     * @param id
     * @return UserOrg
     */
	public UserOrg selectUserOrgById(Integer id);

    /**
     * 插入用户机构
     * @param userOrg
     * @return Integer
     */
	public Integer insertUserOrg(UserOrg userOrg);

	/**
  	 * 根据id删除用户机构
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserOrgById(Integer id);

    /**
     * 修改用户机构
     * @param userOrg
     * @return Integer
     */
	public Integer modifyUserOrg(UserOrg userOrg);

}