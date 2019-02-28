package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class OrderDrawCoin implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long orderDrawCoinId;

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

    private Date createTime;

    private Date updateTime;

    public Long getOrderDrawCoinId() {
        return orderDrawCoinId;
    }

    public void setOrderDrawCoinId(Long orderDrawCoinId) {
        this.orderDrawCoinId = orderDrawCoinId;
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
        this.userAccount = userAccount == null ? null : userAccount.trim();
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
        this.accountAddrFrom = accountAddrFrom == null ? null : accountAddrFrom.trim();
    }

    public String getAccountAddrTo() {
        return accountAddrTo;
    }

    public void setAccountAddrTo(String accountAddrTo) {
        this.accountAddrTo = accountAddrTo == null ? null : accountAddrTo.trim();
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash == null ? null : transactionHash.trim();
    }

    public String getGfc() {
        return gfc;
    }

    public void setGfc(String gfc) {
        this.gfc = gfc == null ? null : gfc.trim();
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
		return "OrderDrawCoin [orderDrawCoinId=" + orderDrawCoinId + ", userId=" + userId + ", userAccount="
				+ userAccount + ", orderNo=" + orderNo + ", accountAddrFrom=" + accountAddrFrom + ", accountAddrTo="
				+ accountAddrTo + ", transactionHash=" + transactionHash + ", gfc=" + gfc + ", fee=" + fee + ", status="
				+ status + ", remark=" + remark + ", completeTime=" + completeTime + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}