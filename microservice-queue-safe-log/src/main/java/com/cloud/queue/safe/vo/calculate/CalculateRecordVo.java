//package com.cloud.queue.safe.vo.calculate;
//
//import java.io.Serializable;
//
//public class CalculateRecordVo implements Serializable {
//
//    /**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//
//    private Integer userId;
//
//    private Long accountCalculateLogId;
//
//    private String gCode;
//
//    private Integer status;
//
//    private Long registryNo;
//
//    //重试次数 默认为0
//    private Integer retry =  0;
//
//	public Integer getUserId() {
//		return this.userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public Long getAccountCalculateLogId() {
//		return this.accountCalculateLogId;
//	}
//
//	public void setAccountCalculateLogId(Long accountCalculateLogId) {
//		this.accountCalculateLogId = accountCalculateLogId;
//	}
//
//	public String getgCode() {
//		return this.gCode;
//	}
//
//	public void setgCode(String gCode) {
//		this.gCode = gCode;
//	}
//
//	public Integer getStatus() {
//		return this.status;
//	}
//
//	public void setStatus(Integer status) {
//		this.status = status;
//	}
//
//	public Long getRegistryNo() {
//		return this.registryNo;
//	}
//
//	public void setRegistryNo(Long registryNo) {
//		this.registryNo = registryNo;
//	}
//
//	public Integer getRetry() {
//		return this.retry;
//	}
//
//	public void setRetry(Integer retry) {
//		this.retry = retry;
//	}
//
//	@Override
//	public String toString() {
//		return "CalculateRecordVo [userId=" + userId + ", accountCalculateLogId=" + accountCalculateLogId + ", gCode="
//				+ gCode + ", status=" + status + ", registryNo=" + registryNo + ", retry=" + retry + "]";
//	}
//
//}