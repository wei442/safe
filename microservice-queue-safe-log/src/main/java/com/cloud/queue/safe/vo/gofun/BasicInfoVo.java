package com.cloud.queue.safe.vo.gofun;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 员工基本信息
 * @author wei.yong
 */
public class BasicInfoVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//用户ID
	@JSONField(name="userId")
	private String gId;

	//手机号码
	@JSONField(name="sim")
    private String userAccount;

	//押金  1已交或免交 0未交
	@JSONField(name="verifyDeposit")
	private String verifyDeposit;

	//驾驶证 1审核通过  0审核不通过
	@JSONField(name="verifyLicense")
	private String verifyLicense;

	//用户免密开关   1免密  0非免密
	@JSONField(name="freeSwitch")
	private String freeSwitch;

	//身份证 1 审核通过  0审核不通过
	@JSONField(name="verifyCard")
	private String verifyCard;

    //时间
    @JSONField(name="date")
    private String date;

	public String getgId() {
		return this.gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getVerifyDeposit() {
		return this.verifyDeposit;
	}

	public void setVerifyDeposit(String verifyDeposit) {
		this.verifyDeposit = verifyDeposit;
	}

	public String getVerifyLicense() {
		return this.verifyLicense;
	}

	public void setVerifyLicense(String verifyLicense) {
		this.verifyLicense = verifyLicense;
	}

	public String getFreeSwitch() {
		return this.freeSwitch;
	}

	public void setFreeSwitch(String freeSwitch) {
		this.freeSwitch = freeSwitch;
	}

	public String getVerifyCard() {
		return this.verifyCard;
	}

	public void setVerifyCard(String verifyCard) {
		this.verifyCard = verifyCard;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BasicInfoVo [gId=" + gId + ", userAccount=" + userAccount + ", verifyDeposit=" + verifyDeposit
				+ ", verifyLicense=" + verifyLicense + ", freeSwitch=" + freeSwitch + ", verifyCard=" + verifyCard
				+ ", date=" + date + "]";
	}

}