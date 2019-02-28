package com.ochain.consumer.wheel.vo.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountLogVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private BigDecimal diamond;

    private String content;

    private BigDecimal balance;

    private Date createTime;

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

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AccountLogVo [diamond=" + diamond + ", content=" + content + ", balance=" + balance + ", createTime="
				+ createTime + "]";
	}

}