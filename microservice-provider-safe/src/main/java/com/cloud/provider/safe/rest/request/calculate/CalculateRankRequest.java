package com.cloud.provider.safe.rest.request.calculate;

import java.util.Date;

import com.cloud.provider.safe.boot.BootRestRequest;

public class CalculateRankRequest  extends BootRestRequest {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer calculateRankId;

	private Date rankTime;

	private Integer userId;

	private String userAccount;

    private Integer calculate;

    private Integer sort;

    private String sortTime;

    private Double percent;

	public Integer getCalculateRankId() {
		return this.calculateRankId;
	}

	public void setCalculateRankId(Integer calculateRankId) {
		this.calculateRankId = calculateRankId;
	}

	public Date getRankTime() {
		return this.rankTime;
	}

	public void setRankTime(Date rankTime) {
		this.rankTime = rankTime;
	}

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

	public Double getPercent() {
		return this.percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "CalculateRankRequest [calculateRankId=" + calculateRankId + ", rankTime=" + rankTime + ", userId="
				+ userId + ", userAccount=" + userAccount + ", calculate=" + calculate + ", sort=" + sort
				+ ", sortTime=" + sortTime + ", percent=" + percent + "]";
	}

}