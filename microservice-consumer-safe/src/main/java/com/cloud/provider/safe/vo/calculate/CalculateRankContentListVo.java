package com.ochain.provider.wheel.vo.calculate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CalculateRankContentListVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Date rankTime;

    private List<CalculateRankContentVo> calculateRankContentList;

	public Date getRankTime() {
		return this.rankTime;
	}

	public void setRankTime(Date rankTime) {
		this.rankTime = rankTime;
	}

	public List<CalculateRankContentVo> getCalculateRankContentList() {
		return this.calculateRankContentList;
	}

	public void setCalculateRankContentList(List<CalculateRankContentVo> calculateRankContentList) {
		this.calculateRankContentList = calculateRankContentList;
	}

	@Override
	public String toString() {
		return "CalculateRankContentListVo [rankTime=" + rankTime + ", calculateRankContentList="
				+ calculateRankContentList + "]";
	}

}