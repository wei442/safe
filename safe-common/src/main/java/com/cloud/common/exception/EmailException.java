package com.cloud.common.exception;

import com.cloud.common.enums.ResultEnum;

/**
 * 邮件异常 EmailException
 * @author wei.yong
 */
public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	public EmailException() {
	}

	public EmailException(Throwable e) {
		super(e);
	}

	public EmailException(String errorCode) {
		this.errorCode = errorCode;
	}

	public EmailException(String errorCode, String errorMessage) {
	 	super(errorMessage);
	    this.errorCode = errorCode;
	    this.errorMessage = errorMessage;
	}

	public EmailException(String errorCode, Throwable e) {
		super(e);
	    this.errorCode = errorCode;
	}

	public EmailException(ResultEnum result) {
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