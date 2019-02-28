package com.ochain.provider.wheel.vo.user;

import java.io.Serializable;
import java.util.Date;

public class UserCalculateConfigVo implements Serializable {

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

    private Integer isUse;

    private String url;

    private Integer isSkip;

    private Integer isDelete;

    private Long userCalculateConfigId;

    private Date completeTime;

    private Integer isComplete;

    private String remark;

	public Integer getCalculateConfigId() {
		return this.calculateConfigId;
	}

	public void setCalculateConfigId(Integer calculateConfigId) {
		this.calculateConfigId = calculateConfigId;
	}

	public String getCalculateCode() {
		return this.calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public String getCalculateName() {
		return this.calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsSkip() {
		return this.isSkip;
	}

	public void setIsSkip(Integer isSkip) {
		this.isSkip = isSkip;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getUserCalculateConfigId() {
		return this.userCalculateConfigId;
	}

	public void setUserCalculateConfigId(Long userCalculateConfigId) {
		this.userCalculateConfigId = userCalculateConfigId;
	}

	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Integer getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserCalculateConfigVo [calculateConfigId=" + calculateConfigId + ", calculateCode=" + calculateCode
				+ ", calculateName=" + calculateName + ", calculateType=" + calculateType + ", period=" + period
				+ ", times=" + times + ", calculate=" + calculate + ", isUse=" + isUse + ", url=" + url + ", isSkip="
				+ isSkip + ", isDelete=" + isDelete + ", userCalculateConfigId=" + userCalculateConfigId
				+ ", completeTime=" + completeTime + ", isComplete=" + isComplete + ", remark=" + remark + "]";
	}

}