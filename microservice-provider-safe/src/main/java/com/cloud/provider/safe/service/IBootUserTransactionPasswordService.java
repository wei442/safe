package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.UserTransactionPassword;

public interface IBootUserTransactionPasswordService {

	/**
	 * 分页查询
	 * @param page
	 * @param UserTransactionPassword
	 * @return List<UserTransactionPassword>
	 * @throws BootServiceException
	 */
	public List<UserTransactionPassword>selectUserTransactionPasswordListByPage(Page<UserTransactionPassword> page, UserTransactionPassword userTransactionPassword) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param UserTransactionPasswordVo
	 * @return List<UserTransactionPassword>
	 * @throws BootServiceException
	 */
	public List<UserTransactionPassword> selectUserTransactionPasswordList(UserTransactionPassword userTransactionPassword) throws BootServiceException;

	/**
	 * 根据id查询用户交易密码表信息
	 * @param id
	 * @return UserTransactionPassword
	 * @throws BootServiceException
	 */
	public UserTransactionPassword selectUserTransactionPasswordById(Integer id) throws BootServiceException;

	/**
	 * 根据userId查询用户交易密码
	 * @param userId
	 * @return UserTransactionPassword
	 * @throws BootServiceException
	 */
	public UserTransactionPassword selectUserTransactionPasswordByUserId(Integer userId) throws BootServiceException;

	/**
	 * 新增用户交易密码数据
	 * @param UserTransactionPassword
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertUserTransactionPassword(UserTransactionPassword userTransactionPassword) throws BootServiceException;

	/**
	 * 修改用户交易密码数据
	 * @param UserTransactionPassword
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyUserTransactionPassword(UserTransactionPassword userTransactionPassword) throws BootServiceException;

	/**
	 * 重设用户交易密码
	 * @param userId
	 * @param newPassword
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer resetUserTransactionPassword(Integer userId,String newPassword) throws BootServiceException;

}