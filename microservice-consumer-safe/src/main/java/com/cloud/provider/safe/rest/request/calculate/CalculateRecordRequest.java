package com.ochain.provider.wheel.rest.request.calculate;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class CalculateRecordRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long calculateRecordId;

    private Integer userId;

   private Long accountCalculateLogId;

    private String calculateCode;

    private String calculateName;

    private Integer calculateType;

    private Integer calculate;

    private String content;

    private Integer status;

    private Long registryNo;

	public Long getCalculateRecordId() {
		return this.calculateRecordId;
	}

	public void setCalculateRecordId(Long calculateRecordId) {
		this.calculateRecordId = calculateRecordId;
	}

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

	public String getCalculateCode() {
		return this.calculateCode;
	}

	public void setCalculateCode(String calculateCode) {
		this.calculateCode = calculateCode;
	}

	public String getCalculateName() {
		return this.calculateName;
	}

	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	@Override
	public String toString() {
		return "CalculateRecordRequest [calculateRecordId=" + calculateRecordId + ", userId=" + userId
				+ ", accountCalculateLogId=" + accountCalculateLogId + ", calculateCode=" + calculateCode
				+ ", calculateName=" + calculateName + ", calculateType=" + calculateType + ", calculate=" + calculate
				+ ", content=" + content + ", status=" + status + ", registryNo=" + registryNo + "]";
	}

}