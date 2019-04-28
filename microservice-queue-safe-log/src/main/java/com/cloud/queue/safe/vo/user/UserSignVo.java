package com.cloud.queue.safe.vo.user;

import java.io.Serializable;
import java.util.Date;

public class UserSignVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer isSign;

	private Date signTime;

	private Integer signDays;

    private Integer isFirst;

	private String desc;

	public Integer getIsSign() {
		return this.isSign;
	}

	public void setIsSign(Integer isSign) {
		this.isSign = isSign;
	}

	public Date getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Integer getSignDays() {
		return this.signDays;
	}

	public void setSignDays(Integer signDays) {
		this.signDays = signDays;
	}

	public Integer getIsFirst() {
		return this.isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "UserSignVo [isSign=" + isSign + ", signTime=" + signTime + ", signDays=" + signDays + ", isFirst="
				+ isFirst + ", desc=" + desc + "]";
	}

}