package com.cloud.common.enums.safe;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum RetSafeResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	NETWORK_ERROR("0000003", "非法请求"),
	PARAMETER_ERROR("0000004", "参数错误"),
	PARAMETER_NULL("0000004", "参数为空"),


	;

	private String code;

	private String msg;

	private RetSafeResultEnum(String code, String msg) {
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