package com.ochain.provider.wheel.rest.request.diamond;

import java.util.Date;

import com.ochain.provider.wheel.boot.BootRestRequest;

public class CarOrderRecordRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long carOrderRecordId;

    private Integer userId;

    private String content;

    private Date orderTime;

    private Long registryNo;

    private Integer status;

	public Long getCarOrderRecordId() {
		return this.carOrderRecordId;
	}

	public void setCarOrderRecordId(Long carOrderRecordId) {
		this.carOrderRecordId = carOrderRecordId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Long getRegistryNo() {
		return this.registryNo;
	}

	public void setRegistryNo(Long registryNo) {
		this.registryNo = registryNo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CarOrderRecordRequest [carOrderRecordId=" + carOrderRecordId + ", userId=" + userId + ", content="
				+ content + ", orderTime=" + orderTime + ", registryNo=" + registryNo + ", status=" + status + "]";
	}


}