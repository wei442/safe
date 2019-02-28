package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.CouponGCoupon;

public interface IBootCouponGCouponService {

	/**
	 * 分页查询
	 * @param page
	 * @param couponGCoupon
	 * @return List<CouponGCoupon>
	 * @throws BootServiceException
	 */
	public List<CouponGCoupon> selectCouponGCouponListByPage(Page<CouponGCoupon> page, CouponGCoupon couponGCoupon) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param CouponGCouponExample
	 * @return List<CouponGCoupon>
	 * @throws BootServiceException
	 */
	public List<CouponGCoupon> selectCouponGCouponList(CouponGCoupon couponGCoupon) throws BootServiceException;

	/**
	 * 根据id查询优惠券关联表信息
	 * @param id
	 * @return CouponGCoupon
	 * @throws BootServiceException
	 */
	public CouponGCoupon selectCouponGCouponById(Integer id) throws BootServiceException;

	/**
	 * 根据couponId查询优惠券关联表信息
	 * @param couponId
	 * @return CouponGCoupon
	 * @throws BootServiceException
	 */
	public CouponGCoupon selectCouponGCouponByCouponId(Integer couponId) throws BootServiceException;

	/**
	 * 根据gCouponId查询优惠券关联表信息
	 * @param gCouponId
	 * @return CouponGCoupon
	 * @throws BootServiceException
	 */
	public CouponGCoupon selectCouponGCouponByGCouponId(String gCouponId) throws BootServiceException;

	/**
	 * 新增优惠券关联数据
	 * @param CouponGCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertCouponGCoupon(CouponGCoupon couponGCoupon) throws BootServiceException;

	/**
	 * 修改优惠券关联数据
	 * @param CouponGCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyCouponGCoupon(CouponGCoupon couponGCoupon) throws BootServiceException;

}