package com.cloud.provider.safe.po;

import java.util.Date;

public class Risk {
    private Integer id;

    private Integer enterpriseId;

    private String riskCode;

    private String riskWorkPlace;

    private String riskCategory;

    private String riskReason;

    private String riskLevel;

    private String controlReason;

    private String controlMethod;

    private Integer riskStatus;

    private Integer isDanger;

    private String frequency;

    private Integer isDelete;

    private String remark;

    private Integer sort;

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

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode == null ? null : riskCode.trim();
    }

    public String getRiskWorkPlace() {
        return riskWorkPlace;
    }

    public void setRiskWorkPlace(String riskWorkPlace) {
        this.riskWorkPlace = riskWorkPlace == null ? null : riskWorkPlace.trim();
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory == null ? null : riskCategory.trim();
    }

    public String getRiskReason() {
        return riskReason;
    }

    public void setRiskReason(String riskReason) {
        this.riskReason = riskReason == null ? null : riskReason.trim();
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    public String getControlReason() {
        return controlReason;
    }

    public void setControlReason(String controlReason) {
        this.controlReason = controlReason == null ? null : controlReason.trim();
    }

    public String getControlMethod() {
        return controlMethod;
    }

    public void setControlMethod(String controlMethod) {
        this.controlMethod = controlMethod == null ? null : controlMethod.trim();
    }

    public Integer getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(Integer riskStatus) {
        this.riskStatus = riskStatus;
    }

    public Integer getIsDanger() {
        return isDanger;
    }

    public void setIsDanger(Integer isDanger) {
        this.isDanger = isDanger;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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