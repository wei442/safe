package com.cloud.consumer.safe.vo.gofun;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 验证App用户登陆状态 Vo
 * @author wei.yong
 */
public class ValidateUserVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//令牌
	@JSONField(name="token")
	private String gToken;

	//用户ID
	@JSONField(name="userId")
    private String gId;

	//手机号码
	@JSONField(name="sim")
    private String userAccount;

	//用户昵称
    @JSONField(name="nickName")
    private String nickName;

    //城市code
    @JSONField(name="cityCode")
    private String cityCode;

    //城市名称
    @JSONField(name="cityName")
    private String cityName;

    //状态 1-正常，2-冻结
    @JSONField(name="state")
    private Integer status;

    //时间
    @JSONField(name="date")
    private Date date;

	public String getgToken() {
		return this.gToken;
	}

	public void setgToken(String gToken) {
		this.gToken = gToken;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ValidateUserVo [gToken=" + gToken + ", gId=" + gId + ", userAccount=" + userAccount + ", nickName="
				+ nickName + ", cityCode=" + cityCode + ", cityName=" + cityName + ", status=" + status + ", date="
				+ date + "]";
	}

}