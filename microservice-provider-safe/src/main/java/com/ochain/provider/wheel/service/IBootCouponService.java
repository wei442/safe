package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.CouponParam;
import com.ochain.provider.wheel.po.Coupon;
import com.ochain.provider.wheel.po.CouponGCoupon;
import com.ochain.provider.wheel.vo.coupon.CouponAndGCouponVo;

public interface IBootCouponService {

	/**
	 * 分页查询
	 * @param page
	 * @param CouponExample
	 * @return List<Coupon>
	 * @throws BootServiceException
	 */
	public List<Coupon>selectCouponListByPage(Page<Coupon> page, Coupon coupon) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param CouponExample
	 * @return List<Coupon>
	 * @throws BootServiceException
	 */
	public List<Coupon> selectCouponList(Coupon coupon) throws BootServiceException;

	/**
	 * 根据id查询优惠券表信息
	 * @param id
	 * @return Coupon
	 * @throws BootServiceException
	 */
	public Coupon selectCouponById(Integer id) throws BootServiceException;

	/**
	 * 新增优惠券数据
	 * @param CouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertCoupon(Coupon coupon, CouponGCoupon couponGCoupon) throws BootServiceException;

	/**
	 * 修改优惠券数据
	 * @param CouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyCoupon(Coupon coupon, CouponGCoupon couponGCoupon) throws BootServiceException;

	/**
	 * 根据参数查询优惠券/优惠券关系/gofun优惠券表
	 * @param page
	 * @param coupon
	 * @return List<CouponAndGCouponVo>
	 * @throws BootServiceException
	 */
	public List<CouponAndGCouponVo> selectCouponAndGCouponVoListByParam(Page<Coupon> page, CouponParam param) throws BootServiceException;

}