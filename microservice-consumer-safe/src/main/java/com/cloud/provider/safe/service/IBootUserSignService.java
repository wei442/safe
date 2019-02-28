package com.ochain.provider.wheel.service;

import java.util.Date;
import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.UserSign;

public interface IBootUserSignService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param userSign
  	 * @return List<UserSign>
  	 * @throws BootServiceException
  	 */
  	public List<UserSign> selectUserSignListByPage(Page<UserSign> page, UserSign userSign) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param userSign
  	 * @return List<UserSign>
  	 * @throws BootServiceException
  	 */
  	public List<UserSign> selectUserSignList(UserSign userSign) throws BootServiceException;

  	/**
  	 * 根据userId、signTimeStart和signTimeEnd查询条数
  	 * @param userId
  	 * @param signTimeStart
  	 * @param signTimeEnd
  	 * @return Long
  	 * @throws BootServiceException
  	 */
	public Long selectRowsByUserIdSignTime(Integer userId,Date signTimeStart, Date signTimeEnd) throws BootServiceException;

  	/**
  	 * 根据排名时间开始和结束时间查询用户签到列表
  	 * @param signTimeStart
  	 * @param signTimeEnd
  	 * @return List<UserSign>
  	 * @throws BootServiceException
  	 */
  	public List<UserSign> selectUserSignListBySignTime(Date signTimeStart, Date signTimeEnd) throws BootServiceException;

  	/**
  	 * 根据id查询用户签到
  	 * @param id
  	 * @return UserSign
  	 * @throws BootServiceException
  	 */
  	public UserSign selectUserSignById(Long id) throws BootServiceException;

  	/**
  	 * 根据userId和signTimeStr查询用户签到
  	 * @param userId
  	 * @param signTimeStr
  	 * @return UserSign
  	 * @throws BootServiceException
  	 */
  	public UserSign selectUserSignByUserId(Integer userId,String signTimeStr) throws BootServiceException;

  	/**
  	 * 插入用户签到
  	 * @param userSign
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer insertUserSign(UserSign userSign) throws BootServiceException;

  	/**
  	 * 修改用户签到
  	 * @param userSign
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer modifyUserSign(UserSign userSign) throws BootServiceException;

  	/**
  	 * 根据id删除用户签到
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer deleteUserSignById(Long id) throws BootServiceException;

}