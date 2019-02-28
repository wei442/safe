package com.ochain.provider.wheel.vo.account;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountUserVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountId;

	private BigDecimal diamond;

	private Integer userId;

	private String userAccount;

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
		return "AccountUserVo [accountId=" + accountId + ", diamond=" + diamond + ", userId=" + userId
				+ ", userAccount=" + userAccount + "]";
	}

}