package com.cloud.provider.safe.rest.request.coupon;

import com.cloud.provider.safe.boot.BootRestRequest;

public class CouponLogListRequest extends BootRestRequest {

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

    private String couponTime;

    private String startTime;

    private String endTime;

    private Integer diamond;

    private String remark;

	//gofun优惠券名称
    private String gName;

    private String gCouponId;

	public Long getCouponLogId() {
		return couponLogId;
	}

	public void setCouponLogId(Long couponLogId) {
		this.couponLogId = couponLogId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCouponTime() {
		return couponTime;
	}

	public void setCouponTime(String couponTime) {
		this.couponTime = couponTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getDiamond() {
		return diamond;
	}

	public void setDiamond(Integer diamond) {
		this.diamond = diamond;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgCouponId() {
		return gCouponId;
	}

	public void setgCouponId(String gCouponId) {
		this.gCouponId = gCouponId;
	}

	@Override
	public String toString() {
		return "CouponLogListRequest [couponLogId=" + couponLogId + ", userId=" + userId + ", couponId=" + couponId
				+ ", userAccount=" + userAccount + ", url=" + url + ", price=" + price + ", couponType=" + couponType
				+ ", status=" + status + ", couponTime=" + couponTime + ", startTime=" + startTime + ", endTime="
				+ endTime + ", diamond=" + diamond + ", remark=" + remark + ", gName=" + gName + ", gCouponId="
				+ gCouponId + "]";
	}

}