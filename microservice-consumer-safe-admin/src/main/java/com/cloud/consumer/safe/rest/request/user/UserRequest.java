package com.ochain.consumer.wheel.rest.request.user;

import java.io.Serializable;

import com.ochain.consumer.wheel.base.BaseRestRequest;

/**
 * 用户请求
 * @author wei.yong
 */
public class UserRequest extends BaseRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//gofun的token
	private String gToken;

	//gId
	private String gId;

	//手机号码
	private String userAccount;

	public String getgToken() {
		return this.gToken;
	}

	public void setgToken(String gToken) {
		this.gToken = gToken;
	}

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

	@Override
	public String toString() {
		return "UserRequest [gToken=" + gToken + ", gId=" + gId + ", userAccount=" + userAccount + "]";
	}

}