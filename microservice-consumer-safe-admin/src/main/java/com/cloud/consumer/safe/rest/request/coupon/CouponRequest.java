package com.cloud.consumer.safe.rest.request.coupon;

import java.io.Serializable;

import com.cloud.consumer.safe.base.BaseRestRequest;

/**
 * 优惠券请求
 * @author wei.yong
 */
public class CouponRequest extends BaseRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//用户id
	private Integer userId;

	//优惠券id
	private Integer couponId;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	@Override
	public String toString() {
		return "CouponRequest [userId=" + userId + ", couponId=" + couponId + "]";
	}

}