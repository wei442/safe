package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.UserCalculateConfigParam;
import com.ochain.provider.wheel.po.UserCalculateConfig;
import com.ochain.provider.wheel.vo.user.UserCalculateConfigContentVo;

public interface IBootUserCalculateConfigService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param userCalculateConfig
  	 * @return List<UserCalculateConfig>
  	 * @throws BootServiceException
  	 */
  	public List<UserCalculateConfig> selectUserCalculateConfigListByPage(Page<UserCalculateConfig> page, UserCalculateConfig userCalculateConfig) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param userCalculateConfig
  	 * @return List<UserCalculateConfig>
  	 * @throws BootServiceException
  	 */
  	public List<UserCalculateConfig> selectUserCalculateConfigList(UserCalculateConfig userCalculateConfig) throws BootServiceException;

  	/**
  	 * 根据id查询用户算力配置
  	 * @param id
  	 * @return UserCalculateConfig
  	 * @throws BootServiceException
  	 */
  	public UserCalculateConfig selectUserCalculateConfigById(Long id) throws BootServiceException;

  	/**
  	 * 根据userId和calculateCode查询用户算力配置
  	 * @param userId
  	 * @param calculateCode
  	 * @return UserCalculateConfig
  	 * @throws BootServiceException
  	 */
  	public UserCalculateConfig selectUserCalculateConfigByUserId(Integer userId,String calculateCode) throws BootServiceException;

  	/**
  	 * 插入用户算力配置
  	 * @param userCalculateConfig
  	 * @param sourceType
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
	public Integer insertUserCalculateConfig(UserCalculateConfig userCalculateConfig,Integer sourceType) throws BootServiceException;

  	/**
  	 * 修改用户算力配置
  	 * @param userCalculateConfig
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer modifyUserCalculateConfig(UserCalculateConfig userCalculateConfig) throws BootServiceException;

  	/**
  	 * 根据id删除用户算力配置
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer deleteUserCalculateConfigById(Long id) throws BootServiceException;

  	/**
     * 根据userId查询用户配置列表
     * @param param
     * @return List<UserCalculateConfigVo>
     */
  	public List<UserCalculateConfigContentVo> selectUserCalculateConfigContentListByUserId(UserCalculateConfigParam param) throws BootServiceException;

}