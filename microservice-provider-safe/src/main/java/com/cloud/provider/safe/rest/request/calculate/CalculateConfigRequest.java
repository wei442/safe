package com.cloud.provider.safe.rest.request.calculate;

import java.util.Date;

import com.cloud.provider.safe.boot.BootRestRequest;

public class CalculateConfigRequest  extends BootRestRequest {

	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer calculateConfigId;

	private String calculateCode;

	private String calculateName;

	private Integer calculateType;

	private String content;

	private Integer isUse;

	private String url;

	private Integer isSkip;

	private Integer isDelete;

	private String remark;

	private Date createTime;

	private Date updateTime;

	public Integer getCalculateConfigId() {
		return calculateConfigId;
	}

	public void setCalculateConfigId(Integer calculateConfigId) {
		this.calculateConfigId = calculateConfigId;
	}

	public String getCalculateCode() {
		return calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public String getCalculateName() {
		return calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	public Integer getCalculateType() {
		return calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsSkip() {
		return isSkip;
	}

	public void setIsSkip(Integer isSkip) {
		this.isSkip = isSkip;
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
		this.remark = remark;
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
		return "CalculateConfigRequest [calculateConfigId=" + calculateConfigId + ", calculateCode=" + calculateCode
				+ ", calculateName=" + calculateName + ", calculateType=" + calculateType + ", content=" + content
				+ ", isUse=" + isUse + ", url=" + url + ", isSkip=" + isSkip + ", isDelete=" + isDelete + ", remark="
				+ remark + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}