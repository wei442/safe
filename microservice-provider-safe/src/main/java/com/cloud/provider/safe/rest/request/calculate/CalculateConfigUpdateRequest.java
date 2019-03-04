package com.cloud.provider.safe.rest.request.calculate;

import com.cloud.provider.safe.boot.BootRestRequest;

public class CalculateConfigUpdateRequest  extends BootRestRequest {

	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer calculateConfigId;

	private String calculateCode;

	private String calculateName;

	private Integer calculateType;

	private Integer period;

	private Integer times;

	private Integer calculate;

	private Double ratio;

	private Integer isUse;

	private String url;

	private Integer isSkip;

	private Integer isDelete;

	private String remark;

	public Integer getCalculateConfigId() {
		return calculateConfigId;
	}

	public void setCalculateConfigId(Integer calculateConfigId) {
		this.calculateConfigId = calculateConfigId;
	}

	public String getCalculateCode() {
		return calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public String getCalculateName() {
		return calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	public Integer getCalculateType() {
		return calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getCalculate() {
		return calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsSkip() {
		return isSkip;
	}

	public void setIsSkip(Integer isSkip) {
		this.isSkip = isSkip;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CalculateConfigUpdateRequest [calculateConfigId=" + calculateConfigId + ", calculateCode="
				+ calculateCode + ", calculateName=" + calculateName + ", calculateType=" + calculateType + ", period="
				+ period + ", times=" + times + ", calculate=" + calculate + ", ratio=" + ratio + ", isUse=" + isUse
				+ ", url=" + url + ", isSkip=" + isSkip + ", isDelete=" + isDelete + ", remark=" + remark + "]";
	}

}