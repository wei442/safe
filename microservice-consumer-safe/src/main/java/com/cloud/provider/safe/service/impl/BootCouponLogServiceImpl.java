package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.CouponLogMapper;
import com.ochain.provider.wheel.param.CouponLogParam;
import com.ochain.provider.wheel.po.CouponLog;
import com.ochain.provider.wheel.po.CouponLogExample;
import com.ochain.provider.wheel.service.IBootCouponLogService;
import com.ochain.provider.wheel.vo.coupon.CouponLogAndGCouponVo;

@Service
public class BootCouponLogServiceImpl implements IBootCouponLogService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//优惠券日志 Mapper
	@Autowired
	private CouponLogMapper couponLogMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param CouponLog
	 * @return List<CouponLog>
	 * @throws BootServiceException
	 */
	@Override
	public List<CouponLogAndGCouponVo> selectCouponLogListByPage(Page<CouponLog> page, CouponLogParam param) throws BootServiceException {
		logger.info("(BootCouponLogService-selectCouponLogListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);

		List<CouponLogAndGCouponVo> list = null;
		try {
			list = couponLogMapper.selectCouponLogAndGCouponVoListByParam(page, param);
		} catch (Exception e) {
			logger.error("(BootCouponLogService-selectCouponLogListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param couponLog
	 * @return List<CouponLog>
	 * @throws BootServiceException
	 */
	@Override
	public List<CouponLog> selectCouponLogList(CouponLog couponLog) throws BootServiceException {
		logger.info("(BootCouponLogService-selectCouponLogList)-不分页查询-传入参数, couponLog:{}", couponLog);
		CouponLogExample example = new CouponLogExample();
		CouponLogExample.Criteria criteria = example.createCriteria();
		if(couponLog != null) {
			if(couponLog.getUserAccount() != null) {
				criteria.andUserAccountEqualTo(couponLog.getUserAccount());
			}
			if(couponLog.getCouponTime() != null) {
				Date addSeconds = DateUtils.addSeconds(couponLog.getCouponTime(), 86399);
				criteria.andCouponTimeBetween(couponLog.getCouponTime(), addSeconds);
			}
		}
		List<CouponLog> list = null;
		try {
			list = couponLogMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCouponLogService-selectCouponLogList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询优惠券日志表信息
	 * @param id
	 * @return CouponLog
	 * @throws BootServiceException
	 */
	@Override
	public CouponLog selectCouponLogById(Long id) throws BootServiceException {
		logger.info("(BootCouponLogService-selectCouponLogById)-根据id查询优惠券日志表信息-传入参数, id:{}", id);
		CouponLog couponLog = null;

		try {
			couponLog = couponLogMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootCouponLogService-selectCouponLogById)-根据id查询优惠券日志表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return couponLog;
	}

	/**
	 * 新增优惠券日志数据
	 * @param CouponLogRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertCouponLog(CouponLog couponLog) throws BootServiceException {
		logger.info("(BootCouponLogService-insertCouponLog)-插入优惠券日志数据-传入参数, couponLog:{}", couponLog);
		couponLog.setCouponTime(new Date());
		couponLog.setCreateTime(new Date());
		couponLog.setUpdateTime(new Date());
		int i = 0;
		try{
			i = couponLogMapper.insertSelective(couponLog);
		} catch (Exception e) {
			logger.error("(BootCouponLogService-insertCouponLog)-插入优惠券日志数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}