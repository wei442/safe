package com.cloud.common.constants.wheel;

/**
 * 方向盘	常量
 * @author wei.yong
 * @2017年04月24日
 */
public class WheelConstants {

	/*----------------------------- 用户常量 -----------------------------*/
	//用户是否签到 0-未签到, 1-已签到
	public static final Integer USER_SIGN_NO = 0;
	public static final Integer USER_SIGN_YES = 1;

	//用户是否今天首次签到 0-否, 1-是
	public static final Integer USER_SIGN_FIRST_NO = 0;
	public static final Integer USER_SIGN_FIRST_YES = 1;

	//用户添加来源类型 1-登录, 2-推送
	public static final Integer USER_ADD_SOURCE_TYPE_LOGIN = 1;
	public static final Integer USER_ADD_SOURCE_TYPE_PUSH = 2;

	//用户昨日签到减去7天已加签到算力 0-未减去, 1-已减去
	public static final String USER_SIGN_MINUS_NO = "0";
	public static final String USER_SIGN_MINUS_YES = "1";
	/*----------------------------- 用户常量 -----------------------------*/

	/*----------------------------- 算力常量 -----------------------------*/
	//算力配置表code初始化值
	public static final String CALCULATE_CONFIG_CODE_START = "0001";
	//算力配置表code前缀
	public static final String CALCULATE_CONFIG_CODE_PREFIX = "CQL";
	/*----------------------------- 算力常量 -----------------------------*/

	/*----------------------------- 能量常量 -----------------------------*/
	//方向盘配置表code前缀
	public static final String DIAMOND_CONFIG_CODE_PREFIX = "NL";
	//方向盘配置表code初始化值
	public static final String DIAMOND_CONFIG_CODE_START = "0001";

	//能量编码
	public static final String DIAMONDCODE_0001 = DIAMOND_CONFIG_CODE_PREFIX + "0001";
	public static final String DIAMONDCODE_0008 = DIAMOND_CONFIG_CODE_PREFIX + "0008";
	//新用户注册登录
	public static final String DIAMONDCODE_0009 = DIAMOND_CONFIG_CODE_PREFIX + "0009";

	//能量记录类型 1-能量发放, 2-新用户登录赠送
	public static final Integer DIAMOND_RECORD_SOURCE_TYPE_SEND = 1;
	public static final Integer DIAMOND_RECORD_SOURCE_TYPE_NEW_USER_LOGIN = 2;
	/*----------------------------- 能量常量 -----------------------------*/

	/*----------------------------- 新用户登录常量 -----------------------------*/
	//1-新用户登录, 2-用户签到, 3-登录签到, 4-登录大于7天签到
	public static final Integer NEW_USER_LOGIN_TYPE_LOGIN = 1;
	public static final Integer NEW_USER_LOGIN_TYPE_SIGN = 2;
	public static final Integer NEW_USER_LOGIN_TYPE_LOGIN_SIGN = 3;
	public static final Integer NEW_USER_LOGIN_TYPE_SIGN_SEVEN_DAYS = 4;
	/*----------------------------- 新用户登录常量 -----------------------------*/

	/*----------------------------- 赠送算力文明分 -----------------------------*/
	//新用户赠送算力文明分
	public static final Integer NEW_USER_GIFT_CIVILIZE_CALCULATE = 50;
	//新用户赠送
	public static final String NEW_USER_GIFT_NAME = "新用户赠送";
	/*----------------------------- 赠送算力文明分 -----------------------------*/

	/*----------------------------- 来源 -----------------------------*/
	public static final String SOURCE_DAY_LOGIN = "每日登录";
	public static final String SOURCE_DRAW = "日常领取";
	public static final String SOURCE_GOFUN = "GoFun发放";
	public static final String SOURCE_COUPON_EXCHANGE = "兑换";
	public static final String SOURCE_RECHARGE = "充值";
	public static final String SOURCE_WITHDRAW = "提取";
	public static final String SOURCE_REFUND = "退款";
	public static final String SOURCE_FROM = "来自";
	public static final String SOURCE_TO = "提取至";
	public static final String SOURCE_RETURN = "退回";
	/*----------------------------- 来源 -----------------------------*/

	/*----------------------------- 来源类型 -----------------------------*/
	//来源类型-来源 1-推送, 2-登录
	public static final Integer SOURCE_TYPE_PUSH = 1;
	public static final Integer SOURCE_TYPE_LOGIN = 2;
	/*----------------------------- 来源类型-----------------------------*/

	/*----------------------------- 提取密码 -----------------------------*/
	//是否设置提取密码 0-未设置, 1-已设置
	public static final Integer IS_DRAW_PASSWORD_NO = 0;
	public static final Integer IS_DRAW_PASSWORD_YES = 1;
	/*----------------------------- 提取密码 -----------------------------*/

	/*----------------------------- 区块链回调 -----------------------------*/
	//回调状态 0:失败，1:成功，2:余额不足
	public static final Integer CALLBACK_STATUS_FAIL = 0;
	public static final Integer CALLBACK_STATUS_SUCCESS = 1;
	public static final Integer CALLBACK_STATUS_BALANCE_NOT_ENOUGH = 2;
	/*----------------------------- 区块链回调 -----------------------------*/

}