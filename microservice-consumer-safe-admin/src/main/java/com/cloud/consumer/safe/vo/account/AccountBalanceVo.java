package com.ochain.consumer.wheel.vo.account;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountBalanceVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountId;

    private Integer userId;

    private BigDecimal diamond;

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	@Override
	public String toString() {
		return "AccountBalanceVo [accountId=" + accountId + ", userId=" + userId + ", diamond=" + diamond + "]";
	}

}