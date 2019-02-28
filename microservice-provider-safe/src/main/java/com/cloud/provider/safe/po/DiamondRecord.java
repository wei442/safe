package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DiamondRecord implements Serializable {

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

    private Date createTime;

    private Date updateTime;

    private String remark;

    public Long getDiamondRecordId() {
        return diamondRecordId;
    }

    public void setDiamondRecordId(Long diamondRecordId) {
        this.diamondRecordId = diamondRecordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode == null ? null : diamondCode.trim();
    }

    public String getDiamondName() {
        return diamondName;
    }

    public void setDiamondName(String diamondName) {
        this.diamondName = diamondName == null ? null : diamondName.trim();
    }

    public Integer getDiamondType() {
        return diamondType;
    }

    public void setDiamondType(Integer diamondType) {
        this.diamondType = diamondType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public BigDecimal getDiamond() {
        return diamond;
    }

    public void setDiamond(BigDecimal diamond) {
        this.diamond = diamond;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRegistryNo() {
        return registryNo;
    }

    public void setRegistryNo(Long registryNo) {
        this.registryNo = registryNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "DiamondRecord [diamondRecordId=" + diamondRecordId + ", userId=" + userId + ", diamondCode="
				+ diamondCode + ", diamondName=" + diamondName + ", diamondType=" + diamondType + ", location="
				+ location + ", diamond=" + diamond + ", useTime=" + useTime + ", isUse=" + isUse + ", status=" + status
				+ ", registryNo=" + registryNo + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", remark=" + remark + "]";
	}

}