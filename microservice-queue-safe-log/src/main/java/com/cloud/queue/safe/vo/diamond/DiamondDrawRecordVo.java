package com.cloud.queue.safe.vo.diamond;

import java.io.Serializable;
import java.util.Date;

public class DiamondDrawRecordVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long diamondRecordId;

	private Integer userId;

	private String userAccount;

	//领取时间
	private Date drawTime;

	public Long getDiamondRecordId() {
		return this.diamondRecordId;
	}

	public void setDiamondRecordId(Long diamondRecordId) {
		this.diamondRecordId = diamondRecordId;
	}

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

	public Date getDrawTime() {
		return this.drawTime;
	}

	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}

	@Override
	public String toString() {
		return "DiamondDrawRecordVo [diamondRecordId=" + diamondRecordId + ", userId=" + userId + ", userAccount="
				+ userAccount + ", drawTime=" + drawTime + "]";
	}

}