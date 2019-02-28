package com.ochain.provider.wheel.vo.account;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountDiamondVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private BigDecimal totalDiamond;

	public BigDecimal getTotalDiamond() {
		return this.totalDiamond;
	}

	public void setTotalDiamond(BigDecimal totalDiamond) {
		this.totalDiamond = totalDiamond;
	}

	@Override
	public String toString() {
		return "AccountDiamondVo [totalDiamond=" + totalDiamond + "]";
	}

}