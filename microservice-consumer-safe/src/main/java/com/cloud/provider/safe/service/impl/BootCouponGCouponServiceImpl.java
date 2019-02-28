package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.CouponGCouponMapper;
import com.ochain.provider.wheel.po.CouponGCoupon;
import com.ochain.provider.wheel.po.CouponGCouponExample;
import com.ochain.provider.wheel.service.IBootCouponGCouponService;

@Service
public class BootCouponGCouponServiceImpl implements IBootCouponGCouponService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//优惠券关联 Mapper
	@Autowired
	private CouponGCouponMapper couponGCouponMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param couponGCoupon
	 * @return List<CouponGCoupon>
	 * @throws BootServiceException
	 */
	@Override
	public List<CouponGCoupon> selectCouponGCouponListByPage(Page<CouponGCoupon> page, CouponGCoupon couponGCoupon) throws BootServiceException {
		logger.info("(BootCouponGCouponService-selectCouponGCouponListByPage)-分页查询-传入参数, page:{}, couponGCoupon:{}", page, couponGCoupon);
		CouponGCouponExample example = new CouponGCouponExample();
		CouponGCouponExample.Criteria criteria = example.createCriteria();
		if(couponGCoupon != null) {
		}
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-selectCouponGCouponListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param CouponGCouponExample
	 * @return List<CouponGCoupon>
	 * @throws BootServiceException
	 */
	@Override
	public List<CouponGCoupon> selectCouponGCouponList(CouponGCoupon couponGCoupon) throws BootServiceException {
		logger.info("(BootCouponGCouponService-selectCouponGCouponList)-不分页查询-传入参数, couponGCoupon:{}", couponGCoupon);
		CouponGCouponExample example = new CouponGCouponExample();
		CouponGCouponExample.Criteria criteria = example.createCriteria();
		if(couponGCoupon != null) {
			if(couponGCoupon.getCouponId() != null) {
				criteria.andCouponIdEqualTo(couponGCoupon.getCouponId());
			}
			if(!StringUtils.isBlank(couponGCoupon.getgCouponId())) {
				criteria.andGCouponIdEqualTo(couponGCoupon.getgCouponId());
			}
		}
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-selectCouponGCouponList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询优惠券关联表信息
	 * @param id
	 * @return CouponGCoupon
	 * @throws BootServiceException
	 */
	@Override
	public CouponGCoupon selectCouponGCouponById(Integer id) throws BootServiceException {
		logger.info("(BootCouponGCouponService-selectCouponGCouponById)-根据id查询优惠券关联表信息-传入参数, id:{}", id);
		CouponGCoupon couponGCoupon = null;

		try {
			couponGCoupon = couponGCouponMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-selectCouponGCouponById)-根据id查询优惠券关联表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return couponGCoupon;
	}

	/**
	 * 根据couponId查询优惠券关联表信息
	 * @param couponId
	 * @return CouponGCoupon
	 * @throws BootServiceException
	 */
	@Override
	public CouponGCoupon selectCouponGCouponByCouponId(Integer couponId) throws BootServiceException {
		logger.info("(BootCouponGCouponService-selectCouponGCouponById)-根据couponId查询优惠券关联表信息-传入参数, couponId:{}", couponId);
		CouponGCouponExample example = new CouponGCouponExample();
		CouponGCouponExample.Criteria criteria = example.createCriteria();
		criteria.andCouponIdEqualTo(couponId);
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-selectCouponGCouponByCouponId)-根据couponId查询优惠券关联表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		CouponGCoupon couponGCoupon = null;
		if(list != null && !list.isEmpty()) {
			couponGCoupon = list.get(0);
		}
		return couponGCoupon;
	}

	/**
	 * 根据gCouponId查询优惠券关联表信息
	 * @param gCouponId
	 * @return CouponGCoupon
	 * @throws BootServiceException
	 */
	@Override
	public CouponGCoupon selectCouponGCouponByGCouponId(String gCouponId) throws BootServiceException {
		logger.info("(BootCouponGCouponService-selectCouponGCouponByGCouponId)-根据gCouponId查询优惠券关联表信息-传入参数, gCouponId:{}", gCouponId);
		CouponGCouponExample example = new CouponGCouponExample();
		CouponGCouponExample.Criteria criteria = example.createCriteria();
		criteria.andGCouponIdEqualTo(gCouponId);
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-selectCouponGCouponByGCouponId)-根据gCouponId查询优惠券关联表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		CouponGCoupon couponGCoupon = null;
		if(list != null && !list.isEmpty()) {
			couponGCoupon = list.get(0);
		}
		return couponGCoupon;
	}

	/**
	 * 新增优惠券关联数据
	 * @param CouponGCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertCouponGCoupon(CouponGCoupon couponGCoupon) throws BootServiceException {
		logger.info("(BootCouponGCouponService-insertCouponGCoupon)-插入优惠券关联数据-传入参数, couponGCoupon:{}", couponGCoupon);
		couponGCoupon.setCreateTime(new Date());
		couponGCoupon.setUpdateTime(new Date());
		int i = 0;
		try{
			i = couponGCouponMapper.insertSelective(couponGCoupon);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-insertCouponGCoupon)-插入优惠券关联数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 修改优惠券关联数据
	 * @param CouponGCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyCouponGCoupon(CouponGCoupon couponGCoupon) throws BootServiceException {
		logger.info("(BootCouponGCouponService-modifyCouponGCoupon)-修改优惠券关联数据-传入参数, couponGCoupon:{}", couponGCoupon);
		couponGCoupon.setUpdateTime(new Date());
		int i = 0;
		try{
			i = couponGCouponMapper.updateByPrimaryKeySelective(couponGCoupon);
		} catch (Exception e) {
			logger.error("(BootCouponGCouponService-modifyCouponGCoupon)-修改优惠券关联数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}