package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.DiamondConfigMapper;
import com.ochain.provider.wheel.po.DiamondConfig;
import com.ochain.provider.wheel.po.DiamondConfigExample;
import com.ochain.provider.wheel.service.IBootDiamondConfigService;
import com.ochain.provider.wheel.vo.diamond.DiamondConfigMaxCodeVo;

@Service
public class BootDiamondConfigServiceImpl implements IBootDiamondConfigService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//能量配置 Mapper
	@Autowired
	private DiamondConfigMapper diamondConfigMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param diamondConfig
	 * @return List<DiamondConfig>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondConfig>selectDiamondConfigListByPage(Page<DiamondConfig> page, DiamondConfig diamondConfig) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectDiamondConfigListByPage)-分页查询-传入参数, page:{}, diamondConfig:{}", page, diamondConfig);
		DiamondConfigExample example = new DiamondConfigExample();
		DiamondConfigExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_DIAMOND_CONFIG_IS_DELETE_NO);
		if(diamondConfig != null) {
		}

		List<DiamondConfig> list = null;
		try {
			list = diamondConfigMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-selectDiamondConfigListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param diamondConfig
	 * @return List<DiamondConfig>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondConfig> selectDiamondConfigList(DiamondConfig diamondConfig) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectDiamondConfigList)-不分页查询-传入参数, diamondConfig:{}", diamondConfig);
		DiamondConfigExample example = new DiamondConfigExample();
		DiamondConfigExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_DIAMOND_CONFIG_IS_DELETE_NO);
		if(diamondConfig != null) {

		}
		List<DiamondConfig> list = null;
		try {
			list = diamondConfigMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-selectDiamondConfigList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询能量配置表信息
	 * @param id
	 * @return DiamondConfig
	 * @throws BootServiceException
	 */
	@Override
	public DiamondConfig selectDiamondConfigById(Integer id) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectDiamondConfigById)-根据id查询能量配置表信息-传入参数, id:{}", id);
		DiamondConfig diamondConfig = null;
		try {
			diamondConfig = diamondConfigMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-selectDiamondConfigById)-根据id查询能量配置表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return diamondConfig;
	}

	/**
	 * 根据code查询机构模板
	 * @param code
	 * @return DiamondConfig
	 * @throws BootServiceException
	 */
	@Override
	public DiamondConfig selectDiamondConfigByCode(String code) throws BootServiceException {
		logger.info("(BootDiamondConfigService-selectDiamondConfigByCode)-根据编码code查询能量配置表信息-传入参数, code:{}", code);
		DiamondConfigExample example = new DiamondConfigExample();
		DiamondConfigExample.Criteria criteria = example.createCriteria();
		criteria.andDiamondCodeEqualTo(code);
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);

		List<DiamondConfig> list = null;
		try {
			list = diamondConfigMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-selectDiamondConfigByCode)-根据编码code查询能量配置表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		DiamondConfig diamondConfig = null;
		if(list != null && !list.isEmpty()) {
			diamondConfig = list.get(0);
		}
		return diamondConfig;
	}

	/**
	 * 新增能量配置数据
	 * @param DiamondConfig
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertDiamondConfig(DiamondConfig diamondConfig) throws BootServiceException {
		logger.info("(BootDiamondConfigService-insertDiamondConfig)-插入能量配置数据-传入参数, diamondConfig:{}", diamondConfig);
		diamondConfig.setCreateTime(new Date());
		diamondConfig.setUpdateTime(new Date());
		diamondConfig.setDiamondCode(this.getMaxDiamondCode());
		int i = 0;
		try{
			i = diamondConfigMapper.insertSelective(diamondConfig);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-insertDiamondConfig)-插入能量配置数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 修改能量配置数据
	 * @param DiamondConfig
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyDiamondConfig(DiamondConfig diamondConfig) throws BootServiceException {
		logger.info("(BootDiamondConfigService-modifyDiamondConfig)-修改能量配置数据-传入参数, diamondConfig:{}", diamondConfig);
		diamondConfig.setUpdateTime(new Date());
		int i = 0;
		try{
			i = diamondConfigMapper.updateByPrimaryKeySelective(diamondConfig);
		} catch (Exception e) {
			logger.error("(BootDiamondConfigService-modifyDiamondConfig)-修改能量配置数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 获取最新code
	 * @return String
	 */
	public String getMaxDiamondCode()  throws BootServiceException {
		DiamondConfigMaxCodeVo diamondConfigMaxCodeVo = null;
		try {
			diamondConfigMaxCodeVo = diamondConfigMapper.selectMaxDiamondCode();
			logger.info("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-获取能量配置表最大编码code信息-返回信息, diamondConfigMaxCodeVo:{}", diamondConfigMaxCodeVo);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-获取能量配置表最大编码code信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		String code = "";
		if(diamondConfigMaxCodeVo != null) {
			String oldCode = diamondConfigMaxCodeVo.getMaxCode();
			logger.info("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-查询数据库得到的最新编码code值, lastCode:{}", oldCode);
			//加一
			String oldNumString = oldCode.replace(WheelConstants.DIAMOND_CONFIG_CODE_PREFIX, code);
			Integer num = Integer.parseInt(oldNumString) + 1;
			String newNum = num.toString();
			if(oldNumString.length() > newNum.toString().length()) {
				int len = oldNumString.length() - newNum.toString().length();
				if(len == 3) {
					newNum = "000" + newNum;
				}else if(len == 2) {
					newNum = "00" + newNum;
				}else if(len == 1) {
					newNum = "0" + newNum;
				}
			}
			code = WheelConstants.DIAMOND_CONFIG_CODE_PREFIX + newNum;
		}else if(diamondConfigMaxCodeVo == null) {
			code = WheelConstants.DIAMOND_CONFIG_CODE_PREFIX + WheelConstants.DIAMOND_CONFIG_CODE_START;
		}
		logger.info("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-计算得到的最新编码code值, newCode:{}", code);
		return code;

	}
}