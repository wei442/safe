package com.cloud.common.constants.wheel;

import com.cloud.common.constants.RetConstants;

/**
 * ret方向盘后台返回错误码-返回给app
 * @author wei.yong
 * @2017年04月24日
 */
public class RetWheelManageConstants extends RetConstants {

	//webtoken
	public static final String WEBTOKEN = "webtoken";
	//ochain
	public static final String OCHAIN = "ochain";

	//webtoken过期时间 600秒 (10分钟)
	public static final Integer WEBTOKEN_TIME = 3600;

	public static final String G_ID = "gId";
	public static final String G_TOKEN = "gToken";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String G_NAME = "gName";

	/*--------------------------- 返回app错误码  ----------------------------*/
	/**
	 * 错误编码-服务不可用
	 */
	public static final String SYSTEM_ERROR = "0000001";
	/**
	 * 错误描述-服务不可用
	 */
	public static final String SYSTEM_ERROR_MSG = "服务暂不可用";
	/**
	 * lbp-内部业务简称
	 */
	public static final String LBP_SYSTEM_ERROR = "lbp.system.error";
	public static final String LBP_SYSTEM_ERROR_MSG = "业务服务不可用";
	/**
	 * tdp-第三方简称
	 */
	public static final String TDP_BLOCKCHAIN_ERROR = "tdp.blockchain.error";
	public static final String TDP_BLOCKCHAIN_ERROR_MSG = "区块链服务不可用";
	public static final String TDP_IPFS_ERROR = "tdp.ipfs.error";
	public static final String TDP_IPFS_ERROR_MSG = "ipfs服务不可用";
	public static final String TDP_ENCRYPT_ERROR = "tdp.encrypt.error";
	public static final String TDP_ENCRYPT_ERROR_MSG = "数据加密解密服务不可用";
	public static final String TDP_SMS_ERROR = "tdp.sms.error";
	public static final String TDP_SMS_ERROR_MSG = "短信服务不可用";
	public static final String TDP_MAIL_ERROR = "tdp.mail.error";
	public static final String TDP_MAIL_ERROR_MSG = "邮件服务不可用";

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
	 * 错误编码-webtoken错误
	 */
	public static final String WEBTOKEN_ERROR = "0000005";
	public static final String WEBTOKEN_ERROR_MSG = "webtoken错误";
	public static final String WEBTOKEN_SIGN_ERROR = "token.sign.error";
	public static final String WEBTOKEN_SIGN_ERROR_MSG = "token签名错误";

	public static final String WEBTOKEN_NULL_ERROR = "webtoken.null";
	public static final String WEBTOKEN_NULL_ERROR_MSG = "webtoken为空";
	public static final String WEBTOKEN_EXPIRE = "webtoken.expire";
	public static final String WEBTOKEN_EXPIRE_MSG = "登录已过期,请重新登录";
	public static final String WEBTOKEN_JWT_ERROR = "webtoken.jwt.error";
	public static final String WEBTOKEN_JWT_ERROR_MSG = "webtoken格式错误";

	/**
	 * 错误编码-timestampId错误
	 */
	public static final String TIMESTAMPID_ERROR = "0000006";
	public static final String TIMESTAMPID_FAIL = "timestampId.error";
	public static final String TIMESTAMPID_ERROR_MSG = "timestampId错误";

	public static final String TIMESTAMPID_NULL_ERROR = "timestampId.null";
	public static final String TIMESTAMPID_NULL_ERROR_MSG = "timestampId为空";

	/**
	 * 错误编码-timestampId错误
	 */
	public static final String SIGN_ERROR = "0000006";
	public static final String SIGN_ERROR_MSG = "用户签到错误";

	public static final String SIGN_EXIST_ERROR = "sign.exist";
	public static final String SIGN_EXIST_ERROR_MSG = "用户已签到";

	/**
	 * 错误编码-JWT错误
	 */
	/*--------------------------- 返回app错误码  -----------------------------*/

	/*--------------------------- 第三方平台使用错误码  -----------------------------*/
	/*--------------------------- GoFun错误码  -----------------------------*/
	/**
	 * 错误编码-GoFun错误
	 */
	public static final String GOFUN_ERROR = "0100001";

	/**
	 * 错误描述-GoFun错误
	 */
	public static final String GOFUN_ERROR_MSG = "GoFun错误";

	/**
	 * 错误描述-GoFun返回成功
	 */
	public final static String GOFUN_SUCCESS_CODE = "200";
	/**
	 * 错误编码-无用户信息
	 */
	public static final String GOFUN_USER_NOT_EXSITE = "1005";
	/**
	 * 错误编码-无用户信息
	 */
	public static final String GOFUN_USER_NOT_EXSITE_MSG = "无用户信息";
	/*--------------------------- GoFun错误码  -----------------------------*/

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
	/*--------------------------- 优惠券配置错误码(303开头)  -----------------------------*/
	/**
	 * 错误编码-参数为空
	 */
	public static final String COUPON_FIELD_EMPTY = "3030001";
	/**
	 * 错误描述-参数为空
	 */
	public static final String COUPON_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-优惠券不存在错误
	 */
	public static final String COUPON_DATA_NOTEXIST = "3030002";
	/**
	 * 错误描述-优惠券不存在错误
	 */
	public static final String COUPON_DATA_NOTEXIST_MSG = "优惠券不存在";
	/**
	 * 错误编码-优惠券LIST不存在错误
	 */
	public static final String COUPON_LIST_NOTEXIST = "3030003";
	/**
	 * 错误描述-优惠券list不存在错误
	 */
	public static final String COUPON_LIST_NOTEXIST_MSG = "优惠券列表不存在";
	/**
	 * 错误编码-不是JSON数据错误
	 */
	public static final String COUPON_CONTENT_NOTJSON = "3030004";
	/**
	 * 错误描述-不是JSON数据错误
	 */
	public static final String COUPON_CONTENT_NOTJSON_MSG = "不是JSON数据";
	/**
	 * 错误编码-上传图片失败
	 */
	public static final String COUPON_GOFUN_UPLOAD_FILE_ERROR = "3030005";
	/**
	 * 错误描述-上传图片失败错误
	 */
	public static final String COUPON_GOFUN_UPLOAD_FILE_ERROR_MSG = "上传图片失败";

	/**
	 * 错误编码-参数为空
	 */
	public static final String COUPON_LOG_FIELD_EMPTY = "3030051";
	/**
	 * 错误描述-参数为空
	 */
	public static final String COUPON_LOG_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-优惠券不存在错误
	 */
	public static final String COUPON_LOG_DATA_NOTEXIST = "3030052";
	/**
	 * 错误描述-优惠券不存在错误
	 */
	public static final String COUPON_LOG_DATA_NOTEXIST_MSG = "优惠券日志不存在";
	/**
	 * 错误编码-优惠券LIST不存在错误
	 */
	public static final String COUPON_LOG_LIST_NOTEXIST = "3030053";
	/**
	 * 错误描述-优惠券list不存在错误
	 */
	public static final String COUPON_LOG_LIST_NOTEXIST_MSG = "优惠券日志列表不存在";

	/*--------------------------- 优惠券配置错误码(303开头)  -----------------------------*/
	/*--------------------------- 用户账户地址错误码(304开头)  -----------------------------*/

	/**
	 * 错误编码-参数为空
	 */
	public static final String USER_COINADDR_FIELD_EMPTY = "3040001";
	/**
	 * 错误描述-参数为空
	 */
	public static final String USER_COINADDR_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-用户账户地址不存在错误
	 */
	public static final String USER_COINADDR_DATA_NOTEXIST = "3040002";
	/**
	 * 错误描述-用户账户地址不存在错误
	 */
	public static final String USER_COINADDR_DATA_NOTEXIST_MSG = "用户账户地址不存在";
	/**
	 * 错误编码-用户账户地址LIST不存在错误
	 */
	public static final String USER_COINADDR_LIST_NOTEXIST = "3040003";
	/**
	 * 错误描述-用户账户地址list不存在错误
	 */
	public static final String USER_COINADDR_LIST_NOTEXIST_MSG = "用户账户地址列表不存在";
	/**
	 * 错误编码-不是JSON数据错误
	 */
	public static final String USER_COINADDR_CONTENT_NOTJSON = "3040004";
	/**
	 * 错误编码-不是JSON数据错误
	 */
	public static final String USER_COINADDR_CONTENT_NOTJSON_MSG = "不是JSON数据";
	/*--------------------------- 用户账户地址错误码(304开头)  -----------------------------*/

	/*----------------------------- 手续费配置错误编码(305开头) -----------------------------*/
	/**
	 * 错误编码-参数为空
	 */
	public static final String FEE_CONFIG_FIELD_EMPTY = "3050001";
	/**
	 * 错误描述-参数为空
	 */
	public static final String FEE_CONFIG_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-手续费配置不存在
	 */
	public static final String FEE_CONFIG_ENTITY_NOTEXIST = "3050002";
	/**
	 * 错误描述-手续费配置不存在
	 */
	public static final String FEE_CONFIG_ENTITY_NOTEXIST_MSG = "手续费配置不存在";
	/**
	 * 错误编码-手续费配置已存在
	 */
	public static final String FEE_CONFIG_ENTITY_EXIST = "3050003";
	/**
	 * 错误描述-手续费配置已存在
	 */
	public static final String FEE_CONFIG_ENTITY_EXIST_MSG = "手续费配置已存在";
	/**
	 * 错误编码-手续费配置列表不存在
	 */
	public static final String FEE_CONFIG_LIST_NOTEXIST = "3050004";
	/**
	 * 错误描述-手续费配置列表不存在
	 */
	public static final String FEE_CONFIG_LIST_NOTEXIST_MSG = "手续费配置列表不存在";
	/**
	 * 错误编码-手续费配置列表已存在
	 */
	public static final String FEE_CONFIG_LIST_EXIST = "3050005";
	/**
	 * 错误描述-手续费配置列表已存在
	 */
	public static final String FEE_CONFIG_LIST_EXIST_MSG = "手续费配置列表已存在";

	/*----------------------------- 手续费配置错误编码(305开头) -----------------------------*/
	/*----------------------------- 充币订单错误编码(306开头) -----------------------------*/
	/**
	 * 错误编码-充币订单不存在
	 */
	public static final String ORDER_RECHARGECOIN_ENTITY_NOTEXIST = "3060001";
	/**
	 * 错误描述-充币订单不存在
	 */
	public static final String ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG = "充币订单不存在";
	/**
	 * 错误编码-充币订单已存在
	 */
	public static final String ORDER_RECHARGECOIN_ENTITY_EXIST = "3060002";
	/**
	 * 错误描述-充币订单已存在
	 */
	public static final String ORDER_RECHARGECOIN_ENTITY_EXIST_MSG = "充币订单已存在";

	/**
	 * 错误编码-充币订单列表不存在
	 */
	public static final String ORDER_RECHARGECOIN_LIST_NOTEXIST = "3060003";
	/**
	 * 错误描述-充币订单列表不存在
	 */
	public static final String ORDER_RECHARGECOIN_LIST_NOTEXIST_MSG = "充币订单列表不存在";
	/**
	 * 错误编码-充币订单列表已存在
	 */
	public static final String ORDER_RECHARGECOIN_LIST_EXIST = "3060004";
	/**
	 * 错误描述-充币订单列表已存在
	 */
	public static final String ORDER_RECHARGECOIN_LIST_EXIST_MSG = "充币订单列表已存在";

	/*----------------------------- 充币订单错误编码(306开头) -----------------------------*/

	/*----------------------------- 提币订单错误编码(307开头) -----------------------------*/
	/**
	 * 错误编码-提币订单不存在
	 */
	public static final String ORDER_DRAWCOIN_ENTITY_NOTEXIST = "3070001";
	/**
	 * 错误描述-提币订单不存在
	 */
	public static final String ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG = "提币订单不存在";
	/**
	 * 错误编码-提币订单已存在
	 */
	public static final String ORDER_DRAWCOIN_ENTITY_EXIST = "3070002";
	/**
	 * 错误描述-提币订单已存在
	 */
	public static final String ORDER_DRAWCOIN_ENTITY_EXIST_MSG = "提币订单已存在";

	/**
	 * 错误编码-提币订单列表不存在
	 */
	public static final String ORDER_DRAWCOIN_LIST_NOTEXIST = "3070003";
	/**
	 * 错误描述-提币订单列表不存在
	 */
	public static final String ORDER_DRAWCOIN_LIST_NOTEXIST_MSG = "提币订单列表不存在";
	/**
	 * 错误编码-提币订单列表已存在
	 */
	public static final String ORDER_DRAWCOIN_LIST_EXIST = "3070004";
	/**
	 * 错误描述-提币订单列表已存在
	 */
	public static final String ORDER_DRAWCOIN_LIST_EXIST_MSG = "提币订单列表已存在";

	/*----------------------------- 提币订单错误编码(307开头) -----------------------------*/
	/*----------------------------- 非法数据处理错误编码(308开头) -----------------------------*/
	/**
	 * 错误编码-用户不存在
	 */
	public static final String ILLEGAL_USER_INFO_ENTITY_NOTEXIST = "3080001";
	/**
	 * 错误描述-用户不存在
	 */
	public static final String ILLEGAL_USER_INFO_ENTITY_NOTEXIST_MSG = "用户不存在";
	/**
	 * 错误编码-用户能量不存在
	 */
	public static final String ILLEGAL_ACCOUNT_ENTITY_NOTEXIST = "3080002";
	/**
	 * 错误描述-用户能量不存在
	 */
	public static final String ILLEGAL_ACCOUNT_ENTITY_NOTEXIST_MSG = "用户能量不存在";
	/*----------------------------- 非法数据处理错误编码(308开头) -----------------------------*/
	/*--------------------------- wheel平台使用错误码  -----------------------------*/

}