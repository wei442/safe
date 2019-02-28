package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.UserCoinAddr;

public interface IBootUserCoinAddrService {

	/**
	 * 分页查询
	 * @param page
	 * @param UserCoinAddr
	 * @return List<UserCoinAddr>
	 * @throws BootServiceException
	 */
	public List<UserCoinAddr>selectUserCoinAddrListByPage(Page<UserCoinAddr> page, UserCoinAddr userCoinAddr) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param UserCoinAddrVo
	 * @return List<UserCoinAddr>
	 * @throws BootServiceException
	 */
	public List<UserCoinAddr> selectUserCoinAddrList(UserCoinAddr userCoinAddr) throws BootServiceException;

	/**
	 * 根据类型查询用户货币地址列表
	 * @param type
	 * @return List<UserCoinAddr>
	 * @throws BootServiceException
	 */
	public List<UserCoinAddr> selectUserCoinAddrListByType(Integer type) throws BootServiceException;

	/**
	 * 根据id查询用户账户地址表信息
	 * @param id
	 * @return UserCoinAddr
	 * @throws BootServiceException
	 */
	public UserCoinAddr selectUserCoinAddrById(Integer id) throws BootServiceException;

	/**
	 * 根据coinCode查询用户货币地址
	 * @param coinCode
	 * @return UserCoinAddr
	 * @throws BootServiceException
	 */
	public UserCoinAddr selectUserCoinAddrByCoinCode(String coinCode) throws BootServiceException;

	/**
	 * 根据publicKey查询用户货币地址
	 * @param publicKey
	 * @return UserCoinAddr
	 * @throws BootServiceException
	 */
	public UserCoinAddr selectUserCoinAddrByPublicKey(String publicKey) throws BootServiceException;

	/**
	 * 新增用户账户地址数据
	 * @param UserCoinAddr
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertUserCoinAddr(UserCoinAddr userCoinAddr) throws BootServiceException;

	/**
	 * 修改用户账户地址数据
	 * @param UserCoinAddr
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyUserCoinAddr(UserCoinAddr userCoinAddr) throws BootServiceException;

}