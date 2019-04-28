package com.cloud.queue.safe.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiamondRealRankVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

    private BigDecimal diamond;

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

	@Override
	public String toString() {
		return "DiamondRealRankVo [userId=" + userId + ", userAccount=" + userAccount + ", diamond=" + diamond + "]";
	}

}