package com.cloud.common.exception;

import com.cloud.common.enums.ResultEnum;

/**
 * Redis异常 RedisException
 * @author wei.yong
 */
public class RedisException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	public RedisException() {
	}

	public RedisException(Throwable e) {
		super(e);
	}

	public RedisException(String errorCode) {
	    this.errorCode = errorCode;
	}

	 public RedisException(String errorCode, String msg) {
	    super(msg);
	    this.errorCode = errorCode;
	 }

	public RedisException(String errorCode, Throwable e) {
		super(e);
	    this.errorCode = errorCode;
	}

	public RedisException(ResultEnum result) {
		super(result.getMsg());
		this.errorCode = result.getCode();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}