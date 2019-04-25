package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.BaseUserPassword;

public interface IBaseUserPasswordService {

    /**
     * 根据id查询基础用户密码
     * @param id
     * @return BaseUserPassword
     */
	public BaseUserPassword selectById(Integer id);

	/**
	 * 根据baseUserId查询基础用户密码
	 * @param  baseUserId
	 * @return BaseUserPassword
	 */
	public BaseUserPassword selectByBaseUserId(Integer baseUserId);

	/**
	 * 根据baseUserId和password查询基础用户密码
	 * @param  baseUserId
	 * @param  password
	 * @return BaseUserPassword
	 */
	public BaseUserPassword selectByBaseUserIdPassword(Integer baseUserId,String password);

    /**
     * 插入基础用户密码
     * @param baseUserPassword
     * @return Integer
     */
	public Integer insert(BaseUserPassword baseUserPassword);

	/**
  	 * 根据id删除基础用户密码
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改基础用户密码
     * @param baseUserPassword
     * @return Integer
     */
	public Integer modify(BaseUserPassword baseUserPassword);

}