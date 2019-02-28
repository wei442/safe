package com.cloud.common.constants.third;

/**
 * 数据安全存储返回错误码 SecurityConstants
 * @author wei.yong
 * @2017-08-16
 */
public class SecurityConstants {

	//系统异常
	public static final String SECURITY_SYSTEM_ERROR = "-1";
	public static final String SECURITY_SYSTEM_ERROR_MSG = "系统异常";

	//请求参数错误
	public static final String SECURITY_REQUEST_ERROR = "40010000";
	public static final String SECURITY_REQUEST_ERROR_MSG = "请求参数错误";

	//生成 key/pswdkey/pswd key/pswd 算法异常
	public static final String SECURITY_ALGORITHM_ERROR = "40010001";
	public static final String SECURITY_ALGORITHM_ERROR_MSG = "生成 key/pswdkey/pswd key/pswd 算法异常";

	//生成 salt 错误
	public static final String SECURITY_SALT_ERROR = "40010002";
	public static final String SECURITY_SALT_ERROR_MSG = "生成 salt 错误";

	//Aes 加密 算法异常
	public static final String SECURITY_AES_ENCRYPT_ERROR = "40010003";
	public static final String SECURITY_AES_ENCRYPT_ERROR_MSG = "Aes 加密 算法异常";

	//aes 加密结果为空
	public static final String SECURITY_AES_ENCRYPT_NOTEXITS = "40010004";
	public static final String SECURITY_AES_ENCRYPT_NOTEXITS_MSG = "aes 加密结果为空";

	//Aes 解密算法异常
	public static final String SECURITY_AES_DECRYPT_ERROR = "40010005";
	public static final String SECURITY_AES_DECRYPT_ERROR_MSG = "Aes 解密算法异常 ";

	//aes 解密结果为
	public static final String SECURITY_AES_DECRYPT_NOTEXITS = "40010006";
	public static final String SECURITY_AES_DECRYPT_NOTEXITS_MSG = "aes 解密结果为空";


}