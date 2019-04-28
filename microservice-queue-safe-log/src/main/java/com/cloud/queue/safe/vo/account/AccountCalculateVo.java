package com.cloud.queue.safe.vo.account;

import java.io.Serializable;

public class AccountCalculateVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Integer userId;

    private String userAccount;

    private Integer accountCalculateId;

    private String calculateCode;

    private String calculateName;

    private Integer calculateType;

    //算力值
    private Integer calculate;

    private Integer loginCount;

    //重试次数 默认为0
    private Integer retry =  0;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getAccountCalculateId() {
		return this.accountCalculateId;
	}

	public void setAccountCalculateId(Integer accountCalculateId) {
		this.accountCalculateId = accountCalculateId;
	}

	public String getCalculateCode() {
		return this.calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public String getCalculateName() {
		return this.calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getRetry() {
		return this.retry;
	}

	public void setRetry(Integer retry) {
		this.retry = retry;
	}

	@Override
	public String toString() {
		return "AccountCalculateVo [userId=" + userId + ", userAccount=" + userAccount + ", accountCalculateId="
				+ accountCalculateId + ", calculateCode=" + calculateCode + ", calculateName=" + calculateName
				+ ", calculateType=" + calculateType + ", calculate=" + calculate + ", loginCount=" + loginCount
				+ ", retry=" + retry + "]";
	}

}