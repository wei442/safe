package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class AccountCalculate implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountCalculateId;

    private Integer userId;

    private Integer calculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

    private Date createTime;

    private Date updateTime;

    public Integer getAccountCalculateId() {
        return accountCalculateId;
    }

    public void setAccountCalculateId(Integer accountCalculateId) {
        this.accountCalculateId = accountCalculateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCalculate() {
        return calculate;
    }

    public void setCalculate(Integer calculate) {
        this.calculate = calculate;
    }

    public Integer getCivilizeCalculate() {
        return civilizeCalculate;
    }

    public void setCivilizeCalculate(Integer civilizeCalculate) {
        this.civilizeCalculate = civilizeCalculate;
    }

    public Integer getTaskCalculate() {
        return taskCalculate;
    }

    public void setTaskCalculate(Integer taskCalculate) {
        this.taskCalculate = taskCalculate;
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
		return "AccountCalculate [accountCalculateId=" + accountCalculateId + ", userId=" + userId + ", calculate="
				+ calculate + ", civilizeCalculate=" + civilizeCalculate + ", taskCalculate=" + taskCalculate
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}


}