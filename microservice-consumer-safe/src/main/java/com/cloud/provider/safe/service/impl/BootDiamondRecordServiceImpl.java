package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.DiamondRecordMapper;
import com.ochain.provider.wheel.param.DiamondRecordParam;
import com.ochain.provider.wheel.po.DiamondRecord;
import com.ochain.provider.wheel.po.DiamondRecordExample;
import com.ochain.provider.wheel.service.IBootDiamondRecordService;
import com.ochain.provider.wheel.vo.diamond.DiamondRecordVo;

/**
 * 能量记录 BootDiamondRecordService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootDiamondRecordServiceImpl implements IBootDiamondRecordService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //能量记录 Mapper
  	@Autowired
  	private DiamondRecordMapper diamondRecordMapper;

	/**
  	 * 分页查询
  	 * @param page
  	 * @param diamondRecord
  	 * @return List<DiamondRecord>
  	 * @throws BootServiceException
  	 */
  	@Override
  	public List<DiamondRecord> selectDiamondRecordListByPage(Page<DiamondRecord> page, DiamondRecord diamondRecord) throws BootServiceException{
  		logger.info("(BootDiamondRecordService-selectDiamondRecordListByPage)-分页查询-传入参数, page:{}, diamondRecord:{}", page, diamondRecord);
  		DiamondRecordExample example = new DiamondRecordExample();
  		example.setOrderByClause(" id desc ");
  		DiamondRecordExample.Criteria criteria = example.createCriteria();
  		if(diamondRecord != null) {
  			if(diamondRecord.getUserId() != null) {
  				criteria.andUserIdEqualTo(diamondRecord.getUserId());
  			}
  		}

  		List<DiamondRecord> list = null;
  		try {
  			list = diamondRecordMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-selectDiamondRecordListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param diamondRecord
  	 * @return List<DiamondRecord>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<DiamondRecord> selectDiamondRecordList(DiamondRecord diamondRecord) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-selectDiamondRecordList)-不分页查询-传入参数, diamondRecord:{}", diamondRecord);
  		DiamondRecordExample example = new DiamondRecordExample();
  		example.setOrderByClause(" id desc ");
  		DiamondRecordExample.Criteria criteria = example.createCriteria();
  		if(diamondRecord != null) {
  		}

  		List<DiamondRecord> list = null;
  		try {
  			list = diamondRecordMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-selectDiamondRecordList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 查询3天前未领取的能量方块数据列表
  	 * @param userId
  	 * @return List<DiamondRecord>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<DiamondRecord> selectDiamondRecordListByThreeDays(Integer userId) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-selectDiamondRecordListByThreeDays)-查询3天前未领取的能量方块数据列表-传入参数, userId:{}", userId);
  		//三天前
  		DateTime threeDays = new DateTime().minus(Period.days(3));
  		DiamondRecordExample example = new DiamondRecordExample();
  		example.setOrderByClause(" id desc ");
  		DiamondRecordExample.Criteria criteria = example.createCriteria();
  		criteria.andUserIdEqualTo(userId);
  		criteria.andCreateTimeGreaterThanOrEqualTo(threeDays.toDate());
  		criteria.andIsUseEqualTo(SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_NO);
  		criteria.andStatusEqualTo(SqlWheelConstants.SQL_DIAMOND_RECORD_STATUS_SUCCESS);
  		List<DiamondRecord> list = null;
  		try {
  			list = diamondRecordMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-selectDiamondRecordListByThreeDays)-查询3天前未领取的能量方块数据列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据id查询能量记录
  	 * @param id
  	 * @return DiamondRecord
  	 * @throws BootServiceException
  	 */
  	@Override
	public DiamondRecord selectDiamondRecordById(Long id) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-selectDiamondRecordById)-根据id查询能量记录-传入参数, id:{}}", id);
  		DiamondRecord diamondRecord = null;
  		try {
  			diamondRecord = diamondRecordMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-selectDiamondRecordById)-根据id查询能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return diamondRecord;
  	}

  	/**
  	 * 插入能量记录
  	 * @param diamondRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
	@Override
	public Integer insertDiamondRecord(DiamondRecord diamondRecord) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-insertDiamondRecord)-插入能量记录-传入参数, diamondRecord:{}", diamondRecord);
		diamondRecord.setIsUse(SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_NO);
		diamondRecord.setStatus(SqlWheelConstants.SQL_DIAMOND_RECORD_STATUS_SUCCESS);
		diamondRecord.setCreateTime(new Date());
  		diamondRecord.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = diamondRecordMapper.insertSelective(diamondRecord);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-insertDiamondRecord)-插入能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改能量记录
  	 * @param diamondRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer modifyDiamondRecord(DiamondRecord diamondRecord) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-modifyDiamondRecord)-修改能量记录-传入参数, diamondRecord:{}}", diamondRecord);
  		diamondRecord.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = diamondRecordMapper.updateByPrimaryKeySelective(diamondRecord);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-modifyDiamondRecord)-修改能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除能量记录
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer deleteDiamondRecordById(Long id) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-deleteDiamondRecordById)-根据id删除能量记录-传入参数, id:{}}", id);
  		int i = 0;
  		try {
  			i = diamondRecordMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-deleteDiamondRecordById)-根据id删除能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据领用时间查询已领取的能量数量
  	 * @param useTimeStr
  	 * @return DiamondRecordVo
  	 * @throws BootServiceException
  	 */
	@Override
	public DiamondRecordVo selectDrawDiamondByUseTime(String useTimeStr) throws BootServiceException {
  		logger.info("(BootDiamondRecordService-selectDrawDiamondByUseTime)-根据领用时间查询已领取的能量数量-传入参数, useTimeStr:{}}", useTimeStr);
  		DiamondRecordParam param = new DiamondRecordParam();
  		param.setUseTimeStartStr(useTimeStr+DateFormatConstants.TIME_START);
  		param.setUseTimeEndStr(useTimeStr+DateFormatConstants.TIME_END);
  		List<DiamondRecordVo> list = null;
  		try {
  			list = diamondRecordMapper.selectDrawDiamondListByUseTime(param);
  		} catch (Exception e) {
  			logger.error("(BootDiamondRecordService-selectDrawDiamondByUseTime)-根据领用时间查询已领取的能量数量-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		DiamondRecordVo diamondRecordVo = null;
  		if(list != null && list.isEmpty()) {
  			diamondRecordVo = list.get(0);
  		}
  		return diamondRecordVo;
  	}

	/**
	 * 根据创建时间查询未领取的能量数量
	 * @param useTimeStr
	 * @return DiamondRecordVo
	 * @throws BootServiceException
	 */
	@Override
	public DiamondRecordVo selectNotDrawDiamondByCreateTime(String createTimeStr) throws BootServiceException {
		logger.info("(BootDiamondRecordService-selectNotDrawDiamondByCreateTime)-根据创建时间查询未领取的能量数量-传入参数, createTimeStr:{}}", createTimeStr);
		DiamondRecordParam param = new DiamondRecordParam();
		param.setCreateTimeStartStr(createTimeStr+DateFormatConstants.TIME_START);
  		param.setCreateTimeEndStr(createTimeStr+DateFormatConstants.TIME_END);
		List<DiamondRecordVo> list = null;
		try {
			list = diamondRecordMapper.selectNotDrawDiamondListByCreateTime(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRecordService-selectNotDrawDiamondByCreateTime)-根据创建时间查询未领取的能量数量-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		DiamondRecordVo diamondRecordVo = null;
		if(list != null && list.isEmpty()) {
			diamondRecordVo = list.get(0);
		}
		return diamondRecordVo;
	}

}