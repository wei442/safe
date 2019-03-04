package com.cloud.provider.safe.rest.request.user;

import com.cloud.provider.safe.boot.BootRestRequest;

public class UserAccountListRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountLogType;

	private String startTime;

	private String endTime;

	private String updateTime;

	private String userAccount;

	private String userName;

	public Integer getAccountLogType() {
		return accountLogType;
	}

	public void setAccountLogType(Integer accountLogType) {
		this.accountLogType = accountLogType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserAccountListRequest [accountLogType=" + accountLogType + ", startTime=" + startTime + ", endTime="
				+ endTime + ", updateTime=" + updateTime + ", userAccount=" + userAccount + ", userName=" + userName
				+ "]";
	}

}