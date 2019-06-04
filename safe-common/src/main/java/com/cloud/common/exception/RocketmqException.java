package com.cloud.common.exception;

import com.cloud.common.enums.ResultEnum;

/**
 * rocketmq异常 RocketmqException
 * @author wei.yong
 */
public class RocketmqException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	public RocketmqException() {
	}

	public RocketmqException(Throwable e) {
		super(e);
	}

	public RocketmqException(String errorCode) {
		this.errorCode = errorCode;
	}

	public RocketmqException(String errorCode, String errorMessage) {
	 	super(errorMessage);
	    this.errorCode = errorCode;
	    this.errorMessage = errorMessage;
	}

	public RocketmqException(String errorCode, Throwable e) {
		super(e);
	    this.errorCode = errorCode;
	}

	public RocketmqException(ResultEnum result) {
		super(result.getMsg());
		this.errorCode = result.getCode();
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}