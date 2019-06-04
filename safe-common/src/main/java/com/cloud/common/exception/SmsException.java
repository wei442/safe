package com.cloud.common.exception;

import com.cloud.common.enums.ResultEnum;

/**
 * 短信异常 SmsException
 * @author wei.yong
 */
public class SmsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	public SmsException() {
	}

	public SmsException(Throwable e) {
		super(e);
	}

	public SmsException(String errorCode) {
		this.errorCode = errorCode;
	}

	public SmsException(String errorCode, String errorMessage) {
	 	super(errorMessage);
	    this.errorCode = errorCode;
	    this.errorMessage = errorMessage;
	}

	public SmsException(String errorCode, Throwable e) {
		super(e);
	    this.errorCode = errorCode;
	}

	public SmsException(ResultEnum result) {
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