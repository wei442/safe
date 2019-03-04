package com.cloud.provider.safe.param;

import java.io.Serializable;

public class CouponParam implements Serializable {

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

    private Integer isDelete;

    private String gCouponId;

    private String orderByClause;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDiamond() {
		return diamond;
	}

	public void setDiamond(Integer diamond) {
		this.diamond = diamond;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getgCouponId() {
		return gCouponId;
	}

	public void setgCouponId(String gCouponId) {
		this.gCouponId = gCouponId;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	@Override
	public String toString() {
		return "CouponParam [couponId=" + couponId + ", url=" + url + ", price=" + price + ", couponType=" + couponType
				+ ", amount=" + amount + ", diamond=" + diamond + ", isUse=" + isUse + ", isDelete=" + isDelete
				+ ", gCouponId=" + gCouponId + ", orderByClause=" + orderByClause + "]";
	}

}