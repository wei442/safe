package com.cloud.provider.safe.rest.request.user;

import com.cloud.provider.safe.boot.BootRestRequest;

public class UserCalculateConfigRequest  extends BootRestRequest {

	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userCalculateConfigId;

    private Integer userId;

    private String calculateCode;

    private Integer isComplete;

    private Integer calculateType;

    private Integer sourceType;

    private Integer isAdd;

    private Integer amount;

	public Long getUserCalculateConfigId() {
		return this.userCalculateConfigId;
	}

	public void setUserCalculateConfigId(Long userCalculateConfigId) {
		this.userCalculateConfigId = userCalculateConfigId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCalculateCode() {
		return this.calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public Integer getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getIsAdd() {
		return this.isAdd;
	}

	public void setIsAdd(Integer isAdd) {
		this.isAdd = isAdd;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UserCalculateConfigRequest [userCalculateConfigId=" + userCalculateConfigId + ", userId=" + userId
				+ ", calculateCode=" + calculateCode + ", isComplete=" + isComplete + ", calculateType=" + calculateType
				+ ", sourceType=" + sourceType + ", isAdd=" + isAdd + ", amount=" + amount + "]";
	}

}