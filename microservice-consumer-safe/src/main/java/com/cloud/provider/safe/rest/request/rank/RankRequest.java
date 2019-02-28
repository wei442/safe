package com.ochain.provider.wheel.rest.request.rank;

import java.math.BigDecimal;
import java.util.Date;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class RankRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Date rankTime;

	private BigDecimal realDiamond;

	public Date getRankTime() {
		return this.rankTime;
	}

	public void setRankTime(Date rankTime) {
		this.rankTime = rankTime;
	}

	public BigDecimal getRealDiamond() {
		return this.realDiamond;
	}

	public void setRealDiamond(BigDecimal realDiamond) {
		this.realDiamond = realDiamond;
	}

	@Override
	public String toString() {
		return "RankRequest [rankTime=" + rankTime + ", realDiamond=" + realDiamond + "]";
	}

}