package com.cloud.queue.safe.vo.user;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 用户登录日志 UserLoginLogVo
 * @author wei.yong
 */
public class UserLoginLogVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String loginIp;

	private Date loginTime;

    private Integer loginType;

    private Integer logType;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
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
		return "UserLoginLogVo [userId=" + userId + ", loginIp=" + loginIp + ", loginTime=" + loginTime + ", loginType="
				+ loginType + ", logType=" + logType + "]";
	}

}