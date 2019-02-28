package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.GCoupon;

public interface IBootGCouponService {

	/**
	 * 分页查询
	 * @param page
	 * @param gCoupon
	 * @return List<GCoupon>
	 * @throws BootServiceException
	 */
	public List<GCoupon> selectGCouponListByPage(Page<GCoupon> page, GCoupon gCoupon) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param GCouponExample
	 * @return List<GCoupon>
	 * @throws BootServiceException
	 */
	public List<GCoupon> selectGCouponList(GCoupon gCoupon) throws BootServiceException;

	/**
	 * 根据id查询gofun优惠券表信息
	 * @param id
	 * @return GCoupon
	 * @throws BootServiceException
	 */
	public GCoupon selectGCouponById(String id) throws BootServiceException;

	/**
	 * 新增gofun优惠券数据
	 * @param GCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertGCoupon(GCoupon gCoupon) throws BootServiceException;

	/**
	 * 修改gofun优惠券数据
	 * @param GCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyGCoupon(GCoupon gCoupon) throws BootServiceException;

	/**
	 * 同步gofun优惠券数据
	 * @param GCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Boolean resetGCoupon(String gCouponListStr) throws BootServiceException;

}