package com.cloud.consumer.safe.vo.sign;

import java.io.Serializable;
import java.util.Date;

public class SignVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer isSign;

	private Date signTime;

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

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SignVo [isSign=" + isSign + ", signTime=" + signTime + ", desc=" + desc + "]";
	}

}