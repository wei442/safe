package com.cloud.provider.safe.param;

import java.io.Serializable;

public class UserCoinAddrParam implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userCoinAddrId;

    private Integer userId;

    private String coinCode;

    private String coinName;

    private Integer type;

    private Integer status;

	//排序
  	private String orderByClause;

    public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public Integer getUserCoinAddrId() {
        return userCoinAddrId;
    }

    public void setUserCoinAddrId(Integer userCoinAddrId) {
        this.userCoinAddrId = userCoinAddrId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode == null ? null : coinCode.trim();
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName == null ? null : coinName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "UserCoinAddrParam [userCoinAddrId=" + userCoinAddrId + ", userId=" + userId + ", coinCode=" + coinCode
				+ ", coinName=" + coinName + ", type=" + type + ", status=" + status + ", orderByClause="
				+ orderByClause + "]";
	}

}