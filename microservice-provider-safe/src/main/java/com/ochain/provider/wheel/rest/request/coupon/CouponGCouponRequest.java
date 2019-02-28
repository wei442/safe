package com.ochain.provider.wheel.rest.request.coupon;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class CouponGCouponRequest extends BootRestRequest {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer couponGCouponId;

    private Integer couponId;

    private String gCouponId;

	public Integer getCouponGCouponId() {
		return this.couponGCouponId;
	}

	public void setCouponGCouponId(Integer couponGCouponId) {
		this.couponGCouponId = couponGCouponId;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getgCouponId() {
		return this.gCouponId;
	}

	public void setgCouponId(String gCouponId) {
		this.gCouponId = gCouponId;
	}

	@Override
	public String toString() {
		return "CouponGCouponRequest [couponGCouponId=" + couponGCouponId + ", couponId=" + couponId + ", gCouponId="
				+ gCouponId + "]";
	}

}