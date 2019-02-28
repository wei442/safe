package com.ochain.provider.wheel.rest.request.user;

import java.util.Date;

import com.ochain.provider.wheel.boot.BootRestRequest;

/**
 * 用户登录日志请求
 * @author wei.yong
 *
 */
public class UserLoginLogRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	//用户id
	private Integer userId;

	//登录时间
	private Date loginTime;

	//登录类型
	private Integer loginType;

	//日志类型
    private Integer logType;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public Integer getLogType() {
		return this.logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	@Override
	public String toString() {
		return "UserLoginLogRequest [userId=" + userId + ", loginTime=" + loginTime + ", loginType=" + loginType
				+ ", logType=" + logType + "]";
	}

}