package com.cloud.common.enums.rocketmq;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum RocketmqResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR("6050001", CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR("6050002", CommConstants.DATABASE_ERROR_MSG),
	PARAMETER_EMPTY("6051001", "传入参数为空"),
	PARAMETER_ERROR("6051002", "传入参数错误"),
	;

	private String code;

	private String msg;

	private RocketmqResultEnum(String code, String msg) {
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