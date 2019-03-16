package com.cloud.common.enums.safe;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum SafeResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST(CommConstants.DATABASE_NOTEXIST, CommConstants.DATABASE_NOTEXIST_MSG),
	FIELD_EMPTY("1030001", "传入参数为空"),
	FIELD_ERROR("1030002", "传入参数错误"),
//	ORDER_LIST_NOTEXIST("1031001", "订单列表不存在"),
//	ORDER_LIST_EXIST("1031002", "订单列表已存在"),
//	ORDER_ENTITY_NOTEXIST("1031003", "订单不存在"),
//	ORDER_ENTITY_EXIST("1031004", "订单已存在"),
//
//	ORDER_SETTING_ENTITY_NOTEXIST("1035001", "订单设置不存在"),
//	ORDER_SETTING_ENTITY_EXIST("1035002", "订单设置已存在"),
//
//	USER_ENTITY_NOTEXIST("1011001", "用户不存在"),
//	USER_ENTITY_EXIST("1011002", "用户已存在"),
//	ENTERPRISE_ENTITY_NOTEXIST("1012001", "企业不存在"),
//	ENTERPRISE_ENTITY_EXIST("1012002", "企业已存在"),
//
//	ORG_ENTITY_NOTEXIST("1031001", "组织机构不存在"),
//	ORG_ENTITY_EXIST("1031002", "组织机构已存在"),
//	DICT_ENTITY_NOTEXIST("1032001", "字典不存在"),
//	DICT_ENTITY_EXIST("1032002", "字典已存在"),
//	DICT_ITEM_ENTITY_NOTEXIST("1033001", "字典子项不存在"),
//	DICT_ITEM_ENTITY_EXIST("1033002", "字典子项已存在"),
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