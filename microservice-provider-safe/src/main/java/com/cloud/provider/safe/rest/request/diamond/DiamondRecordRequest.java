package com.cloud.provider.safe.rest.request.diamond;

import java.math.BigDecimal;
import java.util.Date;

import com.cloud.provider.safe.boot.BootRestRequest;

public class DiamondRecordRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long diamondRecordId;

    private Integer userId;

    private String diamondCode;

    private String diamondName;

    private Integer diamondType;

    private String location;

    private BigDecimal diamond;

    private Double percent;

    private BigDecimal sendAmount;

    private Long registryNo;

    private Date drawTime;

	public Long getDiamondRecordId() {
		return this.diamondRecordId;
	}

	public void setDiamondRecordId(Long diamondRecordId) {
		this.diamondRecordId = diamondRecordId;
	}

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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	public Double getPercent() {
		return this.percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public BigDecimal getSendAmount() {
		return this.sendAmount;
	}

	public void setSendAmount(BigDecimal sendAmount) {
		this.sendAmount = sendAmount;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	public Date getDrawTime() {
		return this.drawTime;
	}

	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}

	@Override
	public String toString() {
		return "DiamondRecordRequest [diamondRecordId=" + diamondRecordId + ", userId=" + userId + ", diamondCode="
				+ diamondCode + ", diamondName=" + diamondName + ", diamondType=" + diamondType + ", location="
				+ location + ", diamond=" + diamond + ", percent=" + percent + ", sendAmount=" + sendAmount
				+ ", registryNo=" + registryNo + ", drawTime=" + drawTime + "]";
	}

}