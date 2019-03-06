package com.cloud.consumer.safe.vo.account;

import java.io.Serializable;
import java.util.Date;

public class AccountCalculateLogVo implements Serializable  {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Integer calculate;

    private String content;

    private Date createTime;

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AccountCalculateLogVo [calculate=" + calculate + ", content=" + content + ", createTime=" + createTime
				+ "]";
	}

}