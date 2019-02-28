package com.ochain.provider.wheel.vo.coupon;

import java.io.Serializable;
import java.util.Date;

public class CouponAndGCouponVo implements Serializable {
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

    private String gCouponId;

    private String gName;

    private String gCityName;

    private String gAreaInfo;

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

	public String getgCouponId() {
		return gCouponId;
	}

	public void setgCouponId(String gCouponId) {
		this.gCouponId = gCouponId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgCityName() {
		return gCityName;
	}

	public void setgCityName(String gCityName) {
		this.gCityName = gCityName;
	}

	public String getgAreaInfo() {
		return gAreaInfo;
	}

	public void setgAreaInfo(String gAreaInfo) {
		this.gAreaInfo = gAreaInfo;
	}

	@Override
	public String toString() {
		return "CouponAndGCouponVo [couponId=" + couponId + ", url=" + url + ", price=" + price + ", couponType="
				+ couponType + ", amount=" + amount + ", diamond=" + diamond + ", isUse=" + isUse + ", isDelete="
				+ isDelete + ", createTime=" + createTime + ", updateTime=" + updateTime + ", gCouponId=" + gCouponId
				+ ", gName=" + gName + ", gCityName=" + gCityName + ", gAreaInfo=" + gAreaInfo + "]";
	}

}