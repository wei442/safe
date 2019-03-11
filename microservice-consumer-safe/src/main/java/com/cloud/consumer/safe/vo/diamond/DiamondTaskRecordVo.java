package com.cloud.consumer.safe.vo.diamond;

import java.io.Serializable;

public class DiamondTaskRecordVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String diamondCode;

	private Integer userId;

	private Double percent;

	private Long registryNo;

	//来源类型
	private Integer sourceType;

	public String getDiamondCode() {
		return this.diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getPercent() {
		return this.percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}


}