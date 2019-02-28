package com.ochain.provider.wheel.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiamondRankContentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

    private BigDecimal diamond;

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

	public BigDecimal getDiamond() {
		return diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
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
		return "DiamondRankContentVo [userId=" + userId + ", userAccount=" + userAccount + ", diamond=" + diamond
				+ ", sort=" + sort + ", sortTime=" + sortTime + "]";
	}

}