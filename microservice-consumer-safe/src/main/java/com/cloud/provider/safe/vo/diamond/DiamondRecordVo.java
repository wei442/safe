package com.ochain.provider.wheel.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 能量记录 DiamondRecordVo
 * @author wei.yong
 */
public class DiamondRecordVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private BigDecimal totalDiamond;

    private BigDecimal totalDrawDiamond;

	public BigDecimal getTotalDiamond() {
		return this.totalDiamond;
	}

	public void setTotalDiamond(BigDecimal totalDiamond) {
		this.totalDiamond = totalDiamond;
	}

	public BigDecimal getTotalDrawDiamond() {
		return this.totalDrawDiamond;
	}

	public void setTotalDrawDiamond(BigDecimal totalDrawDiamond) {
		this.totalDrawDiamond = totalDrawDiamond;
	}

	@Override
	public String toString() {
		return "DiamondRecordVo [totalDiamond=" + totalDiamond + ", totalDrawDiamond=" + totalDrawDiamond + "]";
	}

}