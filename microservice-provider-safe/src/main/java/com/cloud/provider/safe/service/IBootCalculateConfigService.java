package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.CalculateConfig;
import com.ochain.provider.wheel.po.CalculateConfigUpdate;

public interface IBootCalculateConfigService {

	/**
	 * 分页查询
	 * @param page
	 * @param CalculateConfigVo
	 * @return List<CalculateConfig>
	 * @throws BootServiceException
	 */
	public List<CalculateConfig>selectCalculateConfigListByPage(Page<CalculateConfig> page, CalculateConfig calculateConfig) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param CalculateConfigVo
	 * @return List<CalculateConfig>
	 * @throws BootServiceException
	 */
	public List<CalculateConfig> selectCalculateConfigList(CalculateConfig calculateConfig) throws BootServiceException;

	/**
	 * 根据算力类型正序查询算力配置列表
	 * @param calculateType
	 * @return List<CalculateConfig>
	 * @throws BootServiceException
	 */
	public List<CalculateConfig> selectCalculateConfigListByCalculateType(Integer calculateType) throws BootServiceException;

	/**
	 * 根据id查询算力配置表信息
	 * @param id
	 * @return CalculateConfig
	 * @throws BootServiceException
	 */
	public CalculateConfig selectCalculateConfigById(Integer id) throws BootServiceException;

	/**
	 * 根据code查询机构模板
	 * @param code
	 * @return CalculateConfig
	 * @throws BootServiceException
	 */
	public CalculateConfig selectCalculateConfigByCode(String code) throws BootServiceException;

	/**
	 * 根据gCode查询机构模板
	 * @param gCode
	 * @return CalculateConfig
	 * @throws BootServiceException
	 */
	//public CalculateConfig selectCalculateConfigByGCode(String gCode) throws BootServiceException;


	/**
	 * 新增算力配置数据
	 * @param CalculateConfig
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertCalculateConfig(CalculateConfig calculateConfig) throws BootServiceException;

	/**
	 * 修改算力配置数据
	 * @param CalculateConfigUpdate
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyCalculateConfig(CalculateConfigUpdate calculateConfigUpdate) throws BootServiceException;

}