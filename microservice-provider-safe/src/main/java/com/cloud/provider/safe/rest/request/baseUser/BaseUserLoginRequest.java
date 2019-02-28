package com.ochain.provider.wheel.rest.request.baseUser;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class BaseUserLoginRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BaseUserLoginRequest [userName=" + userName + "]";
	}

}