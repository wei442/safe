package com.cloud.queue.safe.vo.user;

import java.io.Serializable;

public class UserCalculateConfigVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String calculateCode;

    private Integer isComplete;

    private Integer isAdd;

    private Integer verifyAmount;

    private Integer sourceType;

    //重试次数 默认为0
    private Integer retry =  0;

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

	public Integer getIsAdd() {
		return this.isAdd;
	}

	public void setIsAdd(Integer isAdd) {
		this.isAdd = isAdd;
	}

	public Integer getVerifyAmount() {
		return this.verifyAmount;
	}

	public void setVerifyAmount(Integer verifyAmount) {
		this.verifyAmount = verifyAmount;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getRetry() {
		return this.retry;
	}

	public void setRetry(Integer retry) {
		this.retry = retry;
	}

	@Override
	public String toString() {
		return "UserCalculateConfigVo [userId=" + userId + ", calculateCode=" + calculateCode + ", isComplete="
				+ isComplete + ", isAdd=" + isAdd + ", verifyAmount=" + verifyAmount + ", sourceType=" + sourceType
				+ ", retry=" + retry + "]";
	}

}