package com.cloud.consumer.safe.vo.account;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountDiamondVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userAccount;

	private Integer accountId;

    private String diamondCode;

    private String diamondName;

    private Integer diamondType;

    private BigDecimal diamond;

    private Integer loginCount;

    private String source;

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

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getDiamondCode() {
		return this.diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public String getDiamondName() {
		return this.diamondName;
	}

	public void setDiamondName(String diamondName) {
		this.diamondName = diamondName;
	}

	public Integer getDiamondType() {
		return this.diamondType;
	}

	public void setDiamondType(Integer diamondType) {
		this.diamondType = diamondType;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "AccountDiamondVo [userId=" + userId + ", userAccount=" + userAccount + ", accountId=" + accountId
				+ ", diamondCode=" + diamondCode + ", diamondName=" + diamondName + ", diamondType=" + diamondType
				+ ", diamond=" + diamond + ", loginCount=" + loginCount + ", source=" + source + "]";
	}

}