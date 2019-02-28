package com.ochain.provider.wheel.vo.coupon;

import java.io.Serializable;

public class GCouponRestVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String couponId;

    private String name;

    private Integer amount;

    private String cityName;

    private String priceType;

    private String areaInfo;

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	@Override
	public String toString() {
		return "GCouponRestVo [couponId=" + couponId + ", name=" + name + ", amount=" + amount + ", cityName="
				+ cityName + ", priceType=" + priceType + ", areaInfo=" + areaInfo + "]";
	}

}