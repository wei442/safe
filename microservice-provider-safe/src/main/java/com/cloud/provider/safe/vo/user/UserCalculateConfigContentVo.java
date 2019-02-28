package com.ochain.provider.wheel.vo.user;

import java.io.Serializable;
import java.util.Date;

public class UserCalculateConfigContentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer calculateConfigId;

    private String calculateCode;

    private String calculateName;

    private Integer calculateType;

    private Object content;

    private Integer isUse;

    private String url;

    private Integer isSkip;

    private Integer isDelete;

    private String remark;

    private Long userCalculateConfigId;

    private Date completeTime;

    private Integer isComplete;

	public Integer getCalculateConfigId() {
		return this.calculateConfigId;
	}

	public void setCalculateConfigId(Integer calculateConfigId) {
		this.calculateConfigId = calculateConfigId;
	}

	public String getCalculateCode() {
		return this.calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public String getCalculateName() {
		return this.calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsSkip() {
		return this.isSkip;
	}

	public void setIsSkip(Integer isSkip) {
		this.isSkip = isSkip;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getUserCalculateConfigId() {
		return this.userCalculateConfigId;
	}

	public void setUserCalculateConfigId(Long userCalculateConfigId) {
		this.userCalculateConfigId = userCalculateConfigId;
	}

	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Integer getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return "UserCalculateConfigContentVo [calculateConfigId=" + calculateConfigId + ", calculateCode="
				+ calculateCode + ", calculateName=" + calculateName + ", calculateType=" + calculateType + ", content="
				+ content + ", isUse=" + isUse + ", url=" + url + ", isSkip=" + isSkip + ", isDelete=" + isDelete
				+ ", remark=" + remark + ", userCalculateConfigId=" + userCalculateConfigId + ", completeTime="
				+ completeTime + ", isComplete=" + isComplete + "]";
	}

}