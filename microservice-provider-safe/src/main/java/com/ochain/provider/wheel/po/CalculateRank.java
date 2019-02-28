package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class CalculateRank implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer calculateRankId;

    private Object content;

    private Date rankTime;

    private Date createTime;

    private Date updateTime;

    public Integer getCalculateRankId() {
        return calculateRankId;
    }

    public void setCalculateRankId(Integer calculateRankId) {
        this.calculateRankId = calculateRankId;
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
		return "CalculateRank [calculateRankId=" + calculateRankId + ", content=" + content + ", rankTime=" + rankTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}