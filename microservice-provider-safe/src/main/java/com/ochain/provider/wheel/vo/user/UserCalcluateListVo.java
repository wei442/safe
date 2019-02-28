package com.ochain.provider.wheel.vo.user;

import java.io.Serializable;
import java.util.Date;

public class UserCalcluateListVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

    private String nickName;

    private Integer gender;

    private Integer status;

    private String cityCode;

    private String cityName;

    private Integer loginCount;

    private Integer accountCalculateId;

    private Integer totalCalculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

    private Date updateTime;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UserCalcluateListVo [userId=" + userId + ", userAccount=" + userAccount + ", nickName=" + nickName
				+ ", gender=" + gender + ", status=" + status + ", cityCode=" + cityCode + ", cityName=" + cityName
				+ ", loginCount=" + loginCount + ", accountCalculateId=" + accountCalculateId + ", totalCalculate="
				+ totalCalculate + ", civilizeCalculate=" + civilizeCalculate + ", taskCalculate=" + taskCalculate
				+ ", updateTime=" + updateTime + "]";
	}

}