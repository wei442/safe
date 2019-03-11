package com.cloud.provider.safe.po;

import java.util.Date;

public class Enterprise {
    private Integer id;

    private String enterpriseName;

    private Integer enterpriseType;

    private Integer enterpriseNature;

    private Integer enterpriseStatus;

    private String enterpriseAlias;

    private String enterpriseTelphone;

    private Integer enterpriseLevel;

    private String enterpriseFax;

    private String enterpriseEmail;

    private String enterprisePostCode;

    private String enterpriseAddr;

    private String enterpriseWebsite;

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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Integer getEnterpriseNature() {
        return enterpriseNature;
    }

    public void setEnterpriseNature(Integer enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    public Integer getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(Integer enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEnterpriseAlias() {
        return enterpriseAlias;
    }

    public void setEnterpriseAlias(String enterpriseAlias) {
        this.enterpriseAlias = enterpriseAlias == null ? null : enterpriseAlias.trim();
    }

    public String getEnterpriseTelphone() {
        return enterpriseTelphone;
    }

    public void setEnterpriseTelphone(String enterpriseTelphone) {
        this.enterpriseTelphone = enterpriseTelphone == null ? null : enterpriseTelphone.trim();
    }

    public Integer getEnterpriseLevel() {
        return enterpriseLevel;
    }

    public void setEnterpriseLevel(Integer enterpriseLevel) {
        this.enterpriseLevel = enterpriseLevel;
    }

    public String getEnterpriseFax() {
        return enterpriseFax;
    }

    public void setEnterpriseFax(String enterpriseFax) {
        this.enterpriseFax = enterpriseFax == null ? null : enterpriseFax.trim();
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail == null ? null : enterpriseEmail.trim();
    }

    public String getEnterprisePostCode() {
        return enterprisePostCode;
    }

    public void setEnterprisePostCode(String enterprisePostCode) {
        this.enterprisePostCode = enterprisePostCode == null ? null : enterprisePostCode.trim();
    }

    public String getEnterpriseAddr() {
        return enterpriseAddr;
    }

    public void setEnterpriseAddr(String enterpriseAddr) {
        this.enterpriseAddr = enterpriseAddr == null ? null : enterpriseAddr.trim();
    }

    public String getEnterpriseWebsite() {
        return enterpriseWebsite;
    }

    public void setEnterpriseWebsite(String enterpriseWebsite) {
        this.enterpriseWebsite = enterpriseWebsite == null ? null : enterpriseWebsite.trim();
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