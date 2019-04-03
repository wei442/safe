package com.cloud.common.enums.safe;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum SafeResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST(CommConstants.DATABASE_NOTEXIST, CommConstants.DATABASE_NOTEXIST_MSG),
	FIELD_EMPTY("1000001", "传入参数为空"),
	FIELD_ERROR("1000002", "传入参数错误"),

	USER_ACCOUNT_NOTEXIST("1010001", "您的账号不存在"),
	USER_ACCOUNT_EXIST("1010002", "您已经注册过"),
	USER_ADMIN_PASSWORD_ERROR("1010003", "您的管理密码错误"),
	USER_ADMIN_PASSWORD_NOTEXIST("1010004", "您的管理密码不存在"),
	USER_ADMIN_PASSWORD_EXIST("1010005", "您的管理密码已存在"),
	USER_ADMIN_FIRST_LOGIN_CHANGE_PASSWORD("1010006", "您好，这是你第一次登录该企业的管理后台，请先设置管理密码"),
	USER_ADMIN_PASSWORD_RULE("1010007", "密码长度为6到20位，必须包含数字、小写字母、大写字母"),
	USER_ADMIN_PASSWORD_NOT_EQUQAL("1010008", "密码和确认密码不一致"),

	USER_ORG_EXIST("1010009", "此手机号码已存在"),
	USER_ORG_LIST_EXIST("1010010", "请先删除该部门下的人员，再删除该部门!"),
	USER_POST_LIST_EXIST("1010011", "当前岗位有人员，无法删除!"),


	ENTERPRISE_NOTEXIST("1020001", "您没有注册企业"),
	ENTERPRISE_EXIST("1020002", "您已经注册企业"),
	ORG_CHILD_LIST_EXIST("1020003", "请先删除改部门下的子部门，再删除该部门!"),



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