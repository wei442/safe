package com.cloud.consumer.safe.vo.calculate;

import java.io.Serializable;

public class CalculateRecordVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Integer userId;

    private Long accountCalculateLogId;

    private String gId;

    private String gCode;

    private Integer status;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getAccountCalculateLogId() {
		return this.accountCalculateLogId;
	}

	public void setAccountCalculateLogId(Long accountCalculateLogId) {
		this.accountCalculateLogId = accountCalculateLogId;
	}

	public String getgId() {
		return this.gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgCode() {
		return this.gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CalculateRecordVo [userId=" + userId + ", accountCalculateLogId=" + accountCalculateLogId + ", gId="
				+ gId + ", gCode=" + gCode + ", status=" + status + "]";
	}

}