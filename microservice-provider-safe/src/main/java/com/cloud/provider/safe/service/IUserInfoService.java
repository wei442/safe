package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.rest.request.page.UserInfoPageRequest;
import com.github.pagehelper.Page;

public interface IUserInfoService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserInfo>
	 */
	public List<UserInfo> selectListByPage(Page<?> page, UserInfoPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserInfo>
	 */
	public List<UserInfo> selectList(UserInfoPageRequest param);

//	/**
//	 * 根据orgId查询当前组织机构下的所有人员
//	 * @param param
//	 * @return List<UserInfoVo>
//	 */
//	public List<UserInfoOrgVo> selectListByOrgId(UserParam param);

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
	public UserInfo selectById(Integer id);

	/**
	 * 根据userAccount查询用户信息
	 * @param userAccount
	 * @return UserInfo
	 */
	public UserInfo selectByUserAccount(String userAccount);

    /**
     * 插入用户信息
     * @param userInfo
     * @return Integer
     */
	public Integer insert(UserInfo userInfo);

 	/**
  	 * 根据id删除用户信息
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户信息
     * @param userInfo
     * @return Integer
     */
	public Integer modify(UserInfo userInfo);

}