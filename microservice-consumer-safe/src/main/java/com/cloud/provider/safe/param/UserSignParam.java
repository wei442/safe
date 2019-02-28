package com.ochain.provider.wheel.param;

import java.io.Serializable;

/**
 * 用户签到请求 UserSignParam
 * @author wei.yong
 */
public class UserSignParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    //用户id
  	private Integer userId;

  	//签到时间开始字符串
  	private String signTimeStartStr;

  	//签到时间结束字符串
  	private String signTimeEndStr;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSignTimeStartStr() {
		return this.signTimeStartStr;
	}

	public void setSignTimeStartStr(String signTimeStartStr) {
		this.signTimeStartStr = signTimeStartStr;
	}

	public String getSignTimeEndStr() {
		return this.signTimeEndStr;
	}

	public void setSignTimeEndStr(String signTimeEndStr) {
		this.signTimeEndStr = signTimeEndStr;
	}

	@Override
	public String toString() {
		return "UserSignParam [userId=" + userId + ", signTimeStartStr=" + signTimeStartStr + ", signTimeEndStr="
				+ signTimeEndStr + "]";
	}

}