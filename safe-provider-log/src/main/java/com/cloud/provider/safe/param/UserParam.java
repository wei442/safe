package com.cloud.provider.safe.param;

import java.io.Serializable;

/**
 * 用户请求 Param
 * @author wei.yong
 */
public class UserParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    //用户id
  	private Integer userId;

  	//用户账户
  	private String userAccount;

  	//用户名字
    private String userName;

    //昵称
    private String nickName;

  	//账户日志类型
  	private Integer accountLogType;

  	//账户算力日志类型
  	private Integer accountCalculateLogType;

  	//算力类型
  	private Integer calculateType;

  	//排序
  	private String orderByClause;

  	//时间开始字符串
  	private String timeStartStr;

  	//时间结束字符串
  	private String timeEndStr;

	public Integer getUserId() {
		return userId;
	}

	public String getTimeStartStr() {
		return timeStartStr;
	}

	public void setTimeStartStr(String timeStartStr) {
		this.timeStartStr = timeStartStr;
	}

	public String getTimeEndStr() {
		return timeEndStr;
	}

	public void setTimeEndStr(String timeEndStr) {
		this.timeEndStr = timeEndStr;
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

	public Integer getAccountLogType() {
		return accountLogType;
	}

	public void setAccountLogType(Integer accountLogType) {
		this.accountLogType = accountLogType;
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

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	@Override
	public String toString() {
		return "UserParam [userId=" + userId + ", userAccount=" + userAccount + ", userName=" + userName + ", nickName="
				+ nickName + ", accountLogType=" + accountLogType + ", accountCalculateLogType="
				+ accountCalculateLogType + ", calculateType=" + calculateType + ", orderByClause=" + orderByClause
				+ ", timeStartStr=" + timeStartStr + ", timeEndStr=" + timeEndStr + "]";
	}

}