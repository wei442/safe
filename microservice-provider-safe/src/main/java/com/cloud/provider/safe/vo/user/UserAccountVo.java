package com.ochain.provider.wheel.vo.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserAccountVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String gId;

    private String userAccount;

    private String userName;

    private String nickName;

    private Integer userType;

    private Integer gender;

    private Integer status;

    private String cityCode;

    private String cityName;

    private Integer isDelete;

    private Integer loginCount;

    private Integer accountId;

    private BigDecimal totalDiamond;

    private Long accountLogId;

    private BigDecimal diamond;

    private String content;

    private Integer accountLogType;

    private BigDecimal balance;

    private Date createTime;

    private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getTotalDiamond() {
		return totalDiamond;
	}

	public void setTotalDiamond(BigDecimal totalDiamond) {
		this.totalDiamond = totalDiamond;
	}

	public Long getAccountLogId() {
		return accountLogId;
	}

	public void setAccountLogId(Long accountLogId) {
		this.accountLogId = accountLogId;
	}

	public BigDecimal getDiamond() {
		return diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAccountLogType() {
		return accountLogType;
	}

	public void setAccountLogType(Integer accountLogType) {
		this.accountLogType = accountLogType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserAccountVo [userId=" + userId + ", gId=" + gId + ", userAccount=" + userAccount + ", userName="
				+ userName + ", nickName=" + nickName + ", userType=" + userType + ", gender=" + gender + ", status="
				+ status + ", cityCode=" + cityCode + ", cityName=" + cityName + ", isDelete=" + isDelete
				+ ", loginCount=" + loginCount + ", accountId=" + accountId + ", totalDiamond=" + totalDiamond
				+ ", accountLogId=" + accountLogId + ", diamond=" + diamond + ", content=" + content
				+ ", accountLogType=" + accountLogType + ", balance=" + balance + ", createTime=" + createTime
				+ ", source=" + source + "]";
	}

}