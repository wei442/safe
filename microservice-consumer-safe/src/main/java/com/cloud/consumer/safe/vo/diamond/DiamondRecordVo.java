package com.ochain.consumer.wheel.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DiamondRecordVo implements Serializable  {

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

    private Date useTime;

    private Integer isUse;

    private Integer status;

    private Long registryNo;

    private String remark;

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

	public Date getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "DiamondRecordVo [diamondRecordId=" + diamondRecordId + ", userId=" + userId + ", diamondCode="
				+ diamondCode + ", diamondName=" + diamondName + ", diamondType=" + diamondType + ", location="
				+ location + ", diamond=" + diamond + ", useTime=" + useTime + ", isUse=" + isUse + ", status=" + status
				+ ", registryNo=" + registryNo + ", remark=" + remark + "]";
	}

}