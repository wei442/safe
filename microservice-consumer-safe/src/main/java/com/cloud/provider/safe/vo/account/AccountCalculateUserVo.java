package com.ochain.provider.wheel.vo.account;

import java.io.Serializable;

public class AccountCalculateUserVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountCalculateId;

    private Integer calculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

    private Integer userId;

    private String userAccount;

	public Integer getAccountCalculateId() {
		return this.accountCalculateId;
	}

	public void setAccountCalculateId(Integer accountCalculateId) {
		this.accountCalculateId = accountCalculateId;
	}

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getCivilizeCalculate() {
		return this.civilizeCalculate;
	}

	public void setCivilizeCalculate(Integer civilizeCalculate) {
		this.civilizeCalculate = civilizeCalculate;
	}

	public Integer getTaskCalculate() {
		return this.taskCalculate;
	}

	public void setTaskCalculate(Integer taskCalculate) {
		this.taskCalculate = taskCalculate;
	}

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

	@Override
	public String toString() {
		return "AccountCalculateUserVo [accountCalculateId=" + accountCalculateId + ", calculate=" + calculate
				+ ", civilizeCalculate=" + civilizeCalculate + ", taskCalculate=" + taskCalculate + ", userId=" + userId
				+ ", userAccount=" + userAccount + "]";
	}

}