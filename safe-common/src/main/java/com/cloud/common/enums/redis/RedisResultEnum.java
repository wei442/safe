package com.cloud.common.enums.redis;

import com.cloud.common.enums.ResultEnum;

public enum RedisResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	REDIS_FIELD_EMPTY("6020001", "传入参数为空"),
	REDIS_ERROR("6020002", "redis错误"),
	REDIS_NULL_ERROR("6020003", "redis空信息错误");

	private String code;

	private String msg;

	private RedisResultEnum(String code, String msg) {
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