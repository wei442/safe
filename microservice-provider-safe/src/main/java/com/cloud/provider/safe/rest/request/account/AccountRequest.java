package com.cloud.provider.safe.rest.request.account;

import java.math.BigDecimal;

import com.cloud.provider.safe.boot.BootRestRequest;

/**
 * 账户请求
 * @author wei.yong
 */
public class AccountRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	private Integer accountId;

    private BigDecimal payDiamond;

    private BigDecimal diamond;

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getPayDiamond() {
		return this.payDiamond;
	}

	public void setPayDiamond(BigDecimal payDiamond) {
		this.payDiamond = payDiamond;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	@Override
	public String toString() {
		return "AccountRequest [accountId=" + accountId + ", payDiamond=" + payDiamond + ", diamond=" + diamond + "]";
	}

}