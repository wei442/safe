package com.cloud.provider.safe.rest.request.account;

import com.cloud.provider.safe.boot.BootRestRequest;

/**
 * 账户算力日志请求
 * @author wei.yong
 */
public class AccountCalculateLogRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

  	private Integer userId;

	private Long accountCalculateLogId;

    private Integer accountCalculateId;

    private Integer calculate;

    private String content;

    private Integer accountCalculateLogType;

    private Integer accountCalculateLogStatus;

    private Integer calculateType;

    private Integer balance;

    private String source;

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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAccountCalculateLogType() {
		return this.accountCalculateLogType;
	}

	public void setAccountCalculateLogType(Integer accountCalculateLogType) {
		this.accountCalculateLogType = accountCalculateLogType;
	}

	public Integer getAccountCalculateLogStatus() {
		return this.accountCalculateLogStatus;
	}

	public void setAccountCalculateLogStatus(Integer accountCalculateLogStatus) {
		this.accountCalculateLogStatus = accountCalculateLogStatus;
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

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "AccountCalculateLogRequest [userId=" + userId + ", accountCalculateLogId=" + accountCalculateLogId
				+ ", accountCalculateId=" + accountCalculateId + ", calculate=" + calculate + ", content=" + content
				+ ", accountCalculateLogType=" + accountCalculateLogType + ", accountCalculateLogStatus="
				+ accountCalculateLogStatus + ", calculateType=" + calculateType + ", balance=" + balance + ", source="
				+ source + "]";
	}

}