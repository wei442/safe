package com.ochain.provider.wheel.rest.request.user;

import java.util.Date;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class UserSignRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userSignId;

    private Integer userId;

    private Date signTime;

    private Integer signDays;

    private Date signTimeStart;

    private Date signTimeEnd;

	public Long getUserSignId() {
		return userSignId;
	}

	public void setUserSignId(Long userSignId) {
		this.userSignId = userSignId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Integer getSignDays() {
		return signDays;
	}

	public void setSignDays(Integer signDays) {
		this.signDays = signDays;
	}

	public Date getSignTimeStart() {
		return this.signTimeStart;
	}

	public void setSignTimeStart(Date signTimeStart) {
		this.signTimeStart = signTimeStart;
	}

	public Date getSignTimeEnd() {
		return this.signTimeEnd;
	}

	public void setSignTimeEnd(Date signTimeEnd) {
		this.signTimeEnd = signTimeEnd;
	}

	@Override
	public String toString() {
		return "UserSignRequest [userSignId=" + userSignId + ", userId=" + userId + ", signTime=" + signTime
				+ ", signDays=" + signDays + ", signTimeStart=" + signTimeStart + ", signTimeEnd=" + signTimeEnd + "]";
	}

}