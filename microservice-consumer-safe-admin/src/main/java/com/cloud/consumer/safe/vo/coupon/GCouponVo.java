package com.cloud.consumer.safe.vo.coupon;

import java.io.Serializable;

public class GCouponVo implements Serializable {

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
        return gCouponId;
    }

    public void setgCouponId(String gCouponId) {
        this.gCouponId = gCouponId == null ? null : gCouponId.trim();
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Integer getgMoney() {
        return gMoney;
    }

    public void setgMoney(Integer gMoney) {
        this.gMoney = gMoney;
    }

    public String getgCityName() {
        return gCityName;
    }

    public void setgCityName(String gCityName) {
        this.gCityName = gCityName == null ? null : gCityName.trim();
    }

    public Integer getgPriceType() {
        return gPriceType;
    }

    public void setgPriceType(Integer gPriceType) {
        this.gPriceType = gPriceType;
    }

    public String getgAreaInfo() {
        return gAreaInfo;
    }

    public void setgAreaInfo(String gAreaInfo) {
        this.gAreaInfo = gAreaInfo == null ? null : gAreaInfo.trim();
    }

	@Override
	public String toString() {
		return "GCouponVo [gCouponId=" + gCouponId + ", gName=" + gName + ", gMoney=" + gMoney + ", gCityName="
				+ gCityName + ", gPriceType=" + gPriceType + ", gAreaInfo=" + gAreaInfo + "]";
	}

}