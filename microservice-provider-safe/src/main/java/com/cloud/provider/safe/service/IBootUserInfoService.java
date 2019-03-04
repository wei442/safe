package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserInfo;
import com.github.pagehelper.Page;

public interface IBootUserInfoService {

    /**
	 * 分页查询
	 * @param page
	 * @param userInfo
	 * @return List<UserInfo>
	 */
	public List<UserInfo> selectUserInfoListByPage(Page<?> page, UserInfo userInfo);

	/**
	 * 不分页查询
	 * @param userInfo
	 * @return List<UserInfo>
	 */
	public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
	public UserInfo selectUserInfoById(Integer id);

    /**
     * 插入用户信息
     * @param userInfo
     * @return Integer
     */
	public Integer insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     * @return Integer
     */
	public Integer modifyUserInfo(UserInfo userInfo);

}