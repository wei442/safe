package com.cloud.consumer.safe.vo.calculate;

import java.io.Serializable;

public class CalculateConfigVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer calculateConfigId;

    private String calculateCode;

    private String calculateName;

    private Integer calculateType;

    private String url;

    private Integer isSkip;

    private Integer isDelete;

    //周期 1-不限, 2-一周, 3-一次, 4-临时
  	private Integer period;

  	//奖励次数
  	private Integer times;

  	//算力值
  	private Integer calculate;

  	//是否启用 0-未启用, 1-已启用
  	private Integer isUse;

  	//系数
  	private Double ratio;

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

	public Double getRatio() {
		return this.ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CalculateConfigVo [calculateConfigId=" + calculateConfigId + ", calculateCode=" + calculateCode
				+ ", calculateName=" + calculateName + ", calculateType=" + calculateType + ", url=" + url + ", isSkip="
				+ isSkip + ", isDelete=" + isDelete + ", period=" + period + ", times=" + times + ", calculate="
				+ calculate + ", isUse=" + isUse + ", ratio=" + ratio + ", remark=" + remark + "]";
	}

}