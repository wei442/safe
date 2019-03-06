package com.cloud.consumer.safe.vo.calculate;

import java.io.Serializable;

public class CalculateRankContentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String userAccount;

    private Integer calculate;

    private Integer sort;

    private String sortTime;

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSortTime() {
		return this.sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	@Override
	public String toString() {
		return "CalculateRankContentVo [userAccount=" + userAccount + ", calculate=" + calculate + ", sort=" + sort
				+ ", sortTime=" + sortTime + "]";
	}

}