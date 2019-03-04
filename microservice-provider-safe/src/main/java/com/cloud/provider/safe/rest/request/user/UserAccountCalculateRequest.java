package com.cloud.provider.safe.rest.request.user;

import com.cloud.provider.safe.boot.BootRestRequest;

/**
 * 用户账户请求
 * @author wei.yong
 */
public class UserAccountCalculateRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private Long accountCalculateLogId;

    private Integer accountCalculateId;

    private Integer calculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

    private String content;

    private Integer type;

    private Integer calculateType;

    private Integer balance;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getAccountCalculateLogId() {
		return this.accountCalculateLogId;
	}

	public void setAccountCalculateLogId(Long accountCalculateLogId) {
		this.accountCalculateLogId = accountCalculateLogId;
	}

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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UserAccountCalculateRequest [userId=" + userId + ", accountCalculateLogId=" + accountCalculateLogId
				+ ", accountCalculateId=" + accountCalculateId + ", calculate=" + calculate + ", civilizeCalculate="
				+ civilizeCalculate + ", taskCalculate=" + taskCalculate + ", content=" + content + ", type=" + type
				+ ", calculateType=" + calculateType + ", balance=" + balance + "]";
	}

}