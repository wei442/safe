package com.ochain.provider.wheel.rest.request.coupon;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class GCouponRestRequest extends BootRestRequest {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String gCouponList;

	public String getgCouponList() {
		return gCouponList;
	}

	public void setgCouponList(String gCouponList) {
		this.gCouponList = gCouponList;
	}

	@Override
	public String toString() {
		return "GCouponRestRequest [gCouponList=" + gCouponList + "]";
	}

}