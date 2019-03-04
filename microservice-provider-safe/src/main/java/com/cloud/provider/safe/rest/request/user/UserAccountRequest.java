package com.cloud.provider.safe.rest.request.user;

import java.math.BigDecimal;

import com.cloud.provider.safe.boot.BootRestRequest;

/**
 * 用户账户请求
 * @author wei.yong
 */
public class UserAccountRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private Long accountLogId;

    private Integer accountId;

    private BigDecimal diamond;

    private String content;

    private Integer type;

    private BigDecimal balance;

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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UserAccountRequest [userId=" + userId + ", accountLogId=" + accountLogId + ", accountId=" + accountId
				+ ", diamond=" + diamond + ", content=" + content + ", type=" + type + ", balance=" + balance + "]";
	}

}