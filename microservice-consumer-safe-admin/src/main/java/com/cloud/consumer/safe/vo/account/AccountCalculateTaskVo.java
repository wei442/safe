package com.ochain.consumer.wheel.vo.account;

import java.io.Serializable;
import java.util.Date;

public class AccountCalculateTaskVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String gId;

    private String gCode;

    private String userAccount;

    private String verifyStatus;

    private Integer verifyAmount;

    private Integer pushType;

    private Long registryNo;

    private String desc;

    private Date date;

    private Integer sourceType;

    //重试次数 默认为0
    private Integer retry =  0;

	public String getgId() {
		return this.gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgCode() {
		return this.gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getVerifyStatus() {
		return this.verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public Integer getVerifyAmount() {
		return this.verifyAmount;
	}

	public void setVerifyAmount(Integer verifyAmount) {
		this.verifyAmount = verifyAmount;
	}

	public Integer getPushType() {
		return this.pushType;
	}

	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getRetry() {
		return this.retry;
	}

	public void setRetry(Integer retry) {
		this.retry = retry;
	}

	@Override
	public String toString() {
		return "AccountCalculateTaskVo [gId=" + gId + ", gCode=" + gCode + ", userAccount=" + userAccount
				+ ", verifyStatus=" + verifyStatus + ", verifyAmount=" + verifyAmount + ", pushType=" + pushType
				+ ", registryNo=" + registryNo + ", desc=" + desc + ", date=" + date + ", sourceType=" + sourceType
				+ ", retry=" + retry + "]";
	}

}