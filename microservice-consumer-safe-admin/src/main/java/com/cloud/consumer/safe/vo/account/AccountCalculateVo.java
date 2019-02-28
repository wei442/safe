package com.ochain.consumer.wheel.vo.account;

public class AccountCalculateVo {

	private Integer accountCalculateId;

    private Integer userId;

    private Integer calculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

	public Integer getAccountCalculateId() {
		return accountCalculateId;
	}

	public void setAccountCalculateId(Integer accountCalculateId) {
		this.accountCalculateId = accountCalculateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCalculate() {
		return calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getCivilizeCalculate() {
		return civilizeCalculate;
	}

	public void setCivilizeCalculate(Integer civilizeCalculate) {
		this.civilizeCalculate = civilizeCalculate;
	}

	public Integer getTaskCalculate() {
		return taskCalculate;
	}

	public void setTaskCalculate(Integer taskCalculate) {
		this.taskCalculate = taskCalculate;
	}

	@Override
	public String toString() {
		return "AccountCalculateVo [accountCalculateId=" + accountCalculateId + ", userId=" + userId + ", calculate="
				+ calculate + ", civilizeCalculate=" + civilizeCalculate + ", taskCalculate=" + taskCalculate + "]";
	}

}