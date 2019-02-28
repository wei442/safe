package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FeeConfig implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer feeConfigId;

    private String feeCode;

    private String feeName;

    private BigDecimal fee;

    private Date createTime;

    private Date updateTime;

    public Integer getFeeConfigId() {
        return feeConfigId;
    }

    public void setFeeConfigId(Integer feeConfigId) {
        this.feeConfigId = feeConfigId;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode == null ? null : feeCode.trim();
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName == null ? null : feeName.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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
		return "FeeConfig [feeConfigId=" + feeConfigId + ", feeCode=" + feeCode + ", feeName=" + feeName + ", fee="
				+ fee + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}


}