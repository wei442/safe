package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class CarOrderRecord implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long carOrderRecordId;

    private Integer userId;

    private String content;

    private Date orderTime;

    private Integer status;

    private Long registryNo;

    private Date createTime;

    private Date updateTime;

    public Long getCarOrderRecordId() {
        return carOrderRecordId;
    }

    public void setCarOrderRecordId(Long carOrderRecordId) {
        this.carOrderRecordId = carOrderRecordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRegistryNo() {
        return registryNo;
    }

    public void setRegistryNo(Long registryNo) {
        this.registryNo = registryNo;
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
		return "CarOrderRecord [carOrderRecordId=" + carOrderRecordId + ", userId=" + userId + ", content=" + content
				+ ", orderTime=" + orderTime + ", status=" + status + ", registryNo=" + registryNo + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

}