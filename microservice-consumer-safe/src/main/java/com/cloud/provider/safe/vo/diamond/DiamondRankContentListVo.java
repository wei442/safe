package com.ochain.provider.wheel.vo.diamond;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DiamondRankContentListVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Date rankTime;

    private List<DiamondRankContentVo> diamondRankContentList;

	public Date getRankTime() {
		return this.rankTime;
	}

	public void setRankTime(Date rankTime) {
		this.rankTime = rankTime;
	}

	public List<DiamondRankContentVo> getDiamondRankContentList() {
		return this.diamondRankContentList;
	}

	public void setDiamondRankContentList(List<DiamondRankContentVo> diamondRankContentList) {
		this.diamondRankContentList = diamondRankContentList;
	}

	@Override
	public String toString() {
		return "DiamondRankContentListVo [rankTime=" + rankTime + ", diamondRankContentList=" + diamondRankContentList
				+ "]";
	}

}