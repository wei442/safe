package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.CouponLogParam;
import com.ochain.provider.wheel.po.CouponLog;
import com.ochain.provider.wheel.vo.coupon.CouponLogAndGCouponVo;

public interface IBootCouponLogService {

	/**
	 * 分页查询
	 * @param page
	 * @param CouponLogExample
	 * @return List<CouponLog>
	 * @throws BootServiceException
	 */
	public List<CouponLogAndGCouponVo>selectCouponLogListByPage(Page<CouponLog> page, CouponLogParam param) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param CouponLogExample
	 * @return List<CouponLog>
	 * @throws BootServiceException
	 */
	public List<CouponLog> selectCouponLogList(CouponLog couponLog) throws BootServiceException;

	/**
	 * 根据id查询优惠券日志表信息
	 * @param id
	 * @return CouponLog
	 * @throws BootServiceException
	 */
	public CouponLog selectCouponLogById(Long id) throws BootServiceException;

	/**
	 * 新增优惠券日志数据
	 * @param CouponLogRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertCouponLog(CouponLog couponLog) throws BootServiceException;

}