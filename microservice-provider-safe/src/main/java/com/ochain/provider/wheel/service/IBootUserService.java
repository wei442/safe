package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.UserParam;
import com.ochain.provider.wheel.po.UserInfo;
import com.ochain.provider.wheel.vo.user.UserAccountCalcluateVo;
import com.ochain.provider.wheel.vo.user.UserAccountVo;
import com.ochain.provider.wheel.vo.user.UserCalcluateListVo;
import com.ochain.provider.wheel.vo.user.UserVo;

/**
 * 用户的接口IBootUserService
 * @author wei.yong
 * @date 2017/3/1
 */
public interface IBootUserService {

 	/**
	 * 分页查询
	 * @param page
	 * @param userInfo
	 * @return List<UserInfo>
	 * @throws BootServiceException
	 */
	public List<UserInfo> selectUserInfoListByPage(Page<UserInfo> page, UserInfo userInfo) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param userInfo
	 * @return List<UserInfo>
	 * @throws BootServiceException
	 */
	public List<UserInfo> selectUserInfoList(UserInfo userInfo) throws BootServiceException;

	/**
	 * 根据status查询用户信息列表
	 * @param status
	 * @return List<UserInfo>
	 * @throws BootServiceException
	 */
	public List<UserInfo> selectUserInfoListByStatus(Integer status) throws BootServiceException;

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return UserInfo
	 * @throws BootServiceException
	 */
	public UserInfo selectUserInfoById(Integer id) throws BootServiceException;

	/**
	 * 根据userAccount查询用户信息
	 * @param userAccount
	 * @return UserInfo
	 * @throws BootServiceException
	 */
	public UserInfo selectUserInfoByUserAccount(String userAccount) throws BootServiceException;

	/**
	 * 根据gId查询用户信息
	 * @param gId
	 * @return UserInfo
	 * @throws BootServiceException
	 */
	public UserInfo selectUserInfoByGId(String gId) throws BootServiceException;

	/**
	 * 插入用户信息
	 * @param userInfo
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertUserInfo(UserInfo userInfo) throws BootServiceException;

	/**
	 * 插入用户信息和用户账户
	 * @param userInfo
	 * @return UserVo
	 * @throws BootServiceException
	 */
	public UserVo insertUser(UserInfo userInfo) throws BootServiceException;

	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyUserInfo(UserInfo userInfo) throws BootServiceException;

	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer deleteUserInfoById(Integer id) throws BootServiceException;

	/**
	 * 分页查询用户信息/账户/账户日志列表
	 * @param page
	 * @param param
	 * @return List<UserAccountVo>
	 * @throws BootServiceException
	 */
	public List<UserAccountVo> selectUserAccountVoListByPage(Page<UserInfo> page, UserParam param) throws BootServiceException;

	/**
	 * 分页查询用户信息/账户算力/账户算力日志列表
	 * @param page
	 * @param param
	 * @return List<UserAccountCalcluateVo>
	 * @throws BootServiceException
	 */
	public List<UserAccountCalcluateVo> selectUserAccountCalcluateVoListByPage(Page<UserInfo> page, UserParam param) throws BootServiceException;

	/**
	 * 分页查询用户信息/账户算力列表
	 * @param page
	 * @param param
	 * @return List<UserAccountCalcluateVo>
	 * @throws BootServiceException
	 */
	public List<UserCalcluateListVo> selectUserCalcluateListByPage(Page<UserInfo> page, UserParam param) throws BootServiceException;
}