package com.cloud.provider.safe.vo.danger;

import java.util.Date;

public class Danger {
    private Integer id;

    private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String dangerSite;

    private Integer dangerLevel;

    private String dangerCategory;

    private String dangerSubCategory;

    private Date dangerTime;

    private String dangerDesc;

    private Integer dangerUserId;

    private String dangeUserAccount;

    private String dangeUserName;

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

    public String getDangerCategory() {
        return dangerCategory;
    }

    public void setDangerCategory(String dangerCategory) {
        this.dangerCategory = dangerCategory == null ? null : dangerCategory.trim();
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

    public String getDangeUserAccount() {
        return dangeUserAccount;
    }

    public void setDangeUserAccount(String dangeUserAccount) {
        this.dangeUserAccount = dangeUserAccount == null ? null : dangeUserAccount.trim();
    }

    public String getDangeUserName() {
        return dangeUserName;
    }

    public void setDangeUserName(String dangeUserName) {
        this.dangeUserName = dangeUserName == null ? null : dangeUserName.trim();
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