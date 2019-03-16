package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.rest.request.page.BaseUserInfoPageRequest;
import com.github.pagehelper.Page;

public interface IBaseUserInfoService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<BaseUserInfo>
	 */
	public List<BaseUserInfo> selectBaseUserInfoListByPage(Page<?> page, BaseUserInfoPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<BaseUserInfo>
	 */
	public List<BaseUserInfo> selectBaseUserInfoList(BaseUserInfoPageRequest param);

    /**
     * 根据id查询用户信息
     * @param id
     * @return BaseUserInfo
     */
	public BaseUserInfo selectBaseUserInfoById(Integer id);

    /**
     * 插入用户信息
     * @param baseUserInfo
     * @return Integer
     */
	public Integer insertBaseUserInfo(BaseUserInfo baseUserInfo);

 	/**
  	 * 根据id删除基础用户信息
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteBaseUserInfoById(Integer id);

    /**
     * 修改用户信息
     * @param baseUserInfo
     * @return Integer
     */
	public Integer modifyBaseUserInfo(BaseUserInfo baseUserInfo);

}