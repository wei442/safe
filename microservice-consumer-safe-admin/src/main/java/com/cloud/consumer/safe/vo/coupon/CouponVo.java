package com.ochain.consumer.wheel.vo.coupon;

import java.io.Serializable;

public class CouponVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer couponId;

    private String url;

    private Integer price;

    private Integer couponType;

    private Integer amount;

    private Integer diamond;

    private Integer isUse;

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCouponType() {
		return this.couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDiamond() {
		return this.diamond;
	}

	public void setDiamond(Integer diamond) {
		this.diamond = diamond;
	}

	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	@Override
	public String toString() {
		return "CouponVo [couponId=" + couponId + ", url=" + url + ", price=" + price + ", couponType=" + couponType
				+ ", amount=" + amount + ", diamond=" + diamond + ", isUse=" + isUse + "]";
	}

}