package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.FeeConfig;

public interface IBootFeeConfigService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param feeConfig
  	 * @return List<FeeConfig>
  	 * @throws BootServiceException
  	 */
  	public List<FeeConfig> selectFeeConfigListByPage(Page<FeeConfig> page, FeeConfig feeConfig) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param feeConfig
  	 * @return List<FeeConfig>
  	 * @throws BootServiceException
  	 */
  	public List<FeeConfig> selectFeeConfigList(FeeConfig feeConfig) throws BootServiceException;

  	/**
  	 * 根据id查询手续费配置
  	 * @param id
  	 * @return FeeConfig
  	 * @throws BootServiceException
  	 */
  	public FeeConfig selectFeeConfigById(Integer id) throws BootServiceException;

  	/**
  	 * 根据feeCode查询手续费配置
  	 * @param feeCode
  	 * @return FeeConfig
  	 * @throws BootServiceException
  	 */
  	public FeeConfig selectFeeConfigByFeeCode(String feeCode) throws BootServiceException;

  	/**
  	 * 插入手续费配置
  	 * @param feeConfig
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer insertFeeConfig(FeeConfig feeConfig) throws BootServiceException;

  	/**
  	 * 修改手续费配置
  	 * @param feeConfig
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer modifyFeeConfig(FeeConfig feeConfig) throws BootServiceException;

  	/**
  	 * 根据id删除手续费配置
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer deleteFeeConfigById(Integer id) throws BootServiceException;

}