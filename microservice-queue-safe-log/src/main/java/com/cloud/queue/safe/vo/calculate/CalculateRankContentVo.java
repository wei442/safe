package com.cloud.queue.safe.vo.calculate;

import java.io.Serializable;

public class CalculateRankContentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

    private String content;

    private Integer calculate;

    private Integer sort;

    private String sortTime;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCalculate() {
		return calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	@Override
	public String toString() {
		return "CalculateRankContentVo [userId=" + userId + ", userAccount=" + userAccount + ", content=" + content
				+ ", calculate=" + calculate + ", sort=" + sort + ", sortTime=" + sortTime + "]";
	}

}