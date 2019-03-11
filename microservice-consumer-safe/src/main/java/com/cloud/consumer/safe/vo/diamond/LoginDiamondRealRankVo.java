package com.cloud.consumer.safe.vo.diamond;

import java.io.Serializable;

public class LoginDiamondRealRankVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

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

	@Override
	public String toString() {
		return "LoginDiamondRealRankVo [userId=" + userId + ", userAccount=" + userAccount + "]";
	}

}