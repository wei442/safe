package com.cloud.provider.safe.rest.request.user;

import java.util.Date;

import com.cloud.provider.safe.boot.BootRestRequest;

public class UserOperateLogRequest extends BootRestRequest {

	private static final long serialVersionUID = 1L;

	//用户id
	private Integer userId;

    private Integer operationType;

    private String content;

    private Date operationTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	@Override
	public String toString() {
		return "UserOperateLogRequest [userId=" + userId + ", operationType=" + operationType + ", content=" + content
				+ ", operationTime=" + operationTime + "]";
	}


}