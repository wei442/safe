package com.ochain.provider.wheel.vo.baseUser;

import java.util.Date;

public class BaseUserLoginLogVo {
    private Long baseUserLoginLogId;

    private Integer baseUserId;

    private Integer loginType;

    private Date loginTime;

    private Date createdTime;

    private Date updateTime;

    public Long getBaseUserLoginLogId() {
        return baseUserLoginLogId;
    }

    public void setBaseUserLoginLogId(Long baseUserLoginLogId) {
        this.baseUserLoginLogId = baseUserLoginLogId;
    }

    public Integer getBaseUserId() {
        return baseUserId;
    }

    public void setBaseUserId(Integer baseUserId) {
        this.baseUserId = baseUserId;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}