package com.ochain.consumer.wheel.vo.coupon;

import java.io.Serializable;

public class CouponPushVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userAccount;

	private Integer accountId;

	private Integer couponId;

	//支付能量方块
	private Integer payDiamond;

    private String url;

    private Integer price;

    private Integer couponType;

    private String gId;

    private String gToken;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getPayDiamond() {
		return this.payDiamond;
	}

	public void setPayDiamond(Integer payDiamond) {
		this.payDiamond = payDiamond;
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

	public String getgId() {
		return this.gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgToken() {
		return this.gToken;
	}

	public void setgToken(String gToken) {
		this.gToken = gToken;
	}

	@Override
	public String toString() {
		return "CouponPushVo [userId=" + userId + ", userAccount=" + userAccount + ", accountId=" + accountId
				+ ", couponId=" + couponId + ", payDiamond=" + payDiamond + ", url=" + url + ", price=" + price
				+ ", couponType=" + couponType + ", gId=" + gId + ", gToken=" + gToken + "]";
	}

}