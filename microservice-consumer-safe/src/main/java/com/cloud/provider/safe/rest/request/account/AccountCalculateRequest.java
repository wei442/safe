package com.ochain.provider.wheel.rest.request.account;

import com.ochain.provider.wheel.boot.BootRestRequest;

/**
 * 账户算力请求
 * @author wei.yong
 */
public class AccountCalculateRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	private Integer accountCalculateId;

    private Integer userId;

    private Integer payCalculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

    private Integer calculateType;

	public Integer getAccountCalculateId() {
		return this.accountCalculateId;
	}

	public void setAccountCalculateId(Integer accountCalculateId) {
		this.accountCalculateId = accountCalculateId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPayCalculate() {
		return this.payCalculate;
	}

	public void setPayCalculate(Integer payCalculate) {
		this.payCalculate = payCalculate;
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

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	@Override
	public String toString() {
		return "AccountCalculateRequest [accountCalculateId=" + accountCalculateId + ", userId=" + userId
				+ ", payCalculate=" + payCalculate + ", civilizeCalculate=" + civilizeCalculate + ", taskCalculate="
				+ taskCalculate + ", calculateType=" + calculateType + "]";
	}

}