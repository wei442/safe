package com.cloud.common.exception;

import com.cloud.common.enums.ResultEnum;

/**
 * 异常 SafeException
 * @author wei.yong
 */
public class SafeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	public SafeException() {
	}

	public SafeException(Throwable e) {
		super(e);
	}

	public SafeException(String errorCode) {
		this.errorCode = errorCode;
	}

	public SafeException(String errorCode, String errorMessage) {
	 	super(errorMessage);
	    this.errorCode = errorCode;
	    this.errorMessage = errorMessage;
	}

	public SafeException(String errorCode, Throwable e) {
		super(e);
	    this.errorCode = errorCode;
	}

	public SafeException(ResultEnum result) {
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

	@Override
	public String toString() {
		return "SafeException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}