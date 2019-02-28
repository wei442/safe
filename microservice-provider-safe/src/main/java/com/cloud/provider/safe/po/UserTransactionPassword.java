package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class UserTransactionPassword implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userTransactionPasswordId;

    private Integer userId;

    private String password;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getUserTransactionPasswordId() {
        return userTransactionPasswordId;
    }

    public void setUserTransactionPasswordId(Integer userTransactionPasswordId) {
        this.userTransactionPasswordId = userTransactionPasswordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
		return "UserTransactionPassword [userTransactionPasswordId=" + userTransactionPasswordId + ", userId=" + userId
				+ ", password=" + password + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}