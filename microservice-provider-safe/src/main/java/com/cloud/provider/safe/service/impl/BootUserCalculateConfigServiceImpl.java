package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.UserCalculateConfigMapper;
import com.ochain.provider.wheel.param.UserCalculateConfigParam;
import com.ochain.provider.wheel.po.UserCalculateConfig;
import com.ochain.provider.wheel.po.UserCalculateConfigExample;
import com.ochain.provider.wheel.service.IBootUserCalculateConfigService;
import com.ochain.provider.wheel.vo.user.UserCalculateConfigContentVo;

/**
 * 用户算力配置 BootUserCalculateConfigService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootUserCalculateConfigServiceImpl implements IBootUserCalculateConfigService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户算力配置 Mapper
  	@Autowired
  	private UserCalculateConfigMapper userCalculateConfigMapper;

	/**
  	 * 分页查询
  	 * @param page
  	 * @param userCalculateConfig
  	 * @return List<UserCalculateConfig>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<UserCalculateConfig> selectUserCalculateConfigListByPage(Page<UserCalculateConfig> page, UserCalculateConfig userCalculateConfig) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-selectUserCalculateConfigListByPage)-分页查询-传入参数, page:{}, userCalculateConfig:{}", page, userCalculateConfig);
  		UserCalculateConfigExample example = new UserCalculateConfigExample();
  		example.setOrderByClause(" id desc ");
  		UserCalculateConfigExample.Criteria criteria = example.createCriteria();
  		if(userCalculateConfig != null) {
  		}

  		List<UserCalculateConfig> list = null;
  		try {
  			list = userCalculateConfigMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-selectUserCalculateConfigListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param userCalculateConfig
  	 * @return List<UserCalculateConfig>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<UserCalculateConfig> selectUserCalculateConfigList(UserCalculateConfig userCalculateConfig) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-selectUserCalculateConfigList)-不分页查询-传入参数, userCalculateConfig:{}", userCalculateConfig);
  		UserCalculateConfigExample example = new UserCalculateConfigExample();
  		example.setOrderByClause(" id desc ");
  		UserCalculateConfigExample.Criteria criteria = example.createCriteria();
  		if(userCalculateConfig != null) {
  		}

  		List<UserCalculateConfig> list = null;
  		try {
  			list = userCalculateConfigMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-selectUserCalculateConfigList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据id查询用户算力配置
  	 * @param id
  	 * @return UserCalculateConfig
  	 * @throws BootServiceException
  	 */
  	@Override
	public UserCalculateConfig selectUserCalculateConfigById(Long id) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-selectUserCalculateConfigById)-根据id查询用户算力配置-传入参数, id:{}", id);
  		UserCalculateConfig userCalculateConfig = null;
  		try {
  			userCalculateConfig = userCalculateConfigMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-selectUserCalculateConfigById)-根据id查询用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return userCalculateConfig;
  	}

  	/**
  	 * 根据userId和calculateCode查询用户算力配置
  	 * @param userId
  	 * @param calculateCode
  	 * @return UserCalculateConfig
  	 * @throws BootServiceException
  	 */
  	@Override
	public UserCalculateConfig selectUserCalculateConfigByUserId(Integer userId,String calculateCode) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-selectUserCalculateConfigByUserId)-根据userId和calculateCode查询用户算力配置-传入参数, userId:{}, calculateCode:{}", userId, calculateCode);
  		UserCalculateConfigExample example = new UserCalculateConfigExample();
//  		example.setOrderByClause(" id desc ");
  		UserCalculateConfigExample.Criteria criteria = example.createCriteria();
  		criteria.andUserIdEqualTo(userId);
  		criteria.andCalculateCodeEqualTo(calculateCode);
  		List<UserCalculateConfig> list = null;
  		try {
  			list = userCalculateConfigMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-selectUserCalculateConfigByUserId)-根据userId和calculateCode查询用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		UserCalculateConfig userCalculateConfig = null;
  		if(list != null && !list.isEmpty()) {
  			userCalculateConfig = list.get(0);
  		}
  		return userCalculateConfig;
  	}

  	/**
  	 * 插入用户算力配置
  	 * @param userCalculateConfig
  	 * @param sourceType
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer insertUserCalculateConfig(UserCalculateConfig userCalculateConfig,Integer sourceType) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-insertUserCalculateConfig)-插入用户算力配置-传入参数, userCalculateConfig:{}, sourceType:{}", userCalculateConfig, sourceType);
  		Integer userId = userCalculateConfig.getUserId();
  		String calculateCode = userCalculateConfig.getCalculateCode();
  		UserCalculateConfigExample example = new UserCalculateConfigExample();
  		UserCalculateConfigExample.Criteria criteria = example.createCriteria();
  		criteria.andUserIdEqualTo(userId);
  		criteria.andCalculateCodeEqualTo(calculateCode);
  		List<UserCalculateConfig> list = null;
  		try {
  			list = userCalculateConfigMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-insertUserCalculateConfig)-根据userId和calculateCode查询用户算力配置列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		Integer isComplete = userCalculateConfig.getIsComplete();
  		Integer amount = userCalculateConfig.getAmount();


  		int i = 0;
  		//有值更新，无值插入
  		if(list != null && !list.isEmpty()) {
  			userCalculateConfig = list.get(0);
  			Integer times = userCalculateConfig.getTimes();
  			Integer oldAmount = userCalculateConfig.getAmount();
  			userCalculateConfig.setIsComplete(isComplete);
  			userCalculateConfig.setCompleteTime(new Date());
  			userCalculateConfig.setTimes(times+1);
  			userCalculateConfig.setAmount(amount+oldAmount);
  			userCalculateConfig.setUpdateTime(new Date());
  			try{
  				i = userCalculateConfigMapper.updateByPrimaryKeySelective(userCalculateConfig);
  			} catch (Exception e) {
  				logger.error("(BootUserCalculateConfigService-insertUserCalculateConfig)-更新用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  				throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  			}
  			if(i<=0) {
  				throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  			}
  		} else {
  			//推送过来的才插入用户算力配置
  			if(WheelConstants.SOURCE_TYPE_PUSH.equals(sourceType)) {
  				userCalculateConfig.setCompleteTime(new Date());
  				userCalculateConfig.setCreateTime(new Date());
  				userCalculateConfig.setUpdateTime(new Date());
  				try{
  					i = userCalculateConfigMapper.insertSelective(userCalculateConfig);
  				} catch (Exception e) {
  					logger.error("(BootUserCalculateConfigService-insertUserCalculateConfig)-插入用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  					throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  				}
  			}
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改用户算力配置
  	 * @param userCalculateConfig
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer modifyUserCalculateConfig(UserCalculateConfig userCalculateConfig) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-modifyUserCalculateConfig)-修改用户算力配置-传入参数, userCalculateConfig:{}", userCalculateConfig);
  		userCalculateConfig.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = userCalculateConfigMapper.updateByPrimaryKeySelective(userCalculateConfig);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-modifyUserCalculateConfig)-修改用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除用户算力配置
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer deleteUserCalculateConfigById(Long id) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-deleteUserCalculateConfigById)-根据id删除用户算力配置-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userCalculateConfigMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-deleteUserCalculateConfigById)-根据id删除用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
     * 根据userId查询用户配置列表
     * @param param
     * @return List<UserCalculateConfigVo>
     */
  	@Override
	public List<UserCalculateConfigContentVo> selectUserCalculateConfigContentListByUserId(UserCalculateConfigParam param) throws BootServiceException {
  		logger.info("(BootUserCalculateConfigService-selectUserCalculateConfigContentListByUserId)-根据userId查询用户配置列表-传入参数, param:{}", param);

  		List<UserCalculateConfigContentVo> list = null;
  		try {
  			list = userCalculateConfigMapper.selectUserCalculateConfigContentListByUserId(param);
  		} catch (Exception e) {
  			logger.error("(BootUserCalculateConfigService-selectUserCalculateConfigContentListByUserId)-根据userId查询用户配置列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}


}