package com.cloud.provider.safe.param;

import java.io.Serializable;

/**
 * 用户交易密码请求 UserTransactionPasswordParam
 * @author wei.yong
 */
public class UserTransactionPasswordParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    //用户id
  	private Integer userId;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserTransactionPasswordParam [userId=" + userId + "]";
	}

}