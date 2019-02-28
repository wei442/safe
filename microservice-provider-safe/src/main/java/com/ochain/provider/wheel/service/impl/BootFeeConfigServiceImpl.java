package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.FeeConfigMapper;
import com.ochain.provider.wheel.po.FeeConfig;
import com.ochain.provider.wheel.po.FeeConfigExample;
import com.ochain.provider.wheel.service.IBootFeeConfigService;

/**
 * 手续费配置 BootFeeConfigService
 * @author wei.yong
 * @date 2017-10-13
 */
@Service
public class BootFeeConfigServiceImpl implements IBootFeeConfigService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //手续费配置 Mapper
  	@Autowired
  	private FeeConfigMapper feeConfigMapper;

	/**
  	 * 分页查询
  	 * @param page
  	 * @param feeConfig
  	 * @return List<FeeConfig>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<FeeConfig> selectFeeConfigListByPage(Page<FeeConfig> page, FeeConfig feeConfig) throws BootServiceException {
  		logger.info("(BootFeeConfigService-selectFeeConfigListByPage)-分页查询-传入参数, page:{}, feeConfig:{}", page, feeConfig);
  		FeeConfigExample example = new FeeConfigExample();
  		example.setOrderByClause(" id desc ");
  		FeeConfigExample.Criteria criteria = example.createCriteria();
  		if(feeConfig != null) {
  		}

  		List<FeeConfig> list = null;
  		try {
  			list = feeConfigMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-selectFeeConfigListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param feeConfig
  	 * @return List<FeeConfig>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<FeeConfig> selectFeeConfigList(FeeConfig feeConfig) throws BootServiceException {
  		logger.info("(BootFeeConfigService-selectFeeConfigList)-不分页查询-传入参数, feeConfig:{}", feeConfig);
  		FeeConfigExample example = new FeeConfigExample();
  		example.setOrderByClause(" id desc ");
  		FeeConfigExample.Criteria criteria = example.createCriteria();
  		if(feeConfig != null) {
  		}

  		List<FeeConfig> list = null;
  		try {
  			list = feeConfigMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-selectFeeConfigList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据id查询手续费配置
  	 * @param id
  	 * @return FeeConfig
  	 * @throws BootServiceException
  	 */
  	@Override
	public FeeConfig selectFeeConfigById(Integer id) throws BootServiceException {
  		logger.info("(BootFeeConfigService-selectFeeConfigById)-根据id查询手续费配置-传入参数, id:{}}", id);
  		FeeConfig feeConfig = null;
  		try {
  			feeConfig = feeConfigMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-selectFeeConfigById)-根据id查询手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return feeConfig;
  	}

  	/**
  	 * 根据feeCode查询手续费配置
  	 * @param feeCode
  	 * @return FeeConfig
  	 * @throws BootServiceException
  	 */
  	public FeeConfig selectFeeConfigByFeeCode(String feeCode) throws BootServiceException {
  		logger.info("(BootFeeConfigService-selectFeeConfigByFeeCode)-根据feeCode查询手续费配置-传入参数, feeCode:{}}", feeCode);
  		FeeConfigExample example = new FeeConfigExample();
  		FeeConfigExample.Criteria criteria = example.createCriteria();
  		criteria.andFeeCodeEqualTo(feeCode);

  		List<FeeConfig> list = null;
  		try {
  			list = feeConfigMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-selectFeeConfigByFeeCode)-根据feeCode查询手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		FeeConfig feeConfig = null;
  		if(list != null && !list.isEmpty()) {
  			feeConfig = list.get(0);
  		}
  		return feeConfig;
  	}

  	/**
  	 * 插入手续费配置
  	 * @param feeConfig
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer insertFeeConfig(FeeConfig feeConfig) throws BootServiceException {
  		logger.info("(BootFeeConfigService-insertFeeConfig)-插入手续费配置-传入参数, feeConfig:{}}", feeConfig);
  		feeConfig.setCreateTime(new Date());
  		feeConfig.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = feeConfigMapper.insertSelective(feeConfig);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-insertFeeConfig)-插入手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改手续费配置
  	 * @param feeConfig
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer modifyFeeConfig(FeeConfig feeConfig) throws BootServiceException {
  		logger.info("(BootFeeConfigService-modifyFeeConfig)-修改手续费配置-传入参数, feeConfig:{}}", feeConfig);
  		feeConfig.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = feeConfigMapper.updateByPrimaryKeySelective(feeConfig);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-modifyFeeConfig)-修改手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除手续费配置
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer deleteFeeConfigById(Integer id) throws BootServiceException {
  		logger.info("(BootFeeConfigService-deleteFeeConfigById)-根据id删除手续费配置-传入参数, id:{}}", id);
  		int i = 0;
  		try {
  			i = feeConfigMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootFeeConfigService-deleteFeeConfigById)-根据id删除手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

}