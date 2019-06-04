package com.cloud.common.enums.mail;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum MailResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR("6040001", CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR("6040002", CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST("6040003", CommConstants.DATABASE_NOTEXIST_MSG),
	PARAMETER_EMPTY("6041001", "传入参数为空"),
	PARAMETER_ERROR("6041002", "传入参数错误"),
	MAIL_SEND_FAIL("6041003", "邮件发送失败"),
	;

	private String code;

	private String msg;

	private MailResultEnum(String code, String msg) {
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