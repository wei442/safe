package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.rest.request.page.base.user.BaseUserInfoPageRequest;
import com.github.pagehelper.Page;

public interface IBaseUserInfoService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUserInfo>
	 */
	public List<BaseUserInfo> selectListByPage(Page<?> page, BaseUserInfoPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<BaseUserInfo>
	 */
	public List<BaseUserInfo> selectList(BaseUserInfoPageRequest param);

    /**
     * 根据id查询用户信息
     * @param id
     * @return BaseUserInfo
     */
	public BaseUserInfo selectById(Integer id);

   /**
    * 根据userAccount查询基础用户信息
    * @param userAccount
    * @return BaseUserInfo
    */
	public BaseUserInfo selectByUserAccount(String userAccount);

    /**
     * 插入用户信息
     * @param baseUserInfo
     * @return Integer
     */
	public Integer insert(BaseUserInfo baseUserInfo);

 	/**
  	 * 根据id删除基础用户信息
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户信息
     * @param baseUserInfo
     * @return Integer
     */
	public Integer modify(BaseUserInfo baseUserInfo);

}