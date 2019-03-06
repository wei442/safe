package com.cloud.consumer.safe.vo.coupon;

import java.io.Serializable;

public class CouponGCouponVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer couponGCouponId;

    private Integer couponId;

    private String gCouponId;

    public Integer getCouponGCouponId() {
        return couponGCouponId;
    }

    public void setCouponGCouponId(Integer couponGCouponId) {
        this.couponGCouponId = couponGCouponId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getgCouponId() {
        return gCouponId;
    }

    public void setgCouponId(String gCouponId) {
        this.gCouponId = gCouponId == null ? null : gCouponId.trim();
    }

	@Override
	public String toString() {
		return "CouponGCouponVo [couponGCouponId=" + couponGCouponId + ", couponId=" + couponId + ", gCouponId="
				+ gCouponId + "]";
	}

}