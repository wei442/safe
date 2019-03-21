//package com.cloud.common.exception;
//
///**
// * Boot异常 BootServiceException
// * @author wei.yong
// */
//public class BootServiceException extends Exception {
//
//	private static final long serialVersionUID = 1L;
//
//	private String errorCode;
//
//	private String errorMessage;
//
//	public BootServiceException() {
//	}
//
//	public BootServiceException(Throwable e) {
//		super(e);
//	}
//
//
//	public BootServiceException(String errorCode) {
//		this.errorCode = errorCode;
//	}
//
//	public BootServiceException(String errorCode, String errorMessage) {
//	 	super(errorMessage);
//	    this.errorCode = errorCode;
//	    this.errorMessage = errorMessage;
//	}
//
//	public BootServiceException(String errorCode, Throwable e) {
//		super(e);
//	    this.errorCode = errorCode;
//	}
//
//	public String getErrorCode() {
//		return this.errorCode;
//	}
//
//	public void setErrorCode(String errorCode) {
//		this.errorCode = errorCode;
//	}
//
//	public String getErrorMessage() {
//		return this.errorMessage;
//	}
//
//	public void setErrorMessage(String errorMessage) {
//		this.errorMessage = errorMessage;
//	}
//
//	@Override
//	public String toString() {
//		return "BootServiceException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
//	}
//
//}