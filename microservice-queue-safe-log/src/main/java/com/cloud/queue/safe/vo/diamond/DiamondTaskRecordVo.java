package com.cloud.queue.safe.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiamondTaskRecordVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String diamondCode;

    private String diamondName;

    private Integer diamondType;

    private BigDecimal sendAmount;

    private Integer isFix;

    private BigDecimal fixSendAmount;

	private Double percent;

	private BigDecimal diamond;

	private Long registryNo;

	//来源类型
	private Integer sourceType;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDiamondCode() {
		return this.diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public String getDiamondName() {
		return this.diamondName;
	}

	public void setDiamondName(String diamondName) {
		this.diamondName = diamondName;
	}

	public Integer getDiamondType() {
		return this.diamondType;
	}

	public void setDiamondType(Integer diamondType) {
		this.diamondType = diamondType;
	}

	public BigDecimal getSendAmount() {
		return this.sendAmount;
	}

	public void setSendAmount(BigDecimal sendAmount) {
		this.sendAmount = sendAmount;
	}

	public Integer getIsFix() {
		return this.isFix;
	}

	public void setIsFix(Integer isFix) {
		this.isFix = isFix;
	}

	public BigDecimal getFixSendAmount() {
		return this.fixSendAmount;
	}

	public void setFixSendAmount(BigDecimal fixSendAmount) {
		this.fixSendAmount = fixSendAmount;
	}

	public Double getPercent() {
		return this.percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
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

	@Override
	public String toString() {
		return "DiamondTaskRecordVo [userId=" + userId + ", diamondCode=" + diamondCode + ", diamondName=" + diamondName
				+ ", diamondType=" + diamondType + ", sendAmount=" + sendAmount + ", isFix=" + isFix
				+ ", fixSendAmount=" + fixSendAmount + ", percent=" + percent + ", diamond=" + diamond + ", registryNo="
				+ registryNo + ", sourceType=" + sourceType + "]";
	}

}