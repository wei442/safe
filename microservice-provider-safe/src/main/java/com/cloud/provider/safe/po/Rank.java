package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Rank implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer rankId;

    private BigDecimal totalDiamond;

    private BigDecimal planDiamond;

    private BigDecimal realDiamond;

    private Long totalCalculate;

    private Long totalCivilizeCalculate;

    private Long totalTaskCalculate;

    private Date rankTime;

    private Date createTime;

    private Date updateTime;

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public BigDecimal getTotalDiamond() {
        return totalDiamond;
    }

    public void setTotalDiamond(BigDecimal totalDiamond) {
        this.totalDiamond = totalDiamond;
    }

    public BigDecimal getPlanDiamond() {
        return planDiamond;
    }

    public void setPlanDiamond(BigDecimal planDiamond) {
        this.planDiamond = planDiamond;
    }

    public BigDecimal getRealDiamond() {
        return realDiamond;
    }

    public void setRealDiamond(BigDecimal realDiamond) {
        this.realDiamond = realDiamond;
    }

    public Long getTotalCalculate() {
        return totalCalculate;
    }

    public void setTotalCalculate(Long totalCalculate) {
        this.totalCalculate = totalCalculate;
    }

    public Long getTotalCivilizeCalculate() {
        return totalCivilizeCalculate;
    }

    public void setTotalCivilizeCalculate(Long totalCivilizeCalculate) {
        this.totalCivilizeCalculate = totalCivilizeCalculate;
    }

    public Long getTotalTaskCalculate() {
        return totalTaskCalculate;
    }

    public void setTotalTaskCalculate(Long totalTaskCalculate) {
        this.totalTaskCalculate = totalTaskCalculate;
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
		return "Rank [rankId=" + rankId + ", totalDiamond=" + totalDiamond + ", planDiamond=" + planDiamond
				+ ", realDiamond=" + realDiamond + ", totalCalculate=" + totalCalculate + ", totalCivilizeCalculate="
				+ totalCivilizeCalculate + ", totalTaskCalculate=" + totalTaskCalculate + ", rankTime=" + rankTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}