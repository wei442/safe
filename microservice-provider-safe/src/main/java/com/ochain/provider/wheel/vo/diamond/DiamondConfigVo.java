package com.ochain.provider.wheel.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DiamondConfigVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer diamondConfigId;

    private String diamondCode;

    private String diamondName;

    private Integer diamondType;

    private BigDecimal sendAmount;

    private Integer isFix;

    private BigDecimal fixSendAmount;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    public Integer getDiamondConfigId() {
        return diamondConfigId;
    }

    public void setDiamondConfigId(Integer diamondConfigId) {
        this.diamondConfigId = diamondConfigId;
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

    public BigDecimal getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(BigDecimal sendAmount) {
        this.sendAmount = sendAmount;
    }

    public Integer getIsFix() {
        return isFix;
    }

    public void setIsFix(Integer isFix) {
        this.isFix = isFix;
    }

    public BigDecimal getFixSendAmount() {
        return fixSendAmount;
    }

    public void setFixSendAmount(BigDecimal fixSendAmount) {
        this.fixSendAmount = fixSendAmount;
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

	@Override
	public String toString() {
		return "DiamondConfigVo [diamondConfigId=" + diamondConfigId + ", diamondCode=" + diamondCode + ", diamondName="
				+ diamondName + ", diamondType=" + diamondType + ", sendAmount=" + sendAmount + ", isFix=" + isFix
				+ ", fixSendAmount=" + fixSendAmount + ", isDelete=" + isDelete + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}