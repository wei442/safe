package com.cloud.provider.safe.vo.risk;

import java.util.Date;

public class RiskDuty {
    private Integer id;

    private Integer riskId;

    private Integer dutyUserId;

    private String dutyUserAccount;

    private String dutyUserName;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRiskId() {
        return riskId;
    }

    public void setRiskId(Integer riskId) {
        this.riskId = riskId;
    }

    public Integer getDutyUserId() {
        return dutyUserId;
    }

    public void setDutyUserId(Integer dutyUserId) {
        this.dutyUserId = dutyUserId;
    }

    public String getDutyUserAccount() {
        return dutyUserAccount;
    }

    public void setDutyUserAccount(String dutyUserAccount) {
        this.dutyUserAccount = dutyUserAccount == null ? null : dutyUserAccount.trim();
    }

    public String getDutyUserName() {
        return dutyUserName;
    }

    public void setDutyUserName(String dutyUserName) {
        this.dutyUserName = dutyUserName == null ? null : dutyUserName.trim();
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