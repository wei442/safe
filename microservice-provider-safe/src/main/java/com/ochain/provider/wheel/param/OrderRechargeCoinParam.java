package com.ochain.provider.wheel.param;

import java.io.Serializable;
import java.util.Date;

public class OrderRechargeCoinParam implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

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

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Long getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getAccountAddrFrom() {
		return this.accountAddrFrom;
	}

	public void setAccountAddrFrom(String accountAddrFrom) {
		this.accountAddrFrom = accountAddrFrom;
	}

	public String getAccountAddrTo() {
		return this.accountAddrTo;
	}

	public void setAccountAddrTo(String accountAddrTo) {
		this.accountAddrTo = accountAddrTo;
	}

	public String getTransactionHash() {
		return this.transactionHash;
	}

	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}

	public String getGfc() {
		return this.gfc;
	}

	public void setGfc(String gfc) {
		this.gfc = gfc;
	}

	public String getFee() {
		return this.fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Date getCompleteTimeStart() {
		return this.completeTimeStart;
	}

	public void setCompleteTimeStart(Date completeTimeStart) {
		this.completeTimeStart = completeTimeStart;
	}

	public Date getCompleteTimeEnd() {
		return this.completeTimeEnd;
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
		return "OrderRechargeCoinParam [userAccount=" + userAccount + ", orderNo=" + orderNo + ", accountAddrFrom="
				+ accountAddrFrom + ", accountAddrTo=" + accountAddrTo + ", transactionHash=" + transactionHash
				+ ", gfc=" + gfc + ", fee=" + fee + ", status=" + status + ", remark=" + remark + ", completeTime="
				+ completeTime + ", completeTimeStart=" + completeTimeStart + ", completeTimeEnd=" + completeTimeEnd
				+ ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd + "]";
	}

}