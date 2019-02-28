package com.ochain.provider.wheel.param;

import java.io.Serializable;

/**
 * 功能描述：优惠券日志查询
 * @Package: com.ochain.provider.wheel.param
 * @author: TM.WANG
 * @date: 2018年7月26日
 */
public class CouponLogParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer couponId;

    private Integer status;

    private Integer couponType;
	//排名时间开始时间字符串
  	protected String couponTimeStartStr;

  	//排名时间结束时间字符串
  	protected String couponTimeEndStr;

    private String userAccount;

  	//gofun优惠券ID
    private String gCouponId;

	//gofun优惠券名称
    private String gName;

	//gofun优惠券使用说明
    private String gCityName;

	//gofun优惠券使用范围
    private String gAreaInfo;

  	//排序
  	private String orderByClause;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCouponTimeStartStr() {
		return couponTimeStartStr;
	}

	public void setCouponTimeStartStr(String couponTimeStartStr) {
		this.couponTimeStartStr = couponTimeStartStr;
	}

	public String getCouponTimeEndStr() {
		return couponTimeEndStr;
	}

	public void setCouponTimeEndStr(String couponTimeEndStr) {
		this.couponTimeEndStr = couponTimeEndStr;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	@Override
	public String toString() {
		return "CouponLogParam [couponId=" + couponId + ", status=" + status + ", couponType=" + couponType
				+ ", couponTimeStartStr=" + couponTimeStartStr + ", couponTimeEndStr=" + couponTimeEndStr
				+ ", userAccount=" + userAccount + ", gCouponId=" + gCouponId + ", gName=" + gName + ", gCityName="
				+ gCityName + ", gAreaInfo=" + gAreaInfo + ", orderByClause=" + orderByClause + "]";
	}

}