package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class UserCalculateConfig implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userCalculateConfigId;

    private Integer userId;

    private String calculateCode;

    private Integer isComplete;

    private Date completeTime;

    private Integer isAdd;

    private Integer times;

    private Integer amount;

    private Date createTime;

    private Date updateTime;

    public Long getUserCalculateConfigId() {
        return userCalculateConfigId;
    }

    public void setUserCalculateConfigId(Long userCalculateConfigId) {
        this.userCalculateConfigId = userCalculateConfigId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCalculateCode() {
        return calculateCode;
    }

    public void setCalculateCode(String calculateCode) {
        this.calculateCode = calculateCode == null ? null : calculateCode.trim();
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(Integer isAdd) {
        this.isAdd = isAdd;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
		return "UserCalculateConfig [userCalculateConfigId=" + userCalculateConfigId + ", userId=" + userId
				+ ", calculateCode=" + calculateCode + ", isComplete=" + isComplete + ", completeTime=" + completeTime
				+ ", isAdd=" + isAdd + ", times=" + times + ", amount=" + amount + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}