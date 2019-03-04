package com.cloud.provider.safe.param;

import java.io.Serializable;

/**
 * 排名请求 RankParam
 * @author wei.yong
 */
public class RankParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

  	//用户id
  	protected Integer userId;

  	//用户账号
  	protected String userAccount;

  	//分页显示字符串
  	protected String pageNumStr;

  	//排名时间开始时间字符串
  	protected String rankTimeStartStr;

  	//排名时间结束时间字符串
  	protected String rankTimeEndStr;

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

	public String getPageNumStr() {
		return this.pageNumStr;
	}

	public void setPageNumStr(String pageNumStr) {
		this.pageNumStr = pageNumStr;
	}

	public String getRankTimeStartStr() {
		return this.rankTimeStartStr;
	}

	public void setRankTimeStartStr(String rankTimeStartStr) {
		this.rankTimeStartStr = rankTimeStartStr;
	}

	public String getRankTimeEndStr() {
		return this.rankTimeEndStr;
	}

	public void setRankTimeEndStr(String rankTimeEndStr) {
		this.rankTimeEndStr = rankTimeEndStr;
	}

	@Override
	public String toString() {
		return "RankParam [userId=" + userId + ", userAccount=" + userAccount + ", pageNumStr=" + pageNumStr
				+ ", rankTimeStartStr=" + rankTimeStartStr + ", rankTimeEndStr=" + rankTimeEndStr + "]";
	}

}