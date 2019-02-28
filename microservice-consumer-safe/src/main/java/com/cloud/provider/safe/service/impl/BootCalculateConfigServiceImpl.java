package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.CalculateConfigMapper;
import com.ochain.provider.wheel.po.CalculateConfig;
import com.ochain.provider.wheel.po.CalculateConfigExample;
import com.ochain.provider.wheel.po.CalculateConfigUpdate;
import com.ochain.provider.wheel.service.IBootCalculateConfigService;
import com.ochain.provider.wheel.vo.calculate.CalculateConfigMaxCodeVo;

@Service
public class BootCalculateConfigServiceImpl implements IBootCalculateConfigService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//算力配置 Mapper
	@Autowired
	private CalculateConfigMapper calculateConfigMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param CalculateConfigVo
	 * @return List<CalculateConfig>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateConfig> selectCalculateConfigListByPage(Page<CalculateConfig> page, CalculateConfig calculateConfig) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-selectCalculateConfigListByPage)-分页查询-传入参数, page:{}, calculateConfig:{}", page, calculateConfig);
		CalculateConfigExample example = new CalculateConfigExample();
		example.setOrderByClause(" id desc ");
		CalculateConfigExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);
		if(calculateConfig != null) {
			if(calculateConfig.getCalculateCode() != null) {
				criteria.andCalculateCodeEqualTo(calculateConfig.getCalculateCode());
			}
			if(calculateConfig.getCalculateName() != null) {
				criteria.andCalculateNameEqualTo(calculateConfig.getCalculateName());
			}
			if(calculateConfig.getCalculateType() != null) {
				criteria.andCalculateTypeEqualTo(calculateConfig.getCalculateType());
			}
			if(calculateConfig.getIsUse() != null) {
				criteria.andIsUseEqualTo(calculateConfig.getIsUse());
			}
		}

		List<CalculateConfig> list = null;
		try {
			list = calculateConfigMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-selectCalculateConfigListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param CalculateConfigVo
	 * @return List<CalculateConfig>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateConfig> selectCalculateConfigList(CalculateConfig calculateConfig) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-selectCalculateConfigList)-不分页查询-传入参数, calculateConfig:{}", calculateConfig);
		CalculateConfigExample example = new CalculateConfigExample();
		example.setOrderByClause(" id desc ");
		CalculateConfigExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);
		if(calculateConfig != null) {
			if(calculateConfig.getCalculateCode() != null) {
				criteria.andCalculateCodeEqualTo(calculateConfig.getCalculateCode());
			}
			if(calculateConfig.getCalculateName() != null) {
				criteria.andCalculateNameEqualTo(calculateConfig.getCalculateName());
			}
			if(calculateConfig.getCalculateType() != null) {
				criteria.andCalculateTypeEqualTo(calculateConfig.getCalculateType());
			}
			if(calculateConfig.getIsUse() != null) {
				criteria.andIsUseEqualTo(calculateConfig.getIsUse());
			}
		}
		List<CalculateConfig> list = null;
		try {
			list = calculateConfigMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-selectCalculateConfigList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据算力类型正序查询算力配置列表
	 * @param calculateType
	 * @return List<CalculateConfig>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateConfig> selectCalculateConfigListByCalculateType(Integer calculateType) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-selectCalculateConfigList)-根据算力类型正序查询算力配置列表-传入参数, calculateType:{}", calculateType);
		CalculateConfigExample example = new CalculateConfigExample();
		example.setOrderByClause(" id asc ");
		CalculateConfigExample.Criteria criteria = example.createCriteria();
		criteria.andIsUseEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_USE_YES);
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);
		criteria.andCalculateTypeEqualTo(calculateType);
		List<CalculateConfig> list = null;
		try {
			list = calculateConfigMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-selectCalculateConfigListByCalculateType)-根据算力类型正序查询算力配置列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询算力配置表信息
	 * @param id
	 * @return CalculateConfig
	 * @throws BootServiceException
	 */
	@Override
	public CalculateConfig selectCalculateConfigById(Integer id) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-selectCalculateConfigById)-根据id查询算力配置表信息-传入参数, id:{}", id);
		CalculateConfig calculateConfig = null;
		try {
			calculateConfig = calculateConfigMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-selectCalculateConfigById)-根据id查询算力配置表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return calculateConfig;
	}

	/**
	 * 根据code查询算力配置
	 * @param code
	 * @return CalculateConfig
	 * @throws BootServiceException
	 */
	@Override
	public CalculateConfig selectCalculateConfigByCode(String code) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-selectCalculateConfigByCode)-根据编码code查询算力配置表信息-传入参数, code:{}", code);
		CalculateConfigExample example = new CalculateConfigExample();
		CalculateConfigExample.Criteria criteria = example.createCriteria();
		criteria.andCalculateCodeEqualTo(code);
		criteria.andIsUseEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_USE_YES);
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);
		List<CalculateConfig> list = null;
		try {
			list = calculateConfigMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-selectCalculateConfigByCode)-根据编码code查询算力配置表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		CalculateConfig calculateConfig = null;
		if(list != null && !list.isEmpty()) {
			calculateConfig = list.get(0);
		}
		return calculateConfig;
	}

	/**
	 * 新增算力配置数据
	 * @param CalculateConfigRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertCalculateConfig(CalculateConfig calculateConfig) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-insertCalculateConfig)-插入算力配置数据-传入参数, calculateConfig:{}", calculateConfig);
		calculateConfig.setCalculateCode(this.getMaxCalculateCode());
		calculateConfig.setCreateTime(new Date());
		calculateConfig.setUpdateTime(new Date());
		int i = 0;
		try{
			i = calculateConfigMapper.insertSelective(calculateConfig);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-insertCalculateConfig)-插入算力配置数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 修改算力配置数据
	 * @param CalculateConfigRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyCalculateConfig(CalculateConfigUpdate calculateConfigUpdate) throws BootServiceException {
		logger.info("(BootCalculateConfigServiceImpl-modifyCalculateConfig)-修改算力配置数据-传入参数, calculateConfigUpdate:{}", calculateConfigUpdate);
		calculateConfigUpdate.setUpdateTime(new Date());
		int i = 0;
		try{
			i = calculateConfigMapper.updateForContent(calculateConfigUpdate);
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-modifyCalculateConfig)-修改算力配置数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
	public String getMaxCalculateCode()  throws BootServiceException {
		CalculateConfigMaxCodeVo calculateConfigMaxCodeVo = null;
		try {
			calculateConfigMaxCodeVo = calculateConfigMapper.selectMaxCalculateCode();
		} catch (Exception e) {
			logger.error("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-获取算力配置表最大编码code信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		String code = "";
		if(calculateConfigMaxCodeVo != null) {
			String oldCode = calculateConfigMaxCodeVo.getMaxCode();
			logger.info("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-查询数据库得到的最新编码code值, lastCode:{}", oldCode);
			//加一
			String oldNumString = StringUtils.removeStart(oldCode, WheelConstants.CALCULATE_CONFIG_CODE_PREFIX);
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
			code = WheelConstants.CALCULATE_CONFIG_CODE_PREFIX + newNum;
		}else if(calculateConfigMaxCodeVo == null) {
			code = WheelConstants.CALCULATE_CONFIG_CODE_PREFIX + WheelConstants.CALCULATE_CONFIG_CODE_START;
		}
		logger.info("(BootCalculateConfigServiceImpl-getMaxCalculateCode)-计算得到的最新编码code值, newCode:{}", code);
		return code;
	}

}