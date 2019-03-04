package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseUserLoginLog implements Serializable {
    private Long Id;

    private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    private Date loginTime;

    private String loginIp;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Integer getBaseUserId() {
        return baseUserId;
    }

    public void setBaseUserId(Integer baseUserId) {
        this.baseUserId = baseUserId;
    }

    public String getBaseUserAccount() {
        return baseUserAccount;
    }

    public void setBaseUserAccount(String baseUserAccount) {
        this.baseUserAccount = baseUserAccount == null ? null : baseUserAccount.trim();
    }

    public String getBaseUserName() {
        return baseUserName;
    }

    public void setBaseUserName(String baseUserName) {
        this.baseUserName = baseUserName == null ? null : baseUserName.trim();
    }

    public String getBaseUserNameEn() {
        return baseUserNameEn;
    }

    public void setBaseUserNameEn(String baseUserNameEn) {
        this.baseUserNameEn = baseUserNameEn == null ? null : baseUserNameEn.trim();
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

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated == null ? null : updated.trim();
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
}