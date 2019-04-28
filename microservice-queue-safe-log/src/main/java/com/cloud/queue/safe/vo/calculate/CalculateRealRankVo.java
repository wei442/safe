package com.cloud.queue.safe.vo.calculate;

import java.io.Serializable;

public class CalculateRealRankVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

    private Integer calculate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getCalculate() {
		return calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	@Override
	public String toString() {
		return "CalculateRealRankVo [userId=" + userId + ", userAccount=" + userAccount + ", calculate=" + calculate
				+ "]";
	}

}