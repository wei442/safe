package com.ochain.provider.wheel.vo.user;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserVo implements Serializable {

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

    private BigDecimal diamond;

    private Integer accountCalculateId;

    private Integer calculate;

    private Integer civilizeCalculate;

    private Integer taskCalculate;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	public Integer getAccountCalculateId() {
		return this.accountCalculateId;
	}

	public void setAccountCalculateId(Integer accountCalculateId) {
		this.accountCalculateId = accountCalculateId;
	}

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getCivilizeCalculate() {
		return this.civilizeCalculate;
	}

	public void setCivilizeCalculate(Integer civilizeCalculate) {
		this.civilizeCalculate = civilizeCalculate;
	}

	public Integer getTaskCalculate() {
		return this.taskCalculate;
	}

	public void setTaskCalculate(Integer taskCalculate) {
		this.taskCalculate = taskCalculate;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", gId=" + gId + ", userAccount=" + userAccount + ", userName=" + userName
				+ ", nickName=" + nickName + ", userType=" + userType + ", gender=" + gender + ", status=" + status
				+ ", cityCode=" + cityCode + ", cityName=" + cityName + ", isDelete=" + isDelete + ", loginCount="
				+ loginCount + ", accountId=" + accountId + ", diamond=" + diamond + ", accountCalculateId="
				+ accountCalculateId + ", calculate=" + calculate + ", civilizeCalculate=" + civilizeCalculate
				+ ", taskCalculate=" + taskCalculate + "]";
	}

}