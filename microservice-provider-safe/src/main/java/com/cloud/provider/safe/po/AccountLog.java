package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountLog implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long accountLogId;

    private Integer accountId;

    private BigDecimal diamond;

    private String content;

    private Integer type;

    private Integer status;

    private BigDecimal balance;

    private String source;

    private Date createTime;

    private Date updateTime;

    public Long getAccountLogId() {
        return accountLogId;
    }

    public void setAccountLogId(Long accountLogId) {
        this.accountLogId = accountLogId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getDiamond() {
        return diamond;
    }

    public void setDiamond(BigDecimal diamond) {
        this.diamond = diamond;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "AccountLog [accountLogId=" + accountLogId + ", accountId=" + accountId + ", diamond=" + diamond
				+ ", content=" + content + ", type=" + type + ", status=" + status + ", balance=" + balance
				+ ", source=" + source + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}