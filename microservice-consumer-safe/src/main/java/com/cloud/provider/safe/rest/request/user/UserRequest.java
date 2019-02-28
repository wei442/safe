package com.ochain.provider.wheel.rest.request.user;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class UserRequest extends BootRestRequest {

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

    private String headImage;

    private Integer sourceType;

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

	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	@Override
	public String toString() {
		return "UserRequest [userId=" + userId + ", gId=" + gId + ", userAccount=" + userAccount + ", userName="
				+ userName + ", nickName=" + nickName + ", userType=" + userType + ", gender=" + gender + ", status="
				+ status + ", cityCode=" + cityCode + ", cityName=" + cityName + ", headImage=" + headImage
				+ ", sourceType=" + sourceType + "]";
	}

}