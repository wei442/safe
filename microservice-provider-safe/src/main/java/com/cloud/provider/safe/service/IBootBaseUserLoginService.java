package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.BaseUserLogin;
import com.github.pagehelper.Page;

public interface IBootBaseUserLoginService {

    /**
	 * 分页查询
	 * @param page
	 * @param baseUserLogin
	 * @return List<BaseUserLogin>
	 */
	public List<BaseUserLogin> selectBaseUserLoginListByPage(Page<?> page, BaseUserLogin baseUserLogin);

	/**
	 * 不分页查询
	 * @param baseUserLogin
	 * @return List<BaseUserLogin>
	 */
	public List<BaseUserLogin> selectBaseUserLoginList(BaseUserLogin baseUserLogin);

    /**
     * 根据id查询基础用户登录
     * @param id
     * @return BaseUserLogin
     */
	public BaseUserLogin selectBaseUserLoginById(Integer id);

    /**
     * 插入基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	public Integer insertBaseUserLogin(BaseUserLogin baseUserLogin);

 	/**
  	 * 根据id删除基础用户登录
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteBaseUserLoginById(Integer id);

    /**
     * 修改基础用户登录
     * @param baseUserLogin
     * @return Integer
     */
	public Integer modifyBaseUserLogin(BaseUserLogin baseUserLogin);

}