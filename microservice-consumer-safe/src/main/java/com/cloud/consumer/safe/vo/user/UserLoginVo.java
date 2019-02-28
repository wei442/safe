package com.ochain.consumer.wheel.vo.user;

import java.io.Serializable;

/**
 *
 * 用户注册登录 Vo
 * @author wei.yong
 */
public class UserLoginVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String token;

	private String userAccount;

	private Integer isSign;

	private String gToken;

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getIsSign() {
		return this.isSign;
	}

	public void setIsSign(Integer isSign) {
		this.isSign = isSign;
	}

	public String getgToken() {
		return this.gToken;
	}

	public void setgToken(String gToken) {
		this.gToken = gToken;
	}

	@Override
	public String toString() {
		return "UserLoginVo [token=" + token + ", userAccount=" + userAccount + ", isSign=" + isSign + ", gToken="
				+ gToken + "]";
	}

}