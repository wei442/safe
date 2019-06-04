package com.cloud.common.enums.sms;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum SmsResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR("6030001", CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR("6030002", CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST("6030003", CommConstants.DATABASE_NOTEXIST_MSG),
	PARAMETER_EMPTY("6031001", "传入参数为空"),
	PARAMETER_ERROR("6031002", "传入参数错误"),
	SMS_SEND_FAIL("6031003", "短信发送失败"),
	;

	private String code;

	private String msg;

	private SmsResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * @return the msg
	 */
	@Override
	public String getMsg() {
		return this.msg;
	}

}