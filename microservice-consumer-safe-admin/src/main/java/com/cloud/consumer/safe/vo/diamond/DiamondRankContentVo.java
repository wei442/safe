package com.ochain.consumer.wheel.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiamondRankContentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String userAccount;

    private BigDecimal diamond;

    private Integer sort;

    private String sortTime;

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
		return "DiamondRankContentVo [userAccount=" + userAccount + ", diamond=" + diamond + ", sort=" + sort
				+ ", sortTime=" + sortTime + "]";
	}

}