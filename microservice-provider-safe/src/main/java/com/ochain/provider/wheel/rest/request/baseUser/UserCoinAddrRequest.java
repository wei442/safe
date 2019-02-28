package com.ochain.provider.wheel.rest.request.baseUser;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class UserCoinAddrRequest extends BootRestRequest{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userCoinAddrId;

    private Integer userId;

    private String coinCode;

    private String coinName;

    private String privateKey;

    private String publicKey;

    private Integer type;

    private Integer status;

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

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
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
		return "userCoinAddrRequest [userCoinAddrId=" + userCoinAddrId + ", userId=" + userId + ", coinCode=" + coinCode
				+ ", coinName=" + coinName + ", privateKey=" + privateKey + ", publicKey=" + publicKey + ", type="
				+ type + ", status=" + status + "]";
	}

}