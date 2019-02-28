package com.ochain.provider.wheel.rest.request.coupon;

import java.util.Date;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class CouponLogRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long couponLogId;

    private Integer userId;

    private Integer couponId;

    private String userAccount;

    private String url;

    private Integer price;

    private Integer couponType;

    private Integer status;

    private Date couponTime;

    private Integer diamond;

    private String remark;

	public Long getCouponLogId() {
		return this.couponLogId;
	}

	public void setCouponLogId(Long couponLogId) {
		this.couponLogId = couponLogId;
	}

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

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCouponTime() {
		return this.couponTime;
	}

	public void setCouponTime(Date couponTime) {
		this.couponTime = couponTime;
	}

	public Integer getDiamond() {
		return this.diamond;
	}

	public void setDiamond(Integer diamond) {
		this.diamond = diamond;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CouponLogRequest [couponLogId=" + couponLogId + ", userId=" + userId + ", couponId=" + couponId
				+ ", userAccount=" + userAccount + ", url=" + url + ", price=" + price + ", couponType=" + couponType
				+ ", status=" + status + ", couponTime=" + couponTime + ", diamond=" + diamond + ", remark=" + remark
				+ "]";
	}

}