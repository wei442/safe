package com.cloud.provider.safe.rest.request.account;

import java.math.BigDecimal;

import com.cloud.provider.safe.boot.BootRestRequest;

/**
 * 账户日志请求
 * @author wei.yong
 */
public class AccountLogRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

  	private Integer userId;

	private Long accountLogId;

    private Integer accountId;

    private BigDecimal diamond;

    private String content;

    private Integer accountLogType;

    private Integer accountLogStatus;

    private BigDecimal balance;

    private String source;

    private Long diamondRecordId;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getAccountLogId() {
		return this.accountLogId;
	}

	public void setAccountLogId(Long accountLogId) {
		this.accountLogId = accountLogId;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAccountLogType() {
		return this.accountLogType;
	}

	public void setAccountLogType(Integer accountLogType) {
		this.accountLogType = accountLogType;
	}

	public Integer getAccountLogStatus() {
		return this.accountLogStatus;
	}

	public void setAccountLogStatus(Integer accountLogStatus) {
		this.accountLogStatus = accountLogStatus;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getSource() {
		return this.source;
	}

	public Long getDiamondRecordId() {
		return this.diamondRecordId;
	}

	public void setDiamondRecordId(Long diamondRecordId) {
		this.diamondRecordId = diamondRecordId;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "AccountLogRequest [userId=" + userId + ", accountLogId=" + accountLogId + ", accountId=" + accountId
				+ ", diamond=" + diamond + ", content=" + content + ", accountLogType=" + accountLogType
				+ ", accountLogStatus=" + accountLogStatus + ", balance=" + balance + ", source=" + source
				+ ", diamondRecordId=" + diamondRecordId + "]";
	}

}