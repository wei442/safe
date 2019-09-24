package com.cloud.provider.safe.po;

import java.util.Date;

public class Danger {
    private Integer id;

    private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String dangerSite;

    private Integer dangerLevel;

    private Integer dangerType;

    private String dangerMainCategory;

    private String dangerSubCategory;

    private Date dangerTime;

    private String dangerDesc;

    private Integer dangerUserId;

    private String dangerUserAccount;

    private String dangerUserName;

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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getDangerSite() {
        return dangerSite;
    }

    public void setDangerSite(String dangerSite) {
        this.dangerSite = dangerSite == null ? null : dangerSite.trim();
    }

    public Integer getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Integer dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public Integer getDangerType() {
        return dangerType;
    }

    public void setDangerType(Integer dangerType) {
        this.dangerType = dangerType;
    }

    public String getDangerMainCategory() {
        return dangerMainCategory;
    }

    public void setDangerMainCategory(String dangerMainCategory) {
        this.dangerMainCategory = dangerMainCategory == null ? null : dangerMainCategory.trim();
    }

    public String getDangerSubCategory() {
        return dangerSubCategory;
    }

    public void setDangerSubCategory(String dangerSubCategory) {
        this.dangerSubCategory = dangerSubCategory == null ? null : dangerSubCategory.trim();
    }

    public Date getDangerTime() {
        return dangerTime;
    }

    public void setDangerTime(Date dangerTime) {
        this.dangerTime = dangerTime;
    }

    public String getDangerDesc() {
        return dangerDesc;
    }

    public void setDangerDesc(String dangerDesc) {
        this.dangerDesc = dangerDesc == null ? null : dangerDesc.trim();
    }

    public Integer getDangerUserId() {
        return dangerUserId;
    }

    public void setDangerUserId(Integer dangerUserId) {
        this.dangerUserId = dangerUserId;
    }

    public String getDangerUserAccount() {
        return dangerUserAccount;
    }

    public void setDangerUserAccount(String dangerUserAccount) {
        this.dangerUserAccount = dangerUserAccount == null ? null : dangerUserAccount.trim();
    }

    public String getDangerUserName() {
        return dangerUserName;
    }

    public void setDangerUserName(String dangerUserName) {
        this.dangerUserName = dangerUserName == null ? null : dangerUserName.trim();
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