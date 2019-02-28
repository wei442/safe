package com.ochain.provider.wheel.rest.request.order;

import java.util.Date;

import com.ochain.provider.wheel.boot.BootRestRequest;

/**
 * 充币订单请求
 * @author wei.yong
 */
public class OrderRechargeCoinRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	private Long orderRechargeCoinId;

    private Integer userId;

    private String userAccount;

    private Long orderNo;

    private String accountAddrFrom;

    private String accountAddrTo;

    private String transactionHash;

    private String gfc;

    private String fee;

    private Integer status;

    private String remark;

    private Date completeTime;

    private Date completeTimeStart;

    private Date completeTimeEnd;

    private Date createTimeStart;

    private Date createTimeEnd;

	public Long getOrderRechargeCoinId() {
		return orderRechargeCoinId;
	}

	public void setOrderRechargeCoinId(Long orderRechargeCoinId) {
		this.orderRechargeCoinId = orderRechargeCoinId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getAccountAddrFrom() {
		return accountAddrFrom;
	}

	public void setAccountAddrFrom(String accountAddrFrom) {
		this.accountAddrFrom = accountAddrFrom;
	}

	public String getAccountAddrTo() {
		return accountAddrTo;
	}

	public void setAccountAddrTo(String accountAddrTo) {
		this.accountAddrTo = accountAddrTo;
	}

	public String getTransactionHash() {
		return transactionHash;
	}

	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}

	public String getGfc() {
		return gfc;
	}

	public void setGfc(String gfc) {
		this.gfc = gfc;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Date getCompleteTimeStart() {
		return completeTimeStart;
	}

	public void setCompleteTimeStart(Date completeTimeStart) {
		this.completeTimeStart = completeTimeStart;
	}

	public Date getCompleteTimeEnd() {
		return completeTimeEnd;
	}

	public void setCompleteTimeEnd(Date completeTimeEnd) {
		this.completeTimeEnd = completeTimeEnd;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	@Override
	public String toString() {
		return "OrderRechargeCoinRequest [orderRechargeCoinId=" + orderRechargeCoinId + ", userId=" + userId
				+ ", userAccount=" + userAccount + ", orderNo=" + orderNo + ", accountAddrFrom=" + accountAddrFrom
				+ ", accountAddrTo=" + accountAddrTo + ", transactionHash=" + transactionHash + ", gfc=" + gfc
				+ ", fee=" + fee + ", status=" + status + ", remark=" + remark + ", completeTime=" + completeTime
				+ ", completeTimeStart=" + completeTimeStart + ", completeTimeEnd=" + completeTimeEnd
				+ ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd + "]";
	}

}