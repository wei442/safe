package com.ochain.provider.wheel.vo.coupon;

import java.io.Serializable;
import java.util.Date;

public class CouponGCouponVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer couponGCouponId;

    private Integer couponId;

    private String gCouponId;

    private Date createTime;

    private Date updateTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "CouponGCoupon [couponGCouponId=" + couponGCouponId + ", couponId=" + couponId + ", gCouponId="
				+ gCouponId + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}