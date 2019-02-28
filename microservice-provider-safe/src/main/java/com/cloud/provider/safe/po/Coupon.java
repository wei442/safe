package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable {

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

    private Date createTime;

    private Date updateTime;

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
		return "Coupon [couponId=" + couponId + ", url=" + url + ", price=" + price + ", couponType=" + couponType
				+ ", amount=" + amount + ", diamond=" + diamond + ", isUse=" + isUse + ", isDelete=" + isDelete
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}