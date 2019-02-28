package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class UserLoginLog implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userLoginLogId;

    private Integer userId;

    private Integer loginType;

    private Date loginTime;

    private Integer logType;

    private String loginIp;

    private Date createTime;

    private Date updateTime;

    public Long getUserLoginLogId() {
        return userLoginLogId;
    }

    public void setUserLoginLogId(Long userLoginLogId) {
        this.userLoginLogId = userLoginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
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
		return "UserLoginLog [userLoginLogId=" + userLoginLogId + ", userId=" + userId + ", loginType=" + loginType
				+ ", loginTime=" + loginTime + ", logType=" + logType + ", loginIp=" + loginIp + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

}