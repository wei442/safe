package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class AccountCalculateLog implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long accountCalculateLogId;

    private Integer accountCalculateId;

    private Integer calculate;

    private String content;

    private Integer type;

    private Integer status;

    private Integer calculateType;

    private Integer balance;

    private String source;

    private Date createTime;

    private Date updateTime;

    public Long getAccountCalculateLogId() {
        return accountCalculateLogId;
    }

    public void setAccountCalculateLogId(Long accountCalculateLogId) {
        this.accountCalculateLogId = accountCalculateLogId;
    }

    public Integer getAccountCalculateId() {
        return accountCalculateId;
    }

    public void setAccountCalculateId(Integer accountCalculateId) {
        this.accountCalculateId = accountCalculateId;
    }

    public Integer getCalculate() {
        return calculate;
    }

    public void setCalculate(Integer calculate) {
        this.calculate = calculate;
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

    public Integer getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(Integer calculateType) {
        this.calculateType = calculateType;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
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
		return "AccountCalculateLog [accountCalculateLogId=" + accountCalculateLogId + ", accountCalculateId="
				+ accountCalculateId + ", calculate=" + calculate + ", content=" + content + ", type=" + type
				+ ", status=" + status + ", calculateType=" + calculateType + ", balance=" + balance + ", source="
				+ source + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}