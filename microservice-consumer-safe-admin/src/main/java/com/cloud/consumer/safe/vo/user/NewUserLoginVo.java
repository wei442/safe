package com.cloud.consumer.safe.vo.user;

import java.io.Serializable;

/**
 *
 * 新用户登录 NewUserLoginVo
 * @author wei.yong
 */
public class NewUserLoginVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userAccount;

	private String diamondCode;

	private Integer signDays;

	//签到时间字符串
	private String signTimeStr;

	private Integer type;

	//用户签到时间缓存key
	private String queueUserSignTimeKey;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getDiamondCode() {
		return this.diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public Integer getSignDays() {
		return this.signDays;
	}

	public void setSignDays(Integer signDays) {
		this.signDays = signDays;
	}

	public String getSignTimeStr() {
		return this.signTimeStr;
	}

	public void setSignTimeStr(String signTimeStr) {
		this.signTimeStr = signTimeStr;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getQueueUserSignTimeKey() {
		return this.queueUserSignTimeKey;
	}

	public void setQueueUserSignTimeKey(String queueUserSignTimeKey) {
		this.queueUserSignTimeKey = queueUserSignTimeKey;
	}

	@Override
	public String toString() {
		return "NewUserLoginVo [userId=" + userId + ", userAccount=" + userAccount + ", diamondCode=" + diamondCode
				+ ", signDays=" + signDays + ", signTimeStr=" + signTimeStr + ", type=" + type
				+ ", queueUserSignTimeKey=" + queueUserSignTimeKey + "]";
	}

}