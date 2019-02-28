package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class DiamondRank implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer diamondRankId;

    private Object content;

    private Date rankTime;

    private Date createTime;

    private Date updateTime;

    public Integer getDiamondRankId() {
        return diamondRankId;
    }

    public void setDiamondRankId(Integer diamondRankId) {
        this.diamondRankId = diamondRankId;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Date getRankTime() {
        return rankTime;
    }

    public void setRankTime(Date rankTime) {
        this.rankTime = rankTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "DiamondRank [diamondRankId=" + diamondRankId + ", content=" + content + ", rankTime=" + rankTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}