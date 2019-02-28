package com.cloud.common.constants.wheel;

import com.cloud.common.constants.RetConstants;

/**
 * ret方向盘数据接收返回错误码-返回给app
 * @author wei.yong
 * @2017年04月24日
 */
public class RetWheelDataReceiveConstants extends RetConstants {

	//token
	public static final String TOKEN = "token";
	//ochain
	public static final String OCHAIN = "ochain";

	/*--------------------------- 返回方向盘数据接收错误码  -----------------------------*/
	/**
	 * 错误编码-非法请求
	 */
	public static final String NETWORK_ERROR = "0100001";
	public static final String NETWORK_FAIL = "network.error";
	public static final String NETWORK_ERROR_MSG = "非法请求";

	/**
	 * 错误编码-token错误
	 */
	public static final String TOKEN_ERROR = "0100002";
	public static final String TOKEN_ERROR_MSG = "token错误";
	public static final String TOKEN_SIGN_ERROR = "token.sign.error";
	public static final String TOKEN_SIGN_ERROR_MSG = "token签名错误";

	public static final String TOKEN_NULL_ERROR = "token.null";
	public static final String TOKEN_NULL_ERROR_MSG = "token为空";
	public static final String TOKEN_EXPIRE = "token.expire";
	public static final String TOKEN_EXPIRE_MSG = "token已过期";

	public static final String TOKEN_ISSURE_ERROR = "token.issure.error";
	public static final String TOKEN_ISSURE_ERROR_MSG = "token发行者错误";
	public static final String TOKEN_AUDIENCE_ERROR = "token.audience.error";
	public static final String TOKEN_AUDIENCE_ERROR_MSG = "token观众错误";
	public static final String TOKEN_NOTBEFORE_ERROR = "token.notberfore.error";
	public static final String TOKEN_NOTBEFORE_ERROR_MSG = "token生效时间错误";
	public static final String TOKEN_EXPIRATION_ERROR = "token.expiration.error";
	public static final String TOKEN_EXPIRATION_ERROR_MSG = "token过期时间错误";

	/**
	 * 错误编码-传入数据为空
	 */
	public static final String DATA_NULL_ERROR = "0100003";
	public static final String DATA_NULL_ERROR_MSG = "传入数据为空";

	/**
	 * 错误编码-传入数据失败
	 */
	public static final String DATA_ERROR = "0100004";
	public static final String DATA_ERROR_MSG = "传入数据失败";
	/*--------------------------- 返回方向盘数据接收错误码  -----------------------------*/


}