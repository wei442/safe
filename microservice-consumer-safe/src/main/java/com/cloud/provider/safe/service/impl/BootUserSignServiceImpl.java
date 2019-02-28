package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.UserSignMapper;
import com.ochain.provider.wheel.param.UserSignParam;
import com.ochain.provider.wheel.po.UserSign;
import com.ochain.provider.wheel.po.UserSignExample;
import com.ochain.provider.wheel.service.IBootUserSignService;

/**
 * 用户签到接口 BootUserSignService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootUserSignServiceImpl implements IBootUserSignService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用户签到 Mapper
  	@Autowired
  	private UserSignMapper userSignMapper;

	/**
  	 * 分页查询
  	 * @param page
  	 * @param userSign
  	 * @return List<UserSign>
  	 * @throws BootServiceException
  	 */
  	@Override
  	public List<UserSign> selectUserSignListByPage(Page<UserSign> page, UserSign userSign) throws BootServiceException {
  		logger.info("(BootUserSignService-selectUserSignListByPage)-分页查询-传入参数, page:{}, userSign:{}", page, userSign);
  		UserSignExample example = new UserSignExample();
  		example.setOrderByClause(" id desc ");
  		UserSignExample.Criteria criteria = example.createCriteria();
  		if(userSign != null) {
  		}

  		List<UserSign> list = null;
  		try {
  			list = userSignMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-selectUserSignListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param userSign
  	 * @return List<UserSign>
  	 * @throws BootServiceException
  	 */
  	@Override
  	public List<UserSign> selectUserSignList(UserSign userSign) throws BootServiceException {
  		logger.info("(BootUserSignService-selectUserSignList)-不分页查询-传入参数, userSign:{}", userSign);
  		UserSignExample example = new UserSignExample();
  		example.setOrderByClause(" id desc ");
  		UserSignExample.Criteria criteria = example.createCriteria();
  		if(userSign != null) {
  		}

  		List<UserSign> list = null;
  		try {
  			list = userSignMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-selectUserSignList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据排名时间开始和结束时间查询用户签到列表
  	 * @param signTimeStart
  	 * @param signTimeEnd
  	 * @return List<UserSign>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<UserSign> selectUserSignListBySignTime(Date signTimeStart, Date signTimeEnd) throws BootServiceException {
  		logger.info("(BootUserSignService-selectUserSignListBySignTime)-根据排名时间开始和结束时间查询用户签到列表-传入参数, signTimeStart:{}, signTimeEnd:{}", signTimeStart, signTimeEnd);
  		UserSignExample example = new UserSignExample();
  		example.setOrderByClause(" id desc ");
  		UserSignExample.Criteria criteria = example.createCriteria();
  		criteria.andSignTimeBetween(signTimeStart, signTimeEnd);
  		List<UserSign> list = null;
  		try {
  			list = userSignMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-selectUserSignListBySignTime)-根据排名时间开始和结束时间查询用户签到列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}


  	/**
  	 * 根据id查询用户签到
  	 * @param id
  	 * @return UserSign
  	 * @throws BootServiceException
  	 */
  	@Override
  	public UserSign selectUserSignById(Long id) throws BootServiceException {
  		logger.info("(BootUserSignService-selectUserSignById)-根据id查询用户签到-传入参数, id:{}}", id);
  		UserSign userSign = null;
  		try {
  			userSign = userSignMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-selectUserSignById)-根据id查询用户签到-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return userSign;
  	}

  	/**
  	 * 根据userId和signTimeStr查询用户签到
  	 * @param userId
  	 * @param signTimeStr
  	 * @return UserSign
  	 * @throws BootServiceException
  	 */
  	@Override
	public UserSign selectUserSignByUserId(Integer userId,String signTimeStr) throws BootServiceException {
  		logger.info("(BootUserSignService-selectUserSignByUserId)-根据userId和signTimeStr查询用户签到-传入参数, userId:{}, signTimeStr:{}", userId, signTimeStr);
  		UserSignParam param = new UserSignParam();
  		param.setUserId(userId);
  		param.setSignTimeStartStr(signTimeStr+DateFormatConstants.TIME_START);
  		param.setSignTimeEndStr(signTimeStr+DateFormatConstants.TIME_END);
  		List<UserSign> list = null;
  		try {
  			list = userSignMapper.selectUserSignListByUserId(param);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-selectUserSignByUserId)-根据userId和signTimeStr查询用户签到-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}

  		UserSign userSign = null;
  		if(list != null && !list.isEmpty()) {
  			userSign = list.get(0);
  		}
  		return userSign;
  	}

  	/**
  	 * 根据userId、signTimeStart和signTimeEnd查询条数
  	 * @param userId
  	 * @param signTimeStart
  	 * @param signTimeEnd
  	 * @return Long
  	 * @throws BootServiceException
  	 */
  	@Override
	public Long selectRowsByUserIdSignTime(Integer userId,Date signTimeStart, Date signTimeEnd) throws BootServiceException {
  		logger.info("(BootUserSignService-selectRowsBySignTime)-根据userId、signTimeStart和signTimeEnd查询条数查询条数-传入参数, userId:{}, signTimeStart:{}, signTimeEnd:{}", userId, signTimeStart, signTimeEnd);
  		UserSignExample example = new UserSignExample();
  		UserSignExample.Criteria criteria = example.createCriteria();
  		criteria.andUserIdEqualTo(userId);
  		criteria.andSignTimeBetween(signTimeStart, signTimeEnd);
  		long rows = 0;
  		try {
  			rows = userSignMapper.countByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-selectRowsByUserIdSignTime)-根据userId、signTimeStart和signTimeEnd查询条数查询条数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return rows;
  	}

  	/**
  	 * 插入用户签到
  	 * @param userSign
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
  	public Integer insertUserSign(UserSign userSign) throws BootServiceException {
  		logger.info("(BootUserSignService-insertUserSign)-插入用户签到-传入参数, userSign:{}}", userSign);
  		//前一天时间
  		String signTimeStr = new LocalDate().minus(Period.days(1)).toString();
  		Integer userId = userSign.getUserId();
  		UserSignParam param = new UserSignParam();
  		param.setUserId(userId);
  		param.setSignTimeStartStr(signTimeStr+DateFormatConstants.TIME_START);
  		param.setSignTimeEndStr(signTimeStr+DateFormatConstants.TIME_END);
  		List<UserSign> list = null;
  		try {
  			list = userSignMapper.selectUserSignListByUserId(param);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-insertUserSign)-根据userId和signTimeStr查询用户签到-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}

  		Integer signDays = 0;
  		int i = 0;
  		if(list != null && !list.isEmpty()) {
  			UserSign userSignLastDay = list.get(0);
  			signDays = userSignLastDay.getSignDays();
  		}

  		userSign.setSignDays(signDays+1);
  		userSign.setSignTime(new Date());
  		userSign.setCreateTime(new Date());
  		userSign.setUpdateTime(new Date());
  		try{
  			i = userSignMapper.insertSelective(userSign);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-insertUserSign)-插入用户签到-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改用户签到
  	 * @param userSign
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
  	public Integer modifyUserSign(UserSign userSign) throws BootServiceException {
  		logger.info("(BootUserSignService-modifyUserSign)-修改用户签到-传入参数, userSign:{}}", userSign);
  		userSign.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = userSignMapper.updateByPrimaryKeySelective(userSign);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-modifyUserSign)-修改用户签到-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除用户签到
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
  	public Integer deleteUserSignById(Long id) throws BootServiceException {
  		logger.info("(BootUserSignService-deleteUserSignById)-根据id删除用户签到-传入参数, id:{}}", id);
  		int i = 0;
  		try {
  			i = userSignMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserSignService-deleteUserSignById)-根据id删除用户签到-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

}