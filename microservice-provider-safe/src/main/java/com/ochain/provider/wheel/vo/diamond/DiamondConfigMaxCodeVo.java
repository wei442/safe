package com.ochain.provider.wheel.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiamondConfigMaxCodeVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String maxCode;

    private BigDecimal totalSendDiamond;

	public String getMaxCode() {
		return maxCode;
	}

	public void setMaxCode(String maxCode) {
		this.maxCode = maxCode;
	}

	public BigDecimal getTotalSendDiamond() {
		return this.totalSendDiamond;
	}

	public void setTotalSendDiamond(BigDecimal totalSendDiamond) {
		this.totalSendDiamond = totalSendDiamond;
	}

	@Override
	public String toString() {
		return "DiamondConfigMaxCodeVo [maxCode=" + maxCode + ", totalSendDiamond=" + totalSendDiamond + "]";
	}

}