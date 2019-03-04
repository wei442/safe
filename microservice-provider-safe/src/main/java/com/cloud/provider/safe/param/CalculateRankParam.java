package com.cloud.provider.safe.param;

import java.io.Serializable;

/**
 * 算力排名 CalculateRankParam
 * @author wei.yong
 */
public class CalculateRankParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    //用户id
  	private Integer userId;

  	//用户账号
  	private String userAccount;

  	private Integer calculateRankId;

  	//分页显示字符串
  	private String pageNumStr;

    //排名字符串
  	private String rankStr;

  	//条数
  	private Integer rows;

	//排名时间开始时间字符串
  	private String rankTimeStartStr;

  	//排名时间结束时间字符串
  	private String rankTimeEndStr;

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

	public Integer getCalculateRankId() {
		return this.calculateRankId;
	}

	public void setCalculateRankId(Integer calculateRankId) {
		this.calculateRankId = calculateRankId;
	}

	public String getPageNumStr() {
		return this.pageNumStr;
	}

	public void setPageNumStr(String pageNumStr) {
		this.pageNumStr = pageNumStr;
	}

	public String getRankStr() {
		return this.rankStr;
	}

	public void setRankStr(String rankStr) {
		this.rankStr = rankStr;
	}

	public Integer getRows() {
		return this.rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
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
		return "CalculateRankParam [userId=" + userId + ", userAccount=" + userAccount + ", calculateRankId="
				+ calculateRankId + ", pageNumStr=" + pageNumStr + ", rankStr=" + rankStr + ", rows=" + rows
				+ ", rankTimeStartStr=" + rankTimeStartStr + ", rankTimeEndStr=" + rankTimeEndStr + "]";
	}

}