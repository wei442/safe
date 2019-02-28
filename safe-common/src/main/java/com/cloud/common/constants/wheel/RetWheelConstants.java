package com.cloud.common.constants.wheel;

import com.cloud.common.constants.RetConstants;

/**
 * ret方向盘返回错误码-返回给app
 * @author wei.yong
 * @2017年04月24日
 */
public class RetWheelConstants extends RetConstants {

	//token
	public static final String TOKEN = "token";

	public static final String USER_ID = "userId";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String GTOKEN = "gToken";
	public static final String GID = "gId";

	//token过期时间 2592000秒 30天(30*24*60*60)
	public static final Integer TOKEN_TIME = 2592000;
	//用户签到86400秒 24小时(24*60*60)
	public static final Integer USER_SIGN_TIME = 86400;

	/*--------------------------- 返回app错误码  -----------------------------*/
	/**
	 * 错误编码-服务不可用
	 */
	public static final String SYSTEM_ERROR = "0000001";
	/**
	 * 错误描述-服务不可用
	 */
	public static final String SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";
	/**
	 * lbp-内部业务简称
	 */
	public static final String LBP_SYSTEM_ERROR = "lbp.system.error";
	public static final String LBP_SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";
	/**
	 * tdp-第三方简称
	 */
	public static final String TDP_BLOCKCHAIN_ERROR = "tdp.blockchain.error";
	public static final String TDP_BLOCKCHAIN_ERROR_MSG = "区块链服务繁忙，请稍后再试";
	public static final String TDP_GOFUN_ERROR = "tdp.gofun.error";
	public static final String TDP_GOFUN_ERROR_MSG = "gofun系统繁忙，请稍后再试";

	/**
     * 错误编码-数据库操作失败编码
     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
     */
    public static final String DATABASE_ERROR = "00000002";
    public static final String DATABASE_FAIL = "database.error";
    public static final String DATABASE_ERROR_MSG = "操作失败";

	/**
	 * 错误编码-非法请求
	 */
	public static final String NETWORK_ERROR = "0000003";
	public static final String NETWORK_FAIL = "network.error";
	public static final String NETWORK_ERROR_MSG = "非法请求";

	/**
	 * 错误编码-参数错误
	 */
	public static final String PARAMETER_ERROR = "0000004";
	public static final String PARAMETER_NULL_ERROR_MSG = "参数为空";
	public static final String PARAMETER_ERROR_MSG = "参数错误";

	/**
	 * 错误编码-token错误
	 */
	public static final String TOKEN_ERROR = "0000005";
	public static final String TOKEN_ERROR_MSG = "token错误";
	public static final String TOKEN_FAIL = "token.error";
	public static final String TOKEN_FAIL_MSG = "token失败";
	public static final String TOKEN_VERIFY_FAIL = "token.verify.error";
	public static final String TOKEN_VERIFY_FAIL_MSG = "token失败";

	public static final String TOKEN_NULL_ERROR = "token.null";
	public static final String TOKEN_NULL_ERROR_MSG = "token为空";
	public static final String TOKEN_EXPIRE = "token.expire";
	public static final String TOKEN_EXPIRE_MSG = "token已过期";
	public static final String TOKEN_JWT_ERROR = "token.jwt.error";
	public static final String TOKEN_JWT_ERROR_MSG = "token格式错误";

	/**
	 * 错误编码-gtoken错误
	 */
	public static final String GTOKEN_ERROR = "0000006";
	public static final String GTOKEN_EXPIRE = "gtoken.expire";
	public static final String GTOKEN_EXPIRE_MSG = "gtoken已过期";

	/**
	 * 错误编码-timestampId错误
	 */
	public static final String TIMESTAMPID_ERROR = "0000007";
	public static final String TIMESTAMPID_FAIL = "timestampId.error";
	public static final String TIMESTAMPID_ERROR_MSG = "timestampId错误";

	public static final String TIMESTAMPID_NULL_ERROR = "timestampId.null";
	public static final String TIMESTAMPID_NULL_ERROR_MSG = "timestampId为空";

	/**
	 * 错误编码-用户错误
	 */
	public static final String USER_ERROR = "0000008";
	public static final String USER_ERROR_MSG = "用户错误";

	public static final String USER_FREEZE_ERROR = "user.freeze";
	public static final String USER_FREEZE_ERROR_MSG = "用户已冻结";
	public static final String USER_CANCEL_ERROR = "user.cancel";
	public static final String USER_CANCEL_ERROR_MSG = "用户已注销";

	/**
	 * 错误编码-账户错误
	 */
	public static final String ACCOUNT_ERROR = "0000009";
	public static final String ACCOUNT_ERROR_MSG = "账户错误";

	public static final String ACCOUNT_BALANCE_NOT_ENOUGH_ERROR = "account.balance.not.enough";
	public static final String ACCOUNT_BALANCE_NOT_ENOUGH_ERROR_MSG = "账户余额不足";

	/**
	 * 错误编码-优惠券错误
	 */
	public static final String COUPON_ERROR = "0000010";
	public static final String COUPON_ERROR_MSG = "优惠券错误";

	public static final String COUPON_NOT_USE_ERROR = "coupon.not.use";
	public static final String COUPON_NOT_USE_ERROR_MSG = "优惠券未启用";

	public static final String COUPON_EXCHANGE_ERROR = "coupon.exchange.error";
	public static final String COUPON_EXCHANGE_ERROR_MSG = "兑换失败";

	/**
	 * 错误编码-能量方块领取错误
	 */
	public static final String DIAMOND_RECORD_ERROR = "0000011";
	public static final String DIAMOND_RECORD_ERROR_MSG = "能量方块领取错误";

	public static final String DIAMOND_RECORD_NOT_EQUAL_ERROR = "diamond.record.user.not.equal.error";
	public static final String DIAMOND_RECORD_NOT_EQUAL_ERROR_MSG = "能量方块领取用户错误";

	public static final String DIAMOND_RECORD_IS_USE_ERROR = "diamond.record.isuse";
	public static final String DIAMOND_RECORD_IS_USE_ERROR_MSG = "能量方块已领取";

	public static final String DIAMOND_RECORD_FAIL_ERROR = "diamond.record.fail";
	public static final String DIAMOND_RECORD_FAIL_ERROR_MSG = "能量方块领取失败";

	/*--------------------------- 返回app错误码  -----------------------------*/

	/*--------------------------- 第三方错误码  -----------------------------*/
	/*--------------------------- GoFun错误码  -----------------------------*/
	/**
	 * 错误编码-GoFun错误
	 */
	public static final String GOFUN_ERROR = "0100001";
	/**
	 * 错误描述-GoFun错误
	 */
	public static final String GOFUN_ERROR_MSG = "oFun错误";
	public static final String GOFUN_NULL_ERROR = "gofun.null.error";
	public static final String GOFUN_NULL_ERROR_MSG = "传入参数为空";
	/*--------------------------- GoFun错误码  -----------------------------*/
	/*--------------------------- 第三方错误码  -----------------------------*/

	/*--------------------------- wheel平台使用错误码  -----------------------------*/
	/*--------------------------- 算力配置错误码(301开头)  -----------------------------*/
	/**
	 * 错误编码-参数为空
	 */
	public static final String CALCULATE_CONFIG_FIELD_EMPTY = "3010001";
	/**
	 * 错误描述-参数为空
	 */
	public static final String CALCULATE_CONFIG_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-算力不存在错误
	 */
	public static final String CALCULATE_CONFIG_DATA_NOTEXIST = "3010002";
	/**
	 * 错误描述-算力不存在错误
	 */
	public static final String CALCULATE_CONFIG_DATA_NOTEXIST_MSG = "算力不存在";
	/**
	 * 错误编码-算力list不存在错误
	 */
	public static final String CALCULATE_CONFIG_LIST_NOTEXIST = "3010003";
	/**
	 * 错误描述-算力不存在错误
	 */
	public static final String CALCULATE_CONFIG_LIST_NOTEXIST_MSG = "算力列表不存在";
	/**
	 * 错误编码-不是JSON数据错误
	 */
	public static final String CALCULATE_CONFIG_CONTENT_NOTJSON = "3010004";
	/**
	 * 错误描述-不是JSON数据错误
	 */
	public static final String CALCULATE_CONFIG_CONTENT_NOTJSON_MSG = "不是JSON数据";

	/*--------------------------- 算力配置密错误码(301开头)  -----------------------------*/
	/*--------------------------- 能量配置错误码(302开头)  -----------------------------*/
	/**
	 * 错误编码-参数为空
	 */
	public static final String DIAMOND_CONFIG_FIELD_EMPTY = "3020001";
	/**
	 * 错误描述-参数为空
	 */
	public static final String DIAMOND_CONFIG_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-能量不存在错误
	 */
	public static final String DIAMOND_CONFIG_DATA_NOTEXIST = "3020002";
	/**
	 * 错误描述-能量不存在错误
	 */
	public static final String DIAMOND_CONFIG_DATA_NOTEXIST_MSG = "能量不存在";
	/**
	 * 错误编码-能量LIST不存在错误
	 */
	public static final String DIAMOND_CONFIG_LIST_NOTEXIST = "3020003";
	/**
	 * 错误描述-能量list不存在错误
	 */
	public static final String DIAMOND_CONFIG_LIST_NOTEXIST_MSG = "能量列表不存在";
	/**
	 * 错误编码-不是JSON数据错误
	 */
	public static final String DIAMOND_CONFIG_CONTENT_NOTJSON = "3020004";
	/**
	 * 错误描述-不是JSON数据错误
	 */
	public static final String DIAMOND_CONFIG_CONTENT_NOTJSON_MSG = "不是JSON数据";

	/*--------------------------- 能量配置密错误码(302开头)  -----------------------------*/
	/*--------------------------- wheel平台使用错误码  -----------------------------*/


}