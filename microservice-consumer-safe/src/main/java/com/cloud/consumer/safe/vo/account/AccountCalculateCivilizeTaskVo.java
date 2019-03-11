package com.cloud.consumer.safe.vo.account;

import java.io.Serializable;
import java.util.Date;

public class AccountCalculateCivilizeTaskVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String gId;

    private String gCode;

    private String userAccount;

    private String verifyStatus;

    private Integer score;

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

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
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
		return "AccountCalculateCivilizeTaskVo [gId=" + gId + ", gCode=" + gCode + ", userAccount=" + userAccount
				+ ", verifyStatus=" + verifyStatus + ", score=" + score + ", pushType=" + pushType + ", registryNo="
				+ registryNo + ", desc=" + desc + ", date=" + date + ", sourceType=" + sourceType + ", retry=" + retry
				+ "]";
	}

}