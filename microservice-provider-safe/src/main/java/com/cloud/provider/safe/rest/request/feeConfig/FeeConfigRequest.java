package com.cloud.provider.safe.rest.request.feeConfig;

import java.math.BigDecimal;

import com.cloud.provider.safe.boot.BootRestRequest;

/**
 * 手续费配置请求
 * @author wei.yong
 */
public class FeeConfigRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	private Integer feeConfigId;

    private String feeCode;

    private String feeName;

    private BigDecimal fee;

	public Integer getFeeConfigId() {
		return this.feeConfigId;
	}

	public void setFeeConfigId(Integer feeConfigId) {
		this.feeConfigId = feeConfigId;
	}

	public String getFeeCode() {
		return this.feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getFeeName() {
		return this.feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public BigDecimal getFee() {
		return this.fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "FeeConfigRequest [feeConfigId=" + feeConfigId + ", feeCode=" + feeCode + ", feeName=" + feeName
				+ ", fee=" + fee + "]";
	}

}