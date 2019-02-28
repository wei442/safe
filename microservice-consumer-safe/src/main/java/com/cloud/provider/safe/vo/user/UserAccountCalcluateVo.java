package com.ochain.provider.wheel.vo.user;

import java.io.Serializable;
import java.util.Date;

public class UserAccountCalcluateVo implements Serializable {

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

    private Integer accountCalculateId;

    private Integer totalCalculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

    private Long accountCalculateLogId;

    private Integer calculate;

    private String content;

    private Integer accountCalculateLogType;

    private Integer calculateType;

    private Integer balance;

    private Date createTime;

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

	public Integer getAccountCalculateId() {
		return accountCalculateId;
	}

	public void setAccountCalculateId(Integer accountCalculateId) {
		this.accountCalculateId = accountCalculateId;
	}

	public Integer getTotalCalculate() {
		return totalCalculate;
	}

	public void setTotalCalculate(Integer totalCalculate) {
		this.totalCalculate = totalCalculate;
	}

	public Integer getCivilizeCalculate() {
		return civilizeCalculate;
	}

	public void setCivilizeCalculate(Integer civilizeCalculate) {
		this.civilizeCalculate = civilizeCalculate;
	}

	public Integer getTaskCalculate() {
		return taskCalculate;
	}

	public void setTaskCalculate(Integer taskCalculate) {
		this.taskCalculate = taskCalculate;
	}

	public Long getAccountCalculateLogId() {
		return accountCalculateLogId;
	}

	public void setAccountCalculateLogId(Long accountCalculateLogId) {
		this.accountCalculateLogId = accountCalculateLogId;
	}

	public Integer getCalculate() {
		return calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAccountCalculateLogType() {
		return accountCalculateLogType;
	}

	public void setAccountCalculateLogType(Integer accountCalculateLogType) {
		this.accountCalculateLogType = accountCalculateLogType;
	}

	public Integer getCalculateType() {
		return calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
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
		return "UserAccountCalcluateVo [userId=" + userId + ", gId=" + gId + ", userAccount=" + userAccount
				+ ", userName=" + userName + ", nickName=" + nickName + ", userType=" + userType + ", gender=" + gender
				+ ", status=" + status + ", cityCode=" + cityCode + ", cityName=" + cityName + ", isDelete=" + isDelete
				+ ", loginCount=" + loginCount + ", accountCalculateId=" + accountCalculateId + ", totalCalculate="
				+ totalCalculate + ", civilizeCalculate=" + civilizeCalculate + ", taskCalculate=" + taskCalculate
				+ ", accountCalculateLogId=" + accountCalculateLogId + ", calculate=" + calculate + ", content="
				+ content + ", accountCalculateLogType=" + accountCalculateLogType + ", calculateType=" + calculateType
				+ ", balance=" + balance + ", createTime=" + createTime + "]";
	}

}