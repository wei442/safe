package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.DiamondConfig;

public interface IBootDiamondConfigService {

	/**
	 * 分页查询
	 * @param page
	 * @param diamondConfig
	 * @return List<DiamondConfig>
	 * @throws BootServiceException
	 */
	public List<DiamondConfig>selectDiamondConfigListByPage(Page<DiamondConfig> page, DiamondConfig diamondConfig) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param diamondConfig
	 * @return List<DiamondConfig>
	 * @throws BootServiceException
	 */
	public List<DiamondConfig> selectDiamondConfigList(DiamondConfig diamondConfig) throws BootServiceException;

	/**
	 * 根据id查询算力配置表信息
	 * @param id
	 * @return DiamondConfig
	 * @throws BootServiceException
	 */
	public DiamondConfig selectDiamondConfigById(Integer id) throws BootServiceException;

	/**
	 * 根据code查询机构模板
	 * @param code
	 * @return DiamondConfig
	 * @throws BootServiceException
	 */
	public DiamondConfig selectDiamondConfigByCode(String code) throws BootServiceException;

	/**
	 * 新增算力配置数据
	 * @param DiamondConfig
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertDiamondConfig(DiamondConfig calculateConfig) throws BootServiceException;

	/**
	 * 修改算力配置数据
	 * @param DiamondConfig
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyDiamondConfig(DiamondConfig calculateConfig) throws BootServiceException;

}