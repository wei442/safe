package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.CouponGCouponMapper;
import com.ochain.provider.wheel.dao.CouponMapper;
import com.ochain.provider.wheel.param.CouponParam;
import com.ochain.provider.wheel.po.Coupon;
import com.ochain.provider.wheel.po.CouponExample;
import com.ochain.provider.wheel.po.CouponGCoupon;
import com.ochain.provider.wheel.po.CouponGCouponExample;
import com.ochain.provider.wheel.service.IBootCouponService;
import com.ochain.provider.wheel.vo.coupon.CouponAndGCouponVo;

@Service
public class BootCouponServiceImpl implements IBootCouponService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//优惠券 Mapper
	@Autowired
	private CouponMapper couponMapper;

	//gofun优惠券和优惠券关系表 Mapper
	@Autowired
	private CouponGCouponMapper couponGCouponMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param coupon
	 * @return List<Coupon>
	 * @throws BootServiceException
	 */
	@Override
	public List<Coupon> selectCouponListByPage(Page<Coupon> page, Coupon coupon) throws BootServiceException {
		logger.info("(BootCouponServiceImpl-selectCouponListByPage)-分页查询-传入参数, page:{}, coupon:{}", page, coupon);

		CouponExample example = new CouponExample();
		CouponExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_COUPON_IS_DELETE_NO);
		if(coupon != null) {
			if(coupon.getDiamond() != null) {
				criteria.andDiamondEqualTo(coupon.getDiamond());
			}
			if(coupon.getIsUse() != null) {
				criteria.andIsUseEqualTo(coupon.getIsUse());
			}
		}
		List<Coupon> list = null;
		try {
			list = couponMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-selectCouponListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param CouponExample
	 * @return List<Coupon>
	 * @throws BootServiceException
	 */
	@Override
	public List<Coupon> selectCouponList(Coupon coupon) throws BootServiceException {
		logger.info("(BootCouponServiceImpl-selectCouponList)-不分页查询-传入参数, coupon:{}", coupon);
		CouponExample example = new CouponExample();
		CouponExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlWheelConstants.SQL_COUPON_IS_DELETE_NO);
		if(coupon != null) {
			if(coupon.getDiamond() != null) {
				criteria.andDiamondEqualTo(coupon.getDiamond());
			}
			if(coupon.getIsUse() != null) {
				criteria.andIsUseEqualTo(coupon.getIsUse());
			}
		}
		List<Coupon> list = null;
		try {
			list = couponMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-selectCouponList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询优惠券表信息
	 * @param id
	 * @return Coupon
	 * @throws BootServiceException
	 */
	@Override
	public Coupon selectCouponById(Integer id) throws BootServiceException {
		logger.info("(BootCouponServiceImpl-selectCouponById)-根据id查询优惠券表信息-传入参数, id:{}", id);
		Coupon coupon = null;
		try {
			coupon = couponMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-selectCouponById)-根据id查询优惠券表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		return coupon;
	}

	/**
	 * 新增优惠券数据
	 * @param CouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Transactional
	@Override
	public Integer insertCoupon(Coupon coupon, CouponGCoupon couponGCoupon) throws BootServiceException {
		logger.info("(BootCouponServiceImpl-insertCoupon)-插入优惠券数据-传入参数, coupon:{}", coupon);
		coupon.setIsDelete(SqlWheelConstants.SQL_COUPON_IS_DELETE_NO);
		coupon.setCreateTime(new Date());
		coupon.setUpdateTime(new Date());

		int i = 0;
		int j = 0;
		try{
			i = couponMapper.insertSelective(coupon);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-insertCoupon)-插入优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		couponGCoupon.setCouponId(coupon.getCouponId());
		couponGCoupon.setCreateTime(new Date());
		couponGCoupon.setUpdateTime(new Date());
		try {
			j = couponGCouponMapper.insertSelective(couponGCoupon);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-insertCoupon)-插入优惠券与gofun优惠券关系表数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return j;
	}

	/**
	 * 修改优惠券数据
	 * @param CouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Transactional
	@Override
	public Integer modifyCoupon(Coupon coupon, CouponGCoupon couponGCoupon) throws BootServiceException {
		logger.info("(BootCouponServiceImpl-modifyCoupon)-修改优惠券数据-传入参数, coupon:{}", coupon);
		coupon.setUpdateTime(new Date());
		int i = 0;
		int j = 0;
		try{
			i = couponMapper.updateByPrimaryKeySelective(coupon);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-modifyCoupon)-修改优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		if(StringUtils.isBlank(couponGCoupon.getgCouponId())) {
			return i;
		}
		CouponGCoupon oldCGCoupon = null;
		CouponGCouponExample example = new CouponGCouponExample();
		CouponGCouponExample.Criteria criteria = example.createCriteria();
		criteria.andCouponIdEqualTo(coupon.getCouponId());
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-selectCouponListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(list != null && !list.isEmpty()) {
			oldCGCoupon = list.get(0);
			if(StringUtils.equals(oldCGCoupon.getgCouponId(), couponGCoupon.getgCouponId())) {
				return i;
			}
			couponGCoupon.setCouponGCouponId(oldCGCoupon.getCouponGCouponId());
			couponGCoupon.setCouponId(oldCGCoupon.getCouponId());
			couponGCoupon.setUpdateTime(new Date());
			try{
				i = couponGCouponMapper.updateByPrimaryKeySelective(couponGCoupon);
			} catch (Exception e) {
				logger.error("(BootCouponServiceImpl-modifyCoupon)-修改优惠券关系表数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
		}
		return j;
	}

	/**
	 * 根据参数查询优惠券/优惠券关系/gofun优惠券表
	 * @param page
	 * @param coupon
	 * @return List<CouponAndGCouponVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<CouponAndGCouponVo> selectCouponAndGCouponVoListByParam(Page<Coupon> page, CouponParam param) throws BootServiceException {
		logger.info("(BootCouponServiceImpl-selectCouponAndGCouponVoListByParam)-分页查询优惠券/优惠券关系/gofun优惠券列表-传入参数, page:{}, param:{}", page, param);
		param.setOrderByClause(" t1.id desc ");
		List<CouponAndGCouponVo> list = null;
		try {
			list = couponMapper.selectCouponAndGCouponVoListByParam(page, param);
		} catch (Exception e) {
			logger.error("(BootCouponServiceImpl-selectCouponAndGCouponVoListByParam)-分页查询优惠券/优惠券关系/gofun优惠券列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

}