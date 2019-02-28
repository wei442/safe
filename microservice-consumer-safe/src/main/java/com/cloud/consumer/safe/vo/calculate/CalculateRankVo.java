package com.ochain.consumer.wheel.vo.calculate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CalculateRankVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long accountLogId;

    private Integer accountId;

    private BigDecimal diamond;

    private Integer calculate;

    private String content;

    private Integer type;

    private Integer calculateType;

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

    public Integer getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(Integer calculateType) {
        this.calculateType = calculateType;
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
				+ ", calculate=" + calculate + ", content=" + content + ", type=" + type + ", calculateType="
				+ calculateType + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}