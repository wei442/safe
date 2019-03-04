package com.cloud.provider.safe.rest.request.coupon;

import com.cloud.provider.safe.boot.BootRestRequest;

public class GCouponRequest extends BootRestRequest {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String gCouponId;

    private String gName;

    private Integer gMoney;

    private String gCityName;

    private Integer gPriceType;

    private String gAreaInfo;

	public String getgCouponId() {
		return this.gCouponId;
	}

	public void setgCouponId(String gCouponId) {
		this.gCouponId = gCouponId;
	}

	public String getgName() {
		return this.gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Integer getgMoney() {
		return this.gMoney;
	}

	public void setgMoney(Integer gMoney) {
		this.gMoney = gMoney;
	}

	public String getgCityName() {
		return this.gCityName;
	}

	public void setgCityName(String gCityName) {
		this.gCityName = gCityName;
	}

	public Integer getgPriceType() {
		return this.gPriceType;
	}

	public void setgPriceType(Integer gPriceType) {
		this.gPriceType = gPriceType;
	}

	public String getgAreaInfo() {
		return this.gAreaInfo;
	}

	public void setgAreaInfo(String gAreaInfo) {
		this.gAreaInfo = gAreaInfo;
	}

	@Override
	public String toString() {
		return "GCouponRequest [gCouponId=" + gCouponId + ", gName=" + gName + ", gMoney=" + gMoney + ", gCityName="
				+ gCityName + ", gPriceType=" + gPriceType + ", gAreaInfo=" + gAreaInfo + "]";
	}

}