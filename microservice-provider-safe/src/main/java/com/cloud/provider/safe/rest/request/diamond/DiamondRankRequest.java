package com.cloud.provider.safe.rest.request.diamond;

import java.math.BigDecimal;
import java.util.Date;

import com.cloud.provider.safe.boot.BootRestRequest;

public class DiamondRankRequest  extends BootRestRequest {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer diamondRankId;

	private Date rankTime;

	private Integer userId;

	private String userAccount;

    private BigDecimal diamond;

    private Integer sort;

    private String sortTime;

	public Integer getDiamondRankId() {
		return this.diamondRankId;
	}

	public void setDiamondRankId(Integer diamondRankId) {
		this.diamondRankId = diamondRankId;
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

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
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
		return "DiamondRankRequest [diamondRankId=" + diamondRankId + ", rankTime=" + rankTime + ", userId=" + userId
				+ ", userAccount=" + userAccount + ", diamond=" + diamond + ", sort=" + sort + ", sortTime=" + sortTime
				+ "]";
	}

}