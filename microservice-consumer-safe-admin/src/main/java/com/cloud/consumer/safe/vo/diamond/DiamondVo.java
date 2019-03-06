package com.cloud.consumer.safe.vo.diamond;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DiamondVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long diamondRecordId;

    private String location;

    private BigDecimal diamond;

    private Date createTime;

	public Long getDiamondRecordId() {
		return this.diamondRecordId;
	}

	public void setDiamondRecordId(Long diamondRecordId) {
		this.diamondRecordId = diamondRecordId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getDiamond() {
		return this.diamond;
	}

	public void setDiamond(BigDecimal diamond) {
		this.diamond = diamond;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DiamondRecordVo [diamondRecordId=" + diamondRecordId + ", location=" + location + ", diamond=" + diamond
				+ ", createTime=" + createTime + "]";
	}

}