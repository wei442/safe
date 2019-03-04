package com.cloud.common.enums.safe;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum SafeResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	FIELD_EMPTY("1030001", "传入参数为空"),
	FIELD_ERROR("1030002", "传入参数错误"),
	ORDER_LIST_NOTEXIST("1031001", "订单列表不存在"),
	ORDER_LIST_EXIST("1031002", "订单列表已存在"),
	ORDER_ENTITY_NOTEXIST("1031003", "订单不存在"),
	ORDER_ENTITY_EXIST("1031004", "订单已存在"),

	ORDER_SETTING_LIST_NOTEXIST("1035001", "订单设置列表不存在"),
	ORDER_SETTING_LIST_EXIST("1035002", "订单设置列表已存在"),
	ORDER_SETTING_ENTITY_NOTEXIST("1035003", "订单设置不存在"),
	ORDER_SETTING_ENTITY_EXIST("1035004", "订单设置已存在"),
	;

	private String code;

	private String msg;

	private SafeResultEnum(String code, String msg) {
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