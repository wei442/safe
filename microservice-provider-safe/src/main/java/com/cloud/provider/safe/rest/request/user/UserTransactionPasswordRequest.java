package com.cloud.provider.safe.rest.request.user;

import com.cloud.provider.safe.boot.BootRestRequest;

public class UserTransactionPasswordRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userTransactionPasswordId;

    private Integer userId;

    private String password;

    private Integer status;

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

	@Override
	public String toString() {
		return "userTransactionPassword [userTransactionPasswordId=" + userTransactionPasswordId + ", userId=" + userId
				+ ", password=" + password + ", status=" + status + "]";
	}

}